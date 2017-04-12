package com.focustech.processort;

import com.focustech.xmlviewtonative.base.ViewNode;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;

/**
 * Created by zhangzheng on 2017/4/12.
 */

public class GenerateClassUtils {

    public static void genderClass(ViewNode node, String name, Filer filer) {
        name = name.replace(".", "");

        ClassName view = ClassName.get("android.view", "View");
        ClassName context = ClassName.get("android.content", "Context");
        ClassName baseLayout = ClassName.get("xmlviewtonative.viewparse", "BaseFramLayout");
        ClassName self = ClassName.get("com.focustech", "FastInflate_" + name);

        // 创建main方法
        MethodSpec main = MethodSpec.methodBuilder("getRootView")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addParameter(context, "context")
                .returns(view)
                .addStatement("return  new $T(context,$T.getNode())", baseLayout, self)
                .build();
        TypeSpec fastInflate = TypeSpec.classBuilder("FastInflate_" + name)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main)
                .addMethod(getGenderNodeCode(node))
                .build();

        try {
            JavaFile javaFile = JavaFile.builder("com.focustech", fastInflate)
                    .addFileComment(" This codes are generated automatically. Do not modify!")
                    .build();
            javaFile.writeTo(filer);

            System.out.print("contentState===>sucess");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static MethodSpec getGenderNodeCode(ViewNode node) {

        MethodSpec.Builder builder = MethodSpec.methodBuilder("getNode")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(ViewNode.class);

        builder.addStatement("$T rootNode = new $T()", ViewNode.class, ViewNode.class);
        builder.addStatement("rootNode.setViewName($S)", node.getViewName());
        builder.addStatement("$T map = new $T()", HashMap.class, HashMap.class);
        HashMap<String, String> attributes = node.getAttributes();
        if (attributes != null) {
            Set<String> keys = attributes.keySet();
            for (String key : keys) {
                builder.addStatement("map.put($S,$S)", key, attributes.get(key));
            }
        }
        builder.addStatement("rootNode.setAttributes(map)");

        List<ViewNode> childs = node.getChilds();
        getGenderChildNodeCode(0,"rootNode",builder,childs);

        builder.addStatement("return rootNode");

        return builder.build();
    }

    private static MethodSpec.Builder getGenderChildNodeCode(int index, String nodename,MethodSpec.Builder builder, List<ViewNode> nodes) {
        if(nodes == null||nodes.size()<0){
            return builder;
        }
        index += 1000;
        final int childListIndex = index;
        builder.addStatement("$T child"+childListIndex+" = new $T()", List.class, ArrayList.class);
        for (ViewNode node : nodes) {
            index++;
            builder.addStatement("$T node"+index+" = new $T()", ViewNode.class, ViewNode.class);
            builder.addStatement("node"+index+".setViewName($S)", node.getViewName());
            builder.addStatement("$T map"+index+"= new $T()", HashMap.class, HashMap.class);
            HashMap<String, String> attributes = node.getAttributes();
            if (attributes != null) {
                Set<String> keys = attributes.keySet();
                for (String key : keys) {
                    builder.addStatement("map"+index+".put($S,$S)", key, attributes.get(key));
                }
            }

            builder.addStatement("node"+index+".setAttributes(map"+index+")");

            builder.addStatement("child"+childListIndex+".add(node"+index+")");

            getGenderChildNodeCode(index,"node"+index,builder,node.getChilds());
        }

        builder.addStatement(nodename+".setChilds(child"+childListIndex+")");

        return builder;
    }


}

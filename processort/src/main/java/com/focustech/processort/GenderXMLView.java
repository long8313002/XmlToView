package com.focustech.processort;

import com.focustech.annotations.SetContentView;
import com.focustech.xmlviewtonative.base.ViewNode;
import com.focustech.xmlviewtonative.base.XMLParse;
import com.google.auto.service.AutoService;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

/**
 * Created by zhangzheng on 2017/4/12.
 */
@AutoService(Processor.class)
public class GenderXMLView extends AbstractProcessor {

    private Filer filer;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        filer = processingEnv.getFiler();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        for (TypeElement te : annotations) {
            for (javax.lang.model.element.Element element : roundEnv.getElementsAnnotatedWith(te)) {
                TypeElement classElement = (TypeElement) element;
                PackageElement packageElement = (PackageElement) classElement.getEnclosingElement();
                String packageName = packageElement.getQualifiedName().toString();
                SetContentView converterAnnotation = element.getAnnotation(SetContentView.class);
                if (converterAnnotation != null) {
                    File file = FindXmlFileUtil.findXmlFile(packageName,converterAnnotation.value(),filer);
                    if(file == null){
                        continue;
                    }
                    try {
                        ViewNode node = new XMLParse(new FileInputStream(file)).parse();
                        GenerateClassUtils.genderClass(node,file.getName(),filer);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }



    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(SetContentView.class.getCanonicalName());
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}

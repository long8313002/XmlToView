package xmlviewtonative.viewparse.attributesParse.subs;

import android.view.View;

import java.util.HashMap;

import xmlviewtonative.viewparse.ResourceUtils;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class AndroidPaddingParse implements IAttributesParse<View> {
    @Override
    public void parseAttribute(HashMap<String, String> attribute, View view) {
        int padingLeft = 0;
        int padingTop = 0;
        int padingRight = 0;
        int padingBottom = 0;

        if (attribute.containsKey("android:paddingLeft")) {
            padingLeft = (int) ResourceUtils.getDimension(attribute.get("android:paddingLeft"), view.getContext());
        }

        if (attribute.containsKey("android:paddingTop")) {
            padingTop = (int) ResourceUtils.getDimension(attribute.get("android:paddingTop"), view.getContext());
        }

        if (attribute.containsKey("android:paddingRight")) {
            padingRight = (int) ResourceUtils.getDimension(attribute.get("android:paddingRight"), view.getContext());
        }

        if (attribute.containsKey("android:paddingBottom")) {
            padingBottom = (int) ResourceUtils.getDimension(attribute.get("android:paddingBottom"), view.getContext());
        }

        if (attribute.containsKey("android:padding")) {
            int padding = (int) ResourceUtils.getDimension(attribute.get("android:padding"), view.getContext());
            padingLeft = padding;
            padingTop = padding;
            padingRight = padding;
            padingBottom = padding;
        }

        view.setPadding(padingLeft, padingTop, padingRight, padingBottom);
    }
}

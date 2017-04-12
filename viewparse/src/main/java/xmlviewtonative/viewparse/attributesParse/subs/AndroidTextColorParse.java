package xmlviewtonative.viewparse.attributesParse.subs;

import android.graphics.Color;
import android.widget.TextView;

import java.util.HashMap;

import xmlviewtonative.viewparse.ResourceUtils;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class AndroidTextColorParse implements IAttributesParse<TextView> {

    @Override
    public void parseAttribute(HashMap<String, String> attribute, TextView textView) {
        if (attribute.containsKey("android:textColor")) {
            String textColor = attribute.get("android:textColor");
            if (textColor.startsWith("#")) {
                textView.setTextColor(Color.parseColor(textColor));
            } else if (textColor.contains("@")) {
                int resourceId = ResourceUtils.getResourceId(textColor, textView.getContext());
                textView.setTextColor(textView.getResources().getColorStateList(resourceId));
            }
        }
    }
}

package xmlviewtonative.viewparse.attributesParse.subs;

import android.util.TypedValue;
import android.widget.TextView;

import java.util.HashMap;

import xmlviewtonative.viewparse.ResourceUtils;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class AndroidTextParse implements IAttributesParse<TextView> {
    @Override
    public void parseAttribute(HashMap<String, String> attribute, TextView textView) {
        if(attribute.containsKey("android:text")){
            textView.setText(attribute.get("android:text"));
        }
    }
}

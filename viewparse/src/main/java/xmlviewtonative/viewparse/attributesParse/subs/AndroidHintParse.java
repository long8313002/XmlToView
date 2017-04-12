package xmlviewtonative.viewparse.attributesParse.subs;

import android.widget.EditText;

import java.util.HashMap;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class AndroidHintParse implements IAttributesParse<EditText> {
    @Override
    public void parseAttribute(HashMap<String, String> attribute, EditText editText) {
        if(attribute.containsKey("android:hint")){
            String androidHint = attribute.get("android:hint");
            editText.setHint(androidHint);
        }
    }
}

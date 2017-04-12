package xmlviewtonative.viewparse.attributesParse.subs;

import android.view.View;

import java.util.HashMap;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class AndroidClickableParse implements IAttributesParse<View> {
    @Override
    public void parseAttribute(HashMap<String, String> attribute, View view) {
        if(attribute.containsKey("android:clickable")){
            String value = attribute.get("android:clickable");
            if("true".equals(value)){
                view.setClickable(true);
            }else if("false".equals(value)){
                view.setClickable(false);
            }
        }
    }
}

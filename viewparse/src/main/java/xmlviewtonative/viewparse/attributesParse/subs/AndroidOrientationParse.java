package xmlviewtonative.viewparse.attributesParse.subs;

import android.widget.LinearLayout;

import java.util.HashMap;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class AndroidOrientationParse implements IAttributesParse<LinearLayout> {
    @Override
    public void parseAttribute(HashMap<String, String> attribute, LinearLayout linearLayout) {
        if(attribute.containsKey("android:orientation")){
            String value = attribute.get("android:orientation");
            if("horizontal".equals(value)){
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            }else if("vertical".equals(value)){
                linearLayout.setOrientation(LinearLayout.VERTICAL);
            }
        }
    }
}

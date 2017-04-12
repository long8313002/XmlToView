package xmlviewtonative.viewparse.attributesParse.subs;

import android.os.Build;
import android.view.View;

import java.util.HashMap;

import xmlviewtonative.viewparse.ResourceUtils;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class AndroidBackgroundParse implements IAttributesParse<View> {
    @Override
    public void parseAttribute(HashMap<String, String> attribute, View view) {
        if(attribute.containsKey("android:background")){
            String value = attribute.get("android:background");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                view.setBackground(ResourceUtils.getBackGround(value,view.getContext()));
            }else{
                view.setBackgroundDrawable(ResourceUtils.getBackGround(value,view.getContext()));
            }
        }
    }
}

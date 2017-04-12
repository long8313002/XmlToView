package xmlviewtonative.viewparse.attributesParse.subs;

import android.view.View;

import java.util.HashMap;

import xmlviewtonative.viewparse.ResourceUtils;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class AndroidIdParse implements IAttributesParse<View> {
    @Override
    public void parseAttribute(HashMap<String, String> attribute, View view) {
        if(attribute.containsKey("android:id")){
            int id = ResourceUtils.getResourceId(attribute.get("android:id"), view.getContext());
            view.setId(id);
        }
    }
}

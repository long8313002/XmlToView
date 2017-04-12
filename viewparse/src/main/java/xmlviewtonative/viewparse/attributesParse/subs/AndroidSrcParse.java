package xmlviewtonative.viewparse.attributesParse.subs;

import android.widget.ImageView;

import java.util.HashMap;

import xmlviewtonative.viewparse.ResourceUtils;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class AndroidSrcParse implements IAttributesParse<ImageView> {
    @Override
    public void parseAttribute(HashMap<String, String> attribute, ImageView imageView) {
        if(attribute.containsKey("android:src")){
            String value = attribute.get("android:src");
            imageView.setImageResource(ResourceUtils.getResourceId(value,imageView.getContext()));
        }
    }
}

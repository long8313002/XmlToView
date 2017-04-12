package xmlviewtonative.viewparse.attributesParse;

import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import xmlviewtonative.viewparse.attributesParse.subs.AndroidSrcParse;
import xmlviewtonative.viewparse.attributesParse.subs.IAttributesParse;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class ImageViewAttributeParse implements IAttributeParseInfo<ImageView> {

    private static List<IAttributesParse<ImageView>> attributesParseList = new ArrayList<>();

    static {
        attributesParseList.add(new AndroidSrcParse());
    }

    @Override
    public ImageView parse(HashMap<String, String> params, ImageView view) {
        for (IAttributesParse<ImageView> parse:attributesParseList){
            parse.parseAttribute(params,view);
        }
        return view;
    }
}

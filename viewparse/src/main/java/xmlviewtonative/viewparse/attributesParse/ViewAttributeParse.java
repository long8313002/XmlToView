package xmlviewtonative.viewparse.attributesParse;


import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import xmlviewtonative.viewparse.attributesParse.subs.AndroidBackgroundParse;
import xmlviewtonative.viewparse.attributesParse.subs.AndroidClickableParse;
import xmlviewtonative.viewparse.attributesParse.subs.AndroidIdParse;
import xmlviewtonative.viewparse.attributesParse.subs.AndroidPaddingParse;
import xmlviewtonative.viewparse.attributesParse.subs.IAttributesParse;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class ViewAttributeParse implements IAttributeParseInfo {

    private static List<IAttributesParse<View>> attributesParseList = new ArrayList<>();

    static {
        attributesParseList.add(new AndroidBackgroundParse());
        attributesParseList.add(new AndroidClickableParse());
        attributesParseList.add(new AndroidIdParse());
        attributesParseList.add(new AndroidPaddingParse());
    }

    @Override
    public View parse(HashMap params, View view) {
        for (IAttributesParse<View> parse:attributesParseList){
            parse.parseAttribute(params,view);
        }
        return view;
    }
}

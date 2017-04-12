package xmlviewtonative.viewparse.attributesParse;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import xmlviewtonative.viewparse.attributesParse.subs.AndroidTextColorParse;
import xmlviewtonative.viewparse.attributesParse.subs.AndroidTextParse;
import xmlviewtonative.viewparse.attributesParse.subs.AndroidTextSizeParse;
import xmlviewtonative.viewparse.attributesParse.subs.IAttributesParse;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class TextViewAttributeParse implements IAttributeParseInfo<TextView> {

    private static List<IAttributesParse<TextView>> attributesParseList = new ArrayList<>();

    static {
        attributesParseList.add(new AndroidTextParse());
        attributesParseList.add(new AndroidTextSizeParse());
        attributesParseList.add(new AndroidTextColorParse());
    }

    @Override
    public TextView parse(HashMap params, TextView view) {
        for (IAttributesParse<TextView> parse:attributesParseList){
            parse.parseAttribute(params,view);
        }
        return view;
    }
}

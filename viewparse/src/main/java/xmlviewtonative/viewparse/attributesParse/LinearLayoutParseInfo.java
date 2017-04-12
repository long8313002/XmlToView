package xmlviewtonative.viewparse.attributesParse;

import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import xmlviewtonative.viewparse.attributesParse.subs.AndroidOrientationParse;
import xmlviewtonative.viewparse.attributesParse.subs.IAttributesParse;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class LinearLayoutParseInfo implements IAttributeParseInfo<LinearLayout>{

    private static List<IAttributesParse<LinearLayout>> attributesParseList = new ArrayList<>();

    static {
        attributesParseList.add(new AndroidOrientationParse());
    }

    @Override
    public LinearLayout parse(HashMap<String, String> params, LinearLayout view) {
        for (IAttributesParse<LinearLayout> parse:attributesParseList){
            parse.parseAttribute(params,view);
        }
        return view;
    }
}

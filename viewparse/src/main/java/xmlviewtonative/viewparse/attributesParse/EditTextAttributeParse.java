package xmlviewtonative.viewparse.attributesParse;

import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import xmlviewtonative.viewparse.attributesParse.subs.AndroidHintParse;
import xmlviewtonative.viewparse.attributesParse.subs.IAttributesParse;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class EditTextAttributeParse implements IAttributeParseInfo<EditText> {

    private static List<IAttributesParse<EditText>> attributesParseList = new ArrayList<>();

    static {
        attributesParseList.add(new AndroidHintParse());
    }

    @Override
    public EditText parse(HashMap<String, String> params, EditText view) {
        for (IAttributesParse<EditText> parse:attributesParseList){
            parse.parseAttribute(params,view);
        }
        return view;
    }
}

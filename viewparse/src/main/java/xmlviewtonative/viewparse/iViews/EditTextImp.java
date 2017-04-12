package xmlviewtonative.viewparse.iViews;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import com.focustech.xmlviewtonative.base.ViewNode;

import xmlviewtonative.viewparse.attributesParse.EditTextAttributeParse;
import xmlviewtonative.viewparse.attributesParse.IAttributeParseInfo;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class EditTextImp extends TextViewImp{

    private IAttributeParseInfo<EditText> parse = new EditTextAttributeParse();

    @Override
    public TextView parse(ViewNode viewNode, Context context) {
        EditText editText = (EditText) super.parse(viewNode, context);
        if(viewNode.getAttributes()==null){
            return editText;
        }
        return parse.parse(viewNode.getAttributes(),editText);
    }

    @Override
    protected TextView createView(Context context) {
        return new EditText(context);
    }
}

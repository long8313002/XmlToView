package xmlviewtonative.viewparse.iViews;


import android.content.Context;
import android.widget.TextView;

import com.focustech.xmlviewtonative.base.ViewNode;

import xmlviewtonative.viewparse.attributesParse.IAttributeParseInfo;
import xmlviewtonative.viewparse.attributesParse.TextViewAttributeParse;


/**
 * Created by zhangzheng on 2017/4/10.
 */

public class TextViewImp extends ViewImp<TextView> {

    private IAttributeParseInfo<TextView> parse = new TextViewAttributeParse();

    @Override
    public TextView parse(ViewNode viewNode, Context context) {
        TextView textView = super.parse(viewNode, context);
        if(viewNode.getAttributes()==null){
            return textView;
        }
        return parse.parse(viewNode.getAttributes(),textView);
    }

    @Override
    protected TextView createView(Context context) {
        return new TextView(context);
    }
}

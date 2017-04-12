package xmlviewtonative.viewparse.iViews;

import android.content.Context;
import android.view.View;

import com.focustech.xmlviewtonative.base.ViewNode;

import xmlviewtonative.viewparse.attributesParse.IAttributeParseInfo;
import xmlviewtonative.viewparse.attributesParse.subs.IAttributesParse;
import xmlviewtonative.viewparse.attributesParse.ViewAttributeParse;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class ViewImp<T extends View> implements IView<T> {

   private IAttributeParseInfo<T> parse = new ViewAttributeParse();

    @Override
    public T parse(ViewNode viewNode, Context context) {
        T view = createView(context);
        if(viewNode.getAttributes()==null){
            return view;
        }

        return parse.parse(viewNode.getAttributes(),view);
    }

    protected T createView(Context context) {
        return (T) new View(context);
    }
}

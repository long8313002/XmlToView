package xmlviewtonative.viewparse.iViews;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.focustech.xmlviewtonative.base.ViewNode;

import java.util.List;

import xmlviewtonative.viewparse.ViewParseFactory;
import xmlviewtonative.viewparse.layoutParse.ILayoutParamParse;
import xmlviewtonative.viewparse.layoutParse.ViewGroupLayoutParse;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public abstract class ViewGroupAbs<T extends ViewGroup> extends ViewImp<T> {

    private ILayoutParamParse<ViewGroup.LayoutParams> layoutParse = new ViewGroupLayoutParse();

    @Override
    public T parse(ViewNode viewNode, Context context) {
        T group = super.parse(viewNode, context);
        List<ViewNode> childs = viewNode.getChilds();
        for (ViewNode node:childs){
            IView<View> iview = ViewParseFactory.parse(node.getViewName());
            View childView = iview.parse(node, context);
            group.addView(childView,createLayoutParam(context,node));
        }
        return group;
    }

    @Override
    protected abstract T createView(Context context);

    protected  ViewGroup.LayoutParams createLayoutParam(Context context,ViewNode node){
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(-2,-2);
        if(node.getAttributes()==null){
            return lp;
        }
        return layoutParse.parse(context,node.getAttributes(),lp);
    }

}

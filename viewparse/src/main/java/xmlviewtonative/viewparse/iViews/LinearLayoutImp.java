package xmlviewtonative.viewparse.iViews;

import android.content.Context;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.focustech.xmlviewtonative.base.ViewNode;

import xmlviewtonative.viewparse.attributesParse.IAttributeParseInfo;
import xmlviewtonative.viewparse.attributesParse.LinearLayoutParseInfo;
import xmlviewtonative.viewparse.layoutParse.ILayoutParamParse;
import xmlviewtonative.viewparse.layoutParse.LinearLayoutParse;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class LinearLayoutImp extends ViewGroupAbs<LinearLayout> {

    private IAttributeParseInfo<LinearLayout> parse = new LinearLayoutParseInfo();
    private ILayoutParamParse<LinearLayout.LayoutParams> layoutParse = new LinearLayoutParse();

    @Override
    public LinearLayout parse(ViewNode viewNode, Context context) {
        LinearLayout linearLayout = super.parse(viewNode, context);
        if (viewNode.getAttributes() == null) {
            return linearLayout;
        }
        return parse.parse(viewNode.getAttributes(), linearLayout);
    }

    @Override
    protected LinearLayout createView(Context context) {
        return new LinearLayout(context);
    }

    @Override
    protected ViewGroup.LayoutParams createLayoutParam(Context context, ViewNode node) {
        ViewGroup.LayoutParams parentLp = super.createLayoutParam(context, node);
        if (node.getAttributes() == null) {
            return parentLp;
        }
        LinearLayout.LayoutParams lp;
        if(parentLp instanceof LinearLayout.LayoutParams){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                lp =  new LinearLayout.LayoutParams((LinearLayout.LayoutParams) parentLp);
            }else{
                lp = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) parentLp);
            }
        } else if (parentLp instanceof ViewGroup.MarginLayoutParams) {
            lp = new LinearLayout.LayoutParams((ViewGroup.MarginLayoutParams) parentLp);
        } else {
            lp = new LinearLayout.LayoutParams(parentLp);
        }
        return layoutParse.parse(context, node.getAttributes(), lp);
    }
}

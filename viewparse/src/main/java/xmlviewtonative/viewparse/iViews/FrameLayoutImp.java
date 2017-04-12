package xmlviewtonative.viewparse.iViews;

import android.content.Context;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.focustech.xmlviewtonative.base.ViewNode;

import xmlviewtonative.viewparse.layoutParse.FrameLayoutparse;
import xmlviewtonative.viewparse.layoutParse.ILayoutParamParse;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class FrameLayoutImp extends ViewGroupAbs<FrameLayout> {

    private ILayoutParamParse<FrameLayout.LayoutParams> layoutParse = new FrameLayoutparse();

    @Override
    protected FrameLayout createView(Context context) {
        return new FrameLayout(context);
    }

    @Override
    protected ViewGroup.LayoutParams createLayoutParam(Context context,ViewNode node) {
        ViewGroup.LayoutParams preLp = super.createLayoutParam(context, node);
        if(node.getAttributes() == null){
            return preLp;
        }
        FrameLayout.LayoutParams lp;
        if(preLp instanceof FrameLayout.LayoutParams){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                lp= new FrameLayout.LayoutParams((FrameLayout.LayoutParams)preLp);
            }else{
                lp= new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)preLp);
            }
        }
        else if(preLp instanceof ViewGroup.MarginLayoutParams){
            lp= new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams)preLp);
        }else{
            lp= new FrameLayout.LayoutParams(preLp);
        }

        return layoutParse.parse(context,node.getAttributes(),lp);
    }
}

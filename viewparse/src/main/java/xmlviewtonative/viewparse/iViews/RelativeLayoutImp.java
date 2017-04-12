package xmlviewtonative.viewparse.iViews;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.focustech.xmlviewtonative.base.ViewNode;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class RelativeLayoutImp extends ViewGroupAbs<RelativeLayout> {
    @Override
    protected RelativeLayout createView(Context context) {
        return new RelativeLayout(context);
    }

    @Override
    protected ViewGroup.LayoutParams createLayoutParam(Context context,ViewNode node) {
        return new RelativeLayout.LayoutParams(-2,-2);
    }
}

package xmlviewtonative.viewparse;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.focustech.xmlviewtonative.base.ViewNode;

import xmlviewtonative.viewparse.iViews.IView;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class BaseFramLayout extends FrameLayout {

    public BaseFramLayout(Context context, ViewNode viewNode) {
        super(context);
        parse(viewNode);
    }

    private void parse(ViewNode viewNode){
        IView<View> parse = ViewParseFactory.parse(viewNode.getViewName());
        View contentView = parse.parse(viewNode, getContext());
        addView(contentView);
    }


}

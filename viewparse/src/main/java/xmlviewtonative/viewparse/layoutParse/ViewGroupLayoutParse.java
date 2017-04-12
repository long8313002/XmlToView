package xmlviewtonative.viewparse.layoutParse;

import android.content.Context;
import android.view.ViewGroup;

import java.util.HashMap;

import xmlviewtonative.viewparse.layoutParse.subs.WidthHeightLayoutParse;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class ViewGroupLayoutParse implements ILayoutParamParse {

    private static ILayoutParamParse widthheightparse = WidthHeightLayoutParse.getInstance();

    @Override
    public ViewGroup.LayoutParams parse(Context context, HashMap params, ViewGroup.LayoutParams lp) {
        lp = widthHeightLayoutParse(context, params, lp);
        return lp;
    }


    private ViewGroup.LayoutParams widthHeightLayoutParse(
            Context context, HashMap params, ViewGroup.LayoutParams lp){
        return widthheightparse.parse(context,params,lp);
    }
}

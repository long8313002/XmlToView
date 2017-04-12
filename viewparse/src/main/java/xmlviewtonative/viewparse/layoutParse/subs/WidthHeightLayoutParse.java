package xmlviewtonative.viewparse.layoutParse.subs;

import android.content.Context;
import android.view.ViewGroup;

import java.util.HashMap;

import xmlviewtonative.viewparse.ResourceUtils;
import xmlviewtonative.viewparse.layoutParse.ILayoutParamParse;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class WidthHeightLayoutParse implements ILayoutParamParse {

    private static ILayoutParamParse parse = new WidthHeightLayoutParse();

    public static ILayoutParamParse getInstance(){
        return parse;
    }

    private WidthHeightLayoutParse(){}

    @Override
    public ViewGroup.LayoutParams parse(Context context, HashMap params, ViewGroup.LayoutParams lp) {
        if (params == null || !params.containsKey("android:layout_width")
                || !params.containsKey("android:layout_height")) {
            return lp;
        }
        String width = (String) params.get("android:layout_width");
        String height = (String) params.get("android:layout_height");

        if (width.equals("wrap_content")) {
            lp.width = -2;
        }
        if (width.equals("match_parent")) {
            lp.width = -1;
        }
        if (width.endsWith("dp")) {
            lp.width = Integer.valueOf(width.replace("dp", ""));
            lp.width = ResourceUtils.dip2px(context, lp.width);
        }
        if (height.equals("wrap_content")) {
            lp.height = -2;
        }
        if (height.equals("match_parent")) {
            lp.height = -1;
        }
        if(height.endsWith("dp")){
            lp.height = Integer.valueOf(height.replace("dp", ""));
            lp.height = ResourceUtils.dip2px(context, lp.height);
        }
        return lp;
    }
}

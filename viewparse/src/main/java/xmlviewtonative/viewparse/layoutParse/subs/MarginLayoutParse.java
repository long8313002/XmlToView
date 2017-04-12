package xmlviewtonative.viewparse.layoutParse.subs;

import android.content.Context;
import android.view.ViewGroup;

import java.util.HashMap;

import xmlviewtonative.viewparse.ResourceUtils;
import xmlviewtonative.viewparse.layoutParse.ILayoutParamParse;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class MarginLayoutParse implements ILayoutParamParse<ViewGroup.MarginLayoutParams> {

    private static ILayoutParamParse<ViewGroup.MarginLayoutParams> iparse = new MarginLayoutParse();

    public static ILayoutParamParse<ViewGroup.MarginLayoutParams> getInstance(){
        return iparse;
    }

    private MarginLayoutParse(){}

    @Override
    public ViewGroup.LayoutParams parse(Context context, HashMap<String, String> params, ViewGroup.MarginLayoutParams lp) {

        if(params.containsKey("android:layout_marginLeft")){
            lp.leftMargin = (int) ResourceUtils.getDimension(params.get("android:layout_marginLeft"),context);
        }

        if(params.containsKey("android:layout_marginTop")){
            lp.topMargin = (int) ResourceUtils.getDimension(params.get("android:layout_marginTop"),context);
        }

        if(params.containsKey("android:layout_marginRight")){
            lp.rightMargin = (int) ResourceUtils.getDimension(params.get("android:layout_marginRight"),context);
        }

        if(params.containsKey("android:layout_marginBottom")){
            lp.bottomMargin = (int) ResourceUtils.getDimension(params.get("android:layout_marginBottom"),context);
        }

        if(params.containsKey("android:layout_margin")){
            int margin = (int) ResourceUtils.getDimension(params.get("android:layout_margin"),context);
            lp.leftMargin = margin;
            lp.topMargin = margin;
            lp.rightMargin = margin;
            lp.bottomMargin = margin;
        }

        return lp;
    }
}

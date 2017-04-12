package xmlviewtonative.viewparse.layoutParse;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.HashMap;
import java.util.List;

import xmlviewtonative.viewparse.layoutParse.subs.MarginLayoutParse;

/**
 * Created by zhangzheng on 2017/4/10.
 */

@SuppressWarnings("WrongConstant")
public class LinearLayoutParse implements ILayoutParamParse<LinearLayout.LayoutParams> {

    private ILayoutParamParse<ViewGroup.MarginLayoutParams> marginParse = MarginLayoutParse.getInstance();
    private ILayoutParamParse<LinearLayout.LayoutParams> gravityParse = GravityLayoutParse.getInstance();

    @Override
    public ViewGroup.LayoutParams parse(Context context, HashMap<String, String> params, LinearLayout.LayoutParams lp) {
        lp = (LinearLayout.LayoutParams) gravityParse.parse(context,params,lp);
        return marginParse.parse(context, params, lp);
    }

    public static class GravityLayoutParse implements ILayoutParamParse<LinearLayout.LayoutParams> {

        static ILayoutParamParse parse = new GravityLayoutParse();

        public static ILayoutParamParse getInstance() {
            return parse;
        }

        private GravityLayoutParse(){}

        @Override
        public ViewGroup.LayoutParams parse(Context context, HashMap<String, String> params, LinearLayout.LayoutParams lp) {
            return gravityLayoutParse(params, lp);
        }

        private LinearLayout.LayoutParams gravityLayoutParse(
                HashMap<String, String> params, LinearLayout.LayoutParams lp) {

            if (params.containsKey("android:layout_gravity")) {
                String gravity = params.get("android:layout_gravity");
                if (gravity.contains("|")) {
                    parseGravity(lp, gravity.split("|"));
                } else {
                    parseGravity(lp, new String[]{gravity});
                }

            }
            return lp;
        }

        private void parseGravity(LinearLayout.LayoutParams lp, String[] gravitys) {
            lp.gravity = 0;
            for (String gravity : gravitys) {
                if (gravity.equals("center_horizontal")) {
                    lp.gravity = lp.gravity | Gravity.CENTER_HORIZONTAL;
                } else if (gravity.equals("center_vertical")) {
                    lp.gravity = lp.gravity | Gravity.CENTER_VERTICAL;
                } else if (gravity.equals("center")) {
                    lp.gravity = lp.gravity | Gravity.CENTER;
                } else if (gravity.equals("left")) {
                    lp.gravity = lp.gravity | Gravity.LEFT;
                } else if (gravity.equals("top")) {
                    lp.gravity = lp.gravity | Gravity.TOP;
                } else if (gravity.equals("right")) {
                    lp.gravity = lp.gravity | Gravity.RIGHT;
                } else if (gravity.equals("bottom")) {
                    lp.gravity = lp.gravity | Gravity.BOTTOM;
                } else if (gravity.equals("start")) {
                    lp.gravity = lp.gravity | Gravity.START;
                } else if (gravity.equals("end")) {
                    lp.gravity = lp.gravity | Gravity.END;
                } else if (gravity.equals("fill_horizontal")) {
                    lp.gravity = lp.gravity | Gravity.FILL_HORIZONTAL;
                } else if (gravity.equals("fill_vertical")) {
                    lp.gravity = lp.gravity | Gravity.FILL_VERTICAL;
                } else if (gravity.equals("clip_horizontal")) {
                    lp.gravity = lp.gravity | Gravity.CLIP_HORIZONTAL;
                } else if (gravity.equals("clip_vertical")) {
                    lp.gravity = lp.gravity | Gravity.CLIP_VERTICAL;
                }
            }
        }

    }


}

package xmlviewtonative.viewparse;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class ResourceUtils {

    public static int getResourceId(String componentValue, Context context) {
        componentValue = componentValue.replace("@", "");
        String type = componentValue.split("/")[0];
        String name = componentValue.split("/")[1];
        String packageName = context.getPackageName();
        if (type.contains("android:")) {
            packageName = "android";
            type = type.replaceAll("android:", "");
        }
        if (type.equals("+id")) {
            type = "id";
        }
        return context.getResources().getIdentifier(name, type, packageName);
    }

    public static Drawable getBackGround(String componentValue, Context context) {
        if (componentValue.contains("#")) {
            return new ColorDrawable(Color.parseColor(componentValue));
        }

        return context.getResources().getDrawable(getResourceId(componentValue, context));
    }

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);

    }

    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static float getDimension(String componentValue, Context context) {
        if (componentValue.endsWith("dp")) {
            return dip2px(context, Float.valueOf(componentValue.replace("dp", "")));
        }
        return context.getResources().getDimension(getResourceId(componentValue, context));
    }
}

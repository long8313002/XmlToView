package xmlviewtonative.viewparse.layoutParse;

import android.content.Context;
import android.view.ViewGroup;

import java.util.HashMap;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public interface ILayoutParamParse<T extends ViewGroup.LayoutParams> {

    ViewGroup.LayoutParams parse(Context context,HashMap<String, String> params, T lp);
}

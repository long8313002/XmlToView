package xmlviewtonative.viewparse.iViews;

import android.content.Context;
import android.view.View;

import com.focustech.xmlviewtonative.base.ViewNode;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public interface IView<T> {

    public T parse(ViewNode viewNode, Context context);
}

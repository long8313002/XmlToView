package xmlviewtonative.viewparse.attributesParse.subs;

import android.view.View;

import java.util.HashMap;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public interface IAttributesParse<T extends View> {

    void parseAttribute(HashMap<String,String> attribute,T view);
}

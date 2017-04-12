package xmlviewtonative.viewparse.attributesParse;

import android.view.View;

import java.util.HashMap;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public interface IAttributeParseInfo<T extends View> {

    T parse(HashMap<String,String> params,T view);

}

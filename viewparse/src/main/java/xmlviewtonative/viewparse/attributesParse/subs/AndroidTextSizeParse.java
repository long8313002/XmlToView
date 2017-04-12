package xmlviewtonative.viewparse.attributesParse.subs;

import android.util.TypedValue;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class AndroidTextSizeParse implements IAttributesParse<TextView> {
    @Override
    public void parseAttribute(HashMap<String, String> attribute, TextView textView) {
        if(attribute.containsKey("android:textSize")){
            String value = attribute.get("android:textSize");
            if(value.endsWith("sp")){
                float textSize = Float.valueOf(value.replace("sp",""));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
            }

            if(value.endsWith("dp")){
                float textSize = Float.valueOf(value.replace("dp",""));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSize);
            }

            if(value.endsWith("dip")){
                float textSize = Float.valueOf(value.replace("dip",""));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSize);
            }

            if(value.endsWith("px")){
                float textSize = Float.valueOf(value.replace("px",""));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            }

            if(value.endsWith("pt")){
                float textSize = Float.valueOf(value.replace("pt",""));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PT, textSize);
            }

            if(value.endsWith("in")){
                float textSize = Float.valueOf(value.replace("pt",""));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_IN, textSize);
            }

            if(value.endsWith("mm")){
                float textSize = Float.valueOf(value.replace("pt",""));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_MM, textSize);
            }

        }
    }
}

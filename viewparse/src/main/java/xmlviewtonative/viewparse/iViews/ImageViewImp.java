package xmlviewtonative.viewparse.iViews;

import android.content.Context;
import android.widget.ImageView;

import com.focustech.xmlviewtonative.base.ViewNode;

import xmlviewtonative.viewparse.ResourceUtils;
import xmlviewtonative.viewparse.attributesParse.IAttributeParseInfo;
import xmlviewtonative.viewparse.attributesParse.ImageViewAttributeParse;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class ImageViewImp extends ViewImp<ImageView> {

    private IAttributeParseInfo<ImageView> attributeParse = new ImageViewAttributeParse();

    @Override
    public ImageView parse(ViewNode viewNode, Context context) {
        ImageView imageView = super.parse(viewNode, context);
        if(viewNode.getAttributes()==null){
            return imageView;
        }

        return attributeParse.parse(viewNode.getAttributes(),imageView);
    }

    @Override
    protected ImageView createView(Context context) {
        return new ImageView(context);
    }
}

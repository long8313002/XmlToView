package xmlviewtonative.viewparse;

import android.view.View;

import xmlviewtonative.viewparse.iViews.ButtonImp;
import xmlviewtonative.viewparse.iViews.EditTextImp;
import xmlviewtonative.viewparse.iViews.FrameLayoutImp;
import xmlviewtonative.viewparse.iViews.IView;
import xmlviewtonative.viewparse.iViews.ImageViewImp;
import xmlviewtonative.viewparse.iViews.LinearLayoutImp;
import xmlviewtonative.viewparse.iViews.RelativeLayoutImp;
import xmlviewtonative.viewparse.iViews.TextViewImp;
import xmlviewtonative.viewparse.iViews.ViewImp;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class ViewParseFactory {

    @SuppressWarnings("unchecked")
    public static <T extends View> IView<T> parse(String viewName) {

        if (viewName.equals("FrameLayout")) {
            return (IView<T>) new FrameLayoutImp();
        } else if (viewName.equals("LinearLayout")) {
            return (IView<T>) new LinearLayoutImp();
        } else if (viewName.equals("RelativeLayout")) {
            return (IView<T>) new RelativeLayoutImp();
        } else if (viewName.equals("TextView")) {
            return (IView<T>) new TextViewImp();
        } else if (viewName.equals("Button")) {
            return (IView<T>) new ButtonImp();
        } else if (viewName.equals("CheckBox")) {

        }else if (viewName.equals("ImageView")) {
            return (IView<T>) new ImageViewImp();
        } else if (viewName.equals("View")) {
            return new ViewImp();
        }else if(viewName.equals("EditText")){
            return (IView<T>) new EditTextImp();
        }

        return new ViewImp();

    }
}

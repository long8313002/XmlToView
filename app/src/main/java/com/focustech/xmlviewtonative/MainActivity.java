package com.focustech.xmlviewtonative;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.focustech.FastInflate_activity_mainxml;
import com.focustech.annotations.SetContentView;
import com.focustech.xmlviewtonative.base.ViewNode;
import com.focustech.xmlviewtonative.base.XMLParse;

import xmlviewtonative.viewparse.BaseFramLayout;


@SetContentView(R.layout.activity_main)
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 根据插件 将XML 转换成JAVA代码
         */
        View rootView = FastInflate_activity_mainxml.getRootView(this);
        setContentView(rootView);

        /**
         * 加载本地XML布局
         */
        try {
            ViewNode parse = new XMLParse(getAssets().open("activity_main.xml")).parse();
            BaseFramLayout baseFramLayout = new BaseFramLayout(this, parse);
            setContentView(baseFramLayout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

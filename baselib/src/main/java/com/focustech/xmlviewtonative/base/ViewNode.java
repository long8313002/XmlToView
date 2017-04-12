package com.focustech.xmlviewtonative.base;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * 视图节点信息
 * Created by zhangzheng on 2017/4/10.
 */

public class ViewNode implements Serializable {

    private String viewName;

    private HashMap<String, String> attributes;

    private List<ViewNode> childs;

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }

    public List<ViewNode> getChilds() {
        return childs;
    }

    public void setChilds(List<ViewNode> childs) {
        this.childs = childs;
    }

    @Override
    public String toString() {
        return "ViewNode{" +
                "viewName='" + viewName + '\'' +
                ", attributes=" + attributes +
                ", childs=" + childs +
                '}';
    }
}

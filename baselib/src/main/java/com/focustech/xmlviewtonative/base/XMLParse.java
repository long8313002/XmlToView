package com.focustech.xmlviewtonative.base;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by zhangzheng on 2017/4/10.
 */

public class XMLParse {

    private InputStream in;

    public XMLParse(InputStream in) {

        this.in = in;
    }

    public ViewNode parse() throws Exception {
        if (in == null) {
            return null;
        }

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = dbf.newDocumentBuilder();

        Document doc = db.parse(in);

        doc.getDocumentElement().normalize();

        Element rootElement = doc.getDocumentElement();

        return parseNode(rootElement);
    }

    private ViewNode parseNode(Node node) {
        if (node.getNodeType() != Element.ELEMENT_NODE) {
            return null;
        }

        ViewNode viewNode = new ViewNode();
        viewNode.setViewName(node.getNodeName());

        NamedNodeMap attributes = node.getAttributes();

        HashMap<String, String> attributeMap = new HashMap<>();

        for (int j = 0; j < attributes.getLength(); j++) {
            Node item = attributes.item(j);
            attributeMap.put(item.getNodeName(), item.getNodeValue());
        }

        viewNode.setAttributes(attributeMap);

        NodeList childNodes = node.getChildNodes();
        if (childNodes == null || childNodes.getLength() == 0) {
            return viewNode;
        }
        viewNode.setChilds(parseNodeList(childNodes));

        return viewNode;
    }

    private List<ViewNode> parseNodeList(NodeList nList) {
        List<ViewNode> childNodes = new ArrayList<>();
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            ViewNode viewNode = parseNode(node);
            if (viewNode != null) {
                childNodes.add(viewNode);
            }
        }
        return childNodes;
    }
}

package com.github.jioong.dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;

/**
 * Created by jioong on 17-5-16.
 */
public class App {

    public Document parse(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(url);

        return doc;
    }

    public void bar(Document doc) {
        Element root = doc.getRootElement();

        // 获取根节点的子节点迭代
        for(Iterator i = root.elementIterator(); i.hasNext();) {
            Element element = (Element) i.next();

        }

        // 获取根节点的指定名字的元素的迭代
        for(Iterator i = root.elementIterator("name"); i.hasNext();) {
            Element element = (Element) i.next();

        }

        // 获取根节点的属性
        for(Iterator i = root.attributeIterator(); i.hasNext();) {
            Attribute attribute = (Attribute) i.next();

        }
    }
}

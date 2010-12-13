package com.nss.portlet.journalworkflow.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlRead {
	public static Document read(String path) {
		Document result = null;
		File file = new File(path);
		SAXReader saxReader = new SAXReader();
		try {
			result = saxReader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Document parse(String xml) {
		Document result = null;
		try {
			result = DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Document read(InputStream is) {
		Document result = null;
		SAXReader saxReader = new SAXReader();
		try {
			result = saxReader.read(is);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void write(Document document, String path) {
		try {
			OutputFormat outputFormat = new OutputFormat("  ", true, document
					.getXMLEncoding());
			XMLWriter xmlWriter = new XMLWriter(new FileWriter(path),
					outputFormat);
			xmlWriter.write(document);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> childrenValue(String key, Element element) {
		List<String> result = new ArrayList<String>();
		List children = element.elements();
		Iterator<Element> iterator = children.iterator();
		while (iterator.hasNext()) {
			String s = iterator.next().attributeValue(key);
			if (s != null)
				result.add(s);
		}
		return result;
	}
	
	public static List<String> childrenValue(String key, String xml) {
		return childrenValue(key, parse(xml).getRootElement());
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> getNodeName(String name, String xml) {
		List<String> result = new ArrayList<String>();
		Document document = XmlRead.parse(xml);
		Iterator<Element> iterator = document.getRootElement().elementIterator();
		Element element;
		while (iterator.hasNext()) {
			element = iterator.next();
			if(element.getName().equalsIgnoreCase(name)) {
				result.add(element.attributeValue("name"));
			}
		}
		return result;
	}

//	public static void main(String[] args) {
//		String s = "<root>\n\t<name>canh</name>\n\t<value>30</value>\n</root>";
//
//		Document d = XmlRead.parse(s);
//		Element e = d.getRootElement();
//		
//		System.out.println(e.getNodeTypeName());
//		System.out.println(d.getRootElement().asXML());
//
//	}
}

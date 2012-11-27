package com.test;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Test {
	private static XPathExpression xpathexpression;

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		Test tes=new Test();
		tes.readxml();
		xpathexpression=xPath.compile("/BatchCollection/Mapping");
		Element element=(Element) xpathexpression.evaluate(doc, XPathConstants.NODE);
		System.out.println(element.getAttribute("TransformationPackageID"));
	}

	private static Document doc;
	private static XPath xPath;
	
	private void readxml() throws SAXException, IOException, ParserConfigurationException  {		
		File xmlFile = new File ("GenericPTGInput.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();
		xPath = XPathFactory.newInstance().newXPath();
	}
}

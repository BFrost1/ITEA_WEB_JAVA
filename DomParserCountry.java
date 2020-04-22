package com.shop.parser;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.TreeSet;

public class DomParserCountry {

    public static TreeSet country(){
        TreeSet<String> arrayCountry = new TreeSet<>();
        try {
            NodeList nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("https://www.artlebedev.ru/country-list/xml/").getElementsByTagName("country");
            for (int i = 0; i < nodeList.getLength(); i++) {
                for (int q = 0; q < nodeList.item(i).getChildNodes().getLength(); q++){
                    if(nodeList.item(i).getChildNodes().item(q).getNodeName().equals("english")){
                        arrayCountry.add(nodeList.item(i).getChildNodes().item(q).getTextContent());
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayCountry;
    }

}

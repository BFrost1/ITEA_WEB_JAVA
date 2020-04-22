package com.shop.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserCountry extends DefaultHandler {
    String elementValue;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValue = new String(ch, start, length);
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("english") && !elementValue.equals("На английском")) {
            System.out.println(elementValue);
        }
}}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valentin
 */
public class XmlParser {
    
    private static XmlParser instance = null;
    private Document document;
    
    public static XmlParser getInstance(){
        if(instance == null)
            return new XmlParser();
        else
            return instance;
    }
    
    private XmlParser(){
        try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File inputFile = new File("xml/tools.xml");

        document = builder.parse(inputFile);
        document.getDocumentElement().normalize();
        } catch (Exception ex) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public NodeList getTools(){
        try {
            NodeList tools = document.getElementsByTagName("tool");
            return tools;
        } catch (Exception ex) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

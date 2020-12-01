/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import model.Tool;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import util.SAXParser;

/**
 *
 * @author Valentin
 */

public class ListController extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SAXParser saxParser = new SAXParser();
            NodeList nodesEx1 = saxParser.parse("tools.xml", "/", XPathConstants.NODESET);
            for (int i = 0; i < nodesEx1.getLength(); i++) {
                System.out.println(nodesEx1.item(i).getAttributes().getNamedItem("href").getNodeValue());
            }
     
        } catch (XPathExpressionException ex) {
            Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Tool tool = new Tool(1, "description", "url");
        request.getSession().setAttribute("tool", tool);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
       

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import util.XmlParser;

/**
 *
 * @author Valentin
 */
public class ShowDetailsView extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            // Task no 6 Allow the user to see all the information for a specific tool. Use XPATH/ XQuery
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            XPathExpression expr = xpath.compile(String.format("/tools/tool[@id='%s']", request.getParameter("id")));
            
            XmlParser xmlParser = XmlParser.getInstance();
            
            NodeList tools = (NodeList) expr.evaluate(xmlParser.getDocument(), XPathConstants.NODESET);
            Document newDocument = xmlParser.createXmlFromNodeList(tools);
            
            File xsl = new File("xml/showDetails.xsl");
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            StreamSource style = new StreamSource(xsl);
            Transformer transformer = transformerFactory.newTransformer(style);
            
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            transformer.transform(new DOMSource(newDocument), result);
           
            PrintWriter out = response.getWriter();
            
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\"/>\n"
                    + "        <title>Show Details</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width\">\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <div id=\"content\">\n"
                    + "        <div class=\"header\">\n"
                    + "            <span class=\"header-text\">Learning And Teaching Tools</span>\n"
                    + "        </div>\n"
                    + "        <nav>\n"
                    + "            <ul>\n"
                    + "                    <a href=\"index.jsp\">Home</a>\n"
                    + "                    <a href=\"ListView\">List of tools</a>\n"
                    + "                    <a href=\"AddView\">Add new tool</a>\n"
                    + "            </ul>\n"
                    + "        </nav>\n"
                    + "            <h1>Details for</h1>   \n");
            out.println(writer.toString());
            out.println("    </body>\n"
                    + "</html>\n");
        } catch (Exception ex) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

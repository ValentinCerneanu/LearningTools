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
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import util.XmlParser;

/**
 *
 * @author Valentin
 */
public class ListView extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            // Tasl no 5 Display on your web interface the list of tools from your local XML
            File xml = new File("xml/tools.xml");
            File xsl = new File("xml/checkType.xsl");
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            StreamSource style = new StreamSource(xsl);
            Transformer transformer = transformerFactory.newTransformer(style);
            
            StreamSource source = new StreamSource (xml);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
           
            PrintWriter out = response.getWriter();
            
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\"/>\n"
                    + "        <title>Login</title>\n"
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
                    + "            <h1>List of tools</h1>   \n");
            out.println(writer.toString());
            out.println("    </body>\n"
                    + "</html>\n");
        } catch (Exception ex) {
            Logger.getLogger(XmlParser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

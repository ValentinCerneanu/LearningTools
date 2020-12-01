/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            String error = "";
            if (request.getAttribute("LOGIN_ERROR") != null) {
                error = (String) request.getAttribute("LOGIN_ERROR");
            }

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
                    + "            <img src=\"./img/companyLogo.jpg\" width=\"100px\"  />\n"
                    + "            <span class=\"header-text\">COMPANY NAME</span>\n"
                    + "        </div>\n"
                    + "        <nav>\n"
                    + "            <ul>\n"
                    + "                    <a href=\"index.jsp\">Home</a>\n"
                    + "                    <a href=\"ListView\">List of tools</a>\n"
                    + "                    <a href=\"AddView\">Add new tool</a>\n"
                    + "            </ul>\n"
                    + "        </nav>\n"
                    + "            <h1>Add new tool form</h1>   \n"
+"<a href=\"RegistrationView\">Register</a>\n");

            if (!"".equals(error)) {
                out.println("<div class=\"error\">" + error + "</div>");
            }
            out.println("                <div class=\"form-element\">\n"
                    + "                      <input type=\"submit\" value=\"Submit\">\n"
                    + "                    <input type=\"reset\" value=\"Reset\">\n"
                    + "                </div>\n"
                    + "            </form>\n"
                    + "        </div>\n"
                    + "    </body>\n"
                    + "</html>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

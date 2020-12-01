/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valentin
 */
public class AddView extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {

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
                    + "        <div w3-include-html=\"bar.html\"></div>\n"
                    + "        <nav>\n"
                    + "            <ul>\n"
                    + "                    <a href=\"index.jsp\">Home</a>\n"
                    + "                    <a href=\"ListView\">List of tools</a>\n"
                    + "                    <a href=\"AddView\">Add new tool</a>\n"
                    + "            </ul>\n"
                    + "        </nav>\n"
                    + "            <h1>Add new tool form</h1>   \n"
                    + "            <form method=\"post\" action=\"LoginController\">\n"
                    + "               <div class=\"form-element\">\n"
                    + "                    <label for=\"name\">Name</label>\n"
                    + "                    <input type=\"text\" name=\"uname\" id=\"uname\" required>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-element\">\n"
                    + "                    <label for=\"description\">Description</label>\n"
                    + "                    <input type=\"text\" name=\"description\" id=\"description\" required>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-element\">\n"
                    + "                    <label for=\"url\">Url</label>\n"
                    + "                    <input type=\"text\" name=\"url\" id=\"url\" required>\n"
                    + "                </div>\n"
                    + "                <div class=\"form-element\">\n"
                    + "                        <input type=\"radio\" id=\"free\" name=\"price\" value=\"free\">\n"
                    + "                        <label for=\"free\">Free</label><br>\n"
                    + "                        <input type=\"radio\" id=\"paid\" name=\"price\" value=\"paid\">\n"
                    + "                       <label for=\"paid\">Paid</label><br>\n"
                    + "                </div>\n"
                    + "                 <a href=\"RegistrationView\">Register</a>\n");

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

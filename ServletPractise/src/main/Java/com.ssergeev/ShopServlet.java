package com.ssergeev;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ShopServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String userName = req.getParameter("userName");
        printWriter.print("<H1>Hello, " + userName +"</H1>");
        printWriter.print("<div>Make your order:</div>");
        printWriter.print(
            "<form action=\"/check\" method=\"POST\">" +
                "<select name=\"item\" multiple>" +
                    "<option value=\"1.0\">Matches (1,0$)</option>" +
                    "<option value=\"5.5\">Book (5,5$)</option>" +
                    "<option value=\"36.5\">Chair (36,5$)</option>" +
                    "<option value=\"99.9\">Mobile phone (99,90$)</option>" +
                    "<option value=\"49990\">Bentley (49990$)</option>" +
                "</select>" + "<br>" +
                "<button>Submit</button>" +
            "</form>"
        );
        printWriter.close();
    }
}

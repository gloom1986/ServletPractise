package com.ssergeev;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<H1>Welcome to Online shop</H1>");
        printWriter.print(
            "<form action=\"/shop\" method=\"POST\">" +
                "<input name=\"userName\">" + "<br>" +
                "<button>" + "Enter" + "</button>" +
            "</form>"
        );
        printWriter.close();

    }
}

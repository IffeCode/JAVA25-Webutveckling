package org.example.gritcrm.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AppController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
        } else {
            //super viktigt att ha med getRequestDispatcher för att det ska gå att öppna
            req.getRequestDispatcher("view/index.jsp").forward(req,resp);
        }


    }
}

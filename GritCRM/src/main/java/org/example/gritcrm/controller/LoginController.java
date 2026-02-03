package org.example.gritcrm.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username") == null ? "" : req.getParameter("username");
        String password = req.getParameter("password") == null ? "" : req.getParameter("password");
        String error = null;

        if(username.isEmpty() || password.isEmpty()){
            error = "Username and/or password cannot be empty";
        }

        //more code to come


        if(error != null){
            req.setAttribute("error", error);
            req.setAttribute("username", username);

            try {

                req.getRequestDispatcher("view/login.jsp").forward(req, resp);

            }catch (Throwable e){
                throw new RuntimeException(e);
            }
        }

    }
}

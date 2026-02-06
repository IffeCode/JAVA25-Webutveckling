package org.example.gritcrm.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.gritcrm.dao.UserDAO;
import org.example.gritcrm.model.User;

import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.getRequestDispatcher("/view/register.jsp").forward(req,resp);
        }catch (Throwable e){
            throw e;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username") == null ? "" : req.getParameter("username");
        String password1 = req.getParameter("password1") == null ? "" : req.getParameter("password1");
        String password2 = req.getParameter("password2") == null ? "" : req.getParameter("password2");
        String error = null;

        if (username.isBlank() || password1.isBlank() || password2.isBlank()) {
            error = "Please fill in all the required fields.";
        }

        if (!password1.equals(password2)) {
            error = "Passwords don't match.";
        }

        if (error != null) {
            req.setAttribute("error", error);
            req.setAttribute("username", username);
            req.setAttribute("password1", password1);
            req.setAttribute("password2", password2);

            try {
                System.out.println("Returning to registation page with error! " + error);
                req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
            }catch (Throwable e){
                throw e;
            }

            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password1);
        UserDAO userDAO =  new UserDAO();
        try {
            userDAO.save(user);
            req.setAttribute("success", "Your user has been successfully registered!");
        }catch (Throwable e){
            req.setAttribute("error", "Your user could not be registered! Sorry! :( ");
            System.out.println(e.getMessage());
        }

        try {
            req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
        }catch (Throwable e){
            throw e;
        }
    }
}

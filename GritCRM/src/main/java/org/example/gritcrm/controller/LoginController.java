package org.example.gritcrm.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.gritcrm.dao.UserDAO;
import org.example.gritcrm.model.User;

import java.io.IOException;
import java.util.Date;

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

        UserDAO userDAO = new UserDAO();
        User user = null;

        try {
            if (error == null) {
                user = userDAO.getUser(username);
                if (user == null) {
                    error = "Username not found!";
                }else {
                    //if we use hash:ed passwords we must hash/verify the password
                    if (user.getPassword().equals(password)) {
                        user.setLastLogin(new Date());
                        userDAO.update(user);

                        //Denna raden gör så att användaren anses vara inloggad
                        HttpSession session = req.getSession();
                        session.setAttribute("user", user);

                    }else {
                        error = "Wrong password!";
                    }
                }

            }

        }catch (Throwable e){
            error = "Something went wrong: " + e.getMessage();
            System.out.println(e);
        }

        if(error != null){
            req.setAttribute("error", error);
            req.setAttribute("username", username);

            try {

                req.getRequestDispatcher("view/login.jsp").forward(req, resp);

            }catch (Throwable e){
                throw new RuntimeException(e);
            }
        }

        try {
            resp.sendRedirect("/");
        }catch (Throwable e){
            throw new RuntimeException(e);
        }
    }
}

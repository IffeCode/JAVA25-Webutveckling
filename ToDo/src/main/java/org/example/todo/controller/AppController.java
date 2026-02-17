package org.example.todo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.todo.dao.TodoDAO;
import org.example.todo.model.Todo;
import org.example.todo.utils.WebUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.servlet.IServletWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class AppController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TemplateEngine engine = WebUtils.getWebEngine(getServletContext());
        WebContext webContext = WebUtils.getWebContext(req, resp, getServletContext());

        List<Todo> todos = new TodoDAO().findAll();

        webContext.setVariable("todos", todos);

        engine.process("/index", webContext, resp.getWriter());

    }
}

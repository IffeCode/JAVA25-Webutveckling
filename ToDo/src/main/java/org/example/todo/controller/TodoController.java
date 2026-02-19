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

import java.io.IOException;

@WebServlet("/todo")
public class TodoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TemplateEngine engine = WebUtils.getWebEngine(getServletContext());
        WebContext webContext = WebUtils.getWebContext(req, resp, getServletContext());


        String sId = req.getParameter("id");
        String sAction = req.getParameter("action");

        if ("toggle".equals(sAction)) {
            onToggle(req, resp);
        }

        if ("edit".equals(sAction)) {
            onEdit(req,resp,webContext,engine);
            return;
        }


        if ("delete".equals(sAction)) {
            onDelete(req, resp);
            return;
        }

        if (sId != null) {
            onView(req,resp,webContext,engine);
            return;

        }

        doErrorRedirect(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoDAO todoDAO = new TodoDAO();
        Todo todo = todoDAO.findById(req.getParameter("id"));
        if (todo == null) {
            todo = new Todo();

        }

        todo.setTitle(req.getParameter("title"));
        todo.setDescription(req.getParameter("description"));
        if ("true".equals(req.getParameter("completed"))) {
            todo.setCompleted(true);
        }else{
            todo.setCompleted(false);
        }

        if (todo.getId() == null) {
            todoDAO.save(todo);
        }else {
            todoDAO.update(todo);
        }

        doSuccessRedirect(req, resp);
    }

    public void onToggle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TodoDAO todoDAO = new TodoDAO();
        Todo todo = todoDAO.findById(req.getParameter("id"));
        if (todo == null) {
            doErrorRedirect(req, resp);
            return;
        }
        todo.setCompleted(!todo.getCompleted()); //toggle completed
        todoDAO.update(todo);
    }

    public void onView(HttpServletRequest req, HttpServletResponse resp, WebContext webContext, TemplateEngine engine) throws ServletException, IOException {

        String sId = req.getParameter("id");
        Todo todo = new TodoDAO().findById(sId);


        if (todo == null) {
            doErrorRedirect(req, resp);
            return;
            }

        webContext.setVariable("todo", todo);
        engine.process("todo/view", webContext, resp.getWriter());
    }

    public void onEdit(HttpServletRequest req, HttpServletResponse resp, WebContext webContext, TemplateEngine engine) throws ServletException, IOException {

        Todo todo = new TodoDAO().findById(req.getParameter("id"));

        if (todo == null) {
            todo = new Todo();
        }

        webContext.setVariable("todo",todo);
        engine.process("todo/edit", webContext, resp.getWriter());

    }

    public void onDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoDAO todoDAO = new TodoDAO();
        Todo todo = todoDAO.findById(req.getParameter("id"));

        if (todo != null) {
            todoDAO.delete(todo);
            doSuccessRedirect(req, resp);
        }else {
            doErrorRedirect(req, resp);
        }

    }

    public void doErrorRedirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/");
    }

    public void doSuccessRedirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/");
    }

}



    /*
        if (sId != null) {
            if (!sId.isEmpty()) {
                int id;
                try {
                    id = Integer.parseInt(sId);
                    Todo todo = new TodoDAO().findById(id);
                    if (todo != null) {
                        webContext.setVariable("todo", todo);
                        engine.process("todo/view", webContext, resp.getWriter());
                        return;
                    }
                }catch (Throwable e){

                }
            }
 */
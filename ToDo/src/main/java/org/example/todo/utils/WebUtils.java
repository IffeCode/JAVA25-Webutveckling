package org.example.todo.utils;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.servlet.IServletWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

public class WebUtils {

    /*        TemplateEngine engine = (TemplateEngine) getServletContext().getAttribute("templateEngine");

        JakartaServletWebApplication webApp = JakartaServletWebApplication.
                buildApplication(getServletContext());

        IServletWebExchange exchange = webApp.buildExchange(req, resp);
        WebContext webContext = new WebContext(exchange, req.getLocale());

     */

    public static TemplateEngine getWebEngine(ServletContext servletContext){
        return (TemplateEngine) servletContext.getAttribute("templateEngine");
    }

    public static WebContext getWebContext(HttpServletRequest req, HttpServletResponse resp,
                                           ServletContext servletContext){

        JakartaServletWebApplication webApp = JakartaServletWebApplication.
                buildApplication(servletContext);

        IServletWebExchange exchange = webApp.buildExchange(req, resp);
        WebContext webContext = new WebContext(exchange, req.getLocale());

        return webContext;
    }

}

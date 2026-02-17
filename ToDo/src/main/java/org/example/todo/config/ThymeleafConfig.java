package org.example.todo.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

@WebListener
public class ThymeleafConfig implements ServletContextListener {

    private TemplateEngine templateEngine;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        //create a webapplication for Thymeleaf
        JakartaServletWebApplication webApplication = JakartaServletWebApplication.
                buildApplication(servletContext);

        //create a webApplicationResolver
        WebApplicationTemplateResolver resolver = new WebApplicationTemplateResolver(webApplication);
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");

        //create the template enigne and configure it with the resolver
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        //Store the template engine in the Servlet Context for later use
        servletContext.setAttribute("templateEngine", templateEngine);

    }
}

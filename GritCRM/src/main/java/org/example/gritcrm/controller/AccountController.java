package org.example.gritcrm.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.gritcrm.dao.AccountDAO;
import org.example.gritcrm.model.Account;

import java.io.IOException;
import java.util.List;

@WebServlet("/account")
public class AccountController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AccountDAO accountDAO = new AccountDAO();


        if (req.getParameter("editId") != null) {
            String sId = req.getParameter("editId");
            Account account = new Account();
            if (sId != null && !sId.isEmpty()) {
                Integer id = Integer.parseInt(sId);
                account = accountDAO.findById(id);

            }

            req.setAttribute("account", account);

            req.getRequestDispatcher("view/account/edit.jsp").forward(req, resp);
            return;
        }

        if (req.getParameter("id") != null) {
           openAndRedirect(req,resp, "id", "/view/account/view.jsp");
           return;
        }

        if (req.getParameter("deleteId") != null) {
            String sId = req.getParameter("deleteId");
            if (sId != null && !sId.isEmpty()) {
                Integer id = Integer.parseInt(sId);
                Account account = accountDAO.findById(id);
                accountDAO.delete(account);
            }
        }


        List<Account>accounts = accountDAO.findAll();
        req.setAttribute("accounts", accounts);


        req.getRequestDispatcher("view/account/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AccountDAO  accountDAO = new AccountDAO();
        Account account = new Account();

        String sId = req.getParameter("id");
        if (sId != null){
            Integer id = Integer.parseInt(sId);
            if (id != 0) {
                account = accountDAO.findById(id);
            }
        }

        if (account == null){
            throw new ServletException("Account with id" + sId + " not found");
        }

        account.setName(req.getParameter("name"));
        account.setAdress(req.getParameter("adress"));
        account.setCountry(req.getParameter("country"));

        if (account.getId() > 0){
            accountDAO.update(account);
        }else {
            accountDAO.save(account);
        }
        List<Account>accounts = accountDAO.findAll();
        req.setAttribute("accounts", accounts);

        req.getRequestDispatcher("view/account/list.jsp").forward(req, resp);
    }

    private void openAndRedirect(HttpServletRequest req, HttpServletResponse resp, String parameterName, String viewURI) throws ServletException, IOException {

        AccountDAO accountDAO = new AccountDAO();
            String sId = req.getParameter(parameterName);
            Account account = new Account();
            if (sId != null && !sId.isEmpty()) {
                Integer id = Integer.parseInt(sId);
                account = accountDAO.findById(id);

            }
            req.setAttribute("account", account);

            req.getRequestDispatcher(viewURI).forward(req, resp);
        }


}

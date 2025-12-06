package com.example.contact.web;

import com.example.contact.dao.ContactDAO;
import com.example.contact.model.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/contacts")
public class ContactServlet extends HttpServlet {
    private ContactDAO dao;

    @Override
    public void init() throws ServletException {
        try {
            dao = new ContactDAO();
        } catch (Exception e) {
            throw new ServletException("Failed to initialize ContactDAO", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            if ("new".equals(action)) {
                req.getRequestDispatcher("/WEB-INF/jsp/contact-form.jsp").forward(req, resp);
            } else if ("edit".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                Contact c = dao.findById(id);
                if (c == null) {
                    setSessionMessage(req, "error", "Contact not found.");
                    resp.sendRedirect(req.getContextPath() + "/contacts");
                    return;
                }
                req.setAttribute("contact", c);
                req.getRequestDispatcher("/WEB-INF/jsp/contact-form.jsp").forward(req, resp);
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                boolean ok = dao.delete(id);
                setSessionMessage(req, ok ? "success" : "error", ok ? "Contact deleted." : "Failed to delete contact.");
                resp.sendRedirect(req.getContextPath() + "/contacts");
            } else {
                List<Contact> list = dao.findAll();
                req.setAttribute("contacts", list);
                req.getRequestDispatcher("/WEB-INF/jsp/contacts.jsp").forward(req, resp);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (NumberFormatException ex) {
            setSessionMessage(req, "error", "Invalid contact id.");
            resp.sendRedirect(req.getContextPath() + "/contacts");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String idStr = req.getParameter("id");
        String name = safeTrim(req.getParameter("name"));
        String email = safeTrim(req.getParameter("email"));
        String phone = safeTrim(req.getParameter("phone"));
        String address = safeTrim(req.getParameter("address"));

        if (name == null || name.isEmpty()) {
            setSessionMessage(req, "error", "Name is required.");
            req.getSession().setAttribute("formData", new Contact(null, name, email, phone, address));
            resp.sendRedirect(req.getContextPath() + "/contacts?action=new");
            return;
        }

        Contact c = new Contact();
        c.setName(name);
        c.setEmail(email);
        c.setPhone(phone);
        c.setAddress(address);

        try {
            boolean ok;
            if (idStr != null && !idStr.isEmpty()) {
                c.setId(Integer.parseInt(idStr));
                ok = dao.update(c);
                setSessionMessage(req, ok ? "success" : "error", ok ? "Contact updated." : "Failed to update contact.");
            } else {
                ok = dao.insert(c);
                setSessionMessage(req, ok ? "success" : "error", ok ? "Contact added." : "Failed to add contact.");
            }
            req.getSession().removeAttribute("formData");
            resp.sendRedirect(req.getContextPath() + "/contacts");
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private String safeTrim(String s) {
        return s == null ? "" : s.trim();
    }

    private void setSessionMessage(HttpServletRequest req, String type, String message) {
        HttpSession sess = req.getSession();
        sess.setAttribute("flash.type", type);
        sess.setAttribute("flash.message", message);
    }
}

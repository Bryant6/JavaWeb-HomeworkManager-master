package com.java.code.Servlet;

import com.java.code.Jdbc.StudentHomeworkJdbc;
import com.java.code.Model.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/companyPub")
public class CompanyPubServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Company company = new Company();

        company.setName(req.getParameter("name"));
        company.setAddress(req.getParameter("address"));
        company.setPhone(req.getParameter("phone"));
        company.setEmail(req.getParameter("email"));
        company.setNature(req.getParameter("nature"));
        company.setIntro(req.getParameter("intro"));

        System.out.println("update:" + company.toString());


        StudentHomeworkJdbc.updateToCompany(company);

        req.getRequestDispatcher("/jsp/manager.jsp").forward(req,resp);
    }
}

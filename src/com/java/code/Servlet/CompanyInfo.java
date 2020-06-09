package com.java.code.Servlet;

import com.java.code.Jdbc.StudentHomeworkJdbc;
import com.java.code.Model.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showCompany")
public class CompanyInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Company company = StudentHomeworkJdbc.selectCompany();

        System.out.println("select:"+company.toString());

        req.setAttribute("company",company);

        req.getRequestDispatcher("/jsp/companyInfo.jsp").forward(req,resp);
    }
}

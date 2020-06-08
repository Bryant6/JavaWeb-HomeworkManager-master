package com.java.code.Servlet;

import com.java.code.Jdbc.StudentHomeworkJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");

        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");

        System.out.println(username+password);

        if(password.equals(password2)){
            StudentHomeworkJdbc.insertToUsernameAndPassword(username,password,0);
        }

        req.getRequestDispatcher("/jsp/login.jsp").forward(req,resp);
    }
}

package com.java.code.Servlet;

import com.java.code.Jdbc.StudentHomeworkJdbc;
import com.java.code.Model.User;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        User user = new User();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username+password);

        if(StudentHomeworkJdbc.selectByUsernameAndPassword(username,password) == 2){
            req.getRequestDispatcher("/jsp/login.jsp").forward(req,resp);
        }else {
            if(StudentHomeworkJdbc.selectByUsernameAndPassword(username,password) == 0){
                req.setAttribute("username",username);
                req.getRequestDispatcher("/jsp/usualUser.jsp").forward(req,resp);
            }else{
                req.getRequestDispatcher("/jsp/manager.jsp").forward(req,resp);
            }
        }
    }
}

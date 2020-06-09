package com.java.code.Servlet;

import com.java.code.Jdbc.StudentHomeworkJdbc;
import com.java.code.Model.Meeting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showMeeting2")
public class ShowMeeting2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Meeting> list = StudentHomeworkJdbc.showMeeting();

        req.setAttribute("list",list);
        req.getRequestDispatcher("/jsp/meetingShow.jsp").forward(req,resp);
    }
}

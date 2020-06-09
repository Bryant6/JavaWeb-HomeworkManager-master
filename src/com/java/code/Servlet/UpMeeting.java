package com.java.code.Servlet;

import com.java.code.Jdbc.StudentHomeworkJdbc;
import com.java.code.Model.Meeting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/upMeeting")
public class UpMeeting extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Meeting meeting = new Meeting();
        int id = Integer.parseInt(req.getParameter("id"));
        meeting.setId(id);
        System.out.println("修改会议id" + req.getParameter("id"));
        meeting.setTitle(req.getParameter("title"));
        meeting.setContent(req.getParameter("content"));
        meeting.setStarttime(req.getParameter("starttime"));
        meeting.setEndtime(req.getParameter("endtime"));
        meeting.setSender(req.getParameter("sender"));
        meeting.setAddress(req.getParameter("address"));

        StudentHomeworkJdbc.updateToMeeting(meeting);
        resp.sendRedirect("/showMeeting");
    }
}

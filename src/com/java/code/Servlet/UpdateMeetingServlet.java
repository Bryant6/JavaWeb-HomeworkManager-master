package com.java.code.Servlet;

import com.java.code.Jdbc.StudentHomeworkJdbc;
import com.java.code.Model.Meeting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateMeeting")
public class UpdateMeetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String method = req.getParameter("method");
        System.out.println("待处理会议id:"+id + method);

        if(method.equals("delete")){
            StudentHomeworkJdbc.DeleteMeeting(id);
            resp.sendRedirect("/showMeeting");
        }
        if(method.equals("update")){
            Meeting meeting = StudentHomeworkJdbc.selectMeetingById(id);
            req.setAttribute("meeting",meeting);
            req.setAttribute("id",id);
            System.out.println(id + " +" + meeting);
            req.getRequestDispatcher("/jsp/updateMeeting.jsp").forward(req,resp);
        }

    }
}

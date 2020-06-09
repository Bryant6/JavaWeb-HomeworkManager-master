package com.java.code.Servlet;

import com.java.code.Jdbc.StudentHomeworkJdbc;
import com.java.code.Model.Meeting;
import com.java.code.Model.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addMeeting")
public class addMeeting extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//设置编码，以防表单提交的内容乱码

        Meeting meeting = new Meeting();

        meeting.setTitle(req.getParameter("title"));
        meeting.setContent(req.getParameter("content"));
        meeting.setStarttime(req.getParameter("starttime"));
        meeting.setEndtime(req.getParameter("endtime"));
        meeting.setSender(req.getParameter("sender"));
        meeting.setAddress(req.getParameter("address"));

        boolean result = StudentHomeworkJdbc.addMeeting(meeting);

        req.setAttribute("isOK", result);    //用来判断是否添加会议成功
        req.setAttribute("type","addMeeting");
        req.getRequestDispatcher("result.jsp").forward(req,resp);
    }
}

package com.java.code.Servlet;

import com.java.code.Jdbc.StudentHomeworkJdbc;
import com.java.code.Model.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addNotice")
public class addNoticeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");//设置编码，以防表单提交的内容乱码

        Notice notice = new Notice();

        notice.setTitle(req.getParameter("title"));
        notice.setSender(req.getParameter("sender"));
        notice.setContent(req.getParameter("content"));
        Date date = new Date();
        notice.setSendtime(date.toString());

        boolean result = StudentHomeworkJdbc.addNotice(notice);

        req.setAttribute("isOK", result);    //用来判断是否添加作业成功
        req.setAttribute("type","addNotice");
        req.getRequestDispatcher("result.jsp").forward(req,resp);
    }
}

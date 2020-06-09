<%--
  Created by IntelliJ IDEA.
  User: Q
  Date: 2020/6/8
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日常信息管理系统-管理员</title>
</head>
<body>
<h2 style="text-align: center; color: #2418DA; font-family: '仿宋';">欢迎你，管理员！</h2>
<h2 style="text-align: center; color: #2418DA; font-family: '仿宋';">你可以干这些事情</h2>
<div style="margin-left: 50px; border: 7px solid #13C6EB;">
    <ul style="line-height: 40px; font-family: '华文宋体'; text-align: center;">
        <li><a href="${pageContext.request.contextPath}/showCompany">公司基本信息管理</a></li>
        <li><a href="/jsp/addNotice.jsp">发布公告</a></li>
        <li><a href="${pageContext.request.contextPath}/showNotice">查看所有公告</a></li>
        <li><a href="/jsp/addMeeting.jsp">发布会议</a></li>
        <li><a href="${pageContext.request.contextPath}/showMeeting">查看会议安排</a></li>
    </ul>
</div>

<h2 style="font-family: '华文宋体'; text-align: center; color: #112CEB;"><a href="http://localhost:8080/">退出登录</a></h2>
</body>
</html>
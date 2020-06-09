<%--
  Created by IntelliJ IDEA.
  User: Q
  Date: 2020/6/8
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日常信息管理系统-员工</title>
</head>
<body>
<h2 style="text-align: center; color: #2418DA; font-family: '仿宋';">欢迎你！${username}</h2>
<h2 style="text-align: center; color: #2418DA; font-family: '仿宋';">你可以干这些事情</h2>

<div style="margin-left: 50px; border: 7px solid #13C6EB;">
    <ul style="line-height: 40px; font-family: '华文宋体'; text-align: center;">
        <li><a href="${pageContext.request.contextPath}/showCompanyNoUp">查看公司信息</a></li>
        <li><a href="${pageContext.request.contextPath}/showNotice2">查看公告</a></li>
        <li><a href="${pageContext.request.contextPath}/showMeeting2">查看会议安排</a></li>
    </ul>
</div>

<h2 style="font-family: '华文宋体'; text-align: center; color: #112CEB;"><a href="http://localhost:8080">退出登录</a></h2>
</body>
</html>

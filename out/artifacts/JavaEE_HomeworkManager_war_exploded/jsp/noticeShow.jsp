<%@ page import="com.java.code.Model.Notice" %>
<%@ page import="com.java.code.Jdbc.StudentHomeworkJdbc" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Q
  Date: 2020/6/9
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>查看所有公告</title>
</head>
<body>
<h2 style="text-align: center; color: #2418DA; font-family: '仿宋';">所有公告</h2>
<form id="sub" method="get" action="">
    <table align="center" width="1400" border="1" style="line-height: 40px; font-family: '华文楷体';">
        <tr>
            <th>序号</th>
            <th>公告标题</th>
            <th>公告内容</th>
            <th>公告发布时间</th>
            <th>相关人员</th>
        </tr>

        <c:forEach items="${list}" var="notice">
            <tr>
                <td>${notice.id}</td>
                <td>${notice.title}</td>
                <td>${notice.content}</td>
                <td>${notice.sendtime}</td>
                <td>${notice.sender}</td>
            </tr>
        </c:forEach>
    </table>
</form>
<h2 style="font-family: '华文宋体'; text-align: center; color: #112CEB;"><a href="/jsp/usualUser.jsp">返回操作界面</a></h2>
</body>
</html>

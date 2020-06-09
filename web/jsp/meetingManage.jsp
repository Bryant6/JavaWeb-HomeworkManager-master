<%--
  Created by IntelliJ IDEA.
  User: Q
  Date: 2020/6/9
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>查看所有会议</title>
</head>
<body>
<h2 style="text-align: center; color: #2418DA; font-family: '仿宋';">所有会议</h2>
<form id="sub" method="get" action="">
    <table align="center" width="1400" border="1" style="line-height: 40px; font-family: '华文楷体';">
        <tr>
            <th>序号</th>
            <th>会议标题</th>
            <th>会议内容</th>
            <th>会议地点</th>
            <th>参会人员</th>
            <td>开始时间</td>
            <td>结束时间</td>
            <th>操作</th>
        </tr>

        <c:forEach items="${list}" var="meeting">
            <tr>
                <td>${meeting.id}</td>
                <td>${meeting.title}</td>
                <td>${meeting.content}</td>
                <td>${meeting.address}</td>
                <td>${meeting.sender}</td>
                <td>${meeting.starttime}</td>
                <td>${meeting.endtime}</td>
                <td>
                    <a href="<c:url value='/updateMeeting?method=update&id=${meeting.id}'/> ">修改</a>
                    <a href="<c:url value='/updateMeeting?method=delete&id=${meeting.id}'/> ">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
<h2 style="font-family: '华文宋体'; text-align: center; color: #112CEB;"><a href="/jsp/manager.jsp">返回管理员操作界面</a></h2>
</body>
</html>

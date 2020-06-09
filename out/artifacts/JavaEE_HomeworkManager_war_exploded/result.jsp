<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/3/9
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%--显示添加作业、学生、提交作业结果--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作结果</title>
</head>
<body>
<%
    String type = (String)request.getAttribute("type");
    boolean isOK = (boolean)request.getAttribute("isOK");
    if (type.equals("addNotice")){

        if (isOK){
%>

<p style="margin: 50px; font-family: '华文宋体'; font-size: 50px; color: darkorange; text-align: center;"><%="添加公告成功!"%></p>

<%
}else{
%>

<p style="margin: 50px; font-family: '华文宋体'; font-size: 50px; color: darkorange; text-align: center;"><%="添加公告失败!!!"%></p>

<%
    }
}else if (type.equals("addMeeting")){
    if (isOK){
%>

<p style="margin: 50px; font-family: '华文宋体'; font-size: 50px; color: darkorange; text-align: center;"><%="添加会议成功!"%></p>

<%
}else{
%>

<p style="margin: 50px; font-family: '华文宋体'; font-size: 50px; color: darkorange; text-align: center;"><%="添加会议失败!"%></p>

<%
        }
    }
%>
<h2 style="font-family: '华文宋体'; text-align: center; color: #112CEB;"><a href="/jsp/manager.jsp">返回管理员操作页面</a></h2>
</body>
</html>
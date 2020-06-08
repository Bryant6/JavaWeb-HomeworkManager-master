<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2020/3/9
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%--首页--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>作业管理系统</title>

    <style>
      body{
        background: url("bg.jpg");
        background-repeat: no-repeat;
        background-size:100% ;
      }
    </style>
  </head>
  <body>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/>
  <h1 style="text-align: center; color: #2418DA; font-family: '仿宋';">你好，欢迎来到日常信息管理系统</h1>
  <h2 style="text-align: center; color: #2418DA; font-family: '仿宋';">请选择你的操作：</h2>
  <div style="margin-left: 50px; border: 7px solid #13C6EB;">
    <ul style="line-height: 40px; font-family: '华文宋体'; text-align: center;">
      <li><a href="jsp/login.jsp">已有账号，去登录</a></li>
      <li><a href="jsp/register.jsp">注册，成为用户</a></li>
    </ul>
  </div>
  </body>
</html>

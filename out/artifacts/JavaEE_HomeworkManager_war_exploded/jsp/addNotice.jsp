<%--
  Created by IntelliJ IDEA.
  User: Q
  Date: 2020/6/9
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布公告</title>
</head>
<body>
<div align="center">
    <h2 style="font-family: '仿宋'; color: #1509CA; text-align: center;">新公告</h2>
    <form action="${pageContext.request.contextPath}/addNotice" method="post">
        <table align="center" style="line-height: 40px; font-family: '华文楷体';">
            <tr>
                <td nowrap="nowrap">公告标题：</td>
                <td><input name="title" type="text" required="required" value="${param.hw_id}" size="40" maxlength="20"></td>
            </tr>
            <tr>
                <td nowrap="nowrap">有关人员：</td>
                <td><input name="sender" type="text" required="required" value="${param.hw_title}" size="40" maxlength="20"></td>
            </tr>
            <tr>
                <td nowrap="nowrap">公告内容：</td>
                <td><textarea name="content" cols="40" rows="10" required="required" value="${param.hw_content}"></textarea></td>
            </tr>
            <tr align="center">
                <th><input type="reset" value="清空"></th>
                <td><input type="submit" value="发布"> </td>
            </tr>
        </table>
    </form>
</div>
<h2 style="font-family: '华文宋体'; text-align: center; color: #112CEB;"><a href="manager.jsp">返回管理员操作界面</a></h2>
</body>
</html>

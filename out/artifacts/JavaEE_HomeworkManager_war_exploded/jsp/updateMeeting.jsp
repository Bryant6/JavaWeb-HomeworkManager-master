<%--
  Created by IntelliJ IDEA.
  User: Q
  Date: 2020/6/9
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改会议</title>
</head>
<body>
<div align="center">
    <h2 style="font-family: '仿宋'; color: #1509CA; text-align: center;">修改会议</h2>
    <form action="${pageContext.request.contextPath}/upMeeting" method="get">
        <input type="hidden" name="id" value="${id}">
        <table align="center" style="line-height: 40px; font-family: '华文楷体';">
            <tr>
                <td nowrap="nowrap">会议标题：</td>
                <td><input name="title" type="text" required="required" value="${meeting.title}" size="40" maxlength="20"></td>
            </tr>
            <tr>
                <td nowrap="nowrap">参会人员：</td>
                <td><input name="sender" type="text" required="required" value="${meeting.sender}" size="40" maxlength="20"></td>
            </tr>
            <tr>
                <td nowrap="nowrap">会议内容：</td>
                <td><textarea name="content" cols="40" rows="10" required="required" value="${meeting.content}"></textarea></td>
            </tr>
            <tr>
                <td nowrap="nowrap">开始时间：</td>
                <td><input name="starttime" type="text" required="required" value="${meeting.starttime}" size="40" maxlength="20"></td>
            </tr>
            <tr>
                <td nowrap="nowrap">结束时间：</td>
                <td><input name="endtime" type="text" required="required" value="${meeting.endtime}" size="40" maxlength="20"></td>
            </tr>
            <tr>
                <td nowrap="nowrap">会议地点：</td>
                <td><input name="address" type="text" required="required" value="${meeting.address}" size="40" maxlength="20"></td>
            </tr>
            <tr align="center">
                <th><input type="reset" value="清空"></th>
                <td><input type="submit" value="修改"> </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

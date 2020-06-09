<%--
  Created by IntelliJ IDEA.
  User: Q
  Date: 2020/6/9
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        body{
            /* 设置背景颜色，背景图加载过程中会显示背景色 */
            background-color: #CCCCCC;
        }
        #user_login{
            font-family: 微软雅黑;
            font-size: 40px;
            text-align: center;
            margin-top: 200px;
        }
        form{
            width: 500px;					/*设置宽度，方便使其居中*/
            margin: 40px auto auto auto;	/*上右下左*/
            font-size: 25px;
        }
        input{
            height: 30px;
            width: 12em;
            margin-top: 5px;
            margin-bottom: 5px;
        }
        /*input标签下的属性选择器*/
        input[type="submit"],input[type="reset"]{
            height: 25px;
            width: 5em;
            margin-top: 5px;
            margin-left: 6px;
        }
    </style>
</head>
<body>
<h2>修改公司信息</h2>
<form action="${pageContext.request.contextPath}/companyPub" method="get" name="form" >
    <table>
        <tr>
            <td>公司名称：</td>
            <td><input type="text" id="name" name="name"/></td>
        </tr>
        <tr>
            <td>公司性质：</td>
            <td><input type="text" id="nature" name="nature"/></td>
        </tr>
        <tr>
            <td>公司介绍：</td>
            <td><input type="text" id="intro" name="intro"/></td>
        </tr>
        <tr>
            <td>电子邮箱：</td>
            <td><input type="text" id="email" name="email"/></td>
        </tr>
        <tr>
            <td>联系电话：</td>
            <td><input type="text" id="phone" name="phone"/></td>
        </tr>
        <tr>
            <td>公司地址：</td>
            <td><input type="text" id="address" name="address"/></td>
        </tr>
        <tr>
            <td></td>
            <td ><input type="submit" id="submit_form" value="提交" οnclick="return validate_form()"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

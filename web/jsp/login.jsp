<%--
  Created by IntelliJ IDEA.
  User: Q
  Date: 2020/6/8
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>注册</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

    <style type="text/css">
        body{
            background:url("bg.jpg");
            background-repeat: no-repeat;
            /* 当内容高度大于图片高度时，背景图像的位置相对于viewport固定 */
            background-attachment: fixed;  /*此条属性必须设置否则可能无效*/
            /* 让背景图基于容器大小伸缩 */
            background-size: cover;
            /*!* 设置背景颜色，背景图加载过程中会显示背景色 *!*/
            /*background-color: #CCCCCC;*/
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
<div id="user_login">用户登录:</div>
<form action="${pageContext.request.contextPath}/login" method="post" name="form" >
    <table>
        <tr>
            <td>请输入账号：</td>
            <td><input type="text" id="username" name="username" placeholder="账号" οnblur="validate_username(this.value)"/></td>
            <td id="test_user"></td>
        </tr>
        <tr>
            <td>请输入密码：</td>
            <td><input type="password" id="password" name="password" placeholder="密码" οnblur="validate_password(this.value)"/></td>
            <td id="test_pw"></td>
        </tr>
        <tr>
            <td></td>
            <td ><input type="submit" id="submit_form" value="登录" οnclick="return validate_form()"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

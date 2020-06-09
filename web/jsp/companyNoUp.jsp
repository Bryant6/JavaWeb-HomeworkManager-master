<%--
  Created by IntelliJ IDEA.
  User: Q
  Date: 2020/6/9
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公司基本信息管理</title>
</head>
<body>
<ul>
    <li><h3>公司名称：${company.name}</h3></li>
    <li><h4>公司性质：${company.nature}</h4></li>
    <li><h5>公司简介：${company.intro}</h5></li>
    <li><h5>联系方式：${company.phone}</h5></li>
    <li><h5>电子邮箱：${company.email}</h5></li>
    <li><h5>公司地址：${company.address}</h5></li>
</ul>

</body>
</html>

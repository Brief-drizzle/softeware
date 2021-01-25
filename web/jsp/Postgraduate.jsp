<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/7
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>研究生</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script src="../layui/layui.js"></script>
    <script src="../jquery-3.5.1.js"></script>
    <script src="../layer/layer.js"></script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">研究生的登录界面</div>
        <%--左上名字--%>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui" style="color: #5FB878;" >
            </li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
            <%--左侧栏--%>
                <li class="layui-nav-item"><a href="http://localhost:8080/software_war_exploded/jsp/zj_choose.jsp">助教系统</a></li>
                <li class="layui-nav-item"><a href="">参会系统</a></li>
                <li class="layui-nav-item"><a href="">项目系统</a></li>
            </ul>
        </div>
    </div>
    <form method="post" action="">
        <div class="layui-body">
            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <legend>    </legend>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                </div>
            </fieldset>
        </div>
    </form>
</div>
</body>
</html>

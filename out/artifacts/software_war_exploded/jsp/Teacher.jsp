<%@ page import="user.entity.Tutor" %>
<%@ page import="user.entity.Instructor" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/7
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师选择身份</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script src="../layui/layui.js"></script>
    <script src="../jquery-3.5.1.js"></script>
    <script src="../layer/layer.js"></script>
</head>
<body>
<%
    Tutor tutor= (Tutor) session.getAttribute("istutor");
    Instructor instructor= (Instructor) session.getAttribute("isinstructor");
%>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">教师选择身份</div>
        <%--左上名字--%>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui" style="color: #5FB878;" >
                powered by :
            </li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree">
                <%
                    if (tutor!=null){
                %>
                <li class="layui-nav-item"><a href="">导师</a></li>
                <%
                    }
                    if (instructor!=null){
                %>
                <li class="layui-nav-item"><a href="">授课教师</a></li>
                <%
                    }
                %>
            <%--左侧栏--%>
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

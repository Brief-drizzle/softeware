<%@ page pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%@ page import="user.entity.Course" %>
<%@ page import="user.entity.AssistantAssessment" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/7
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>授课教师评价助教</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script src="../layui/layui.js"></script>
    <script src="../jquery-3.5.1.js"></script>
    <script src="../layer/layer.js"></script>
</head>
<body>
<%
    Course course= (Course) session.getAttribute("evacourse");
    AssistantAssessment assistantAssessment = (AssistantAssessment) session.getAttribute("nowass");
%>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">授课教师评价助教</div>
        <%--左上名字--%>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui" style="color: #5FB878;" >
                powered by : mxm
            </li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <%--左侧栏--%>
        </div>
    </div>
    <form method="post" action="${pageContext.request.contextPath}/course/evaluate.do">
        <div class="layui-body">
            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <legend>为课程<%=course.getCourseName()%>评价</legend>
                <div class="layui-form-item" style="margin-top: 20px;margin-left: 35px;margin-right: 35px">
                    <%--主体--%>
                    <textarea placeholder="请输入内容" class="layui-textarea" name="evaluate"></textarea>
                </div>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <div class="layui-input-inline">
                    <div class="layui-input-block">
                        <select name="result" lay-filter="sex">
                            <option value="2">不通过</option>
                            <option value="1">通过</option>
                        </select>
                        <script>
                            layui.use('form', function(){
                                var form = layui.form;
                                form.render(null, 'sex');
                            });
                        </script>
                    </div>
                    </div>
                </div>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <div style="margin-top: 10px">
                        <button type="submit" class="layui-btn" style="margin-left: 35px">保存</button>
                        <button type="reset" class="layui-btn">重写</button>
                    </div>
                </div>
            </fieldset>
        </div>
    </form>
</div>
</body>
</html>

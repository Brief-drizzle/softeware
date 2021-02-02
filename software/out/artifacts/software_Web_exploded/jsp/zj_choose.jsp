<%@ page pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%@ page import="java.util.List" %>
<%@ page import="user.entity.Course" %>
<%@ page import="user.entity.Selection" %>
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
    <title>助教选题</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script src="../layui/layui.js"></script>
    <script src="../jquery-3.5.1.js"></script>
    <script src="../layer/layer.js"></script>
</head>
<body>
<%
    List<Course> morecourse= (List<Course>) session.getAttribute("morecourse");
    List<Course> selections= (List<Course>) session.getAttribute("myselection");
    List<Course> alreadycourse= (List<Course>) session.getAttribute("asas");
%>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">选题</div>
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
    <form method="post" action="">
        <div class="layui-body">
            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <legend>显示已成为助教的课程并填写自评</legend>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                    <table class="layui-table" style="margin: 20px;" lay-filter="demo2">
                        <thead>
                        <tr>
                            <th width="150px">课程id</th>
                            <th width="150px">课程名</th>
                            <th width="150px">课程性质</th>
                            <th width="150px">授课对象</th>
                            <th width="150px">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (Course selection : alreadycourse) {
                        %>
                        <tr>
                            <td><%=selection.getCourseId()%>
                            </td>
                            <td><a href="/course/selfaccount.do?courseid=<%=selection.getCourseId()%>"><%=selection.getCourseName()%></a>
                            </td>
                            <td><%=selection.getCourseNature()%>
                            </td>
                            <td><%=selection.getCourseAudience()%>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/course/selfaccount.do?courseid=<%=selection.getCourseId()%>">填写自评</a>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </fieldset>
            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <legend>已选志愿</legend>

                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                    <table class="layui-table" style="margin: 20px;" lay-filter="demo1">
                        <thead>
                        <tr>
                            <th width="150px">课程id</th>
                            <th width="150px">课程名</th>
                            <th width="150px">课程性质</th>
                            <th width="150px">授课对象</th>
                            <th width="150px">状态</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (Course selection : selections) {
                        %>
                        <tr>
                            <td><%=selection.getCourseId()%>
                            </td>
                            <td><%=selection.getCourseName()%>
                            </td>
                            <td><%=selection.getCourseNature()%>
                            </td>
                            <td><%=selection.getCourseAudience()%>
                            </td>
                            <td>已选择
                            </td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </fieldset>

            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <legend>添加志愿</legend>

                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                    <table class="layui-table" style="margin: 20px;" lay-filter="demo3">
                        <thead>
                        <tr>
                            <th width="150px">课程id</th>
                            <th width="150px">课程名</th>
                            <th width="150px">课程性质</th>
                            <th width="150px">授课对象</th>
                            <th width="150px">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (Course selection : morecourse) {
                        %>
                        <tr>
                            <td><%=selection.getCourseId()%>
                            </td>
                            <td><%=selection.getCourseName()%>
                            </td>
                            <td><%=selection.getCourseNature()%>
                            </td>
                            <td><%=selection.getCourseAudience()%>
                            </td>
                            <td><a href="${pageContext.request.contextPath}/course/choose.do?courseId=<%=selection.getCourseId()%>">选择为志愿</a></td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </fieldset>
        </div>
    </form>
</div>
</body>
</html>

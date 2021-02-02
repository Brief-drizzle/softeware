<%@ page import="java.util.List" %>
<%@ page import="user.entity.Course" %>
<%@ page import="user.entity.Selection" %>
<%@ page import="user.entity.AssistantAssessment" %>
<%@ page import="com.mysql.cj.Session" %>
<%@ page import="java.awt.*" %>
<%@ page import="user.entity.Postgraduate" %><%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 2020/12/7
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择助教</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <script src="../layui/layui.js"></script>
    <script src="../jquery-3.5.1.js"></script>
    <script src="../layer/layer.js"></script>
</head>
<body>
<%
    List<Course> mycourse= (List<Course>) session.getAttribute("mycourses");
%>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">选择助教</div>
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
                <legend>教授的课程</legend>
                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                    <table class="layui-table" style="margin: 20px;" lay-filter="demo2">
                        <thead>
                        <tr>
                            <th width="150px">课程id</th>
                            <th width="150px">课程名</th>
                            <th width="150px">课程性质</th>
                            <th width="150px">授课对象</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (Course selection : mycourse) {
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
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </fieldset>
            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <legend>助教评价</legend>

                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                    <table class="layui-table" style="margin: 20px;" lay-filter="demo1">
                        <thead>
                        <tr>
                            <th width="150px">课程id</th>
                            <th width="150px">研究生id</th>
                            <th width="150px">是否自评</th>
                            <th width="150px">授课教师是否评价</th>
                            <th width="150px">授课教师评价结果</th>
                            <th width="150px">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<AssistantAssessment> assessments= (List<AssistantAssessment>) session.getAttribute("allassis");
                            for (AssistantAssessment selection : assessments) {
                        %>
                        <tr>
                            <td><%=selection.getCourseId()%>
                            </td>
                            <td><%=selection.getPostgraduateId()%>
                            </td>
                            <%
                                if(selection.getSelfAccount()!=null){
                            %>
                            <td>是</td>
                            <%
                                }
                                else {
                            %>
                            <td>否</td>
                            <%
                                }
                                if (selection.getInstructorEvaluate()!=null){
                            %>
                            <td>是</td>
                            <%
                                }
                                else {
                            %>
                            <td>否</td>
                            <%
                                }
                                if (selection.getEvaluateResult()==1){
                            %>
                            <td>通过</td>
                            <%
                                }
                                else if (selection.getEvaluateResult()==2){
                            %>
                            <td>不通过</td>
                            <%
                                }else {
                            %>
                            <td>未评价</td>
                            <%
                                }
                            %>
                            <td><a href="${pageContext.request.contextPath}/course/enterevaluate.do?assid=<%=selection.getAssessmentId()%>" >修改</a></td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </fieldset>

            <fieldset class="layui-elem-field site-demo-button" style="margin-top: 20px;">
                <legend>选择助教</legend>

                <div class="layui-form-item" style="margin-top: 20px;">
                    <%--主体--%>
                    <table class="layui-table" style="margin: 20px;" lay-filter="demo3">
                        <thead>
                        <tr>
                            <th width="150px">课程id</th>
                            <th width="150px">助教姓名</th>
                            <th width="150px">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<Selection> selections= (List<Selection>) session.getAttribute("allselections");
                            List<Postgraduate>postgraduates= (List<Postgraduate>) session.getAttribute("allpost");
                            Postgraduate now=new Postgraduate();
                            for (Selection selection : selections) {
                                for (Postgraduate postgraduate : postgraduates) {
                                    if (selection.getPostgraduateId().equals(postgraduate.getPostgraduateId())) {
                                        now = postgraduate;
                                    }
                                }
                        %>
                        <tr>
                            <td><%=selection.getCourseId()%>
                            </td>
                            <td><%=now.getPostgraduateName()%>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/course/select.do?courseId=<%=selection.getCourseId()%>&postid=<%=now.getPostgraduateId()%>">选择为助教</a>
                                <a href="${pageContext.request.contextPath}/course/notselect.do?courseId=<%=selection.getCourseId()%>&postid=<%=now.getPostgraduateId()%>">不通过</a>
                            </td>
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

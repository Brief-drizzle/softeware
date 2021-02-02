<%@ page pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>导师</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/layui/css/layui.css">
    <style>
        .hide {
            display: none;
        }
    </style>
    <script type="application/javascript">
        function getBasePath() {
            return "<%=basePath%>";
        }
    </script>
</head>
<body class="layui-layout-body" style="background-color: #f2f2f2">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">导师的登录界面</div>
        <%--左上名字--%>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui" style="color: #5FB878;">
                ${sessionScope.teacher.teacherName}
            </li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item"><a href="<%=basePath%>/teacher/index.do">项目基本信息</a></li>
                <li class="layui-nav-item"><a href="<%=basePath%>/teacher/problem.do">项目问题查看</a></li>
                <li class="layui-nav-item"><a href="<%=basePath%>/student/index.do">研究生学术交流活动查看</a></li>
                <li class="layui-nav-item"><a href="<%=basePath%>/academicExchange/teacher.do">研究生学术交流活动认定</a></li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <div class="layui-form-item" style="margin: 20px;">
            <%--主体--%>
            <div class="layui-card">
                <input type="hidden" id="participateProjectId" value="${participateProject.participateProjectId}">
                <div class="layui-card-header" id="title">${participateProject.projectName}:项目问题列表</div>
                <div class="layui-card-body">
                    <table class="layui-hide" id="participateProblemList-list" lay-filter="participateProblemList-list" style="margin: 10px;"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="participateProblemTips" class="hide">
    <form lay-filter="participateProblem-add-from" class="layui-form" action="" style="width: 80%; margin-top: 20px;">
        <div class="layui-form-item">
            <label class="layui-form-label">问题描述：</label>
            <div class="layui-input-block">
                <input type="hidden" name="participateProjectId" value="${participateProject.participateProjectId}">
                <input type="text" lay-verify="required" class="layui-input" name="problemDescription" autocomplete="off" id="problemDescription" placeholder="请输入问题描述">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">解决过程：</label>
            <div class="layui-input-block">
                <textarea name="solveProcess" id="solveProcess" placeholder="请输入解决过程" class="layui-textarea"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" class="layui-btn" lay-submit="" lay-filter="participateProblem-add-submit">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script type="text/html" id="participateProblemListToolBar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" id="participateProblemList-add-btn" lay-event="participateProblemList-add-btn">
            <i class="layui-icon layui-icon-add-circle" style="vertical-align: initial;">添加问题</i>
        </button>
    </div>
</script>
<script type="text/javascript" src="<%=basePath%>/jquery-3.5.1.js"></script>
<script type="text/javascript" src="<%=basePath%>/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/teacherParticipateProblemList.js"></script>
</body>
</html>

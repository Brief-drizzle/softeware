<%@ page pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>研究生</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/layui/css/layui.css">
    <script type="application/javascript">
        function getBasePath() {
            return "<%=basePath%>";
        }
    </script>
</head>
<body class="layui-layout-body" style="background-color: #f2f2f2">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">研究生的登录界面</div>
        <%--左上名字--%>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui" style="color: #5FB878;">
                ${sessionScope.nowpostgraduate.postgraduateName}
            </li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item"><a href="<%=basePath%>/participateProject/index.do">项目档案管理</a></li>
                <li class="layui-nav-item"><a href="<%=basePath%>/participateProject/problem.do">项目问题管理</a></li>
                <li class="layui-nav-item"><a href="<%=basePath%>/academicExchange/index.do">学术交流活动建档管理</a></li>
                <li class="layui-nav-item"><a href="<%=basePath%>/academicExchange/count.do">学术交流活动汇总</a></li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <div class="layui-form-item" style="margin: 20px;">
            <%--主体--%>
            <div class="layui-card">
                <div class="layui-card-header" id="title">学术交流活动汇总</div>
                <div class="layui-card-body">
                    <table class="layui-hide" id="academicExchangeCount-list" lay-filter="academicExchangeCount-list" style="margin: 10px;"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/jquery-3.5.1.js"></script>
<script type="text/javascript" src="<%=basePath%>/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/academicExchangeCount.js"></script>
</body>
</html>

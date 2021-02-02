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
                <div class="layui-card-header" id="title">添加项目档案</div>
                <div class="layui-card-body">
                    <form lay-filter="participateProject-add-from" class="layui-form" action="" style="width: 80%;">
                        <div class="layui-form-item">
                            <label class="layui-form-label">档案id</label>
                            <div class="layui-input-inline">
                                <input type="text" name="participateProjectId" lay-verify="participateProjectId" placeholder="请输入档案id" autocomplete="new-password" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">项目名称</label>
                            <div class="layui-input-inline">
                                <select name="projectId" lay-verify="required" lay-filter="projectSelector" id="projectSelector"></select>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">开始时间</label>
                            <div class="layui-input-inline">
                                <input type="text" name="participateStarttime" class="layui-input" autocomplete="off" id="participateStarttime">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">结束时间</label>
                            <div class="layui-input-inline">
                                <input type="text" name="participateEndtime" class="layui-input" autocomplete="off" id="participateEndtime">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">导师姓名</label>
                            <div class="layui-input-inline">
                                <select name="tutorId" lay-verify="required" lay-filter="tutorSelector" id="tutorSelector"></select>
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">审批状态</label>
                            <div class="layui-input-inline">
                                <input type="text" name="participateApprovestatus" lay-verify="required" placeholder="请输入审批状态" autocomplete="new-password" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">审批时间</label>
                            <div class="layui-input-inline">
                                <input type="text" name="participateApprovetimeStr" class="layui-input" autocomplete="off" id="participateApprovetimeStr">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">关键项目难题</label>
                            <div class="layui-input-inline">
                                <input type="text" name="keyDifficulties" class="layui-input" autocomplete="off" id="keyDifficulties">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <label class="layui-form-label">最终完成项目工作</label>
                            <div class="layui-input-inline">
                                <input type="text" name="endParticipateWork" class="layui-input" autocomplete="off" id="endParticipateWork">
                            </div>
                        </div>

                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit="" lay-filter="participateProject-add-submit">立即提交</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>/jquery-3.5.1.js"></script>
<script type="text/javascript" src="<%=basePath%>/layui/layui.all.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/addParticipateProject.js"></script>
</body>
</html>

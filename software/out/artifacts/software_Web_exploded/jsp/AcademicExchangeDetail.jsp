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
                <div class="layui-card-header" id="title">
                    <div style="display: flex; justify-content: space-between;">
                        <div>学术交流活动详情</div>
                        <div style="display: flex; align-items: center;">
                            <button class="layui-btn layui-btn-sm" onclick="window.location.href='<%=basePath%>/jsp/AddAcademicExchange.jsp'">提交学术交流活动</button>
                        </div>
                    </div>
                </div>
                <div class="layui-card-body">
                    <form lay-filter="academicExchange-add-from" class="layui-form" action="" style="width: 80%;">
                        <div style="display: flex;">
                            <div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">学术交流活动id</label>
                                    <div class="layui-input-inline">
                                        <input value="${academicExchange.academicExchangeId}" type="text" name="academicExchangeId" lay-verify="academicExchangeId" autocomplete="new-password" class="layui-input">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">学术交流活动名称</label>
                                    <div class="layui-input-inline">
                                        <input value="${academicExchange.academicExchangeName}" type="text" name="academicExchangeName" lay-verify="academicExchangeId" autocomplete="new-password" class="layui-input">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">活动地点</label>
                                    <div class="layui-input-inline">
                                        <input value="${academicExchange.country.concat(' ').concat(academicExchange.province).concat(' ').concat(academicExchange.city)}" type="text" name="participateStarttime" class="layui-input" autocomplete="off">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">报告英文名称</label>
                                    <div class="layui-input-inline">
                                        <input value="${academicExchange.reportEnglishname}" type="text" name="reportEnglishname" class="layui-input" autocomplete="off">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">报告中文名称</label>
                                    <div class="layui-input-inline">
                                        <input value="${academicExchange.reportChinesename}" type="text" name="participateEndtime" class="layui-input" autocomplete="off">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">国家</label>
                                    <div class="layui-input-inline">
                                        <input value="${academicExchange.country}" type="text" name="country" lay-verify="required" placeholder="请输入审批状态" autocomplete="new-password" class="layui-input">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">省</label>
                                    <div class="layui-input-inline">
                                        <input value="${academicExchange.province}" type="text" name="province" class="layui-input" autocomplete="off">
                                    </div>
                                </div>
                            </div>

                            <div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">市</label>
                                    <div class="layui-input-inline">
                                        <input value="${academicExchange.city}" type="text" name="city" class="layui-input" autocomplete="off">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">学术交流质量</label>
                                    <div class="layui-input-inline">
                                        <input value="${academicExchange.quality}" type="text" name="quality" class="layui-input" autocomplete="off">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">参会照片</label>
                                    <div class="layui-input-inline">
                                        <input value="${academicExchange.activityPhoto}" type="text" name="activityPhoto" class="layui-input" autocomplete="off">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">备注</label>
                                    <div class="layui-input-inline">
                                        <input value="${academicExchange.others}" type="text" name="others" class="layui-input" autocomplete="off">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">审核状态</label>
                                    <div class="layui-input-inline">
                                        <input value="${academicExchange.auditStatus}" type="text" name="auditStatus" class="layui-input" autocomplete="off">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">导师审批时间</label>
                                    <div class="layui-input-inline">
                                        <input value="${academicExchange.tutorAuditTime}" type="text" name="tutorAuditTime" class="layui-input" autocomplete="off">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">学科负责人审批时间</label>
                                    <div class="layui-input-inline">
                                        <input value="${academicExchange.directorAuditTime}" type="text" name="directorAuditTime" class="layui-input" autocomplete="off">
                                    </div>
                                </div>
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
</body>
</html>

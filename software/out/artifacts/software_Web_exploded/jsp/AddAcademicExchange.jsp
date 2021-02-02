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
                    <div>提交学术交流活动</div>
                </div>
                <div class="layui-card-body">
                    <form lay-filter="academicExchange-add-from" class="layui-form" action="" style="width: 80%;">
                        <div style="display: flex;">
                            <div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">学术交流活动id</label>
                                    <div class="layui-input-inline">
                                        <input type="text" placeholder="请输入学术交流活动id" name="academicExchangeId" lay-verify="academicExchangeId" autocomplete="new-password" class="layui-input">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">学术交流活动名称</label>
                                    <div class="layui-input-inline">
                                        <input type="text" placeholder="请输入学术交流活动名称" lay-verify="required" name="academicExchangeName" autocomplete="new-password" class="layui-input">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">报告英文名称</label>
                                    <div class="layui-input-inline">
                                        <input type="text" placeholder="请输入报告英文名称" lay-verify="required" name="reportEnglishname" class="layui-input" autocomplete="off">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">报告中文名称</label>
                                    <div class="layui-input-inline">
                                        <input type="text" placeholder="请输入报告中文名称" lay-verify="required" name="reportChinesename" class="layui-input" autocomplete="off">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">国家</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="country" lay-verify="required" placeholder="请输入国家" autocomplete="new-password" class="layui-input">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">省</label>
                                    <div class="layui-input-inline">
                                        <input type="text" placeholder="请输入省" lay-verify="required" name="province" class="layui-input" autocomplete="off">
                                    </div>
                                </div>
                            </div>

                            <div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">导师审批时间</label>
                                    <div class="layui-input-inline">
                                        <input type="text" placeholder="请输入导师审批时间" lay-verify="required" name="tutorAuditTimeStr" class="layui-input" autocomplete="off" id="tutorAuditTimeStr">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">学科负责人审批时间</label>
                                    <div class="layui-input-inline">
                                        <input type="text" placeholder="请输入学科负责人审批时间" lay-verify="required" name="directorAuditTimeStr" class="layui-input" autocomplete="off" id="directorAuditTimeStr">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">参会照片</label>
                                    <div class="layui-input-inline">
                                        <input type="text" placeholder="请输入参会照片" lay-verify="required" name="activityPhoto" class="layui-input" autocomplete="off">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">备注</label>
                                    <div class="layui-input-inline">
                                        <input type="text" placeholder="请输入备注" lay-verify="required" name="others" class="layui-input" autocomplete="off">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">审核状态</label>
                                    <div class="layui-input-inline">
                                        <input type="text" placeholder="请输入审核状态" lay-verify="required" name="auditStatus" class="layui-input" autocomplete="off">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">市</label>
                                    <div class="layui-input-inline">
                                        <input type="text" placeholder="请输入市" lay-verify="required" name="city" class="layui-input" autocomplete="off">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">学术交流质量</label>
                                    <div class="layui-input-inline">
                                        <input type="text" placeholder="请输入学术交流质量" lay-verify="required" name="quality" class="layui-input" autocomplete="off">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit="" lay-filter="academicExchange-add-submit">立即提交</button>
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
<script>
    var form = layui.form;
    var laydate = layui.laydate;

    // 初始化日期选择框
    laydate.render({
        elem: '#tutorAuditTimeStr',
        type: 'date',
        format: 'yyyy-MM-dd',
        value: new Date()
    });
    laydate.render({
        elem: '#directorAuditTimeStr',
        type: 'date',
        format: 'yyyy-MM-dd',
        value: new Date()
    });

    // 自定义验证规则
    form.verify({
        academicExchangeId: function(value) {
            // 判断项目是否已经存在
            var isExist = true;
            $.ajax({
                url: getBasePath() + '/academicExchange/getById.do',
                type: 'POST',
                data: {
                    id: value
                },
                async: false,
                dataType: 'json',
                success: function(result) {
                    if (result.code != 200) {
                        layer.open({
                            title: '系统提示',
                            anim: 6,
                            content: result.data,
                            btnAlign: 'c'
                        });
                        isExist = true;
                    }
                    isExist = result.data;
                }
            });
            if (isExist) {
                return '该学术交流活动id已存在！';
            }
            if (value == null || value == '' || value == undefined) {
                return "学术交流活动id不能为空！";
            }
        }
    });

    // 监听提交
    form.on('submit(academicExchange-add-submit)', function(data) {
        var that = $(this);
        if (!that.hasClass('layui-btn-disabled')) {
            that.addClass('layui-btn-disabled'); // 禁用提交按钮
            $.ajax({
                url: getBasePath() + '/academicExchange/add.do',
                type: 'POST',
                data: data.field,
                async: false,
                dataType: 'json',
                success: function(result) {
                    if (result.code != 200) {
                        layer.open({
                            title: '系统提示',
                            anim: 6,
                            content: result.data,
                            btnAlign: 'c'
                        });
                        that.removeClass('layui-btn-disabled'); // 释放提交按钮
                        return;
                    }
                    that.removeClass('layui-btn-disabled'); // 释放提交按钮
                    window.location.href = getBasePath() + "/academicExchange/index.do";
                }
            });
        }
        return false;
    });
</script>
</body>
</html>

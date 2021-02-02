//@sourceURL=/js/addParticipateProject.js
$(function() {

    var form = layui.form;
    var laydate = layui.laydate;

    // 自定义验证规则
    form.verify({
        participateProjectId: function(value) {
            // 判断项目是否已经存在
            var isExist = true;
            $.ajax({
                url: getBasePath() + '/participateProject/getById.do',
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
                return '该档案ID已存在！';
            }
            if (value == null || value == '' || value == undefined) {
                return "档案ID不能为空！";
            }
        }
    });

    // 监听提交
    form.on('submit(participateProject-add-submit)', function(data) {
        var that = $(this);
        if (!that.hasClass('layui-btn-disabled')) {
            that.addClass('layui-btn-disabled'); // 禁用提交按钮
            $.ajax({
                url: getBasePath() + '/participateProject/add.do',
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
                    window.location.href = getBasePath() + "/participateProject/index.do";
                }
            });
        }
        return false;
    });

    // 初始化日期选择框
    laydate.render({
        elem: '#participateStarttime',
        type: 'date',
        format: 'yyyy-MM-dd',
        value: new Date()
    });
    laydate.render({
        elem: '#participateEndtime',
        type: 'date',
        format: 'yyyy-MM-dd',
        value: new Date()
    });
    laydate.render({
        elem: '#participateApprovetimeStr',
        type: 'date',
        format: 'yyyy-MM-dd',
        value: new Date()
    });

    // 加载导师下拉框
    $.ajax({
        url: getBasePath() + '/tutor/queryAll.do',
        type: "POST",
        dataType: "json",
        success: function(result) {
            if (result.code != 200) {
                layer.open({
                    title: '系统提示',
                    anim: 6,
                    content: result.data,
                    btnAlign: 'c'
                });
                return;
            }
            var html = '';
            for (var i = 0; i < result.data.length; i++) {
                html += '<option value="' + result.data[i].id + '">' + result.data[i].name + '</option>';
            }
            $('#tutorSelector').html(html);
            form.render("select");
        }
    });

    // 加载项目下拉框
    $.ajax({
        url: getBasePath() + '/project/queryAll.do',
        type: "POST",
        dataType: "json",
        success: function(result) {
            if (result.code != 200) {
                layer.open({
                    title: '系统提示',
                    anim: 6,
                    content: result.data,
                    btnAlign: 'c'
                });
                return;
            }
            var html = '';
            for (var i = 0; i < result.data.length; i++) {
                html += '<option value="' + result.data[i].projectId + '">' + result.data[i].projectName + '</option>';
            }
            $('#projectSelector').html(html);
            form.render("select");
        }
    });

});
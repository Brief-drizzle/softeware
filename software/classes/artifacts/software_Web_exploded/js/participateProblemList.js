//@sourceURL=/js/participateProblemList.js
$(function() {

    var form = layui.form;
    var layer = layui.layer;
    var table = layui.table;

    var reload = function() {
        // 执行重载
        table.reload('participateProblemListReload', {
            page: {
                curr: 1 // 重新从第 1 页开始
            }
        });
    };

    var openDialog = function() {
        layer.open({
            title: "添加问题",
            id: "participateProblemDialog",
            type: 1,
            offset: '20px',
            content: $('#participateProblemTips'),
            area: [$(window).width() <= 750 ? '60%' : '500px', '350px'],
            resize: false,
            end: function() {
                $("#participateProblemTips").css("display", 'none');
            }
        });
    };

    table.render({
        elem: '#participateProblemList-list',
        url: getBasePath() + '/participateProblem/getByPage.do?id=' + $('#participateProjectId').val(),
        toolbar: '#participateProblemListToolBar',
        id: 'participateProblemListReload',
        even: true,
        cols: [[
            {field: 'problemDescription', title: '问题描述'},
            {field: 'solveProcess', title: '解决过程'},
        ]],
        page: true
    });

    // 头工具栏事件
    table.on('toolbar(participateProblemList-list)', function(obj) {
        if (obj.event == 'participateProblemList-add-btn') {
            $('#problemDescription').val('');
            $('#solveProcess').val('');
            openDialog();
        }
    });

    form.on('submit(participateProblem-add-submit)', function(data) {
        var url = '/participateProblem/add.do';
        var submitBtn = $(this);
        if (!submitBtn.hasClass('layui-btn-disabled')) {
            submitBtn.addClass('layui-btn-disabled'); // 禁用提交按钮
            $.ajax({
                url: url,
                type: "POST",
                data: data.field,
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
                    submitBtn.removeClass('layui-btn-disabled'); // 释放提交按钮
                    layer.closeAll();
                    reload();
                }
            });
        }
    });

});
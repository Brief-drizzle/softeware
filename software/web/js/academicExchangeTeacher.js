//@sourceURL=/js/academicExchangeTeacher.js
$(function() {

    var table = layui.table;

    var reload = function() {
        // 执行重载
        table.reload('academicExchangeTeacherReload', {
            page: {
                curr: 1 // 重新从第 1 页开始
            }
        });
    };

    table.render({
        elem: '#academicExchangeTeacher-list',
        url: getBasePath() + '/academicExchange/getByPage.do',
        id: 'academicExchangeTeacherReload',
        even: true,
        cols: [[
            {field: 'academicExchangeId', title: '学术交流活动id'},
            {field: 'academicExchangeName', title: '学术交流活动名称'},
            {
                title: '活动地点', templet: function(d) {
                    return d.country + " " + d.province + " " + d.city;
                }
            },
            {field: 'reportChinesename', title: '报告中文名称'},
            {field: 'reportEnglishname', title: '报告英文名称'},
            {field: 'country', title: '国家'},
            {field: 'province', title: '省'},
            {field: 'city', title: '市'},
            {field: 'city', title: '市'},
            {field: 'quality', title: '学术交流质量'},
            {field: 'activityPhoto', title: '参会照片'},
            {field: 'others', title: '备注'},
            {field: 'auditStatus', title: '审核状态'},
            {
                field: 'tutorAuditTime', title: '导师审批时间', templet: function(d) {
                    return formatDate(d.tutorAuditTime);
                }
            },
            {
                field: 'directorAuditTime', title: '学科负责人审批时间', templet: function(d) {
                    return formatDate(d.directorAuditTime);
                }
            },
            {title: '审核', width: 60, align: 'center', toolbar: '#academicExchangeTeacherListBar'}
        ]],
        page: true
    });

    // 监听工具条
    table.on('tool(academicExchangeTeacher-list)', function(obj) {
        var data = obj.data;
        if (obj.event == 'edit') {
            layer.confirm('确定审核吗?', {title: '提示'}, function(index) {
                $.ajax({
                    url: getBasePath() + '/academicExchange/approval.do',
                    type: 'POST',
                    data: {
                        id: data.academicExchangeId
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
                            layer.close(index);
                            return;
                        }
                        layer.msg("审核成功");
                        layer.close(index);
                        reload();
                    }
                });
            });
        }
    });

    function formatDate(obj) {
        var time = new Date(parseInt(obj));
        var y = time.getFullYear();
        var m = time.getMonth() + 1;
        if (m < 10) {
            m = '0' + m
        }
        var d = time.getDate();
        if (d < 10) {
            d = '0' + d
        }
        var h = time.getHours();
        if (h < 10) {
            h = '0' + h
        }
        var mm = time.getMinutes();
        if (mm < 10) {
            mm = '0' + mm
        }
        var s = time.getSeconds();
        if (s < 10) {
            s = '0' + s
        }
        return y + "-" + m + "-" + d;
    }

});
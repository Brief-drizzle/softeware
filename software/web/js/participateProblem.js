//@sourceURL=/js/participateProblem.js
$(function() {

    var table = layui.table;

    table.render({
        elem: '#participateProblem-list',
        url: getBasePath() + '/participateProject/getByPage.do',
        id: 'participateProblemReload',
        even: true,
        cols: [[
            {field: 'participateProjectId', title: '档案id'},
            {
                field: 'projectName', title: '项目名称', templet: function(d) {
                    return '<a href="' + getBasePath() + '/participateProblem/index.do?id=' + d.participateProjectId + '">' + d.projectName + '</a>';
                }
            },
            {
                field: 'participateStarttime', title: '开始时间', templet: function(d) {
                    return formatDate(d.participateStarttime);
                }
            },
            {
                field: 'participateEndtime', title: '结束时间', templet: function(d) {
                    return formatDate(d.participateEndtime);
                }
            },
            {field: 'teacherName', title: '导师姓名'},
            {field: 'participateApprovestatus', title: '审批状态'},
            {
                field: 'participateApprovetime', title: '审批时间', templet: function(d) {
                    return formatDate(d.participateApprovetime);
                }
            }
        ]],
        page: true
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
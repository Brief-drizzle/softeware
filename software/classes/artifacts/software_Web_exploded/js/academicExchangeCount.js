//@sourceURL=/js/academicExchangeCount.js
$(function() {

    var table = layui.table;

    table.render({
        elem: '#academicExchangeCount-list',
        url: getBasePath() + '/academicExchange/getByPage.do?self=self',
        id: 'academicExchangeCountReload',
        even: true,
        cols: [[
            {type: 'numbers', title: '序号'},
            {
                field: 'academicExchangeName', title: '学术交流活动名称', templet: function(d) {
                    return '<a href="' + getBasePath() + '/academicExchange/detail.do?id=' + d.academicExchangeId + '">' + d.academicExchangeName + '</a>';
                }
            },
            {
                field: 'country', title: '活动地点', templet: function(d) {
                    return "国家：" + d.country + "，省：" + d.province + "，市：" + d.city;
                }
            },
            {
                field: "directorAuditTime", title: "活动时间", templet: function(d) {
                    return formatDate(d.directorAuditTime);
                }
            },
            {
                title: "报告中英文名称", templet: function(d) {
                    return "中文名称：" + d.reportChinesename + "，英文名称：" + d.reportEnglishname;
                }
            },
            {field: "activityPhoto", title: "参会证明照片"},
            {field: "others", title: "备注"}
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
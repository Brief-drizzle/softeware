//@sourceURL=/js/academicExchange.js
$(function() {

    var table = layui.table;

    table.render({
        elem: '#academicExchange-list',
        url: getBasePath() + '/academicExchange/getByPage.do',
        id: 'academicExchangeReload',
        even: true,
        cols: [[
            {field: 'academicExchangeId', title: '学术交流活动id'},
            {
                field: 'academicExchangeName', title: '学术交流活动名称', templet: function(d) {
                    return '<a href="' + getBasePath() + '/academicExchange/detail.do?id=' + d.academicExchangeId + '">' + d.academicExchangeName + '</a>';
                }
            },
            {
                field: 'country', title: '活动地点', templet: function(d) {
                    return d.country + " " + d.province + " " + d.city;
                }
            }
        ]],
        page: true
    });

});
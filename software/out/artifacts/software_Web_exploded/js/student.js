//@sourceURL=/js/student.js
$(function() {

    var table = layui.table;

    table.render({
        elem: '#student-list',
        url: getBasePath() + '/student/getByPage.do',
        id: 'studentReload',
        even: true,
        cols: [[
            {field: 'postgraduateId', title: '学号'},
            {
                field: 'postgraduateName', title: '姓名', templet: function(d) {
                    return '<a href="' + getBasePath() + '/academicExchange/student.do?id=' + d.postgraduateId + '">' + d.postgraduateName + '</a>';
                }
            }
        ]],
        page: true
    });

});
//@sourceURL=/js/teacherParticipateProblemList.js
$(function() {

    var table = layui.table;

    table.render({
        elem: '#participateProblemList-list',
        url: getBasePath() + '/teacher/getByPage.do?id=' + $('#participateProjectId').val(),
        id: 'participateProblemListReload',
        even: true,
        cols: [[
            {field: 'problemDescription', title: '问题描述'},
            {field: 'solveProcess', title: '解决过程'},
        ]],
        page: true
    });

});
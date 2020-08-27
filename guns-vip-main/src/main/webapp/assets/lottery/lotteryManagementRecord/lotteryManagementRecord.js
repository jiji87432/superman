layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;
    var form = layui.form;

    /**
     * 彩票记录表管理
     */
    var LotteryManagementRecord = {
        tableId: "lotteryManagementRecordTable"
    };

    /**
     * 初始化表格的列
     */
    LotteryManagementRecord.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键id'},
            {field: 'deptId', hide: true, sort: true, title: '门店ID'},
            {field: 'deptName', hide: false, sort: true, title: '门店'},
            {field: 'lotteryType', hide: true, sort: true, title: '彩票类型'},
            {field: 'lotteryTypeDescription', sort: true, title: '彩票'},
            {field: 'salesVolume', sort: true, title: '销量'},
            {field: 'commission', sort: true, title: '佣金'},
            {field: 'status', hide: true, sort: true, title: '状态(字典)'},
            {field: 'account', hide: false, sort: true, title: '创建用户'},
            {field: 'startDate', hide: false, sort: true, title: '开始时间'},
            {field: 'endDate', hide: false, sort: true, title: '结束时间'},
            {field: 'createTime', sort: true, title: '创建时间'},
            {field: 'createUser', hide: true, sort: true, title: '创建人'},
            {field: 'updateTime', hide: true, sort: true, title: '更新时间'},
            {field: 'updateUser', hide: true, sort: true, title: '更新人'},
            {field: 'version', hide: true, sort: true, title: '乐观锁'},
            {field: 'extend', hide: true, sort: true, title: '扩展字段'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    LotteryManagementRecord.search = function () {
        var queryData = {};
        queryData['account'] = $('#account').val();
        queryData['lotteryType'] = $('#lotteryType').val();
        queryData['deptId'] = $('#deptId').val();
        table.reload(LotteryManagementRecord.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 跳转到添加页面
     */
    LotteryManagementRecord.jumpAddPage = function () {
        window.location.href = Feng.ctxPath + '/lotteryManagementRecord/add'
    };

    /**
     * 跳转到编辑页面
     *
     * @param data 点击按钮时候的行数据
     */
    LotteryManagementRecord.jumpEditPage = function (data) {
        window.location.href = Feng.ctxPath + '/lotteryManagementRecord/edit?id=' + data.id
    };

    /**
     * 导出excel按钮
     */
    LotteryManagementRecord.exportExcel = function () {
        var checkRows = table.checkStatus(LotteryManagementRecord.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    LotteryManagementRecord.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/lotteryManagementRecord/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(LotteryManagementRecord.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + LotteryManagementRecord.tableId,
        url: Feng.ctxPath + '/lotteryManagementRecord/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: LotteryManagementRecord.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        LotteryManagementRecord.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

        LotteryManagementRecord.jumpAddPage();

    });

    // 导出excel
    $('#btnExp').click(function () {
        LotteryManagementRecord.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + LotteryManagementRecord.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            LotteryManagementRecord.jumpEditPage(data);
        } else if (layEvent === 'delete') {
            LotteryManagementRecord.onDeleteItem(data);
        }
    });
});

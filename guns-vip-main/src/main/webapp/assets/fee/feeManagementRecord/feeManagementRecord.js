layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 费用管理记录表管理
     */
    var FeeManagementRecord = {
        tableId: "feeManagementRecordTable"
    };

    /**
     * 初始化表格的列
     */
    FeeManagementRecord.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键id'},
            {field: 'feeType', hide: true, sort: true, title: '费用类型(字典)'},
            {field: 'feeTypeDescription', sort: true, title: '费用类型'},
            {field: 'feeDescription', sort: true, title: '费用说明'},
            {field: 'amount', sort: true, title: '金额'},
            {field: 'deptId', hide: true, sort: true, title: '部门id'},
            {field: 'deptName', sort: true, title: '部门'},
            {field: 'status', hide: true, sort: true, title: '状态(字典)'},
            {field: 'account', sort: true, title: '创建用户'},
            {field: 'startDate', sort: true, title: '开始时间'},
            {field: 'endDate', sort: true, title: '结束时间'},
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
    FeeManagementRecord.search = function () {
        var queryData = {};


        table.reload(FeeManagementRecord.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 跳转到添加页面
     */
    FeeManagementRecord.jumpAddPage = function () {
        window.location.href = Feng.ctxPath + '/feeManagementRecord/add'
    };

    /**
     * 跳转到编辑页面
     *
     * @param data 点击按钮时候的行数据
     */
    FeeManagementRecord.jumpEditPage = function (data) {
        window.location.href = Feng.ctxPath + '/feeManagementRecord/edit?id=' + data.id
    };

    /**
     * 导出excel按钮
     */
    FeeManagementRecord.exportExcel = function () {
        var checkRows = table.checkStatus(FeeManagementRecord.tableId);
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
    FeeManagementRecord.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/feeManagementRecord/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(FeeManagementRecord.tableId);
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
        elem: '#' + FeeManagementRecord.tableId,
        url: Feng.ctxPath + '/feeManagementRecord/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: FeeManagementRecord.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        FeeManagementRecord.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

        FeeManagementRecord.jumpAddPage();

    });

    // 导出excel
    $('#btnExp').click(function () {
        FeeManagementRecord.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + FeeManagementRecord.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            FeeManagementRecord.jumpEditPage(data);
        } else if (layEvent === 'delete') {
            FeeManagementRecord.onDeleteItem(data);
        }
    });
});

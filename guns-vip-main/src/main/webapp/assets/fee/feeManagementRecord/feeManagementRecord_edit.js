/**
 * 详情对话框
 */
var FeeManagementRecordInfoDlg = {
    data: {
        id: "",
        feeType: "",
        feeTypeDescription: "",
        feeDescription: "",
        amount: "",
        deptId: "",
        deptName: "",
        status: "",
        account: "",
        startDate: "",
        endDate: "",
        createTime: "",
        createUser: "",
        updateTime: "",
        updateUser: "",
        version: "",
        extend: ""
    }
};

layui.use(['form', 'admin', 'ax', 'laydate', 'upload', 'formSelects'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var laydate = layui.laydate;

    // 渲染时间选择框
    laydate.render({
        elem: '#startDate',
        type: 'datetime'
    });

    // 渲染时间选择框
    laydate.render({
        elem: '#endDate',
        type: 'datetime'
    });


    //获取详情信息，填充表单
    var ajax = new $ax(Feng.ctxPath + "/feeManagementRecord/detail?id=" + Feng.getUrlParam("id"));
    var result = ajax.start();
    form.val('feeManagementRecordForm', result.data);

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/feeManagementRecord/editItem", function (data) {
            Feng.success("更新成功！");
            window.location.href = Feng.ctxPath + '/feeManagementRecord'
        }, function (data) {
            Feng.error("更新失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();

        return false;
    });

    $('#cancel').click(function () {
        window.location.href = Feng.ctxPath + '/feeManagementRecord'
    });
});
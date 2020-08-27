package cn.stylefeng.guns.modular.fee.controller;

import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.base.auth.model.LoginUser;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.fee.entity.FeeManagementRecord;
import cn.stylefeng.guns.modular.fee.model.params.FeeManagementRecordParam;
import cn.stylefeng.guns.modular.fee.service.FeeManagementRecordService;
import cn.stylefeng.guns.sys.modular.system.entity.Dept;
import cn.stylefeng.guns.sys.modular.system.entity.Dict;
import cn.stylefeng.guns.sys.modular.system.model.result.DictResult;
import cn.stylefeng.guns.sys.modular.system.service.DeptService;
import cn.stylefeng.guns.sys.modular.system.service.DictService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static cn.stylefeng.guns.base.consts.ConfigConstant.FEE_TYPE;
import static cn.stylefeng.guns.base.consts.ConfigConstant.LOTTERY_TYPE;


/**
 * 费用管理记录表控制器
 *
 * @author yongji.zhang
 * @Date 2020-08-27 18:07:50
 */
@Controller
@RequestMapping("/feeManagementRecord")
public class FeeManagementRecordController extends BaseController {

    private String PREFIX = "/fee/feeManagementRecord";

    @Autowired
    private FeeManagementRecordService feeManagementRecordService;
    @Autowired
    private DictService dictService;
    @Autowired
    private DeptService deptService;

    /**
     * 跳转到主页面
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
    @RequestMapping("")
    public String index(Model model) {
        List<Dict> dictType = dictService.listDictsByCode(FEE_TYPE);
        model.addAttribute("dictType", dictType);
        return PREFIX + "/feeManagementRecord.html";
    }

    /**
     * 新增页面
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
    @RequestMapping("/add")
    public String add(Model model) {
        List<Dict> dictType = dictService.listDictsByCode(FEE_TYPE);
        model.addAttribute("dictType", dictType);
        LoginUser user = LoginContextHolder.getContext().getUser();
        if (!ObjectUtils.isEmpty(user) && !ObjectUtils.isEmpty(user.getRoleTips()) && user.getRoleTips().size() > 0) {
            AtomicBoolean isSuper = new AtomicBoolean(false);
            List<Dept> depts = new ArrayList<>();
            user.getRoleTips().forEach(role -> {
                if (role.equals("administrator")) {
                    isSuper.set(true);
                }
            });
            if (isSuper.get()) {
                depts = deptService.list();
            } else {
                QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("dept_id", user.getDeptId());
                depts = deptService.list(queryWrapper);
            }
            model.addAttribute("depts", depts);
        }
        return PREFIX + "/feeManagementRecord_add.html";
    }

    /**
     * 编辑页面
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
    @RequestMapping("/edit")
    public String edit(Model model) {
        List<Dict> dictType = dictService.listDictsByCode(FEE_TYPE);
        model.addAttribute("dictType", dictType);
        LoginUser user = LoginContextHolder.getContext().getUser();
        if (!ObjectUtils.isEmpty(user) && !ObjectUtils.isEmpty(user.getRoleTips()) && user.getRoleTips().size() > 0) {
            AtomicBoolean isSuper = new AtomicBoolean(false);
            List<Dept> depts = new ArrayList<>();
            user.getRoleTips().forEach(role -> {
                if (role.equals("administrator")) {
                    isSuper.set(true);
                }
            });
            if (isSuper.get()) {
                depts = deptService.list();
            } else {
                QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("dept_id", user.getDeptId());
                depts = deptService.list(queryWrapper);
            }
            model.addAttribute("depts", depts);
        }
        return PREFIX + "/feeManagementRecord_edit.html";
    }

    /**
     * 新增接口
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(FeeManagementRecordParam feeManagementRecordParam) {
        DictResult dictResult = dictService.dictDetail(Long.valueOf(feeManagementRecordParam.getFeeType()));
        if (!ObjectUtils.isEmpty(dictResult)) {
            feeManagementRecordParam.setFeeTypeDescription(dictResult.getName());
        }
        QueryWrapper<Dept> deptQueryWrapper = new QueryWrapper<>();
        deptQueryWrapper.eq("dept_id", feeManagementRecordParam.getDeptId());
        Dept dept = deptService.getOne(deptQueryWrapper);
        if (!ObjectUtils.isEmpty(dept)) {
            feeManagementRecordParam.setDeptName(dept.getFullName());
        }
        LoginUser user = LoginContextHolder.getContext().getUser();
        if (!ObjectUtils.isEmpty(user)) {
            feeManagementRecordParam.setAccount(user.getAccount());
        }
        this.feeManagementRecordService.add(feeManagementRecordParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(FeeManagementRecordParam feeManagementRecordParam) {
        DictResult dictResult = dictService.dictDetail(Long.valueOf(feeManagementRecordParam.getFeeType()));
        if (!ObjectUtils.isEmpty(dictResult)) {
            feeManagementRecordParam.setFeeDescription(dictResult.getName());
        }
        this.feeManagementRecordService.update(feeManagementRecordParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(FeeManagementRecordParam feeManagementRecordParam) {
        this.feeManagementRecordService.delete(feeManagementRecordParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(FeeManagementRecordParam feeManagementRecordParam) {
        FeeManagementRecord detail = this.feeManagementRecordService.getById(feeManagementRecordParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(FeeManagementRecordParam feeManagementRecordParam) {
        return this.feeManagementRecordService.findPageBySpec(feeManagementRecordParam);
    }

}



package cn.stylefeng.guns.modular.lottery.controller;

import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.base.auth.model.LoginUser;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.lottery.entity.LotteryManagementRecord;
import cn.stylefeng.guns.modular.lottery.model.params.LotteryManagementRecordParam;
import cn.stylefeng.guns.modular.lottery.service.LotteryManagementRecordService;
import cn.stylefeng.guns.sys.modular.system.entity.Dept;
import cn.stylefeng.guns.sys.modular.system.entity.Dict;
import cn.stylefeng.guns.sys.modular.system.factory.UserFactory;
import cn.stylefeng.guns.sys.modular.system.model.result.DictResult;
import cn.stylefeng.guns.sys.modular.system.service.DeptService;
import cn.stylefeng.guns.sys.modular.system.service.DictService;
import cn.stylefeng.guns.sys.modular.system.service.UserService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

import static cn.stylefeng.guns.base.consts.ConfigConstant.CARD_DICT_TYPE;
import static cn.stylefeng.guns.base.consts.ConfigConstant.LOTTERY_TYPE;


/**
 * 彩票记录表控制器
 *
 * @author yongji.zhang
 * @Date 2020-08-10 19:47:33
 */
@Controller
@RequestMapping("/lotteryManagementRecord")
public class LotteryManagementRecordController extends BaseController {

    private String PREFIX = "/lottery/lotteryManagementRecord";

    @Autowired
    private LotteryManagementRecordService lotteryManagementRecordService;
    @Autowired
    private DictService dictService;
    @Autowired
    private DeptService deptService;
    @Autowired
    private UserService userService;

    /**
     * 跳转到主页面
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
    @RequestMapping("")
    public String index(Model model) {
        List<Dict> dictType = dictService.listDictsByCode(LOTTERY_TYPE);
        model.addAttribute("dictType", dictType);
        List<Dept> depts = deptService.list();
        model.addAttribute("depts", depts);
        return PREFIX + "/lotteryManagementRecord.html";
    }

    /**
     * 新增页面
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
    @RequestMapping("/add")
    public String add(Model model) {
        List<Dict> dictType = dictService.listDictsByCode(LOTTERY_TYPE);
        model.addAttribute("dictType", dictType);
        List<Dept> depts = deptService.list();
        model.addAttribute("depts", depts);
        return PREFIX + "/lotteryManagementRecord_add.html";
    }

    /**
     * 编辑页面
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
    @RequestMapping("/edit")
    public String edit(Model model) {
        List<Dict> dictType = dictService.listDictsByCode(LOTTERY_TYPE);
        model.addAttribute("dictType", dictType);
        List<Dept> depts = deptService.list();
        model.addAttribute("depts", depts);
        return PREFIX + "/lotteryManagementRecord_edit.html";
    }

    /**
     * 新增接口
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(LotteryManagementRecordParam lotteryManagementRecordParam) {
        DictResult dictResult = dictService.dictDetail(Long.valueOf(lotteryManagementRecordParam.getLotteryType()));
        if (!ObjectUtils.isEmpty(dictResult)) {
            lotteryManagementRecordParam.setLotteryTypeDescription(dictResult.getName());
        }
        QueryWrapper<Dept> deptQueryWrapper = new QueryWrapper<>();
        deptQueryWrapper.eq("dept_id", lotteryManagementRecordParam.getDeptId());
        Dept dept = deptService.getOne(deptQueryWrapper);
        if (!ObjectUtils.isEmpty(dept)) {
            lotteryManagementRecordParam.setDeptName(dept.getFullName());
        }
        LoginUser user = LoginContextHolder.getContext().getUser();
        if (!ObjectUtils.isEmpty(user)) {
            lotteryManagementRecordParam.setAccount(user.getAccount());
        }
        this.lotteryManagementRecordService.add(lotteryManagementRecordParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(LotteryManagementRecordParam lotteryManagementRecordParam) {
        DictResult dictResult = dictService.dictDetail(Long.valueOf(lotteryManagementRecordParam.getLotteryType()));
        if (!ObjectUtils.isEmpty(dictResult)) {
            lotteryManagementRecordParam.setLotteryTypeDescription(dictResult.getName());
        }
        this.lotteryManagementRecordService.update(lotteryManagementRecordParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(LotteryManagementRecordParam lotteryManagementRecordParam) {
        this.lotteryManagementRecordService.delete(lotteryManagementRecordParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(LotteryManagementRecordParam lotteryManagementRecordParam) {
        LotteryManagementRecord detail = this.lotteryManagementRecordService.getById(lotteryManagementRecordParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(LotteryManagementRecordParam lotteryManagementRecordParam) {
        return this.lotteryManagementRecordService.findPageBySpec(lotteryManagementRecordParam);
    }

}



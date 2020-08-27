package cn.stylefeng.guns.modular.fee.service.impl;

import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.base.auth.model.LoginUser;
import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.fee.entity.FeeManagementRecord;
import cn.stylefeng.guns.modular.fee.mapper.FeeManagementRecordMapper;
import cn.stylefeng.guns.modular.fee.model.params.FeeManagementRecordParam;
import cn.stylefeng.guns.modular.fee.model.result.FeeManagementRecordResult;
import cn.stylefeng.guns.modular.fee.service.FeeManagementRecordService;
import cn.stylefeng.guns.modular.lottery.entity.LotteryManagementRecord;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <p>
 * 费用管理记录表 服务实现类
 * </p>
 *
 * @author yongji.zhang
 * @since 2020-08-27
 */
@Service
public class FeeManagementRecordServiceImpl extends ServiceImpl<FeeManagementRecordMapper, FeeManagementRecord> implements FeeManagementRecordService {

    @Override
    public void add(FeeManagementRecordParam param) {
        FeeManagementRecord entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(FeeManagementRecordParam param) {
        this.removeById(getKey(param));
    }

    @Override
    public void update(FeeManagementRecordParam param) {
        FeeManagementRecord oldEntity = getOldEntity(param);
        FeeManagementRecord newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public FeeManagementRecordResult findBySpec(FeeManagementRecordParam param) {
        return null;
    }

    @Override
    public List<FeeManagementRecordResult> findListBySpec(FeeManagementRecordParam param) {
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(FeeManagementRecordParam param) {
        LoginUser user = LoginContextHolder.getContext().getUser();
        if (!ObjectUtils.isEmpty(user) && !ObjectUtils.isEmpty(user.getRoleTips()) && user.getRoleTips().size() > 0) {
            AtomicBoolean isSuper = new AtomicBoolean(true);
            user.getRoleTips().forEach(role -> {
                if (role.equals("administrator")) {
                    isSuper.set(false);
                }
            });
            if (isSuper.get()) {
                param.setDeptId(user.getDeptId());
            }
        }
        Page pageContext = getPageContext();
        QueryWrapper<FeeManagementRecord> objectQueryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(param.getAccount())) {
            objectQueryWrapper.eq("account", param.getAccount());
        }
        if (!ObjectUtils.isEmpty(param.getFeeType())) {
            objectQueryWrapper.eq("fee_type", param.getFeeType());
        }
        if (!ObjectUtils.isEmpty(param.getDeptId())) {
            objectQueryWrapper.eq("dept_id", param.getDeptId());
        }
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(FeeManagementRecordParam param) {
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private FeeManagementRecord getOldEntity(FeeManagementRecordParam param) {
        return this.getById(getKey(param));
    }

    private FeeManagementRecord getEntity(FeeManagementRecordParam param) {
        FeeManagementRecord entity = new FeeManagementRecord();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}

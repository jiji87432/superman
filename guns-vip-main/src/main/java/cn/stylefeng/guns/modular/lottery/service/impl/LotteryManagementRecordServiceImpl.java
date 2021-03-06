package cn.stylefeng.guns.modular.lottery.service.impl;

import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.base.auth.model.LoginUser;
import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.lottery.entity.LotteryManagementRecord;
import cn.stylefeng.guns.modular.lottery.mapper.LotteryManagementRecordMapper;
import cn.stylefeng.guns.modular.lottery.model.params.LotteryManagementRecordParam;
import cn.stylefeng.guns.modular.lottery.model.result.LotteryManagementRecordResult;
import cn.stylefeng.guns.modular.lottery.service.LotteryManagementRecordService;
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
 * 彩票记录表 服务实现类
 * </p>
 *
 * @author yongji.zhang
 * @since 2020-08-10
 */
@Service
public class LotteryManagementRecordServiceImpl extends ServiceImpl<LotteryManagementRecordMapper, LotteryManagementRecord> implements LotteryManagementRecordService {

    @Override
    public void add(LotteryManagementRecordParam param) {
        LotteryManagementRecord entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(LotteryManagementRecordParam param) {
        this.removeById(getKey(param));
    }

    @Override
    public void update(LotteryManagementRecordParam param) {
        LotteryManagementRecord oldEntity = getOldEntity(param);
        LotteryManagementRecord newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public LotteryManagementRecordResult findBySpec(LotteryManagementRecordParam param) {
        return null;
    }

    @Override
    public List<LotteryManagementRecordResult> findListBySpec(LotteryManagementRecordParam param) {
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(LotteryManagementRecordParam param) {
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
        QueryWrapper<LotteryManagementRecord> objectQueryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(param.getAccount())) {
            objectQueryWrapper.eq("account", param.getAccount());
        }
        if (!ObjectUtils.isEmpty(param.getLotteryType())) {
            objectQueryWrapper.eq("lottery_type", param.getLotteryType());
        }
        if (!ObjectUtils.isEmpty(param.getDeptId())) {
            objectQueryWrapper.eq("dept_id", param.getDeptId());
        }
        IPage page = this.page(pageContext, objectQueryWrapper);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(LotteryManagementRecordParam param) {
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private LotteryManagementRecord getOldEntity(LotteryManagementRecordParam param) {
        return this.getById(getKey(param));
    }

    private LotteryManagementRecord getEntity(LotteryManagementRecordParam param) {
        LotteryManagementRecord entity = new LotteryManagementRecord();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}

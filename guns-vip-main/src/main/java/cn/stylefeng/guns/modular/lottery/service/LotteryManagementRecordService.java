package cn.stylefeng.guns.modular.lottery.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.lottery.entity.LotteryManagementRecord;
import cn.stylefeng.guns.modular.lottery.model.params.LotteryManagementRecordParam;
import cn.stylefeng.guns.modular.lottery.model.result.LotteryManagementRecordResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 彩票记录表 服务类
 * </p>
 *
 * @author yongji.zhang
 * @since 2020-08-10
 */
public interface LotteryManagementRecordService extends IService<LotteryManagementRecord> {

    /**
     * 新增
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
    void add(LotteryManagementRecordParam param);

    /**
     * 删除
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
    void delete(LotteryManagementRecordParam param);

    /**
     * 更新
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
    void update(LotteryManagementRecordParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
    LotteryManagementRecordResult findBySpec(LotteryManagementRecordParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
    List<LotteryManagementRecordResult> findListBySpec(LotteryManagementRecordParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
     LayuiPageInfo findPageBySpec(LotteryManagementRecordParam param);

}

package cn.stylefeng.guns.modular.fee.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.fee.entity.FeeManagementRecord;
import cn.stylefeng.guns.modular.fee.model.params.FeeManagementRecordParam;
import cn.stylefeng.guns.modular.fee.model.result.FeeManagementRecordResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 费用管理记录表 服务类
 * </p>
 *
 * @author yongji.zhang
 * @since 2020-08-27
 */
public interface FeeManagementRecordService extends IService<FeeManagementRecord> {

    /**
     * 新增
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
    void add(FeeManagementRecordParam param);

    /**
     * 删除
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
    void delete(FeeManagementRecordParam param);

    /**
     * 更新
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
    void update(FeeManagementRecordParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
    FeeManagementRecordResult findBySpec(FeeManagementRecordParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
    List<FeeManagementRecordResult> findListBySpec(FeeManagementRecordParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
     LayuiPageInfo findPageBySpec(FeeManagementRecordParam param);

}

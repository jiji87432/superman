package cn.stylefeng.guns.modular.lottery.mapper;

import cn.stylefeng.guns.modular.lottery.entity.LotteryManagementRecord;
import cn.stylefeng.guns.modular.lottery.model.params.LotteryManagementRecordParam;
import cn.stylefeng.guns.modular.lottery.model.result.LotteryManagementRecordResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 彩票记录表 Mapper 接口
 * </p>
 *
 * @author yongji.zhang
 * @since 2020-08-10
 */
public interface LotteryManagementRecordMapper extends BaseMapper<LotteryManagementRecord> {

    /**
     * 获取列表
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
    List<LotteryManagementRecordResult> customList(@Param("paramCondition") LotteryManagementRecordParam paramCondition);

    /**
     * 获取map列表
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") LotteryManagementRecordParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
    Page<LotteryManagementRecordResult> customPageList(@Param("page") Page page, @Param("paramCondition") LotteryManagementRecordParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author yongji.zhang
     * @Date 2020-08-10
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") LotteryManagementRecordParam paramCondition);

}

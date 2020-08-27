package cn.stylefeng.guns.modular.fee.mapper;

import cn.stylefeng.guns.modular.fee.entity.FeeManagementRecord;
import cn.stylefeng.guns.modular.fee.model.params.FeeManagementRecordParam;
import cn.stylefeng.guns.modular.fee.model.result.FeeManagementRecordResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 费用管理记录表 Mapper 接口
 * </p>
 *
 * @author yongji.zhang
 * @since 2020-08-27
 */
public interface FeeManagementRecordMapper extends BaseMapper<FeeManagementRecord> {

    /**
     * 获取列表
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
    List<FeeManagementRecordResult> customList(@Param("paramCondition") FeeManagementRecordParam paramCondition);

    /**
     * 获取map列表
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") FeeManagementRecordParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
    Page<FeeManagementRecordResult> customPageList(@Param("page") Page page, @Param("paramCondition") FeeManagementRecordParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author yongji.zhang
     * @Date 2020-08-27
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") FeeManagementRecordParam paramCondition);

}

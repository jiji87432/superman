package cn.stylefeng.guns.modular.lottery.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;

import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 彩票记录表
 * </p>
 *
 * @author yongji.zhang
 * @since 2020-08-10
 */
@Data
public class LotteryManagementRecordParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long id;

    /**
     * 彩票类型(字典)
     */
    private String lotteryType;

    /**
     * 彩票描述
     */
    private String lotteryTypeDescription;

    /**
     * 销量
     */
    private String salesVolume;

    /**
     * 佣金
     */
    private BigDecimal commission;

    /**
     * 部门id(多个逗号隔开)
     */
    private Long deptId;

    /**
     * 部门
     */
    private String deptName;

    /**
     * 状态(字典)
     */
    private String status;

    /**
     * 创建时间
     */
    private Date startDate;

    /**
     * 创建时间
     */
    private Date endDate;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Long createUser;
    private String account;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新人
     */
    private Long updateUser;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 扩展字段
     */
    private String extend;

    @Override
    public String checkParam() {
        return null;
    }

}

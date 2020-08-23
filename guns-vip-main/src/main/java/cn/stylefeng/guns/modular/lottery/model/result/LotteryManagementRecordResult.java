package cn.stylefeng.guns.modular.lottery.model.result;

import lombok.Data;
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
public class LotteryManagementRecordResult implements Serializable {

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

}

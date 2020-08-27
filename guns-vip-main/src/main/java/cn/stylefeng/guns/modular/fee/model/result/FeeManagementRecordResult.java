package cn.stylefeng.guns.modular.fee.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 费用管理记录表
 * </p>
 *
 * @author yongji.zhang
 * @since 2020-08-27
 */
@Data
public class FeeManagementRecordResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long id;

    /**
     * 费用类型(字典)
     */
    private String feeType;

    /**
     * 费用类型描述
     */
    private String feeTypeDescription;

    /**
     * 费用说明
     */
    private String feeDescription;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 部门id
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
     * 创建用户
     */
    private String account;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束时间
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

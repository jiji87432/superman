package cn.stylefeng.guns.modular.lottery.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 彩票记录表
 * </p>
 *
 * @author yongji.zhang
 * @since 2020-08-10
 */
@Data
@TableName("lottery_management_record")
public class LotteryManagementRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 彩票类型(字典)
     */
    @TableField("lottery_type")
    private String lotteryType;

    /**
     * 彩票描述
     */
    @TableField("lottery_type_description")
    private String lotteryTypeDescription;

    /**
     * 销量
     */
    @TableField("sales_volume")
    private String salesVolume;

    /**
     * 佣金
     */
    @TableField("commission")
    private BigDecimal commission;

    /**
     * 部门id(多个逗号隔开)
     */
    @TableField("dept_id")
    private Long deptId;

    /**
     * 部门
     */
    @TableField("dept_name")
    private String deptName;

    /**
     * 状态(字典)
     */
    @TableField("status")
    private String status;

    @TableField("account")
    private String account;

    /**
     * 开始时间
     */
    @TableField(value = "start_date", fill = FieldFill.INSERT)
    private Date startDate;

    /**
     * 结束时间
     */
    @TableField(value = "end_date", fill = FieldFill.INSERT)
    private Date endDate;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 创建人
     */
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private Long createUser;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 更新人
     */
    @TableField(value = "update_user", fill = FieldFill.UPDATE)
    private Long updateUser;

    /**
     * 乐观锁
     */
    @TableField("version")
    private Integer version;

    /**
     * 扩展字段
     */
    @TableField("extend")
    private String extend;
}

package cn.stylefeng.guns.modular.fee.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 费用管理记录表
 * </p>
 *
 * @author yongji.zhang
 * @since 2020-08-27
 */
@TableName("fee_management_record")
public class FeeManagementRecord implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 费用类型(字典)
     */
    @TableField("fee_type")
    private String feeType;

    /**
     * 费用类型描述
     */
    @TableField("fee_type_description")
    private String feeTypeDescription;

    /**
     * 费用说明
     */
    @TableField("fee_description")
    private String feeDescription;

    /**
     * 金额
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 部门id
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

    /**
     * 创建用户
     */
    @TableField("account")
    private String account;

    /**
     * 开始时间
     */
    @TableField("start_date")
    private Date startDate;

    /**
     * 结束时间
     */
    @TableField("end_date")
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getFeeTypeDescription() {
        return feeTypeDescription;
    }

    public void setFeeTypeDescription(String feeTypeDescription) {
        this.feeTypeDescription = feeTypeDescription;
    }

    public String getFeeDescription() {
        return feeDescription;
    }

    public void setFeeDescription(String feeDescription) {
        this.feeDescription = feeDescription;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    @Override
    public String toString() {
        return "FeeManagementRecord{" +
        "id=" + id +
        ", feeType=" + feeType +
        ", feeTypeDescription=" + feeTypeDescription +
        ", feeDescription=" + feeDescription +
        ", amount=" + amount +
        ", deptId=" + deptId +
        ", deptName=" + deptName +
        ", status=" + status +
        ", account=" + account +
        ", startDate=" + startDate +
        ", endDate=" + endDate +
        ", createTime=" + createTime +
        ", createUser=" + createUser +
        ", updateTime=" + updateTime +
        ", updateUser=" + updateUser +
        ", version=" + version +
        ", extend=" + extend +
        "}";
    }
}

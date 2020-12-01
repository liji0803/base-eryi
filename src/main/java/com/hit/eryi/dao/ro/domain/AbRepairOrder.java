package com.hit.eryi.dao.ro.domain;

import com.hit.eryi.infrastructure.persistence.domain.IntegerDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 * @author AutoGenerator
 * 数据库表实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ab_repair_order")
public class AbRepairOrder extends IntegerDomain {
    private static final Long serialVersionUID = 1L;
    /**
     * 工单单号
     */
    @Column(name = "ro_code")
    private String roCode;

    /**
     * 相关单号
     */
    @Column(name = "refer_ro_code")
    private String referRoCode;

    /**
     * 门店编码
     */
    @Column(name = "store_code")
    private String storeCode;

    /**
     * 门店名称
     */
    @Column(name = "store_name")
    private String storeName;

    /**
     * 服务方式(10：店内维修；20：上门维修)
     */
    @Column(name = "service_type")
    private Integer serviceType;

    /**
     * 工单备注
     */
    @Column(name = "remarks")
    private String remarks;

    /**
     * 维修车辆VIN码
     */
    @Column(name = "vin")
    private String vin;

    /**
     * 客户账号
     */
    @Column(name = "customer_account_id")
    private String customerAccountId;

    /**
     * 维修技师编号
     */
    @Column(name = "employee_account_id")
    private String employeeAccountId;

    /**
     * 维修技师名称
     */
    @Column(name = "employee_name")
    private String employeeName;

    /**
     * 维修预计开始时间
     */
    @Column(name = "begin_time")
    private OffsetDateTime beginTime;

    /**
     * 维修预计结束时间
     */
    @Column(name = "end_time")
    private OffsetDateTime endTime;

    /**
     * 工单状态（10:新建；20:检测中；30:维修中；40:已完成）
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 预估费用总计
     */
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    /**
     * 是否挂起（10:挂起；20:解除挂起）
     */
    @Column(name = "suspend_status")
    private Integer suspendStatus;

    /**
     * 挂起时间
     */
    @Column(name = "suspend_time")
    private OffsetDateTime suspendTime;

    /**
     * 创建人编码
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 创建人名称
     */
    @Column(name = "create_username")
    private String createUsername;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private OffsetDateTime createTime;

    /**
     * 是否删除（ 0：未删除，1：删除）
     */
    @Column(name = "is_delete")
    private Integer isDelete;

    /**
     * 修改人编码
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 修改人名称
     */
    @Column(name = "update_username")
    private String updateUsername;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private OffsetDateTime updateTime;

    /**
     * 服务单号
     */
    @Column(name = "ticket_no")
    private String ticketNo;

    /**
     * 工单类型（10:维修工单；20:销售工单）
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 工单创建类型(0：AB创建；1：钣喷创建)
     */
    @Column(name = "create_type")
    private Integer createType;

    /**
     * 送修人姓名
     */
    @Column(name = "repair_username")
    private String repairUsername;


    /**
     * 送修人电话
     */
    @Column(name = "repair_user_phone")
    private String repairUserPhone;

    /**
     * 工单完成时间
     */
    @Column(name = "finish_time")
    private OffsetDateTime finishTime;

    /**
     * 行驶里程
     */
    @Column(name = "total_odometer")
    private String totalOdometer;

    /**
     * 油量
     */
    @Column(name = "fuel_level_position")
    private String fuelLevelPosition;

    /**
     * 增程器里程
     */
    @Column(name = "fuel_endurance")
    private Integer fuelEndurance;

    /**
     * 电量
     */
    @Column(name = "soc")
    private String soc;

    public class Fields {
        public static final String roCode = "roCode";
        public static final String referRoCode = "referRoCode";
        public static final String storeCode = "storeCode";
        public static final String storeName = "storeName";
        public static final String serviceType = "serviceType";
        public static final String remarks = "remarks";
        public static final String vin = "vin";
        public static final String customerAccountId = "customerAccountId";
        public static final String employeeAccountId = "employeeAccountId";
        public static final String employeeName = "employeeName";
        public static final String beginTime = "beginTime";
        public static final String endTime = "endTime";
        public static final String status = "status";
        public static final String totalPrice = "totalPrice";
        public static final String suspendStatus = "suspendStatus";
        public static final String suspendTime = "suspendTime";
        public static final String createUser = "createUser";
        public static final String createUsername = "createUsername";
        public static final String createTime = "createTime";
        public static final String isDelete = "isDelete";
        public static final String updateUser = "updateUser";
        public static final String updateUsername = "updateUsername";
        public static final String updateTime = "updateTime";
        public static final String ticketNo = "ticketNo";
        public static final String type = "type";
        public static final String createType = "createType";
        public static final String id = "id";
        public static final String totalOdometer = "totalOdometer";
        public static final String fuelLevelPosition = "fuelLevelPosition";
        public static final String soc = "soc";
        public static final String fuelEndurance = "fuelEndurance";
    }
}

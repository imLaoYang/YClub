package com.yang.auth.infra.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName auth_permission
 */
@TableName(value ="auth_permission")
@Data
public class AuthPermission implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Long parentId;

    /**
     * 
     */
    private Integer type;

    /**
     * 
     */
    private String menuUrl;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private Integer show;

    /**
     * 
     */
    private String icon;

    /**
     * 
     */
    private String permissionKey;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
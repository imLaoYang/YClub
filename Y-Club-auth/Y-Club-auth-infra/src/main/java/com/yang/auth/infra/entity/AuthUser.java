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
 * @TableName auth_user
 */
@TableName(value ="auth_user")
@Data
public class AuthUser implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String userName;

    /**
     * 
     */
    private String nickName;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private Integer sex;

    /**
     * 
     */
    private String avatar;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private String introduce;

    /**
     * 
     */
    private String extJson;

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
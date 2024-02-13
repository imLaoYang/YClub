package com.yang.auth.application.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName auth_user_role
 */
@Data
public class AuthUserRoleDTO implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private Long roleId;

    private static final long serialVersionUID = 1L;
}
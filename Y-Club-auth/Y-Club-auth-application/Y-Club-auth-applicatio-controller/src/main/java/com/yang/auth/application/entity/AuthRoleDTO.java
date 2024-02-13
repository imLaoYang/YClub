package com.yang.auth.application.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName auth_role
 */
@Data
public class AuthRoleDTO implements Serializable {
    /**
     * 
     */

    private Long id;

    /**
     * 
     */
    private String roleName;

    /**
     * 
     */
    private String roleKey;



    private static final long serialVersionUID = 1L;
}
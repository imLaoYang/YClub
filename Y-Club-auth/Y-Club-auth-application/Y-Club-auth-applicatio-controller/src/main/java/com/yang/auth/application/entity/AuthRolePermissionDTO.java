package com.yang.auth.application.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Data
public class AuthRolePermissionDTO implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long roleId;

    /**
     * 
     */
    private List<Long> permissionIdList;


    private static final long serialVersionUID = 1L;
}
package com.yang.auth.infra.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.auth.infra.entity.AuthPermission;
import com.yang.auth.infra.service.AuthPermissionService;
import com.yang.auth.infra.mapper.AuthPermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author Yang
* @description 针对表【auth_permission】的数据库操作Service实现
* @createDate 2024-02-10 20:47:34
*/
@Service
public class AuthPermissionServiceImpl extends ServiceImpl<AuthPermissionMapper, AuthPermission>
    implements AuthPermissionService{

}





package com.yang.auth.infra.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.auth.infra.entity.AuthUserRole;
import com.yang.auth.infra.service.AuthUserRoleService;
import com.yang.auth.infra.mapper.AuthUserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author Yang
* @description 针对表【auth_user_role】的数据库操作Service实现
* @createDate 2024-02-10 20:47:34
*/
@Service
public class AuthUserRoleServiceImpl extends ServiceImpl<AuthUserRoleMapper, AuthUserRole>
    implements AuthUserRoleService{

}





package com.yang.auth.infra.mapper;

import com.yang.auth.infra.entity.AuthUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Yang
* @description 针对表【auth_user_role】的数据库操作Mapper
* @createDate 2024-02-10 20:47:34
* @Entity com.yang.domain.AuthUserRole
*/@Mapper
public interface AuthUserRoleMapper extends BaseMapper<AuthUserRole> {

}





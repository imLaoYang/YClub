package com.yang.auth.infra.mapper;

import com.yang.auth.infra.entity.AuthUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Yang
* @description 针对表【auth_user】的数据库操作Mapper
* @createDate 2024-02-10 20:47:34
* @Entity com.yang.domain.AuthUser
*/@Mapper
public interface AuthUserMapper extends BaseMapper<AuthUser> {

   void updateUser(@Param("authUser") AuthUser authUser);

   void insertAll(@Param("authUser") AuthUser authUser);


}





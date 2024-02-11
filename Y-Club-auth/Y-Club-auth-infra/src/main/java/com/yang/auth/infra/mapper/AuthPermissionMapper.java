package com.yang.auth.infra.mapper;

import com.yang.auth.infra.entity.AuthPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Yang
* @description 针对表【auth_permission】的数据库操作Mapper
* @createDate 2024-02-10 20:47:34
* @Entity com.yang.domain.AuthPermission
*/
@Mapper
public interface AuthPermissionMapper extends BaseMapper<AuthPermission> {

}





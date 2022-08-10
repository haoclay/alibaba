package com.sgq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sgq.pojo.SysUser;
import org.apache.ibatis.annotations.Insert;

public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser getByUsername(String username);

    // 插入用户
    @Insert("insert into sys_user(id ,username, password, status ,password_non_expired ) value(null,#{username}, #{password}, 1 , 1)")
    int insertSysUser(SysUser sysUser);

}
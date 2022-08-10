package com.sgq.api;

import com.sgq.pojo.SysUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ISysUserService extends UserDetailsService {

    void save(SysUser user);

    List<SysUser> findAll();

    boolean addSysUser(SysUser user);


}
package com.sgq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sgq.pojo.SysRole;

import java.util.List;

public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> listAllByUserId(Long id);
}
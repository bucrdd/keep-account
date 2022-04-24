package org.bucr.keepaccount.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.bucr.keepaccount.entity.Role;
import org.bucr.keepaccount.mapper.RoleMapper;
import org.bucr.keepaccount.repository.RoleRepository;
import org.bucr.keepaccount.service.RoleService;
import org.bucr.keepaccount.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

  @Resource
  private RoleRepository roleRepository;

  RoleMapper roleMapper;

  @Override
  public List<RoleVo> findAll() {
    return roleMapper.rolesToRoleVos(roleRepository.findAll());
  }

  @Autowired
  public void setRoleMapper(RoleMapper roleMapper) {
    this.roleMapper = roleMapper;
  }
}

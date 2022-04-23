package org.bucr.keepaccount.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.bucr.keepaccount.entity.Role;
import org.bucr.keepaccount.repository.RoleRepository;
import org.bucr.keepaccount.service.RoleService;
import org.bucr.keepaccount.vo.RoleVo;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

  @Resource
  private RoleRepository roleRepository;

  @Override
  public List<RoleVo> findAll() {
    List<Role> roles = roleRepository.findAll();
    return roles.stream().map(RoleVo::new).collect(Collectors.toList());
  }
}

package org.bucr.keepaccount.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.bucr.keepaccount.entity.Role;
import org.bucr.keepaccount.repository.RoleRepository;
import org.bucr.keepaccount.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

  @Resource
  private RoleRepository roleRepository;

  @Override
  public List<Role> findAll() {
    return roleRepository.findAll();
  }
}

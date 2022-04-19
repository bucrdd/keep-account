package org.bucr.keepaccount.controller;

import io.swagger.annotations.Api;
import java.util.List;
import javax.annotation.Resource;
import org.bucr.keepaccount.entity.Role;
import org.bucr.keepaccount.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "角色管理")
@RestController
@RequestMapping("/role")
public class RoleController {

  @Resource
  private RoleService roleService;

  @GetMapping("/list")
  public List<Role> findAll() {
    return roleService.findAll();
  }

}

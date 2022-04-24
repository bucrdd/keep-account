package org.bucr.keepaccount.mapper;

import java.util.List;
import org.bucr.keepaccount.entity.Role;
import org.bucr.keepaccount.vo.RoleVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

  @Mapping(target = "createdBy", source = "createdBy.username")
  @Mapping(target = "lastModifiedBy", source = "lastModifiedBy.username")
  RoleVo roleToRoleVo(Role role);

  List<RoleVo> rolesToRoleVos(List<Role> roles);

}

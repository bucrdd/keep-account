package org.bucr.keepaccount.vo;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bucr.keepaccount.entity.Role;

@Data
@NoArgsConstructor
public class RoleVo {

  public RoleVo(Role role) {
    this.id = role.getId();
    this.code = role.getCode();
    this.name = role.getName();
    this.description = role.getDescription();
    this.createdBy = role.getCreatedBy().getUsername();
    this.createdAt = role.getCreatedAt();
    this.lastModifiedBy = role.getLastModifiedBy().getUsername();
    this.lastModifiedAt = role.getLastModifiedAt();
  }

  private Long id;

  private String code;

  private String name;

  private String description;

  private String createdBy;

  private LocalDateTime createdAt;

  private String lastModifiedBy;

  private LocalDateTime lastModifiedAt;

}

package org.bucr.keepaccount.vo;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleVo {

  private Long id;

  private String code;

  private String name;

  private String description;

  private String createdBy;

  private LocalDateTime createdAt;

  private String lastModifiedBy;

  private LocalDateTime lastModifiedAt;

}

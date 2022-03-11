package org.bucr.keepaccount.entity;

import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Role extends AbstractAuditableEntity<User, Long> {

  private String code;

  private String name;

  private String description;

}

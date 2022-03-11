package org.bucr.keepaccount.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractAuditableEntity<U, PK extends Serializable> extends AbstractPersistableEntity<PK> {

  @CreatedBy
  @ManyToOne
  @JoinColumn(name = "created_by")
  U createdBy;

  @CreatedDate
  LocalDateTime createAt;

  @LastModifiedBy
  @ManyToOne
  @JoinColumn(name = "modified_by")
  U modifiedBy;

  @LastModifiedDate
  LocalDateTime modifiedAt;
}

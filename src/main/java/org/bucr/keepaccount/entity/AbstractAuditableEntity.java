package org.bucr.keepaccount.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditableEntity<U, PK extends Serializable> extends AbstractPersistableEntity<PK> {

  @CreatedBy
  @ManyToOne
  @JoinColumn(name = "created_by")
  U createdBy;

  @CreatedDate
  LocalDateTime createdAt;

  @LastModifiedBy
  @ManyToOne
  @JoinColumn(name = "last_modified_by")
  U lastModifiedBy;

  @LastModifiedDate
  LocalDateTime lastModifiedAt;
}

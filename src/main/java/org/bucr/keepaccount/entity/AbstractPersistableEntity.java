package org.bucr.keepaccount.entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
public abstract class AbstractPersistableEntity<PK extends Serializable> {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private PK id;

}

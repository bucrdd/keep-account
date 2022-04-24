package org.bucr.keepaccount.vo;

import java.util.List;
import lombok.Data;
import org.bucr.keepaccount.enums.Gender;

@Data
public class UserVo {

  private Long id;

  private String username;

  private String nickname;

  private Gender gender;

  private List<RoleVo> roles;

  private Boolean locked;

  private Boolean enabled;

}

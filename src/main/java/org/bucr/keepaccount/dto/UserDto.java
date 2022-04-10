package org.bucr.keepaccount.dto;

import lombok.Data;
import org.bucr.keepaccount.enums.Gender;

@Data
public class UserDto {

  private String username;

  private String nickname;

  private String password;

  private Gender gender;

  private Boolean locked;

  private Boolean enabled;

  public Boolean isEnabled() {
    return enabled;
  }

}

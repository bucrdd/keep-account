package org.bucr.keepaccount.mapper;

import org.bucr.keepaccount.dto.UserDto;
import org.bucr.keepaccount.entity.User;
import org.bucr.keepaccount.vo.UserVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserVo userToUserVo(User user);

  User userDtoToUser(UserDto userDto);

}

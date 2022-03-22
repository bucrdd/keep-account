package org.bucr.keepaccount.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.bucr.keepaccount.dto.AuthenticationRequest;
import org.bucr.keepaccount.dto.UserDto;
import org.bucr.keepaccount.entity.User;
import org.bucr.keepaccount.repository.UserRepository;
import org.bucr.keepaccount.security.jwt.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthenticationController {

  @Resource
  private AuthenticationManager authenticationManager;

  @Resource
  private JwtTokenProvider jwtTokenProvider;

  @Resource
  private UserRepository users;

  @Resource
  private PasswordEncoder passwordEncoder;

  @PostMapping("/signin")
  public Map<String, Object> signin(@RequestBody AuthenticationRequest data) {
    try {
      String username = data.getUsername();
      var authentication =
          authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
      String token = jwtTokenProvider.createToken(authentication);
      Map<String, Object> model = new HashMap<>();
      model.put("username", username);
      model.put("token", token);
      return model;
    } catch (AuthenticationException e) {
      throw new BadCredentialsException("Invalid username/password supplied.");
    }
  }

  @PostMapping("/signup")
  public User signup(@RequestBody UserDto data) {
    User user = new User();
    user.setUsername(data.getUsername());
    user.setPassword(passwordEncoder.encode(data.getPassword()));
    user.setNickname(data.getNickname());
    user.setGender(data.getGender());
    user.setEnabled(data.isEnabled());
    user.setLocked(data.getLocked());
    user.setCreatedAt(LocalDateTime.now());
    user.setLastModifiedAt(LocalDateTime.now());
    user.setLastLoginAt(LocalDateTime.now());
    users.save(user);

    return user;
  }

}

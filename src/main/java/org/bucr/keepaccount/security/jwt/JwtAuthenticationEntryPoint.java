package org.bucr.keepaccount.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.bucr.keepaccount.handler.ResponseData;
import org.bucr.keepaccount.handler.ReturnCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

@Slf4j
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
      throws IOException, ServletException {
    log.debug("Jwt authentication failed: " + authException);
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.setContentType("text/json;charset=utf-8");

    ResponseData<String> responseData = new ResponseData<>();
    responseData.setMessage(authException.getMessage());
    responseData.setCode(ReturnCode.UNAUTHORIZED_ERROR.getCode());
    response.getWriter().print(objectMapper.writeValueAsString(responseData));
  }
}

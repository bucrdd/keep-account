package org.bucr.keepaccount.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.bucr.keepaccount.handler.ResponseData;
import org.bucr.keepaccount.handler.ReturnCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

@Slf4j
public class RestAccessDeniedHandler implements AccessDeniedHandler {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public void handle(HttpServletRequest request, HttpServletResponse response,
      AccessDeniedException accessDeniedException) throws IOException, ServletException {
    log.debug("Access denied, path={}, message={}", request.getPathInfo(), accessDeniedException.getMessage());
    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    response.setContentType("text/json;charset=utf-8");

    ResponseData<String> responseData = new ResponseData<>();
    responseData.setMessage(accessDeniedException.getMessage());
    responseData.setCode(ReturnCode.FORBIDDEN_ERROR.getCode());
    response.getWriter().print(objectMapper.writeValueAsString(responseData));
  }
}

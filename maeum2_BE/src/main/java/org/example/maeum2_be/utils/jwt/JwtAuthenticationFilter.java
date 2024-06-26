package org.example.maeum2_be.utils.jwt;


import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.example.maeum2_be._core.FilterResponseUtils;
import org.example.maeum2_be.entity.domain.Member;
import org.example.maeum2_be.entity.domain.PrincipalDetails;
import org.example.maeum2_be.entity.domain.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {


  public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
    super(authenticationManager); // BasicAuthenticationFilter에 필요한 생성자 호출
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException, ServletException, ServletException {
    String jwt = request.getHeader(JwtTokenVerifier.HEADER);
    if (jwt == null) {
      log.error("토큰없음");
      chain.doFilter(request, response);
      return;
    }
    try {
      DecodedJWT decodedJWT = JwtTokenVerifier.execute(jwt);
      String memberId = decodedJWT.getClaim("memberId").asString();
      String childFirstName = decodedJWT.getClaim("childFirstName").asString();
      String childLastName = decodedJWT.getClaim("childLastName").asString();
      String aiName = decodedJWT.getClaim("aiName").asString();
      String email = decodedJWT.getClaim("email").asString();
      Role role = Role.valueOf(decodedJWT.getClaim("role").asString());
      System.out.println("---role---"+role.value());
      Member member = Member.builder().childFirstName(childFirstName).memberId(memberId).childLastName(childLastName).aiName(aiName).role(role).email(email).build();
      PrincipalDetails myUserDetails = new PrincipalDetails(member);
      Authentication authentication =
          new UsernamePasswordAuthenticationToken(
              myUserDetails,
              myUserDetails.getPassword(),
              myUserDetails.getAuthorities()
          );
      SecurityContextHolder.getContext().setAuthentication(authentication);
      log.debug("디버그 : 인증 객체 만들어짐");
      chain.doFilter(request,response);
    } catch (SignatureVerificationException | JWTDecodeException e) {
      FilterResponseUtils.AccessTokenValidationException(response);
    } catch (TokenExpiredException tee) {
      FilterResponseUtils.AccessTokenExpired(response);
    }
  }
}

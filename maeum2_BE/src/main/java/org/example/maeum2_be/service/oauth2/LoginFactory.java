package org.example.maeum2_be.service.oauth2;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.maeum2_be._core.ApiResponse;
import org.example.maeum2_be._core.ApiResponseGenerator;
import org.example.maeum2_be.dto.KakaoProfileDTO;
import org.example.maeum2_be.entity.domain.Member;
import org.example.maeum2_be.entity.domain.PrincipalDetails;
import org.example.maeum2_be.entity.domain.Role;
import org.example.maeum2_be.repository.MemberRepository;
import org.example.maeum2_be.utils.jwt.JwtTokenCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
@RequiredArgsConstructor
public class LoginFactory {


    private final JwtTokenCreator jwtTokenCreator;
    private final MemberCreator memberCreator;

    public ApiResponse<?> kakaoLogin(HttpServletRequest request, HttpServletResponse response, String code){

        Member member = memberCreator.execute(code);
        String jwt = jwtTokenCreator.execute(member);

        PrincipalDetails principalDetails = new PrincipalDetails(member);

        Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails, null,
                principalDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        response.setContentType("application/json");
        // 토큰을 HTTP 헤더에 추가
        response.addHeader("Authorization", jwt);

        return ApiResponseGenerator.success(HttpStatus.OK);
    }




}
package org.example.maeum2_be.controller;


import lombok.RequiredArgsConstructor;
import org.example.maeum2_be._core.ApiResponse;
import org.example.maeum2_be._core.ApiResponseGenerator;
import org.example.maeum2_be.dto.AiNameDTO;
import org.example.maeum2_be.dto.MemberDTO;
import org.example.maeum2_be.dto.MemberUpdateDTO;
import org.example.maeum2_be.entity.domain.Member;
import org.example.maeum2_be.entity.domain.PrincipalDetails;
import org.example.maeum2_be.service.register.AiNameSetter;
import org.example.maeum2_be.service.register.MemberService;
import org.example.maeum2_be.service.register.UserRegister;
import org.example.maeum2_be.utils.jwt.JwtTokenCreator;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class RegisterController {
    private final UserRegister userRegister;
    private final JwtTokenCreator jwtTokenCreator;
    private final AiNameSetter aiNameSetter;
    private final MemberService memberService;

    @PostMapping("/api/user/signUp")
    public ApiResponse<?> signUp(HttpServletResponse response,
                                 @RequestBody MemberDTO memberDTO){
       Member member =  userRegister.signUpUser(memberDTO);
        String jwt = jwtTokenCreator.execute(member);

        response.setContentType("application/json");
        //새로 발급된 토큰을 HTTP 헤더에 추가
        response.addHeader("Authorization", jwt);
        return ApiResponseGenerator.success(HttpStatus.OK);
    }

    @PostMapping("/api/user/aiName")
    public ApiResponse<?> setAiName(@AuthenticationPrincipal PrincipalDetails principalDetails, @RequestBody AiNameDTO aiNameDTO){
        String memberId = principalDetails.getMemberId();
        String aiName = aiNameDTO.getAiName();
        return aiNameSetter.execute(memberId,aiName);
    }

    @PostMapping("api/user/info")
    public ApiResponse<?> updateUserInfo(@AuthenticationPrincipal PrincipalDetails principalDetails, @RequestBody MemberUpdateDTO memberUpdateDTO, HttpServletResponse response){
        Member member = memberService.updateMemberInfo(principalDetails.getMemberId(), memberUpdateDTO);
        String jwt = jwtTokenCreator.execute(member);
        response.setContentType("application/json");
        // 토큰을 HTTP 헤더에 추가
        response.addHeader("Authorization", jwt);
        return ApiResponseGenerator.success(HttpStatus.OK);
    }
}

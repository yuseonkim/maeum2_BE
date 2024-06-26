package org.example.maeum2_be._core;


import org.example.maeum2_be.exception.AccessDeniedException;
import org.example.maeum2_be.exception.MemberNotFoundException;
import org.example.maeum2_be.exception.VerificationCodeNotEqualException;
import org.example.maeum2_be.exception.VerificationCodeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VerificationCodeNotEqualException.class)
    public ApiResponse<ApiResponse.CustomBody> handleMemberNotFoundException(
            VerificationCodeNotEqualException verificationCodeNotEqualException) {
        return ApiResponseGenerator.fail(verificationCodeNotEqualException.getMessageCode().getCode(),
                verificationCodeNotEqualException.getMessageCode().getValue(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VerificationCodeNotFoundException.class)
    public ApiResponse<ApiResponse.CustomBody> verificationCodeNotFoundException(
            VerificationCodeNotFoundException verificationCodeNotFoundException) {
        return ApiResponseGenerator.fail(verificationCodeNotFoundException.getMessageCode().getCode(),
                verificationCodeNotFoundException.getMessageCode().getValue(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MemberNotFoundException.class)
    public ApiResponse<ApiResponse.CustomBody> memberNotFoundException(
            MemberNotFoundException memberNotFoundException) {
        return ApiResponseGenerator.fail(memberNotFoundException.getMessageCode().getCode(),
                memberNotFoundException.getMessageCode().getValue(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ApiResponse<ApiResponse.CustomBody> accessDeniedException(
            AccessDeniedException accessDeniedException) {
        return ApiResponseGenerator.fail(accessDeniedException.getMessageCode().getCode(),
                accessDeniedException.getMessageCode().getValue(), HttpStatus.BAD_REQUEST);
    }


}

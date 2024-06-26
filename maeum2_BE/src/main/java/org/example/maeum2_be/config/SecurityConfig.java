package org.example.maeum2_be.config;


import lombok.RequiredArgsConstructor;
import org.example.maeum2_be._core.FilterResponseUtils;
import org.example.maeum2_be.utils.jwt.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    public class CustomSecurityFilterManager extends AbstractHttpConfigurer<CustomSecurityFilterManager, HttpSecurity> {
        @Override
        public void configure(HttpSecurity builder) throws Exception {
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
            builder.addFilter(new JwtAuthenticationFilter(authenticationManager));
            super.configure(builder);
        }
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.exceptionHandling().authenticationEntryPoint((request, response, authException) -> {
            FilterResponseUtils.unAuthorized(response);
        });



        http.exceptionHandling().accessDeniedHandler((request, response, accessDeniedException) -> {
            boolean isRoleNotUser = request.isUserInRole("User");
            FilterResponseUtils.forbidden(response, isRoleNotUser);
        });


        http.cors()
                .configurationSource(corsConfigurationSource());
        http.apply(new CustomSecurityFilterManager());
        http.headers().frameOptions().disable();

        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
//

                //회원가입을 안 한 사람만 접근 가능
//                //모든 사용자 접근 가능
                .antMatchers("/api/myPage","/api/home","/api/main/gpt1","/api/main/gpt2","/api/main/quit","/api/main/solve","/api/main/wrong","/api/main/ai","/api/user/info").access("hasRole('USER')")
                .antMatchers("/api/user/send/**","/api/test" ).permitAll()
                // GET 메서드에 대한 /api/post 는 모든 사용자가 접근 가능
                .antMatchers(HttpMethod.POST, "/api/login","api/user/signUp").permitAll();


        return http.build();
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        configuration.setExposedHeaders(Arrays.asList("Authorization"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


}

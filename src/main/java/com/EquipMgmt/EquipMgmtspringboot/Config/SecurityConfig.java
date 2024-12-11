package com.EquipMgmt.EquipMgmtspringboot.Config;

import com.EquipMgmt.EquipMgmtspringboot.Models.CurrencyUtils;
import com.EquipMgmt.EquipMgmtspringboot.Security.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity

public class SecurityConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private CustomUserDetailService customUserDetailService;

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:src/main/resources/static/uploads/");
    }

    @Autowired
    private final CustomUserDetailService customUserDetailService;

    public SecurityConfig(CustomUserDetailService customUserDetailService) {
        this.customUserDetailService = customUserDetailService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests((auth)->auth
                        .requestMatchers("/admin-assets/**", "/admin/login").permitAll()
//                        .requestMatchers("/admin/**").hasAuthority("Quản Trị Viên")
                                .requestMatchers("/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/admin/login")
                        .loginProcessingUrl("/admin/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/admin", true)
                        .permitAll()
                )
                .logout(logout -> logout.logoutUrl("/admin-logout").logoutSuccessUrl("/admin/login"));
        return http.build();
    }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring().requestMatchers("/static/**","/uploads/**");
    }

    @Bean
    public CurrencyUtils currencyUtils() {
        return new CurrencyUtils();
    }
}




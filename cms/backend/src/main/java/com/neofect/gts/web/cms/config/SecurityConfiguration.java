package com.neofect.gts.web.cms.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.neofect.gts.core.security.NvAuthenticationSuccessHandler;
import com.neofect.gts.core.services.common.service.ActionLogService;
import com.neofect.gts.core.services.user.service.UserService;
import com.neofect.gts.web.cms.security.CmsAjaxLogoutSuccessHandler;
import com.neofect.gts.web.cms.security.CountableAjaxAuthenticationFailureHandler;
import io.github.jhipster.config.JHipsterProperties;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CorsFilter;
import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport;

import javax.annotation.PostConstruct;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Import(SecurityProblemSupport.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final UserDetailsService userDetailsService;

    private final JHipsterProperties jHipsterProperties;

    private final RememberMeServices rememberMeServices;

    private final CorsFilter corsFilter;

    private final SecurityProblemSupport problemSupport;

    private final ObjectMapper mapper;

    protected final UserService userService;

    protected final ActionLogService actionLogService;

    public SecurityConfiguration(AuthenticationManagerBuilder authenticationManagerBuilder, UserDetailsService userDetailsService,
                                 JHipsterProperties jHipsterProperties, RememberMeServices rememberMeServices, CorsFilter corsFilter, SecurityProblemSupport problemSupport, ObjectMapper mapper,
                                 UserService userService, ActionLogService actionLogService) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDetailsService = userDetailsService;
        this.jHipsterProperties = jHipsterProperties;
        this.rememberMeServices = rememberMeServices;
        this.corsFilter = corsFilter;
        this.problemSupport = problemSupport;
        this.mapper = mapper;
        this.userService = userService;
        this.actionLogService = actionLogService;
    }

    @PostConstruct
    public void init() {
        try {
            authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
        } catch (Exception e) {
            throw new BeanInitializationException("Security configuration failed", e);
        }
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new NvAuthenticationSuccessHandler(mapper, userService, actionLogService, "cms");
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CountableAjaxAuthenticationFailureHandler(actionLogService, "cms");
    }

    @Bean
    public CmsAjaxLogoutSuccessHandler cmsAjaxLogoutSuccessHandler() {
        return new CmsAjaxLogoutSuccessHandler(actionLogService, "cms");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers(HttpMethod.OPTIONS, "/**")
            .antMatchers("/app/**/*.{js,html}")
            .antMatchers("/i18n/**")
            .antMatchers("/content/**")
            .antMatchers("/swagger-ui/index.html")
            .antMatchers("/test/**")
            .antMatchers("/assets/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
            .ignoringAntMatchers("/", "/static/**", "/api/u/**", "/assets/**")
            .requireCsrfProtectionMatcher(new AndRequestMatcher(CsrfFilter.DEFAULT_CSRF_MATCHER))
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        .and()
            .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
            .exceptionHandling()
            .authenticationEntryPoint(problemSupport)
            .accessDeniedHandler(problemSupport)
        .and()
            .rememberMe()
            .rememberMeServices(rememberMeServices)
            .rememberMeParameter("remember-me")
            .key(jHipsterProperties.getSecurity().getRememberMe().getKey())
        .and()
            .formLogin()
            .loginProcessingUrl("/api/authenticate")
            .successHandler(authenticationSuccessHandler())
            .failureHandler(authenticationFailureHandler())
            .usernameParameter("j_username")
            .passwordParameter("j_password")
            .permitAll()
        .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/api/signout"))
            .logoutSuccessHandler(cmsAjaxLogoutSuccessHandler())
            .permitAll()
        .and()
            .headers()
            .frameOptions()
            .disable()
        .and()
            .authorizeRequests()
            .antMatchers("/api/register").permitAll()
            .antMatchers("/api/activate").permitAll()
            .antMatchers("/api/authenticate").permitAll()
            .antMatchers("/api/authenticate/fail").permitAll()
            .antMatchers("/api/account/reset-password/init").permitAll()
            .antMatchers("/api/account/reset-password/finish").permitAll()
            .antMatchers("/api/**").hasAnyRole("CMS")
            .antMatchers("/error").permitAll()
            .antMatchers("/management/info").permitAll()
            .antMatchers("/**").permitAll();

    }
}

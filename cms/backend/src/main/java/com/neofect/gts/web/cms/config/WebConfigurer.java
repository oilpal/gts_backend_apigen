package com.neofect.gts.web.cms.config;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import com.google.common.collect.ImmutableList;

import com.unvus.config.UnvusConstants;
import com.unvus.config.properties.UnvusProperties;
import com.unvus.web.filter.PagingFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.MimeMappings;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CorsFilter;

import io.github.jhipster.config.JHipsterProperties;
import io.github.jhipster.web.filter.CachingHttpHeadersFilter;

/**
 * Configuration of web application with Servlet 3.0 APIs.
 */
@Configuration
@EnableRedisHttpSession(redisNamespace = "gts")
public class WebConfigurer implements ServletContextInitializer, WebServerFactoryCustomizer<WebServerFactory>{

    private final Logger log = LoggerFactory.getLogger(WebConfigurer.class);

    private Environment env;

    private UnvusProperties props;

    private JHipsterProperties jHipsterProperties;

    public WebConfigurer(Environment env, UnvusProperties props, JHipsterProperties jHipsterProperties) {
        this.env = env;
        this.props = props;
        this.jHipsterProperties = jHipsterProperties;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("Web application configuration, using profiles: {}", Arrays.toString(env.getActiveProfiles()));
        EnumSet<DispatcherType> disps = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ASYNC);

        if (env.acceptsProfiles(UnvusConstants.SPRING_PROFILE_PRODUCTION)) {
            initCachingHttpHeadersFilter(servletContext, disps);
        }

        log.info("Web application fully configured");
    }

    /**
     * Customize the Servlet engine: Mime types, the document root, the cache.
     */
    @Override
    public void customize(WebServerFactory server) {
        setMimeMappings(server);

    }

    private void setMimeMappings(WebServerFactory server) {
        if (server instanceof ConfigurableServletWebServerFactory) {
            MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
            // IE issue, see https://github.com/jhipster/generator-jhipster/pull/711
            mappings.add("html", MediaType.TEXT_HTML_VALUE + ";charset=" + StandardCharsets.UTF_8.name().toLowerCase());
            // CloudFoundry issue, see https://github.com/cloudfoundry/gorouter/issues/64
            mappings.add("json", MediaType.TEXT_HTML_VALUE + ";charset=" + StandardCharsets.UTF_8.name().toLowerCase());
            ConfigurableServletWebServerFactory servletWebServer = (ConfigurableServletWebServerFactory) server;
            servletWebServer.setMimeMappings(mappings);
        }
    }




    /**
     * Initializes the caching HTTP Headers Filter.
     */
    private void initCachingHttpHeadersFilter(ServletContext servletContext,
                                              EnumSet<DispatcherType> disps) {
        log.debug("Registering Caching HTTP Headers Filter");
        FilterRegistration.Dynamic cachingHttpHeadersFilter =
            servletContext.addFilter("cachingHttpHeadersFilter",
                new CachingHttpHeadersFilter(jHipsterProperties));

        cachingHttpHeadersFilter.addMappingForUrlPatterns(disps, true, "/images/*");
        cachingHttpHeadersFilter.addMappingForUrlPatterns(disps, true, "/scripts/*");
        cachingHttpHeadersFilter.setAsyncSupported(true);
    }


    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = jHipsterProperties.getCors();

        config.setAllowedOrigins(ImmutableList.of("*"));
        config.setAllowedHeaders(ImmutableList.of("Origin", "X-Requested-With", "Content-Type", "Accept"));
        config.setAllowedMethods(ImmutableList.of("*"));

        if (config.getAllowedOrigins() != null && !config.getAllowedOrigins().isEmpty()) {
            source.registerCorsConfiguration("/authentication", config);
            source.registerCorsConfiguration("/api/**", config);
            source.registerCorsConfiguration("/pages/**", config);
            source.registerCorsConfiguration("/jsecurity/**", config);
        }

        return new CorsFilter(source);
    }


    @Bean
    public FilterRegistrationBean characterEncodingFilter() {
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        filterRegBean.setFilter(new CharacterEncodingFilter());
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        filterRegBean.setUrlPatterns(urlPatterns);
        filterRegBean.setOrder(-200);
        filterRegBean.setAsyncSupported(true);
        filterRegBean.addInitParameter("encoding", "UTF-8");
        return filterRegBean;
    }


    @Bean
    public FilterRegistrationBean pagingFilter() {
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        filterRegBean.setFilter(new PagingFilter());
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        filterRegBean.setUrlPatterns(urlPatterns);
        filterRegBean.setOrder(-90);
        filterRegBean.setAsyncSupported(true);
        return filterRegBean;
    }


}

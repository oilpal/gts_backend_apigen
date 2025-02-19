package com.neofect.gts.web.cms;

import com.neofect.gts.core.config.properties.ApplicationProperties;
import com.unvus.config.UnvusConstants;
import com.unvus.config.properties.AttachProperties;
import com.unvus.config.properties.UnvusProperties;
import com.unvus.util.DefaultProfileUtil;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 */
@ComponentScan({"com.unvus", "com.neofect"})
@MapperScan("com.neofect")
@EnableAutoConfiguration
@EnableConfigurationProperties({ ApplicationProperties.class, UnvusProperties.class, AttachProperties.class})
public class GtsCmsApp {

    private static final Logger log = LoggerFactory.getLogger(GtsCmsApp.class);

    private final Environment env;

    public GtsCmsApp(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void initApplication() throws IOException {
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
        if (activeProfiles.contains(UnvusConstants.SPRING_PROFILE_LOCAL) && activeProfiles.contains(UnvusConstants.SPRING_PROFILE_PRODUCTION)) {
            log.error("You have misconfigured your application! It should not run " +
                "with both the 'local' and 'prod' profiles at the same time.");
        }
        if (activeProfiles.contains(UnvusConstants.SPRING_PROFILE_LOCAL) && activeProfiles.contains(UnvusConstants.SPRING_PROFILE_DEVELOPMENT)) {
            log.error("You have misconfigured your application! It should not " +
                "run with both the 'local' and 'dev' profiles at the same time.");
        }
        if (activeProfiles.contains(UnvusConstants.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(UnvusConstants.SPRING_PROFILE_PRODUCTION)) {
            log.error("You have misconfigured your application! It should not " +
                "run with both the 'dev' and 'prod' profiles at the same time.");
        }
    }

    /**
     * Main method, used to run the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GtsCmsApp.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
    }

    private static void logApplicationStartup(Environment env) {
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        if (StringUtils.isBlank(contextPath)) {
            contextPath = "/";
        }
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }
        log.info("\n----------------------------------------------------------\n\t" +
                "Application '{}' is running! Access URLs:\n\t" +
                "Local: \t\t{}://localhost:{}{}\n\t" +
                "External: \t{}://{}:{}{}\n\t" +
                "Profile(s): \t{}\n----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            protocol,
            serverPort,
            contextPath,
            protocol,
            hostAddress,
            serverPort,
            contextPath,
            env.getActiveProfiles());
    }
}

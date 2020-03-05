package com.neofect.gts;

import com.neofect.gts.core.config.properties.ApplicationProperties;
import com.unvus.config.UnvusConstants;
import com.unvus.config.properties.UnvusProperties;
import com.unvus.util.DefaultProfileUtil;
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
import java.util.Arrays;
import java.util.Collection;

@ComponentScan({"com.unvus"})
@MapperScan("com.neofect.gts.core")
@EnableAutoConfiguration
@EnableConfigurationProperties({ ApplicationProperties.class, UnvusProperties.class})
public class GtsTestApp {

    private static final Logger log = LoggerFactory.getLogger(com.neofect.gts.GtsTestApp.class);

    private final Environment env;

    public GtsTestApp(Environment env) {
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
        SpringApplication app = new SpringApplication(com.neofect.gts.GtsTestApp.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
    }

    private static void logApplicationStartup(Environment env) {
        log.info("\n----------------------------------------------------------\n\t" +
                "Application '{}' is running!\n\t" +
                "Profile(s): \t{}\n----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            env.getActiveProfiles());
    }
}

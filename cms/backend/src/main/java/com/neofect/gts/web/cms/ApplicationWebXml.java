package com.neofect.gts.web.cms;

import com.unvus.util.DefaultProfileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created by guava on 5/26/16.
 */
public class ApplicationWebXml extends SpringBootServletInitializer {

    private final Logger log = LoggerFactory.getLogger(ApplicationWebXml.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        /**
         * set a default to use when no profile is configured.
         */
        DefaultProfileUtil.addDefaultProfile(application.application());
        return application.sources(GtsCmsApp.class);
    }

}

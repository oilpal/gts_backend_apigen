package com.neofect.gts.core.config.properties;

import com.unvus.config.properties.BaseDatabaseProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by guava on 16.6.19.
 */
@Getter
@Setter
@ConfigurationProperties(prefix = DefaultDatabaseProperties.PREFIX)
public class DefaultDatabaseProperties extends BaseDatabaseProperties {
    public static final String PREFIX = "application.datasource.default";

}

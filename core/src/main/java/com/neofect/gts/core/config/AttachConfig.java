package com.neofect.gts.core.config;

import com.neofect.gts.core.services.attach.service.ReferenceTypeRegistry;
import com.unvus.config.properties.AttachProperties;
import com.unvus.services.attach.domain.AttachRoom;
import com.unvus.services.attach.domain.AttachRoomImpl;
import com.unvus.services.attach.filter.AttachFilter;
import com.unvus.services.attach.policy.DirectoryPathPolicy;
import com.unvus.services.attach.policy.impl.DateDirectoryPathPolicy;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@EnableConfigurationProperties(AttachProperties.class)
@Configuration
public class AttachConfig {
    private static final Logger log = LoggerFactory.getLogger(AttachConfig.class);

    private static final String patternStr = "\\{(.*?)}";
    private static final Pattern pattern = Pattern.compile(patternStr);

    private final AttachProperties attachProperties;

    public AttachConfig(AttachProperties attachProperties) {
        this.attachProperties = attachProperties;
    }

    @PostConstruct
    public void initialize() {
        Map<String, AttachProperties.Filter> filterMap = attachProperties.getFilterMap();

        attachProperties.getRooms().forEach(room -> {
            String roomName = extractName(room.getName());
            AttachRoom newRoom = new AttachRoomImpl() {
                @Override
                public String getRoomName() {
                    return roomName;
                }
            };

            if(CollectionUtils.isEmpty(room.getCabs())) {
                newRoom
                    .addCabinet(ReferenceTypeRegistry._DEFAULT_CABINET_NAME);
            }else {
                room.getCabs().forEach(cabWithFilter -> {
                    List<AttachFilter> filters = extractFilters(cabWithFilter, filterMap);

                    newRoom
                        .addCabinet(extractName(cabWithFilter))
                        .addFilters(filters);

                });
            }

            ReferenceTypeRegistry.add(newRoom.getRoomName(), newRoom);

        });

    }

    @Bean
    public DirectoryPathPolicy directoryPathPolicy() {
        DateDirectoryPathPolicy policy = new DateDirectoryPathPolicy(
            DateDirectoryPathPolicy.DATE_SUBDIR_TYPE.YYYY_MM,
            attachProperties.getDirectory().getUploadBaseDir(),
            attachProperties.getDirectory().getTmpDir()
        );

        return policy;
    }

    private List<AttachFilter> extractFilters(String containFilterString, Map<String, AttachProperties.Filter> filterMap) {
        List<AttachFilter> filters = new ArrayList<>();

        Matcher m = pattern.matcher(containFilterString);
        if(m.find()) {
            String filterStr = m.group(1);
            if(StringUtils.isNotBlank(filterStr)) {

                for(String filterName : StringUtils.split(filterStr, ',')) {
                    AttachProperties.Filter filterInfo = filterMap.get(StringUtils.trim(filterName));
                    if(filterInfo != null) {
                        try {
                            AttachFilter attachFilter = (AttachFilter)Class.forName(filterInfo.getClassName()).newInstance();
                            attachFilter.config(filterInfo.getConfig());
                            filters.add(attachFilter);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                return filters;
            }
        }

        return filters;
    }

    private String extractName(String name) {
        String result = StringUtils.removePattern(name, patternStr);
        return StringUtils.trim(result);
    }

}

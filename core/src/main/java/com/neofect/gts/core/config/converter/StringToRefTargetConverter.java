package com.neofect.gts.core.config.converter;

import com.neofect.gts.core.services.common.domain.enums.RefTarget;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by guava on 16.8.10.
 */
@Component
public class StringToRefTargetConverter implements Converter<String, RefTarget> {

    @Override
    public RefTarget convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }

        RefTarget enumCode = RefTarget.getByCode(source);

        return enumCode;
    }
}

package com.neofect.gts.core.config.converter;

import com.neofect.gts.core.services.common.domain.enums.RefTarget;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by guava on 16.8.10.
 */
@Component
public class RefTargetToStringConverter implements Converter<RefTarget, String> {

    @Override
    public String convert(RefTarget source) {
        if (source == null) {
            return null;
        }

        return source.getCode();
    }
}

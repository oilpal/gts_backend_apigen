package com.neofect.gts.core.config.converter;

import java.io.IOException;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neofect.gts.core.services.attach.domain.AttachBag;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToAttachBagConverter implements Converter<String, AttachBag> {
    @Inject
    private ObjectMapper objectMapper;

    public StringToAttachBagConverter() {
    }

    public AttachBag convert(String source) {
        if (source != null && !source.isEmpty()) {
            AttachBag queryMap = null;

            try {
                queryMap = (AttachBag)this.objectMapper.readValue(source, AttachBag.class);
            } catch (IOException var4) {
                var4.printStackTrace();
            }

            return queryMap;
        } else {
            return null;
        }
    }
}

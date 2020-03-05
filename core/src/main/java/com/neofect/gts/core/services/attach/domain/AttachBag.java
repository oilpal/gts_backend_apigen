package com.neofect.gts.core.services.attach.domain;

import com.neofect.gts.core.services.attach.domain.Attach;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Created by guava on 16.8.12.
 */
@Data
public class AttachBag extends HashMap<String, List<Attach>> implements Serializable {

    public Attach one(String mapCode) {
        List<Attach> attachList = get(mapCode);
        if(attachList != null && attachList.size() > 0) {
            return attachList.get(0);
        }
        return null;
    }
}

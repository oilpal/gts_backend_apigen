package com.neofect.gts.core.config.mybatis.type;

import com.unvus.config.mybatis.type.EnumCodeTypeHandler;
import com.unvus.domain.EnumCode;
import com.neofect.gts.core.services.common.domain.enums.ActionTypeIf;
import com.neofect.gts.core.services.common.domain.enums.RefTargetIf;
import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@Alias("enumCodeIfTypeHandler")
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes({RefTargetIf.class, ActionTypeIf.class})
public class EnumCodeIfTypeHandler extends EnumCodeTypeHandler {
    public EnumCodeIfTypeHandler(Class<EnumCode> type) {
        super(type);
    }
}

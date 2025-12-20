package com.cibertec.mesaverde.infrastructure.mapper;

import com.cibertec.mesaverde.domain.cuentas.model.TipoCuentaModel;
import com.cibertec.mesaverde.infrastructure.persistence.cuentas.entity.TipoCuentaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoCuentaMapper {

    TipoCuentaModel toModel(TipoCuentaEntity tipoCuentaEntity);

    TipoCuentaEntity toEntity(TipoCuentaModel tipoCuentaModel);
}

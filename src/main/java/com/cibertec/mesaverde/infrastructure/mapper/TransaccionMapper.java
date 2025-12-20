package com.cibertec.mesaverde.infrastructure.mapper;

import com.cibertec.mesaverde.domain.transacciones.model.TransaccionModel;
import com.cibertec.mesaverde.infrastructure.persistence.cuentas.entity.MonedaEntity;
import com.cibertec.mesaverde.infrastructure.persistence.transacciones.entity.TransaccionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransaccionMapper {

    TransaccionModel toModel(TransaccionEntity transaccionEntity);

    @Mapping(source = "moneda", target = "moneda")
    @Mapping(source = "estadoTransaccion", target = "estadoTransaccion")
    TransaccionEntity toEntity(TransaccionModel transaccionModel);
}

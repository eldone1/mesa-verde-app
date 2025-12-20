package com.cibertec.mesaverde.infrastructure.mapper;

import com.cibertec.mesaverde.domain.cuentas.model.CuentaBancariaModel;
import com.cibertec.mesaverde.infrastructure.persistence.cuentas.entity.CuentaBancariaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CuentaBancariaMapper {

    CuentaBancariaModel toModel(CuentaBancariaEntity cuentaBancariaEntity);

    CuentaBancariaEntity toEntity(CuentaBancariaModel cuentaBancariaModel);
}

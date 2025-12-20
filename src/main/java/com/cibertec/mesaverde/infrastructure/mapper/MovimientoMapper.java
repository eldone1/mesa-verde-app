package com.cibertec.mesaverde.infrastructure.mapper;

import com.cibertec.mesaverde.domain.transacciones.model.MovimientoModel;
import com.cibertec.mesaverde.infrastructure.persistence.transacciones.entity.MovimientoEntity;
import com.cibertec.mesaverde.presentation.transacciones.dto.response.ResponseMovimiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {

    MovimientoModel toModel(MovimientoEntity movimientoEntity);

    @Mapping(source = "transaccion", target = "transaccion")
    @Mapping(source = "cuenta", target = "cuenta")
    @Mapping(source = "tipoMovimiento", target = "tipoMovimiento")
    @Mapping(source = "montoMovimiento", target = "montoMovimiento")
    @Mapping(source = "moneda", target = "moneda")
    @Mapping(source = "saldoAntes", target = "saldoAntesMovimiento")
    @Mapping(source = "saldoDespues", target = "saldoDespuesMovimiento")
    @Mapping(source = "fechaHoraMovimiento", target = "fechaHoraMovimiento")
    @Mapping(source = "descripcion", target = "descripcionMovimiento")
    MovimientoEntity toEntity(MovimientoModel movimientoModel);


    @Mapping(source = "fechaHoraMovimiento", target = "fecha")
    @Mapping(source = "cuenta", target = "origen")
    @Mapping(source = "montoMovimiento", target = "monto")
    ResponseMovimiento toResponseMovimiento(MovimientoModel movimientoModel);
}

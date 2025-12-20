package com.cibertec.mesaverde.domain.transacciones.model;

import com.cibertec.mesaverde.domain.cuentas.model.CuentaBancariaModel;
import com.cibertec.mesaverde.domain.cuentas.model.MonedaModel;
import com.cibertec.mesaverde.infrastructure.persistence.cuentas.entity.MonedaEntity;
import com.cibertec.mesaverde.infrastructure.persistence.usuarios.entity.UsuarioEntity;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class TransaccionModel {

    private Long id;
    private CuentaBancariaModel cuentaOrigen;
    private CuentaBancariaModel cuentaDestino;
    private String tipoTransaccion;
    private BigDecimal monto;
    private MonedaModel moneda;
    private String estadoTransaccion;
    private LocalDateTime fechaHoraTransaccion;
    private String descripcion;
    private UsuarioEntity usuarioRegistro;
}

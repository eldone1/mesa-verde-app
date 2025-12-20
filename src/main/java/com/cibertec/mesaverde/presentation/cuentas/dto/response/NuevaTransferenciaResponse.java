package com.cibertec.mesaverde.presentation.cuentas.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class NuevaTransferenciaResponse {

    private String nombreCompleto;
    private String numeroCuenta;
    private String moneda;
    private BigDecimal saldoActual;
}

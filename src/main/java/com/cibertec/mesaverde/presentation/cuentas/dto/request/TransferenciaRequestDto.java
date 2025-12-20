package com.cibertec.mesaverde.presentation.cuentas.dto.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TransferenciaRequestDto {

    private String numeroCuentaOrigen;
    private String numeroCuentaDestino;
    private BigDecimal monto;
    private String descripcion;
}

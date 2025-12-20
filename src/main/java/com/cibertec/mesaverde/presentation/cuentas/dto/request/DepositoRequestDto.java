package com.cibertec.mesaverde.presentation.cuentas.dto.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class DepositoRequestDto {

    private String numeroCuentaDestino;
    private BigDecimal monto;
    private Long idMoneda;
    private String descripcion;
    //private Long idUsuarioRegistro;
}

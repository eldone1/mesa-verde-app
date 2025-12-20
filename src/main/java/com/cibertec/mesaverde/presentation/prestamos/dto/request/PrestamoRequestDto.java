package com.cibertec.mesaverde.presentation.prestamos.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PrestamoRequestDto {

    private Integer idCliente;
    private Integer idCuentaDesembolso;
    private Integer idMoneda;

    private BigDecimal montoPrincipal; // Ej: 10000.00
    private BigDecimal tasaInteres;    // Ej: 0.025 para 2.5%
    private Integer plazoMeses;        // Ej: 12, 24, 36...

    private String usuarioCreacion;
}

package com.cibertec.mesaverde.presentation.prestamos.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PrestamoResponseDto {
 private Integer idPrestamo;
    private Integer idCliente;
    private Integer idCuentaDesembolso;
    private Integer idMoneda;

    private BigDecimal montoPrincipal;
    private BigDecimal montoCuotaMensual;
    private BigDecimal saldoPendiente;

    private String estado;

    private LocalDate fechaInicio;
    private LocalDate fechaFinEstimada;

    private LocalDateTime fechaCreacion;
    private String usuarioCreacion;
}


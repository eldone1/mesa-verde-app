package com.cibertec.mesaverde.domain.prestamos.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class PrestamoModel {

     // Campos principales de la tabla prestamos
    private Long id;
    private Long idCliente;
    private Long idCuentaDesembolso;
    private Long idMoneda;
    private BigDecimal montoPrincipal;
    private BigDecimal tasaInteres;
    private Integer plazoMeses;
    private LocalDate fechaInicio;
    private LocalDate fechaFinEstimada;
    private BigDecimal montoCuotaMensual;
    private BigDecimal saldoPendiente;
    private String estado;
    

    

}

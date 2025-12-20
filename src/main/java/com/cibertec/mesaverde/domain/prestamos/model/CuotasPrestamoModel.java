package com.cibertec.mesaverde.domain.prestamos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.cibertec.mesaverde.infrastructure.persistence.transacciones.entity.MovimientoEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CuotasPrestamoModel {

    private Long id;
    private Long idPrestamo;
    private Integer numeroCuota;
    private LocalDateTime fechaVencimiento;
    private BigDecimal montoCapital;
    private BigDecimal montoInteres;
    private BigDecimal montoTotalCuota;
    private BigDecimal montoPagado;
    private LocalDateTime fechaPago;
    private String estadoCuota;
    private MovimientoEntity movimientoPago;
}

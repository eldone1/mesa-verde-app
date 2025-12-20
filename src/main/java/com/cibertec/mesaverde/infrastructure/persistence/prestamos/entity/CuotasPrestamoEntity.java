package com.cibertec.mesaverde.infrastructure.persistence.prestamos.entity;
import com.cibertec.mesaverde.infrastructure.persistence.transacciones.entity.MovimientoEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cuotas_prestamo")
public class CuotasPrestamoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuota")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestamo")
    private PrestamoEntity prestamo;

    @Column(name = "numero_cuota")
    private int numeroCuota;

    @Column(name = "fecha_vencimiento")
    private LocalDateTime fechaVencimiento;

    @Column(name = "monto_capital")
    private BigDecimal montoCapital;

    @Column(name = "monto_interes")
    private BigDecimal montoInteres;

    @Column(name = "monto_total_cuota")
    private BigDecimal montoTotalCuota;

    @Column(name = "monto_pagado")
    private BigDecimal montoPagado;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    @Column(name = "estado_cuota")
    private String estadoCuota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_movimiento_pago")
    private MovimientoEntity movimientoPago;
}

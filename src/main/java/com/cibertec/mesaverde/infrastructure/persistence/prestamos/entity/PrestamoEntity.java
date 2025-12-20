package com.cibertec.mesaverde.infrastructure.persistence.prestamos.entity;

import com.cibertec.mesaverde.infrastructure.persistence.clientes.entity.ClienteEntity;
import com.cibertec.mesaverde.infrastructure.persistence.cuentas.entity.CuentaBancariaEntity;
import com.cibertec.mesaverde.infrastructure.persistence.cuentas.entity.MonedaEntity;
import com.cibertec.mesaverde.infrastructure.shared.Auditoria;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "prestamos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrestamoEntity extends Auditoria<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_desembolso")
    private CuentaBancariaEntity cuentaDesembolso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moneda")
    private MonedaEntity moneda;

    @Column(name = "monto_principal")
    private BigDecimal montoPrincipal;

    @Column(name = "tasa_interes")
    private BigDecimal tasaInteres;

    @Column(name = "plazo_meses")
    private int plazoMeses;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin_estimada")
    private LocalDate fechaFinEstimada;

    @Column(name = "monto_cuota_mensual")
    private BigDecimal montoCuotaMensual;

    @Column(name = "saldo_pendiente")
    private BigDecimal saldoPendiente;

    @Column(name = "estado_prestamo")
    private String estadoPrestamo;
}

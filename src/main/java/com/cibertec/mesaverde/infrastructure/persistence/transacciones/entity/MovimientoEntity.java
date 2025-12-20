package com.cibertec.mesaverde.infrastructure.persistence.transacciones.entity;

import com.cibertec.mesaverde.infrastructure.persistence.cuentas.entity.CuentaBancariaEntity;
import com.cibertec.mesaverde.infrastructure.persistence.cuentas.entity.MonedaEntity;
import com.cibertec.mesaverde.infrastructure.persistence.prestamos.entity.PrestamoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_transaccion")
    private TransaccionEntity transaccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta")
    private CuentaBancariaEntity cuenta;

    @Column(name = "tipo_movimiento")
    private String  tipoMovimiento;

    @Column(name = "monto_movimiento")
    private BigDecimal montoMovimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moneda")
    private MonedaEntity moneda;

    @Column(name = "saldo_antes_movimiento")
    private BigDecimal saldoAntesMovimiento;

    @Column(name = "saldo_despues_movimiento")
    private BigDecimal saldoDespuesMovimiento;

    @Column(name = "fecha_hora_movimiento")
    private LocalDateTime fechaHoraMovimiento;

    @Column(name = "descripcion_movimiento")
    private String descripcionMovimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestamo")
    private PrestamoEntity prestamo;
}

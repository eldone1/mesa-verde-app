package com.cibertec.mesaverde.infrastructure.persistence.cuentas.entity;

import com.cibertec.mesaverde.infrastructure.persistence.clientes.entity.ClienteEntity;
import com.cibertec.mesaverde.infrastructure.shared.Auditoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cuentas_bancarias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CuentaBancariaEntity extends Auditoria<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_cuenta")
    private TipoCuentaEntity tipoCuenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moneda")
    private MonedaEntity moneda;

    @Column(name = "numero_cuenta")
    private String numeroCuenta;

    @Column(name = "numero_cci_interbancario")
    private String numeroCciInterbancario;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "fecha_apertura")
    private LocalDateTime fechaApertura;

    @Column(name = "estado_cuenta")
    private String estadoCuenta;
}

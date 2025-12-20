package com.cibertec.mesaverde.infrastructure.persistence.transacciones.entity;

import com.cibertec.mesaverde.infrastructure.persistence.bancos.entity.BancoEntity;
import com.cibertec.mesaverde.infrastructure.persistence.cuentas.entity.CuentaBancariaEntity;
import com.cibertec.mesaverde.infrastructure.persistence.cuentas.entity.MonedaEntity;
import com.cibertec.mesaverde.infrastructure.persistence.usuarios.entity.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransaccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_origen")
    private CuentaBancariaEntity cuentaOrigen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_destino")
    private CuentaBancariaEntity cuentaDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_banco_origen_externo")
    private BancoEntity bancoOrigenExterno;

    @Column(name = "numero_cuenta_origen_externo")
    private String numeroCuentaOrigenExterno;

    @Column(name = "nombre_titular_origen_externo")
    private String nombreTitularOrigenExterno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_banco_destino_externo")
    private BancoEntity bancoDestinoExterno;

    @Column(name = "numero_cuenta_destino_externo")
    private String numeroCuentaDestinoExterno;

    @Column(name = "nombre_titular_destino_externo")
    private String nombreTitularDestinoExterno;

    @Column(name = "tipo_transaccion")
    private String tipoTransaccion;

    @Column(name = "monto")
    private BigDecimal monto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moneda")
    private MonedaEntity moneda;

    @Column(name = "fecha_hora_transaccion")
    private LocalDateTime fechaHoraTransaccion;

    @Column(name = "estado_transaccion")
    private String estadoTransaccion;

    @Column(name = "referencia_externa")
    private String referenciaExterna;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_registro")
    private UsuarioEntity usuarioRegistro;
}

package com.cibertec.mesaverde.domain.cuentas.model;

import com.cibertec.mesaverde.domain.clientes.model.ClienteModel;
import com.cibertec.mesaverde.infrastructure.persistence.clientes.entity.ClienteEntity;
import com.cibertec.mesaverde.infrastructure.persistence.cuentas.entity.MonedaEntity;
import com.cibertec.mesaverde.infrastructure.persistence.cuentas.entity.TipoCuentaEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class CuentaBancariaModel {

    private Long id;
    private ClienteModel cliente;
    private TipoCuentaModel tipoCuenta;
    private MonedaModel moneda;
    private String numeroCuenta;
    private String numeroCciInterbancario;
    private BigDecimal saldo;
    private LocalDateTime fechaApertura;
    private String estadoCuenta;
}

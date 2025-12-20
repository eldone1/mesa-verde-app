package com.cibertec.mesaverde.presentation.cuentas.dto.response;

import com.cibertec.mesaverde.domain.cuentas.model.MonedaModel;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CuentasBancariasResponse {

    private Long id;
    private String simboloMoneda;
    private String numeroCuenta;
    private BigDecimal saldo;
}

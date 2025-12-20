package com.cibertec.mesaverde.presentation.transacciones.dto.response;

import com.cibertec.mesaverde.domain.cuentas.model.CuentaBancariaModel;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class ResponseMovimiento {

    private LocalDateTime fecha;
    private CuentaBancariaModel origen;
    private BigDecimal monto;
}

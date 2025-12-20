package com.cibertec.mesaverde.domain.transacciones.model;

import com.cibertec.mesaverde.domain.cuentas.model.CuentaBancariaModel;
import com.cibertec.mesaverde.domain.cuentas.model.MonedaModel;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class MovimientoModel {

    private Long id;
    private TransaccionModel transaccion;
    private CuentaBancariaModel cuenta;
    private String tipoMovimiento;
    private BigDecimal montoMovimiento;
    private MonedaModel moneda;
    private BigDecimal saldoAntes;
    private BigDecimal saldoDespues;
    private LocalDateTime fechaHoraMovimiento;
    private String descripcion;
}

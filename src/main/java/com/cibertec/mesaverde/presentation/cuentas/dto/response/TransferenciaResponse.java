package com.cibertec.mesaverde.presentation.cuentas.dto.response;

import com.cibertec.mesaverde.domain.cuentas.model.CuentaBancariaModel;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class TransferenciaResponse {

    private String numeroCuentaOrigen;
    private String nombreMonedaOrigen;
    private String nombreCompletoOrigen;
    private String numeroCuentaDestino;
    private String nombreMonedaDestino;
    private String nombreCompletoDestino;
    private String simboloMoneda;
    private BigDecimal monto;
    private String descripcion;
    private Long numeroTransaccion;
    private LocalDateTime fechaHora;
}

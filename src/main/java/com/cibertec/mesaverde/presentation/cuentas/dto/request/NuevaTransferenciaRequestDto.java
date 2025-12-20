package com.cibertec.mesaverde.presentation.cuentas.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NuevaTransferenciaRequestDto {
    private String numeroCuentaDestino;
}

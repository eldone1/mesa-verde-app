package com.cibertec.mesaverde.domain.cuentas.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipoCuentaModel {

    private Long id;
    private String nombreTipo;
    private String descripcion;
}

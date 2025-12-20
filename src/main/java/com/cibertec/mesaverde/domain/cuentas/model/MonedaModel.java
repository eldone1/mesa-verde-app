package com.cibertec.mesaverde.domain.cuentas.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MonedaModel {

    private Long id;
    private String codigo;
    private String nombre;
    private String simbolo;
}

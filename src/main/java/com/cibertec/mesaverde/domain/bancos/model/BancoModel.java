package com.cibertec.mesaverde.domain.bancos.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BancoModel {

    private Long id;
    private String nombreBanco;
    private String codigoBanco;
    private String pais;
    private String ciudad;
}

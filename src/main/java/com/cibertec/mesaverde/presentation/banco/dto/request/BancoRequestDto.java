package com.cibertec.mesaverde.presentation.banco.dto.request;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class BancoRequestDto {
    private Long idBanco;
    private String nombreBanco;
    private String codigoBanco;
    private String pais;
    private String ciudad;
}

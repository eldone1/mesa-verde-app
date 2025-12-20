package com.cibertec.mesaverde.domain.clientes.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ClienteModel {

    private Long id;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String numeroDocumento;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String telefono;
    private String email;
    private String estado;
}

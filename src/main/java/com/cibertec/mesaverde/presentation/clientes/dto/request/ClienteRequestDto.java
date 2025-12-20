package com.cibertec.mesaverde.presentation.clientes.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ClienteRequestDto {

    @NotBlank(message = "El nombre del cliente es obligatorio.")
    private String nombre;
    @NotBlank(message = "El nombre del apellido es obligatorio.")
    private String apellido;
    @NotBlank(message = "El tipo de documento es obligatorio.")
    private String tipoDocumento;
    @NotBlank(message = "El número de documento es obligatorio.")
    private String numeroDocumento;
    @NotBlank(message = "La fecha de nacimiento es obligatoria.")
    private LocalDate fechaNacimiento;
    @NotBlank(message = "La dirección es obligatoria.")
    private String direccion;
    private String telefono;
    private String email;
}

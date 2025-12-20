package com.cibertec.mesaverde.domain.seguridad.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
@Table(name = "roles")
public class RolesModel {
    private Long idRol;
    private String nombreRol;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private String usuarioCreacion;
    private LocalDateTime fechaActualizacion;
    private String usuarioActualizacion;
}

package com.cibertec.mesaverde.domain.seguridad.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "usuarios")
public class UsuarioModel {
    private Long idUsuario;
    private String username;
    private String passwordHash;
    private String passwordSalt;
    private Long idCliente;
    private String email;
    private EstadoUsuario estadoUsuario;
    private LocalDateTime ultimaSesion;
    private Integer intentosFallidos;
    private LocalDateTime fechaCreacion;
    private String usuarioCreacion;
    private LocalDateTime fechaActualizacion;
    private String usuarioActualizacion;
    private Set<RolesModel> roles;
}

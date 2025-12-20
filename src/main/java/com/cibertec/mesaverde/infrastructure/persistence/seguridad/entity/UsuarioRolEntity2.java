package com.cibertec.mesaverde.infrastructure.persistence.seguridad.entity;

import com.cibertec.mesaverde.domain.seguridad.model.UsuarioRolId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "UsuarioRolEntity2")
@Table(name = "usuario_rol")
public class UsuarioRolEntity2 {
    @EmbeddedId
    private UsuarioRolId id;

    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity2 usuario;

    @ManyToOne
    @MapsId("idRol")
    @JoinColumn(name = "id_rol")
    private RolEntity2 rol;

    @Column(name = "fecha_asignacion", nullable = false)
    private LocalDateTime fechaAsignacion;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "usuario_creacion", nullable = false, length = 100)
    private String usuarioCreacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;

    @Column(name = "usuario_actualizacion", nullable = false, length = 100)
    private String usuarioActualizacion;
}

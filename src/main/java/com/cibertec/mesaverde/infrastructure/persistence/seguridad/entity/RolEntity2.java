package com.cibertec.mesaverde.infrastructure.persistence.seguridad.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "RolEntity2")
@Table(name = "roles")
public class RolEntity2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", nullable = false, updatable = false)
    private Long idRol;

    @Column(name = "nombre_rol", nullable = false, unique = true, length = 50)
    private String nombreRol;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "usuario_creacion", nullable = false, length = 100)
    private String usuarioCreacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;

    @Column(name = "usuario_actualizacion", nullable = false, length = 100)
    private String usuarioActualizacion;

    @ManyToMany(mappedBy = "roles")
    private Set<UsuarioEntity2> usuarios = new HashSet<>();
}

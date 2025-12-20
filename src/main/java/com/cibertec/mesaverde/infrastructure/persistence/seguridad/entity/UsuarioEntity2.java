package com.cibertec.mesaverde.infrastructure.persistence.seguridad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "UsuarioEntity2")
@Table(name = "usuarios")
public class UsuarioEntity2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false, updatable = false)
    private Long idUsuario;

    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @Column(name = "password_salt", length = 64)
    private String passwordSalt;

    @Column(name = "id_cliente", unique = true)
    private Long idCliente;

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_usuario", nullable = false, length = 20)
    private EstadoUsuario estadoUsuario;

    @Column(name = "ultima_sesion")
    private LocalDateTime ultimaSesion;

    @Column(name = "intentos_fallidos", nullable = false)
    private Integer intentosFallidos;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "usuario_creacion", nullable = false, length = 100)
    private String usuarioCreacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;

    @Column(name = "usuario_actualizacion", nullable = false, length = 100)
    private String usuarioActualizacion;

    @ManyToMany
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private Set<RolEntity2> roles = new HashSet<>();

    public enum EstadoUsuario {
        ACTIVO, INACTIVO, BLOQUEADO, PENDIENTE_ACTIVACION
    }
}

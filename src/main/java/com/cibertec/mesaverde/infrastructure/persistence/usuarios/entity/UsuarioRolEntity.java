package com.cibertec.mesaverde.infrastructure.persistence.usuarios.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario_rol")
@Getter
@Setter
public class UsuarioRolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    private RolEntity idRol;

    @Column(name = "fecha_asignacion")
    private LocalDateTime fechaAsignacion;
}

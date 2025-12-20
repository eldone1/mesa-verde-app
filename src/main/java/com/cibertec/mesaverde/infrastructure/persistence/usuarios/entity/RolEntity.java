package com.cibertec.mesaverde.infrastructure.persistence.usuarios.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long id;

    @Column(name = "nombre_rol")
    private String nombreRol;

    @Column(name = "descripcion")
    private String descripcion;
}

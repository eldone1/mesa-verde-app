package com.cibertec.mesaverde.infrastructure.persistence.usuarios.entity;

import com.cibertec.mesaverde.infrastructure.persistence.clientes.entity.ClienteEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nombre")
    private String username;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "password_salt")
    private String passwordSalt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @Column(name = "email")
    private String email;

    @Column(name = "estado_usuario")
    private String estado;

    @Column(name = "ultima_sesion")
    private LocalDateTime ultimaSesion;

    @Column(name = "intentos_fallidos")
    private int intentosFallidos;
}

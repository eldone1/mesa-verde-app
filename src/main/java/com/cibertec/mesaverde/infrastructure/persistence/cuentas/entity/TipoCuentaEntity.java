package com.cibertec.mesaverde.infrastructure.persistence.cuentas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tipo_cuenta")
public class TipoCuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_cuenta")
    private Long id;

    @Column(name = "nombre_tipo")
    private String nombreTipo;

    @Column(name = "descripcion")
    private String descripcion;
}

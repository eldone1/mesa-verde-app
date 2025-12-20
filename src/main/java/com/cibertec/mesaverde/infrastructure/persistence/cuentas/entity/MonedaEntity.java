package com.cibertec.mesaverde.infrastructure.persistence.cuentas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "monedas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MonedaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_moneda")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "simbolo")
    private String simbolo;
}

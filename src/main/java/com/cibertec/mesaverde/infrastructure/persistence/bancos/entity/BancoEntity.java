package com.cibertec.mesaverde.infrastructure.persistence.bancos.entity;

import com.cibertec.mesaverde.infrastructure.shared.Auditoria;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bancos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BancoEntity extends Auditoria<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_banco")
    private Long id;
    @Column(name = "nombre_banco")
    private String nombreBanco;
    @Column(name = "codigo_banco")
    private String codigoBanco;

    @Column(name = "pais")
    private String pais;

    @Column(name = "ciudad")
    private String ciudad;
}

package com.cibertec.mesaverde.infrastructure.shared;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditoria<U> {

    @CreatedBy
    @JsonIgnore
    @Column(name = "usuario_creacion", updatable = false)
    private U usuarioCreacion;

    @CreatedDate
    @JsonIgnore
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @LastModifiedBy
    @JsonIgnore
    @Column(name = "usuario_actualizacion")
    private U usuarioActualizacion;

    @LastModifiedDate
    @JsonIgnore
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;
}

package com.cibertec.mesaverde.domain.seguridad.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class UsuarioRolId implements Serializable {
    private Integer idUsuario;
    private Integer idRol;

    public UsuarioRolId(Integer idUsuario, Integer idRol) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public Integer getIdRol() {
        return idRol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioRolId that)) return false;
        return Objects.equals(idUsuario, that.idUsuario) &&
                Objects.equals(idRol, that.idRol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idRol);
    }
}
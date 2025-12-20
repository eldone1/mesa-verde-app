package com.cibertec.mesaverde.infrastructure.persistence.seguridad.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UsuarioRolId2 implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long idUsuario;
    private Long idRol;

    public UsuarioRolId2() {}

    public UsuarioRolId2(Long idUsuario, Long idRol) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioRolId2 that)) return false;
        return Objects.equals(idUsuario, that.idUsuario) &&
                Objects.equals(idRol, that.idRol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idRol);
    }
}

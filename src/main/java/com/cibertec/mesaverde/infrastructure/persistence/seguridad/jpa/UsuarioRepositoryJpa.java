package com.cibertec.mesaverde.infrastructure.persistence.seguridad.jpa;

import com.cibertec.mesaverde.infrastructure.persistence.seguridad.entity.UsuarioEntity2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/*
public interface UsuarioRepositoryJpa extends JpaRepository<UsuarioEntity, Long> {

    @Query("""
            SELECT DISTINCT u FROM UsuarioEntity u
            LEFT JOIN FETCH u.roles ur
            LEFT JOIN FETCH ur.rol
            WHERE u.activo = true AND u.username = :username
            """)
    Optional<UsuarioEntity> usuarioPorUsername (@Param("username") String username)
}
*/

public interface UsuarioRepositoryJpa extends JpaRepository<UsuarioEntity2, Long> {

    @Query("""
            SELECT DISTINCT u FROM UsuarioEntity2 u
            LEFT JOIN FETCH u.roles ur
            WHERE u.username = :username
            """)
    Optional<UsuarioEntity2> usuarioPorUsername (@Param("username") String username);
}
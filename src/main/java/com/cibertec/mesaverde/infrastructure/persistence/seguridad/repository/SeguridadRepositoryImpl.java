package com.cibertec.mesaverde.infrastructure.persistence.seguridad.repository;

import com.cibertec.mesaverde.domain.seguridad.model.RolesModel;
import com.cibertec.mesaverde.domain.seguridad.model.UsuarioModel;
import com.cibertec.mesaverde.domain.seguridad.repository.UsuarioRepository;
import com.cibertec.mesaverde.infrastructure.persistence.seguridad.jpa.UsuarioRepositoryJpa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SeguridadRepositoryImpl implements UsuarioRepository {

    private final UsuarioRepositoryJpa usuarioRepositoryJpa;

    @Override
    public Optional<UsuarioModel> usuarioPorUserName(String username) {
        return usuarioRepositoryJpa.usuarioPorUsername(username)
                .map(u -> UsuarioModel.builder()
                        .idUsuario(u.getIdUsuario())
                        .username(u.getUsername())
                        .email(u.getEmail())
                        .passwordHash(u.getPasswordHash())
                        .passwordSalt(u.getPasswordSalt())
                        .idCliente(u.getIdCliente())
                        .estadoUsuario(
                                com.cibertec.mesaverde.domain.seguridad.model.EstadoUsuario
                                        .valueOf(u.getEstadoUsuario().name())
                        )
                        .ultimaSesion(u.getUltimaSesion())
                        .intentosFallidos(u.getIntentosFallidos())
                        .fechaCreacion(u.getFechaCreacion())
                        .usuarioCreacion(u.getUsuarioCreacion())
                        .fechaActualizacion(u.getFechaActualizacion())
                        .usuarioActualizacion(u.getUsuarioActualizacion())
                        .roles(
                                u.getRoles().stream()
                                        .map(ur -> RolesModel.builder()
                                                .idRol(ur.getIdRol())
                                                .nombreRol(ur.getNombreRol())
                                                .descripcion(ur.getDescripcion())
                                                .fechaCreacion(ur.getFechaCreacion())
                                                .usuarioCreacion(ur.getUsuarioCreacion())
                                                .fechaActualizacion(ur.getFechaActualizacion())
                                                .usuarioActualizacion(ur.getUsuarioActualizacion())
                                                .build()
                                        )
                                        .collect(Collectors.toSet())
                        )
                        .build()
                );
    }
    @Override
    public void guardarToken(String token) {
        log.info(token);
    }

    @Override
    public String obtenerTokenCache(String username) {
        return "";
    }
}
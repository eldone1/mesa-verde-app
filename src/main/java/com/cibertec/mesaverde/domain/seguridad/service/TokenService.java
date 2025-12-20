package com.cibertec.mesaverde.domain.seguridad.service;

import com.cibertec.mesaverde.domain.seguridad.model.UsuarioModel;

public interface TokenService {
    String generarTokenAcceso(UsuarioModel usuario);

    String generarTokenRefresco(UsuarioModel usuario);

    String extraerUsuario(String token);

    boolean esTokenValido(String token);
}

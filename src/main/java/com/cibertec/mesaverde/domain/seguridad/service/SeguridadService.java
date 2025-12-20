package com.cibertec.mesaverde.domain.seguridad.service;

import com.cibertec.mesaverde.domain.seguridad.model.SeguridadModel;

public interface SeguridadService {
    SeguridadModel autenticacion(String username, String password);

    SeguridadModel refrescar(String token);
}

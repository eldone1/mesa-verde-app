package com.cibertec.mesaverde.domain.transacciones.service;

import com.cibertec.mesaverde.domain.transacciones.model.MovimientoModel;

import java.util.List;

public interface MovimientoService {
    List<MovimientoModel> obtenerListadoMovimientos();
}

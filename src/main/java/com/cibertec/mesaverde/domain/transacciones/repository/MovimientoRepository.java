package com.cibertec.mesaverde.domain.transacciones.repository;

import com.cibertec.mesaverde.domain.transacciones.model.MovimientoModel;

import java.util.List;

public interface MovimientoRepository {

    MovimientoModel guardarMovimiento(MovimientoModel movimientoModel);

    List<MovimientoModel> listarMovimientos();
}

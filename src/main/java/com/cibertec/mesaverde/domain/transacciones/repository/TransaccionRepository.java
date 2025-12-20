package com.cibertec.mesaverde.domain.transacciones.repository;

import com.cibertec.mesaverde.domain.transacciones.model.TransaccionModel;

public interface TransaccionRepository {

    TransaccionModel guardarTransaccion(TransaccionModel transaccionModel);
}

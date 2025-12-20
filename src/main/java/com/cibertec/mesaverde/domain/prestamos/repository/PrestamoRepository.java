package com.cibertec.mesaverde.domain.prestamos.repository;

import java.util.List;

import com.cibertec.mesaverde.domain.prestamos.model.PrestamoModel;

public interface PrestamoRepository {
    
    List<PrestamoModel> findAllPrestamos();

    //PrestamoModel guardar(PrestamoModel prestamoModel);
}

package com.cibertec.mesaverde.domain.prestamos.service;

import java.util.List;

import com.cibertec.mesaverde.domain.prestamos.model.PrestamoModel;

public interface PrestamoService {

        List<PrestamoModel> listarPrestamos();

        //PrestamoModel guardarPrestamo(PrestamoRequestDto dto);

}

package com.cibertec.mesaverde.application.transacciones.usecase;

import com.cibertec.mesaverde.domain.transacciones.model.MovimientoModel;
import com.cibertec.mesaverde.domain.transacciones.repository.MovimientoRepository;
import com.cibertec.mesaverde.domain.transacciones.service.MovimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;

    @Override
    public List<MovimientoModel> obtenerListadoMovimientos() {

        return movimientoRepository.listarMovimientos();
    }
}

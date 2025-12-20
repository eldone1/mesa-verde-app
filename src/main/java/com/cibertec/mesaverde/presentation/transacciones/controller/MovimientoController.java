package com.cibertec.mesaverde.presentation.transacciones.controller;

import com.cibertec.mesaverde.domain.transacciones.model.MovimientoModel;
import com.cibertec.mesaverde.domain.transacciones.repository.MovimientoRepository;
import com.cibertec.mesaverde.infrastructure.mapper.MovimientoMapper;
import com.cibertec.mesaverde.presentation.transacciones.dto.response.ResponseMovimiento;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/movimientos")
@RequiredArgsConstructor
public class MovimientoController {

    private final MovimientoRepository movimientoRepository;
    private final MovimientoMapper movimientoMapper;

    @GetMapping(value = "lista")
    public List<ResponseMovimiento> listarUltimosMovimientos() {

        List<MovimientoModel> movimientos = movimientoRepository.listarMovimientos();

        return movimientos.stream()
                .map(movimientoMapper::toResponseMovimiento)
                .collect(Collectors.toList());
    }
}

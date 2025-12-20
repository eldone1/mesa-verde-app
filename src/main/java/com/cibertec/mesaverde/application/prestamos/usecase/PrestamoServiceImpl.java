package com.cibertec.mesaverde.application.prestamos.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.mesaverde.domain.prestamos.model.PrestamoModel;
import com.cibertec.mesaverde.domain.prestamos.repository.PrestamoRepository;
import com.cibertec.mesaverde.domain.prestamos.service.PrestamoService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;

    @Override
    public List<PrestamoModel> listarPrestamos() {
        return prestamoRepository.findAllPrestamos();
    }

    

}

package com.cibertec.mesaverde.presentation.prestamos.controller;


import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.mesaverde.domain.prestamos.model.PrestamoModel;
import com.cibertec.mesaverde.domain.prestamos.service.PrestamoService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/prestamos")
@RequiredArgsConstructor
@Tag(name = "Prestamos", description = "Operations related to prestamos")
public class PrestamoController {
    
    private final PrestamoService prestamoService;

    
    @GetMapping
    public List<PrestamoModel> listarPrestamos() {

        return prestamoService.listarPrestamos();
    }
}

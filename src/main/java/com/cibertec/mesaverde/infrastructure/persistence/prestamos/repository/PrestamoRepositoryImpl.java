package com.cibertec.mesaverde.infrastructure.persistence.prestamos.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.cibertec.mesaverde.domain.prestamos.model.PrestamoModel;
import com.cibertec.mesaverde.domain.prestamos.repository.PrestamoRepository;
import com.cibertec.mesaverde.infrastructure.mapper.PrestamoMapper;
import com.cibertec.mesaverde.infrastructure.persistence.prestamos.entity.PrestamoEntity;
import com.cibertec.mesaverde.infrastructure.persistence.prestamos.jpa.PrestamoRepositoryJpa;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PrestamoRepositoryImpl implements PrestamoRepository {

   
    private final PrestamoRepositoryJpa prestamoRepositoryJpa;
    private final PrestamoMapper prestamoMapper;

    @Override
    public List<PrestamoModel> findAllPrestamos() {
        List<PrestamoEntity> prestamos = prestamoRepositoryJpa.findAll();
        return prestamos.stream()
                .map(prestamoMapper::toModel)
                .collect(Collectors.toList());
    }


}

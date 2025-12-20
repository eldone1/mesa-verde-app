package com.cibertec.mesaverde.infrastructure.persistence.prestamos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.mesaverde.infrastructure.persistence.prestamos.entity.PrestamoEntity;

public interface PrestamoRepositoryJpa extends JpaRepository<PrestamoEntity, Long> {




}

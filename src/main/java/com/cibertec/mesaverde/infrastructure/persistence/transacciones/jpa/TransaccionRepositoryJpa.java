package com.cibertec.mesaverde.infrastructure.persistence.transacciones.jpa;

import com.cibertec.mesaverde.infrastructure.persistence.transacciones.entity.TransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepositoryJpa extends JpaRepository<TransaccionEntity, Long> {
}

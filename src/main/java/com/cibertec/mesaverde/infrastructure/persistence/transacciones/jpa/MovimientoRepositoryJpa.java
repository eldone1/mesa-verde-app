package com.cibertec.mesaverde.infrastructure.persistence.transacciones.jpa;

import com.cibertec.mesaverde.infrastructure.persistence.transacciones.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepositoryJpa extends JpaRepository<MovimientoEntity,Long> {
}

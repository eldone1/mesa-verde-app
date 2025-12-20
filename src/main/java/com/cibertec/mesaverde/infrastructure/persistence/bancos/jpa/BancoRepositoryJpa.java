package com.cibertec.mesaverde.infrastructure.persistence.bancos.jpa;

import com.cibertec.mesaverde.infrastructure.persistence.bancos.entity.BancoEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BancoRepositoryJpa extends JpaRepository<BancoEntity,Long> {
}

package com.cibertec.mesaverde.infrastructure.persistence.transacciones.repository;

import com.cibertec.mesaverde.domain.transacciones.model.TransaccionModel;
import com.cibertec.mesaverde.domain.transacciones.repository.TransaccionRepository;
import com.cibertec.mesaverde.infrastructure.mapper.TransaccionMapper;
import com.cibertec.mesaverde.infrastructure.persistence.transacciones.entity.TransaccionEntity;
import com.cibertec.mesaverde.infrastructure.persistence.transacciones.jpa.TransaccionRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TransaccionRepositoryImpl implements TransaccionRepository {

    private final TransaccionRepositoryJpa transaccionRepositoryJpa;
    private final TransaccionMapper transaccionMapper;


    @Override
    public TransaccionModel guardarTransaccion(TransaccionModel transaccionModel) {

        TransaccionEntity entity = transaccionMapper.toEntity(transaccionModel);

        TransaccionEntity transaccionGuardada = transaccionRepositoryJpa.save(entity);

        return transaccionMapper.toModel(transaccionGuardada);
    }
}

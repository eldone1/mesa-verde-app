package com.cibertec.mesaverde.infrastructure.persistence.bancos.repository;

import com.cibertec.mesaverde.domain.bancos.model.BancoModel;
import com.cibertec.mesaverde.domain.bancos.repository.BancoRepository;

import com.cibertec.mesaverde.infrastructure.mapper.BancoMapper;
import com.cibertec.mesaverde.infrastructure.persistence.bancos.entity.BancoEntity;
import com.cibertec.mesaverde.infrastructure.persistence.bancos.jpa.BancoRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BancoRepositoryImpl implements BancoRepository {

    private final BancoRepositoryJpa bancoRepositoryJpa;
    private final BancoMapper bancoMapper;

    @Override
    public List<BancoModel> findAllBancos() {
        List<BancoEntity> bancos = bancoRepositoryJpa.findAll();
        return bancos.stream()
                .map(bancoMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public BancoModel guardarBanco(BancoModel bancoModel) {
        BancoEntity entity = bancoMapper.toEntity(bancoModel);

        BancoEntity bancoGuardado = bancoRepositoryJpa.save(entity);

        return bancoMapper.toModel(bancoGuardado);
    }
}

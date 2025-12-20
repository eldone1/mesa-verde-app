package com.cibertec.mesaverde.infrastructure.persistence.clientes.repository;

import com.cibertec.mesaverde.domain.clientes.model.ClienteModel;
import com.cibertec.mesaverde.domain.clientes.repository.ClienteRepository;
import com.cibertec.mesaverde.infrastructure.mapper.ClienteMapper;
import com.cibertec.mesaverde.infrastructure.persistence.clientes.entity.ClienteEntity;
import com.cibertec.mesaverde.infrastructure.persistence.clientes.jpa.ClienteRepositoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ClienteRepositoryImpl implements ClienteRepository {

    private final ClienteRepositoryJpa clienteRepositoryJpa;
    private final ClienteMapper clienteMapper;

    @Override
    public List<ClienteModel> findAllClientes() {
        List<ClienteEntity> clientes = clienteRepositoryJpa.findAll();
        return clientes.stream()
                .map(clienteMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteModel guardarCliente(ClienteModel clienteModel) {

        ClienteEntity entity = clienteMapper.toEntity(clienteModel);

        ClienteEntity clienteGuardado = clienteRepositoryJpa.save(entity);

        return clienteMapper.toModel(clienteGuardado);
    }
}

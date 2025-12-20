package com.cibertec.mesaverde.domain.clientes.repository;

import com.cibertec.mesaverde.domain.clientes.model.ClienteModel;
import com.cibertec.mesaverde.infrastructure.persistence.clientes.entity.ClienteEntity;

import java.util.List;

public interface ClienteRepository {

    List<ClienteModel> findAllClientes();

    ClienteModel guardarCliente(ClienteModel clienteModel);
}

package com.cibertec.mesaverde.domain.clientes.service;

import com.cibertec.mesaverde.domain.clientes.model.ClienteModel;
import com.cibertec.mesaverde.presentation.clientes.dto.request.ClienteRequestDto;

import java.util.List;

public interface ClienteService {

    List<ClienteModel> listarClientes();

    ClienteModel procesarRegistroCliente(ClienteRequestDto dto);
}

package com.cibertec.mesaverde.application.clientes.usecase;

import com.cibertec.mesaverde.domain.clientes.model.ClienteModel;
import com.cibertec.mesaverde.domain.clientes.repository.ClienteRepository;
import com.cibertec.mesaverde.domain.clientes.service.ClienteService;
import com.cibertec.mesaverde.presentation.clientes.dto.request.ClienteRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<ClienteModel> listarClientes() {
        return clienteRepository.findAllClientes();
    }

    @Override
    @Transactional
    public ClienteModel procesarRegistroCliente(ClienteRequestDto cliente) {

        ClienteModel model = ClienteModel.builder()
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .tipoDocumento(cliente.getTipoDocumento())
                .numeroDocumento(cliente.getNumeroDocumento())
                .fechaNacimiento(cliente.getFechaNacimiento())
                .direccion(cliente.getDireccion())
                .telefono(cliente.getTelefono())
                .email(cliente.getEmail())
                .estado("ACTIVO")
                .build();

        return clienteRepository.guardarCliente(model);
    }
}

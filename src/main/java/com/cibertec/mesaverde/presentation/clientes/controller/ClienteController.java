package com.cibertec.mesaverde.presentation.clientes.controller;

import com.cibertec.mesaverde.domain.clientes.model.ClienteModel;
import com.cibertec.mesaverde.domain.clientes.service.ClienteService;

import com.cibertec.mesaverde.presentation.clientes.dto.request.ClienteRequestDto;
import com.cibertec.mesaverde.presentation.clientes.dto.response.ClienteResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/clientes")
@RequiredArgsConstructor
@Tag(name = "Clientes", description = "Operations related to clients")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping(value = "/lista")
    public List<ClienteModel> listarClientes() {

        return clienteService.listarClientes();
    }

    @PostMapping(value = "/registrar")
    public ClienteResponse registrarCliente(@RequestBody ClienteRequestDto cliente) {

        ClienteModel model = clienteService.procesarRegistroCliente(cliente);

        String mensaje = "Usuario registrado con éxito. ID: "+ model.getId();

        return new ClienteResponse(mensaje);
    }
}

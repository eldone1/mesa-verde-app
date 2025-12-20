package com.cibertec.mesaverde.presentation.cuentas.controller;

import com.cibertec.mesaverde.domain.cuentas.service.CuentaBancariaService;
import com.cibertec.mesaverde.domain.transacciones.model.TransaccionModel;
import com.cibertec.mesaverde.presentation.cuentas.dto.request.DepositoRequestDto;
import com.cibertec.mesaverde.presentation.cuentas.dto.request.NuevaTransferenciaRequestDto;
import com.cibertec.mesaverde.presentation.cuentas.dto.request.TransferenciaRequestDto;
import com.cibertec.mesaverde.presentation.cuentas.dto.response.CuentasBancariasResponse;
import com.cibertec.mesaverde.presentation.cuentas.dto.response.DepositoResponse;
import com.cibertec.mesaverde.presentation.cuentas.dto.response.NuevaTransferenciaResponse;
import com.cibertec.mesaverde.presentation.cuentas.dto.response.TransferenciaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cuentas")
@RequiredArgsConstructor
public class CuentaBancariaController {

    private final CuentaBancariaService cuentaBancariaService;

    @GetMapping(value = "/cuentas-bancarias-usuario")
    public List<CuentasBancariasResponse> listarCuentasBancariasPorUsuario() {

        //String mensaje = "Deposito realizado con extio. Número de transacción:" + transaccion.getId();

        return cuentaBancariaService.listarCuentasBancariasPorUsuario();
    }

    @PostMapping(value = "/deposito")
    public DepositoResponse realizarDeposito(@RequestBody DepositoRequestDto requestDto) {

        TransaccionModel transaccion = cuentaBancariaService.procesarDeposito(requestDto);

        String mensaje = "Deposito realizado con extio. Número de transacción:" + transaccion.getId();

        return new DepositoResponse(mensaje);
    }

    @PostMapping(value = "/nueva-transferencia")
    public NuevaTransferenciaResponse nuevaTransferencia(@RequestBody NuevaTransferenciaRequestDto requestDto) {

        return cuentaBancariaService.nuevaTransferencia(requestDto);
    }

    @PostMapping(value = "/confirmar-transferencia")
    public TransferenciaResponse nuevaTransferencia(@RequestBody TransferenciaRequestDto requestDto) {

        return cuentaBancariaService.procesarTransferencia(requestDto);
    }
}

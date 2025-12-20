package com.cibertec.mesaverde.domain.cuentas.service;

import com.cibertec.mesaverde.domain.cuentas.model.CuentaBancariaModel;
import com.cibertec.mesaverde.domain.transacciones.model.TransaccionModel;
import com.cibertec.mesaverde.presentation.cuentas.dto.request.DepositoRequestDto;
import com.cibertec.mesaverde.presentation.cuentas.dto.request.NuevaTransferenciaRequestDto;
import com.cibertec.mesaverde.presentation.cuentas.dto.request.TransferenciaRequestDto;
import com.cibertec.mesaverde.presentation.cuentas.dto.response.CuentasBancariasResponse;
import com.cibertec.mesaverde.presentation.cuentas.dto.response.NuevaTransferenciaResponse;
import com.cibertec.mesaverde.presentation.cuentas.dto.response.TransferenciaResponse;

import java.util.List;

public interface CuentaBancariaService {

    TransaccionModel procesarDeposito(DepositoRequestDto request);

    NuevaTransferenciaResponse nuevaTransferencia(NuevaTransferenciaRequestDto requestDto);

    TransferenciaResponse procesarTransferencia(TransferenciaRequestDto requestDto);

    List<CuentasBancariasResponse> listarCuentasBancariasPorUsuario();
}

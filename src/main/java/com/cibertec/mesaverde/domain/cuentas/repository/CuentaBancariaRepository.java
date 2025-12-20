package com.cibertec.mesaverde.domain.cuentas.repository;

import com.cibertec.mesaverde.domain.cuentas.model.CuentaBancariaModel;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CuentaBancariaRepository {

    CuentaBancariaModel obtenerCuentaBancaria(String numero);

    CuentaBancariaModel guardarCuentaBancaria(CuentaBancariaModel cuentaBancariaModel);

    CuentaBancariaModel guardarDeposito(CuentaBancariaModel cuentaBancariaModel);

    List<CuentaBancariaModel> obtenerCuentasBancariasPorUsuario(String usuario);
}

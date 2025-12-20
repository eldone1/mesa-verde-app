package com.cibertec.mesaverde.application.cuentas.usecase;

import com.cibertec.mesaverde.domain.cuentas.model.CuentaBancariaModel;
import com.cibertec.mesaverde.domain.cuentas.repository.CuentaBancariaRepository;
import com.cibertec.mesaverde.domain.cuentas.service.CuentaBancariaService;
import com.cibertec.mesaverde.domain.transacciones.model.MovimientoModel;
import com.cibertec.mesaverde.domain.transacciones.model.TransaccionModel;
import com.cibertec.mesaverde.domain.transacciones.repository.MovimientoRepository;
import com.cibertec.mesaverde.domain.transacciones.repository.TransaccionRepository;
import com.cibertec.mesaverde.presentation.cuentas.dto.request.DepositoRequestDto;
import com.cibertec.mesaverde.presentation.cuentas.dto.request.NuevaTransferenciaRequestDto;
import com.cibertec.mesaverde.presentation.cuentas.dto.request.TransferenciaRequestDto;
import com.cibertec.mesaverde.presentation.cuentas.dto.response.CuentasBancariasResponse;
import com.cibertec.mesaverde.presentation.cuentas.dto.response.NuevaTransferenciaResponse;
import com.cibertec.mesaverde.presentation.cuentas.dto.response.TransferenciaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CuentaBancariaServiceImpl implements CuentaBancariaService {

    private final CuentaBancariaRepository cuentaBancariaRepository;
    private final TransaccionRepository transaccionRepository;
    private final MovimientoRepository movimientoRepository;

    @Override
    @Transactional
    public TransaccionModel procesarDeposito(DepositoRequestDto requestDto) {

        System.out.println("numero cuenta dto:"+ requestDto.getNumeroCuentaDestino());

        System.out.println("monto del requestDto: " + requestDto.getMonto()); // <-- Agrega esta línea
        System.out.println("descripcion del requestDto: " + requestDto.getDescripcion()); // <-- Y esta también para depurar

        CuentaBancariaModel cuentaDestino = cuentaBancariaRepository.obtenerCuentaBancaria(requestDto.getNumeroCuentaDestino());

        TransaccionModel transaccion = TransaccionModel.builder()
                .cuentaDestino(cuentaDestino)
                .tipoTransaccion("DEPOSITO")
                .monto(requestDto.getMonto())
                .moneda(cuentaDestino.getMoneda())
                .fechaHoraTransaccion(LocalDateTime.now())
                .estadoTransaccion("COMPLETADA")
                .descripcion(requestDto.getDescripcion() != null ? requestDto.getDescripcion() : "Depósito en efectivo.")
                .build();

        transaccion = transaccionRepository.guardarTransaccion(transaccion);

        BigDecimal saldoAntes = cuentaDestino.getSaldo();
        cuentaDestino.setSaldo(saldoAntes.add(requestDto.getMonto()).setScale(4, RoundingMode.HALF_UP));
        cuentaBancariaRepository.guardarDeposito(cuentaDestino);

        MovimientoModel movimiento = MovimientoModel.builder()
                .transaccion(transaccion)
                .cuenta(cuentaDestino)
                .tipoMovimiento("DEBITO")
                .montoMovimiento(requestDto.getMonto())
                .moneda(cuentaDestino.getMoneda())
                .saldoAntes(saldoAntes)
                .saldoDespues(cuentaDestino.getSaldo())
                .fechaHoraMovimiento(LocalDateTime.now())
                .descripcion(transaccion.getDescripcion())
                .build();

        movimientoRepository.guardarMovimiento(movimiento);

        return transaccion;
    }

    @Override
    public NuevaTransferenciaResponse nuevaTransferencia(NuevaTransferenciaRequestDto requestDto) {

        System.out.println("Num cuenta:" + requestDto.getNumeroCuentaDestino());

        CuentaBancariaModel cuentaDestino = cuentaBancariaRepository.obtenerCuentaBancaria(requestDto.getNumeroCuentaDestino());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Nombre usuario: " + authentication.getName());

        List<CuentaBancariaModel> cuentaOrigenJwt = cuentaBancariaRepository.obtenerCuentasBancariasPorUsuario(authentication.getName());

        //System.out.println("cuentaOrigenJwt " + cuentaOrigenJwt.getNumeroCuenta());

        return NuevaTransferenciaResponse.builder()
                .nombreCompleto(cuentaDestino.getCliente().getNombre() + " " + cuentaDestino.getCliente().getApellido())
                .numeroCuenta(cuentaDestino.getNumeroCuenta())
                .moneda(cuentaDestino.getMoneda().getNombre())
                .saldoActual(BigDecimal.valueOf(45000))
                .build();
    }

    @Override
    @Transactional
    public TransferenciaResponse procesarTransferencia(TransferenciaRequestDto requestDto) {

        System.out.println("Num cuenta:" + requestDto.getNumeroCuentaDestino());

        CuentaBancariaModel cuentaOrigen = cuentaBancariaRepository.obtenerCuentaBancaria(requestDto.getNumeroCuentaOrigen());

        // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CuentaBancariaModel cuentaDestino = cuentaBancariaRepository.obtenerCuentaBancaria(requestDto.getNumeroCuentaDestino());

        // Transaccion

        TransaccionModel transaccion = TransaccionModel.builder()
                .monto(requestDto.getMonto())
                .tipoTransaccion("TRANSFERENCIA_INTERNA")
                .moneda(cuentaOrigen.getMoneda())
                .fechaHoraTransaccion(LocalDateTime.now())
                .estadoTransaccion("COMPLETADA")
                .descripcion(requestDto.getDescripcion() != null ? requestDto.getDescripcion() : "Transferencia interna.")
                .cuentaOrigen(cuentaOrigen)
                .cuentaDestino(cuentaDestino)
                .build();

        transaccion = transaccionRepository.guardarTransaccion(transaccion);

        // Debito

        BigDecimal saldoOrigenAntes = cuentaOrigen.getSaldo();
        cuentaOrigen.setSaldo(saldoOrigenAntes.subtract(requestDto.getMonto()).setScale(4, RoundingMode.HALF_UP));
        cuentaBancariaRepository.guardarCuentaBancaria(cuentaOrigen);

        MovimientoModel movimientoDebito = MovimientoModel.builder()
                .transaccion(transaccion)
                .cuenta(cuentaOrigen)
                .tipoMovimiento("DEBITO")
                .montoMovimiento(requestDto.getMonto())
                .moneda(cuentaOrigen.getMoneda())
                .saldoAntes(saldoOrigenAntes)
                .saldoDespues(cuentaOrigen.getSaldo())
                .fechaHoraMovimiento(LocalDateTime.now())
                .descripcion("Debito por transferencia a "+ cuentaDestino.getNumeroCuenta())
                .build();
        movimientoRepository.guardarMovimiento(movimientoDebito);

        // Credito

        BigDecimal saldoDestinoAntes = cuentaDestino.getSaldo();
        cuentaDestino.setSaldo(saldoDestinoAntes.add(requestDto.getMonto()).setScale(4, RoundingMode.HALF_UP));
        cuentaBancariaRepository.guardarCuentaBancaria(cuentaDestino);

        MovimientoModel movimientoCredito = MovimientoModel.builder()
                .transaccion(transaccion)
                .cuenta(cuentaDestino)
                .tipoMovimiento("CREDITO")
                .montoMovimiento(requestDto.getMonto())
                .moneda(cuentaDestino.getMoneda())
                .saldoAntes(saldoDestinoAntes)
                .saldoDespues(cuentaDestino.getSaldo())
                .fechaHoraMovimiento(LocalDateTime.now())
                .descripcion("Credito por transferencia de " + cuentaOrigen.getNumeroCuenta())
                .build();
        movimientoRepository.guardarMovimiento(movimientoCredito);

        return TransferenciaResponse.builder()
                .numeroCuentaOrigen(transaccion.getCuentaOrigen().getNumeroCuenta())
                .nombreMonedaOrigen(transaccion.getCuentaOrigen().getMoneda().getNombre())
                .nombreCompletoOrigen(transaccion.getCuentaOrigen().getCliente().getNombre() + " " + transaccion.getCuentaOrigen().getCliente().getApellido())
                .numeroCuentaDestino(transaccion.getCuentaDestino().getNumeroCuenta())
                .nombreMonedaDestino(transaccion.getCuentaOrigen().getMoneda().getNombre())
                .nombreCompletoDestino(transaccion.getCuentaDestino().getCliente().getNombre() + " " + transaccion.getCuentaDestino().getCliente().getApellido())
                .simboloMoneda(transaccion.getCuentaDestino().getMoneda().getSimbolo())
                .monto(transaccion.getMonto())
                .descripcion(transaccion.getDescripcion())
                .numeroTransaccion(transaccion.getId())
                .fechaHora(transaccion.getFechaHoraTransaccion())
                .build();
    }

    @Override
    public List<CuentasBancariasResponse> listarCuentasBancariasPorUsuario() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        List<CuentaBancariaModel> cuentasUsuarioLogueado = cuentaBancariaRepository.obtenerCuentasBancariasPorUsuario(username);

        List<CuentasBancariasResponse> cuentas = cuentasUsuarioLogueado.stream()
                .map(cuenta -> CuentasBancariasResponse.builder()
                        .id(cuenta.getId())
                        .simboloMoneda(cuenta.getMoneda().getSimbolo())
                        .numeroCuenta(cuenta.getNumeroCuenta())
                        .saldo(cuenta.getSaldo())
                        .build()
                ).toList();

        System.out.println("Nombre usuario listar cuentas: " + authentication.getName());

        return cuentas;
    }
}

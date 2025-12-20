package com.cibertec.mesaverde.application.banco.usecase;

import com.cibertec.mesaverde.domain.bancos.model.BancoModel;
import com.cibertec.mesaverde.domain.bancos.repository.BancoRepository;
import com.cibertec.mesaverde.domain.bancos.service.BancoService;
import com.cibertec.mesaverde.presentation.banco.dto.request.BancoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BancoServiceImpl implements BancoService {

    private final BancoRepository bancoRepository; // Inyección del repositorio

    @Override
    public List<BancoModel> listarBancos() {
        return bancoRepository.findAllBancos();
    }
    @Override
    @Transactional
    public BancoModel procesarRegistroBanco(BancoRequestDto banco) {

        BancoModel model = BancoModel.builder()
                .nombreBanco(banco.getNombreBanco())
                .codigoBanco(banco.getCodigoBanco())
                .pais(banco.getPais())
                .ciudad(banco.getCiudad())
                .build();
        return bancoRepository.guardarBanco(model);
    }
}

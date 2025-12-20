package com.cibertec.mesaverde.domain.bancos.service;


import com.cibertec.mesaverde.domain.bancos.model.BancoModel;
import com.cibertec.mesaverde.presentation.banco.dto.request.BancoRequestDto;

import java.util.List;

public interface BancoService {
    List<BancoModel> listarBancos();
    BancoModel procesarRegistroBanco(BancoRequestDto dto);
}

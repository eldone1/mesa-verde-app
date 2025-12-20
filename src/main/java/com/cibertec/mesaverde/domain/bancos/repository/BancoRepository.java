package com.cibertec.mesaverde.domain.bancos.repository;

import com.cibertec.mesaverde.domain.bancos.model.BancoModel;

import java.util.List;

public interface BancoRepository {

    List<BancoModel> findAllBancos();
    BancoModel guardarBanco(BancoModel bancoModel);

}

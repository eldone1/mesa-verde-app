package com.cibertec.mesaverde.presentation.banco.controller;


import com.cibertec.mesaverde.domain.bancos.model.BancoModel;
import com.cibertec.mesaverde.domain.bancos.service.BancoService;
import com.cibertec.mesaverde.presentation.banco.dto.request.BancoRequestDto;
import com.cibertec.mesaverde.presentation.banco.dto.response.BancoResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bancos")
@RequiredArgsConstructor
@Tag(name = "Bancos", description = "Operations related  to banks")
public class BancoController {

    private final BancoService bancoService;

    @GetMapping(value = "/lista")
    public List<BancoModel>bancos(){
        return bancoService.listarBancos();
    }
    @PostMapping(value = "/registrar")
    public BancoResponse registrarBanco(@RequestBody BancoRequestDto banco) {

        BancoModel model = bancoService.procesarRegistroBanco(banco);

        String mensaje = "Registro un Banco con éxito. ID: "+ model.getId();

        return new BancoResponse(mensaje);
    }

}

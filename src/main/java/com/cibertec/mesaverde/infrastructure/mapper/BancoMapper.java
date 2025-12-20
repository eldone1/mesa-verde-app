package com.cibertec.mesaverde.infrastructure.mapper;

import com.cibertec.mesaverde.domain.bancos.model.BancoModel;
import com.cibertec.mesaverde.infrastructure.persistence.bancos.entity.BancoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BancoMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombreBanco", source = "nombreBanco")
    @Mapping(target = "codigoBanco", source = "codigoBanco")
    @Mapping(target = "pais", source = "pais")
    @Mapping(target = "ciudad", source = "ciudad")
    BancoModel toModel(BancoEntity bancoEntity);

    BancoEntity toEntity(BancoModel bancoModel);
}

package com.cibertec.mesaverde.infrastructure.mapper;

import com.cibertec.mesaverde.domain.clientes.model.ClienteModel;
import com.cibertec.mesaverde.infrastructure.persistence.clientes.entity.ClienteEntity;
import com.cibertec.mesaverde.presentation.clientes.dto.request.ClienteRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteModel toModel(ClienteEntity clienteEntity);

    @Mapping(target = "estado", source = "estado")
    ClienteEntity toEntity(ClienteModel clienteModel);
}

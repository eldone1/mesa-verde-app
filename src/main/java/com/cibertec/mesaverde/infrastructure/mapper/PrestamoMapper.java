package com.cibertec.mesaverde.infrastructure.mapper;


import org.mapstruct.Mapper;

import com.cibertec.mesaverde.domain.prestamos.model.PrestamoModel;
import com.cibertec.mesaverde.infrastructure.persistence.prestamos.entity.PrestamoEntity;


@Mapper(componentModel = "spring")
public interface PrestamoMapper {

    
   PrestamoModel toModel(PrestamoEntity prestamoEntity);

   //PrestamoEntity toEntity(PrestamoModel prestamoModel);
    
}

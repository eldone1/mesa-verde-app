package com.cibertec.mesaverde.infrastructure.persistence.cuentas.jpa;

import com.cibertec.mesaverde.infrastructure.persistence.cuentas.entity.CuentaBancariaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CuentaBancariaRepositoryJpa extends JpaRepository<CuentaBancariaEntity, Long> {

    @Query("""
            select cb from CuentaBancariaEntity cb where cb.numeroCuenta = :numero
            """)
    CuentaBancariaEntity getCuentaBancariaInterna(@Param("numero") String numero);

    @Query("""
            select cb from CuentaBancariaEntity cb
            join cb.cliente ce
            join UsuarioEntity2 u on ce.id = u.idCliente
            where u.username = :usuario
            """)
    List<CuentaBancariaEntity> getCuentasBancariasPorUsuario(@Param("usuario") String usuario);
}

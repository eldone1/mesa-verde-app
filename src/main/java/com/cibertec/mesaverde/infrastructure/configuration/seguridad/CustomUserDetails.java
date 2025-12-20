package com.cibertec.mesaverde.infrastructure.configuration.seguridad;

import com.cibertec.mesaverde.domain.seguridad.model.EstadoUsuario;
import com.cibertec.mesaverde.domain.seguridad.model.UsuarioModel;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
public class CustomUserDetails implements UserDetails {

    private final UsuarioModel usuario;

    public CustomUserDetails(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return usuario.getRoles()
                .stream()
                .map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.getNombreRol()))
                .toList();
    }

    @Override
    public String getPassword() {
        return usuario.getPasswordHash();
    }

    @Override
    public String getUsername() {
        return usuario.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // o lógica según tu modelo
    }

    @Override
    public boolean isAccountNonLocked() {
        return usuario.getEstadoUsuario() != EstadoUsuario.BLOQUEADO;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // o lógica según tu modelo
    }

    @Override
    public boolean isEnabled() {
        return usuario.getEstadoUsuario() == EstadoUsuario.ACTIVO;
    }
}

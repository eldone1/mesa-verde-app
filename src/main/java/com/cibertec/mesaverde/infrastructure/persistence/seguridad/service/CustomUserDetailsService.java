package com.cibertec.mesaverde.infrastructure.persistence.seguridad.service;

import com.cibertec.mesaverde.domain.seguridad.repository.UsuarioRepository;
import com.cibertec.mesaverde.infrastructure.configuration.seguridad.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.usuarioPorUserName(username)
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "No se encontró el usuario con username: " + username
                ));
    }
}

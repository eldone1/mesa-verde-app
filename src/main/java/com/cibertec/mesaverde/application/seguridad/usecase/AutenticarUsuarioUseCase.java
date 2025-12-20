package com.cibertec.mesaverde.application.seguridad.usecase;

import com.cibertec.mesaverde.domain.seguridad.exception.CredencialesInvalidasException;
import com.cibertec.mesaverde.domain.seguridad.model.SeguridadModel;
import com.cibertec.mesaverde.domain.seguridad.model.UsuarioModel;
import com.cibertec.mesaverde.domain.seguridad.service.TokenService;
import com.cibertec.mesaverde.infrastructure.configuration.seguridad.CustomUserDetails;
import com.cibertec.mesaverde.infrastructure.persistence.seguridad.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AutenticarUsuarioUseCase {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final CustomUserDetailsService userDetailsService;

    public SeguridadModel ejecutar(String username, String password) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            
        } catch (Exception ex) {
            log.warn("Autenticación fallida para el usuario '{}'", username, ex);
            throw new CredencialesInvalidasException("Credenciales inválidas");
        }

        return generarTokensDesdeUsername(username);
    }

    private SeguridadModel generarTokensDesdeUsername(String username) {
        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(username);
        UsuarioModel usuario = userDetails.getUsuario();

        String accessToken = tokenService.generarTokenAcceso(usuario);
        String refreshToken = tokenService.generarTokenRefresco(usuario);

        return SeguridadModel.builder()
                .token(accessToken)
                .refresh(refreshToken)
                .build();
    }
}

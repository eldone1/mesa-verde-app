package com.cibertec.mesaverde.presentation.seguridad.controller;

import com.cibertec.mesaverde.domain.seguridad.model.SeguridadModel;
import com.cibertec.mesaverde.domain.seguridad.service.SeguridadService;
import com.cibertec.mesaverde.infrastructure.configuration.seguridad.JwtProperties;
import com.cibertec.mesaverde.presentation.seguridad.dto.LoginRequestDto;
import com.cibertec.mesaverde.presentation.seguridad.dto.LoginResponseDto;
import com.cibertec.mesaverde.presentation.seguridad.dto.RefreshTokenRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/public/api/auth")
public class AuthController {
    private final JwtProperties jwtProperties;
    private final SeguridadService seguridadService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto request) {
        SeguridadModel seguridad = seguridadService.autenticacion(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(
                buildLoginResponse(
                        seguridad.getToken(),
                        seguridad.getRefresh()
                )
        );
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponseDto> refresh(@Valid @RequestBody RefreshTokenRequestDto request) {
        SeguridadModel seguridad = seguridadService.refrescar(request.getRefreshToken());
        return ResponseEntity.ok(
                buildLoginResponse(
                        seguridad.getToken(),
                        seguridad.getRefresh()
                )
        );
    }


    private LoginResponseDto buildLoginResponse(String accessToken, String refreshToken) {
        long accessTtlSeconds = Duration.ofMillis(jwtProperties.getAccessTokenExpiration()).toSeconds();
        return new LoginResponseDto(accessToken, refreshToken, accessTtlSeconds);
    }
}

package com.cibertec.mesaverde.presentation.seguridad.dto;

public record LoginResponseDto(
        String accessToken,
        String refreshToken,
        Long expiresIn
) {
}

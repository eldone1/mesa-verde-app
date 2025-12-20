package com.cibertec.mesaverde.infrastructure.configuration;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareConfig implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        //return Optional.empty();
        return Optional.of("admin");
    }
}

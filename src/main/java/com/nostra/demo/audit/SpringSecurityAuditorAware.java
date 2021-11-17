package com.nostra.demo.audit;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@EnableJpaAuditing
public class SpringSecurityAuditorAware implements AuditorAware<String> {


	
	
	@Override
	public Optional<String> getCurrentAuditor() {
		
		return Optional.of("SYSTEM");
	}

}

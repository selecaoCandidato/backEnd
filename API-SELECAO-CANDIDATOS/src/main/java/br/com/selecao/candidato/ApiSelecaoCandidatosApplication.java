package br.com.selecao.candidato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ApiSelecaoCandidatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSelecaoCandidatosApplication.class, args);
	}

}

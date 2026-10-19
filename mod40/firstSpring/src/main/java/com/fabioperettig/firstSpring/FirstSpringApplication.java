package com.fabioperettig.firstSpring;

import com.fabioperettig.domain.Cliente;
import com.fabioperettig.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.fabioperettig.domain")
@EnableJpaRepositories(basePackages = "com.fabioperettig.repository")
@ComponentScan(basePackages = "com.fabioperettig")
public class FirstSpringApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(FirstSpringApplication.class);

	/// Injeção de dependência
	@Autowired
	private IClienteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringApplication.class, args);
	}

	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming main method arguments
	 * @throws Exception on error
	 */
	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication");
		Cliente cliente = createClient();
		repository.save(cliente);


		/// teste de busca Criteria
		repository.buscaCriteria("Fabio", null).forEach(encontrado -> log.info(
				"Cliente consultado: id={}, nome={}", encontrado.getId(), encontrado.getNome()));
	}

	/// auxiliar - pattern BUILDER

	private Cliente createClient() {
		return Cliente.builder()
				.nome("Fabio Peretti")
				.cpf(12345678901L)
				.idade(33)
				.contato("fabioperettig@mail.com")
				.build();
	}
}

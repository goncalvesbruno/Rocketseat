package br.com.bruno.primeiroprojetospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// Ano
@SpringBootApplication

// ComponentScan precisa ser usado quando há componentes em outras pastas
@ComponentScan(basePackages = "br.com.bruno")
public class PrimeiroProjetoSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroProjetoSpringbootApplication.class, args);
	}

}

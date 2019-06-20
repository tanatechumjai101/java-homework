package com.wongnai.interview;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
//@ComponentScan
public class Application implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		factory.setPort(8085);
	}
}

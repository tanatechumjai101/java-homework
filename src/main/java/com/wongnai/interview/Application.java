package com.wongnai.interview;

import com.wongnai.interview.movie.Movie;
import com.wongnai.interview.movie.MovieSearchService;
import com.wongnai.interview.movie.external.MoviesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.Resource;

@SpringBootApplication
@EnableJpaRepositories
//@ComponentScan
public class Application implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }


    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(8080);
    }

}

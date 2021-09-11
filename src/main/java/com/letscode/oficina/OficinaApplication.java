package com.letscode.oficina;

import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.domain.TelefoneCliente;
import com.letscode.oficina.repository.ClienteRepository;
import com.letscode.oficina.repository.TelefoneClienteRepository;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;
import org.springframework.r2dbc.core.DatabaseClient;

import java.time.Duration;
import java.util.Arrays;

@SpringBootApplication
public class OficinaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OficinaApplication.class, args);
    }

    @Bean
    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
        return initializer;
    }

    @Bean
    public CommandLineRunner insertValues(ClienteRepository repository) {
        return (args) -> {
            repository.saveAll(Arrays.asList(new Cliente("Jose"), new Cliente("Maria"), new Cliente("Mariano")))
                    .blockLast(Duration.ofSeconds(10));
        };
    }

    @Bean
    public CommandLineRunner insertTelefones(TelefoneClienteRepository repository) {
        return (args) -> {
            repository.saveAll(Arrays.asList(new TelefoneCliente("111111", "1"), new TelefoneCliente("333333", "1"), new TelefoneCliente("222222", "2"), new TelefoneCliente("99999", "3")))
                    .blockLast(Duration.ofSeconds(10));
        };
    }

}





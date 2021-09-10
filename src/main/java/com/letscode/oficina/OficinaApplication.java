package com.letscode.oficina;

import com.letscode.oficina.Repository.ClienteRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@SpringBootApplication
public class OficinaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OficinaApplication.class, args);
    }


    @Bean
    ApplicationRunner init(ClienteRepository repository, DatabaseClient Oficina) {
        return args -> {

            Oficina.sql("create table IF NOT EXISTS CLIENTE" +
                    "(id SERIAL PRIMARY KEY, nome varchar (255) not null);").fetch().first().subscribe();

            Oficina.sql("create table IF NOT EXISTS TELEFONECLIENTE" +
                    "(id SERIAL PRIMARY KEY, telefone varchar (255) not null, idCliente varchar (255)" +
                    //"foreign key (idCliente) references CLIENTE(id)" +
                    " );").fetch().first().subscribe();

            Oficina.sql("ALTER TABLE TELEFONECLIENTE ADD CONSTRAINT FK_CLIENTE_TELEFONE FOREIGN KEY (idCliente) REFERENCES CLIENTE(id)  ON DELETE CASCADE;").fetch().first().subscribe();





            //Oficina.sql("DELETE FROM CLIENTE;").fetch().first().subscribe();



        };
    }
}





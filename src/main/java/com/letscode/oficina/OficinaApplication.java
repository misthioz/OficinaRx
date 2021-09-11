package com.letscode.oficina;

import com.letscode.oficina.Repository.ClienteRepository;
import com.letscode.oficina.Repository.TelefoneClienteRepository;
import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.domain.TelefoneCliente;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

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




//    @Bean
//    ApplicationRunner init(ClienteRepository repository, DatabaseClient Oficina) {
//        return args -> {
//
//
//            Oficina.sql("create table IF NOT EXISTS CLIENTE" +
//                    "(id SERIAL PRIMARY KEY, nome varchar (255) not null, dataNascimento date, " +
//                    "enderecoComplemento varchar(255));").fetch().first().subscribe();
//
//
//
//
//            Oficina.sql("create table IF NOT EXISTS TELEFONECLIENTE" +
//                    "(id SERIAL PRIMARY KEY, telefone varchar (255) not null, idCliente varchar (255)" +
//                    //"foreign key (idCliente) references CLIENTE(id)" +
//                    " );").fetch().first().subscribe();
//
//            Oficina.sql("ALTER TABLE TELEFONECLIENTE ADD CONSTRAINT FK_CLIENTE_TELEFONE FOREIGN KEY (idCliente) REFERENCES CLIENTE(id)  ON DELETE CASCADE;").fetch().first().subscribe();


            //Oficina.sql("DELETE FROM CLIENTE;").fetch().first().subscribe();




}





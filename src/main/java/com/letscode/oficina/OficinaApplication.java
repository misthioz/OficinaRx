package com.letscode.oficina;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

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





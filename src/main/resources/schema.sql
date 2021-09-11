create table IF NOT EXISTS CLIENTE
(id SERIAL PRIMARY KEY, nome varchar (255) not null, data_nascimento date, cep varchar(255), enderecoComplemento varchar (255), enderecoNumero varchar(255));

create table IF NOT EXISTS CARRO
(id SERIAL PRIMARY KEY, placa varchar (255) not null, marca varchar (255), cor varchar (255), idcliente varchar (255) );
--ALTER TABLE CARRO ADD CONSTRAINT FK_CARRO_CLIENTE FOREIGN KEY (idCliente) REFERENCES CLIENTE(id)  ON DELETE CASCADE;

create table IF NOT EXISTS ESPECIALIDADE
(id SERIAL PRIMARY KEY, especialidade varchar (255) not null);

create table IF NOT EXISTS MECANICO
(id SERIAL PRIMARY KEY, nome varchar (255) not null, cep varchar(255), enderecoComplemento varchar (255), enderecoNumero varchar(255), idEspecialidade varchar (255));
--ALTER TABLE MECANICO ADD CONSTRAINT FK_MECANICO_ESPECIALIDADE FOREIGN KEY (idEspecialidade) REFERENCES MECANICO(id)  ON DELETE CASCADE;

create table IF NOT EXISTS TELEFONECLIENTE
(id SERIAL PRIMARY KEY, telefone varchar (255) not null, idCliente varchar (255));
--ALTER TABLE TELEFONECLIENTE ADD CONSTRAINT FK_CLIENTE_TELEFONE FOREIGN KEY (idCliente) REFERENCES CLIENTE(id)  ON DELETE CASCADE;

create table IF NOT EXISTS ORDEMSERVICO
(id SERIAL PRIMARY KEY, idCarro varchar(255), idMecanico varchar(255), idCliente varchar(255), status varchar(255), data date);
--ALTER TABLE ORDEMSERVICO ADD CONSTRAINT FK_OS_CARRO FOREIGN KEY (idCarro) REFERENCES CARRO(id)  ON DELETE CASCADE;
--ALTER TABLE ORDEMSERVICO ADD CONSTRAINT FK_OS_MECANICO FOREIGN KEY (idMecanico) REFERENCES MECANICO(id)  ON DELETE CASCADE;
--ALTER TABLE ORDEMSERVICO ADD CONSTRAINT FK_OS_CLIENTE FOREIGN KEY (idCliente) REFERENCES CLIENTE(id)  ON DELETE CASCADE;









use venda;
CREATE TABLE cliente (
       cli_codigo           INT auto_increment,
       cli_nome             VARCHAR(30) NOT NULL,
       cli_endereco         VARCHAR(30),
       cli_cidade           VARCHAR(30),
       cli_cep              VARCHAR(10),
       cli_estado           VARCHAR(2),
       cli_cpf              VARCHAR(11),
       PRIMARY KEY (cli_codigo)
);


CREATE TABLE vendedor (
       ven_codigo           INT auto_increment,
       ven_nome             VARCHAR(30) NOT null,
       ven_salario_fixo     DECIMAL(10,2),
       PRIMARY KEY (ven_codigo)
);


CREATE TABLE pedido (
       ped_numero           INT auto_increment,
       ven_codigo           INT,
       cli_codigo           INT,
       ped_prazo_entrega    INT,
       ped_data             DATE,
       ped_valor_total      DECIMAL(10,2),
       PRIMARY KEY (ped_numero), 
       FOREIGN KEY (ven_codigo)
                             REFERENCES vendedor (ven_codigo), 
       FOREIGN KEY (cli_codigo)
                             REFERENCES cliente(cli_codigo)
);


CREATE TABLE telefone (
       tel_codigo           INT auto_increment,
       cli_codigo           INT,
       tel_numero           VARCHAR(18),
       PRIMARY KEY (tel_codigo), 
       FOREIGN KEY (cli_codigo)
                             REFERENCES cliente (cli_codigo)
);


CREATE TABLE produto (
       pro_codigo           INT auto_increment,
       prod_descricao       VARCHAR(10),
       pro_quantidade       INT,
       pro_valor_unidade    DECIMAL(10,2),
       PRIMARY KEY (pro_codigo)
);


CREATE TABLE item_pedido (
       pro_codigo           INT ,
       item_quantidade      INT,
       ped_numero           INT,
       PRIMARY KEY (pro_codigo, ped_numero), 
       FOREIGN KEY (pro_codigo) REFERENCES produto (pro_codigo), 
       FOREIGN KEY (ped_numero) REFERENCES pedido (ped_numero)
);




-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2024-08-16 22:28:44.031

-- tables
-- Table: Forncedor
CREATE TABLE Forncedor (
    for_id int  NOT NULL,
    for_nome varchar(30)  NOT NULL,
    CONSTRAINT Forncedor_pk PRIMARY KEY (for_id)
);

-- Table: ItemPedido
CREATE TABLE ItemPedido (
    Pedido_ped_id int  NOT NULL,
    Peca_pec_id int  NOT NULL,
    Peca_quantidade int  NOT NULL,
    Peca_valor int  NOT NULL,
    CONSTRAINT Pedido_Peca_pk PRIMARY KEY (Pedido_ped_id,Peca_pec_id)
) COMMENT 'Itens do pedido.';

-- Table: Peca
CREATE TABLE Peca (
    pec_id int  NOT NULL COMMENT 'identificador da peça',
    pec_descricao varchar(30)  NOT NULL COMMENT 'descrição da peça',
    pec_valor decimal(8,2)  NOT NULL COMMENT 'valor da peça.',
    Forncedor_for_id int  NOT NULL,
    CONSTRAINT Peca_pk PRIMARY KEY (pec_id)
) COMMENT 'Armazena as peças do estoque.';

-- Table: Pedido
CREATE TABLE Pedido (
    ped_id int  NOT NULL COMMENT 'identificador da tabela pedido.',
    ped_data date  NOT NULL COMMENT 'data que foi realizado o pedido.',
    ped_valor decimal(8,2)  NOT NULL COMMENT 'valor total  do pedido.',
    CONSTRAINT Pedido_pk PRIMARY KEY (ped_id)
) COMMENT 'Armazena os pedidos realizados.';

-- End of file.


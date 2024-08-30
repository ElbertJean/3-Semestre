Nome: Elbert Jean dos Santos

CREATE DATABASE bdpratica01;

USE bdpratica01;

CREATE TABLE cinema (
  cin_cod INT PRIMARY KEY,
  cin_nomeFantasia VARCHAR(18) NOT NULL,
  cin_rua VARCHAR(20),
  cin_avenida VARCHAR(20),
  cin_bairro VARCHAR(10),
  cin_municipio VARCHAR(20),
  cin_estado VARCHAR(18),
  cin_capacidade_lotacao INT NOT NULL,
  CHECK (cin_estado IN ('São Paulo', 'Rio de Janeiro', 'Minas Gerais')),
  CHECK (cin_capacidade_lotacao > 0)
);

CREATE TABLE genero (
  gen_codigo INT PRIMARY KEY,
  gen_descricao VARCHAR(18)
);

CREATE TABLE tipo (
  tip_codigo INT PRIMARY KEY,
  tip_descricao VARCHAR(18)
);

CREATE TABLE ator (
  ato_codigo INT PRIMARY KEY,
  ato_nome VARCHAR(20),
  ato_nacionalidade VARCHAR(20),
  ato_idade INT
);

CREATE TABLE filme (
  fil_cod INT PRIMARY KEY,
  gen_codigo INT,
  tip_codigo INT,
  ato_codigo INT,
  fil_titulo_original VARCHAR(18) NOT NULL,
  fil_titulo_portugues VARCHAR(18) UNIQUE,
  fil_duracao INT NOT NULL,
  fil_pais_origem VARCHAR(15),
  CHECK (fil_duracao > 0),
  FOREIGN KEY (gen_codigo) REFERENCES genero(gen_codigo),
  FOREIGN KEY (tip_codigo) REFERENCES tipo(tip_codigo),
  FOREIGN KEY (ato_codigo) REFERENCES ator(ato_codigo)
);

CREATE TABLE filme_cinema (
  fil_codigo INT,
  cin_codigo INT,
  PRIMARY KEY (fil_codigo, cin_codigo),
  FOREIGN KEY (cin_codigo) REFERENCES cinema(cin_cod),
  FOREIGN KEY (fil_codigo) REFERENCES filme(fil_cod)
);

CREATE TABLE sessao (
  ses_cod INT PRIMARY KEY,
  fil_codigo INT,
  cin_codigo INT,
  sec_hora_inicial TIME NOT NULL,
  ses_hora_final TIME NOT NULL,
  sec_total_pessoas INT,
  FOREIGN KEY (fil_codigo) REFERENCES filme(fil_cod),
  FOREIGN KEY (cin_codigo) REFERENCES cinema(cin_cod),
  CHECK (ses_hora_final > sec_hora_inicial),
  CHECK (sec_total_pessoas > 0)
);

CREATE TABLE ator_filme (
  ato_codigo INT,
  fil_codigo INT,
  PRIMARY KEY (ato_codigo, fil_codigo),
  FOREIGN KEY (ato_codigo) REFERENCES ator(ato_codigo),
  FOREIGN KEY (fil_codigo) REFERENCES filme(fil_cod)
);

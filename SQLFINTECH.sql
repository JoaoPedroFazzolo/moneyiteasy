CREATE TABLE tb_usuario
(
    id_usuario   INT PRIMARY KEY,
    nome_usuario VARCHAR2(255) NOT NULL,
    nr_cpf       VARCHAR2(14) NOT NULL,
    criacao_user DATE,
    ds_email     VARCHAR2(150)
);

CREATE SEQUENCE sq_tb_usuario
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE tb_login
(
    ds_email VARCHAR2(150) PRIMARY KEY,
    ds_senha VARCHAR2(50) NOT NULL
);

ALTER TABLE tb_usuario
    ADD CONSTRAINT fk_ds_email
        FOREIGN KEY (ds_email)
            REFERENCES tb_login (ds_email);

CREATE TABLE tb_receita
(
    id_receita    INT PRIMARY KEY,
    valor_receita DECIMAL(10, 2) NOT NULL,
    dt_receita    DATE,
    id_categoria  INT,
    id_usuario    INT
);

CREATE TABLE tb_despesa
(
    id_despesa    INT PRIMARY KEY,
    valor_despesa DECIMAL(10, 2) NOT NULL,
    dt_despesa    DATE,
    id_categoria  INT,
    id_usuario    INT
);

CREATE TABLE tb_investimento
(
    id_investimento    INT PRIMARY KEY,
    valor_investimento DECIMAL(10, 2) NOT NULL,
    dt_investimento    DATE,
    id_categoria       INT,
    id_usuario         INT
);

CREATE TABLE tb_categoria
(
    id_categoria   INT PRIMARY KEY,
    nome_categoria VARCHAR2(50) NOT NULL,
    tipo           VARCHAR2(20) NOT NULL CHECK (tipo IN ('RECEITA', 'DESPESA', 'INVESTIMENTO'))
);

CREATE SEQUENCE sq_tb_categoria
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE sq_tb_receita
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE sq_tb_despesa
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE sq_tb_investimento
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;

ALTER TABLE tb_receita
    ADD CONSTRAINT fk_id_categoria_receita
        FOREIGN KEY (id_categoria)
            REFERENCES tb_categoria (id_categoria);

ALTER TABLE tb_receita
    ADD CONSTRAINT fk_id_usuario_receita
        FOREIGN KEY (id_usuario)
            REFERENCES tb_usuario (id_usuario);

ALTER TABLE tb_despesa
    ADD CONSTRAINT fk_id_categoria_despesa
        FOREIGN KEY (id_categoria)
            REFERENCES tb_categoria (id_categoria);

ALTER TABLE tb_despesa
    ADD CONSTRAINT fk_id_usuario_despesa
        FOREIGN KEY (id_usuario)
            REFERENCES tb_usuario (id_usuario);

ALTER TABLE tb_investimento
    ADD CONSTRAINT fk_id_categoria_investimento
        FOREIGN KEY (id_categoria)
            REFERENCES tb_categoria (id_categoria);

ALTER TABLE tb_investimento
    ADD CONSTRAINT fk_id_usuario_investimento
        FOREIGN KEY (id_usuario)
            REFERENCES tb_usuario (id_usuario);

CREATE TABLE tb_conta
(
    id_conta   INT PRIMARY KEY,
    nome_conta VARCHAR2(100) NOT NULL,
    id_usuario INT
);

ALTER TABLE tb_conta
    ADD CONSTRAINT fk_id_usuario_conta
        FOREIGN KEY (id_usuario)
            REFERENCES tb_usuario (id_usuario);


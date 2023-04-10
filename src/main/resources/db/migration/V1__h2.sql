DROP TABLE usuario if EXISTS ;

create table usuario(
    id bigint       not null auto_increment,
    email           varchar(150)    not null    unique,
    nome            varchar(150)    not null,
    senha           varchar(10)     not null,
    tipoUsuario_id  bigint          not null,
    ativo           BOOLEAN         not null,
    data            DATE            not null,
    logradouro      varchar(150),
    cep             varchar(8),
    numero          INTEGER,

    primary key(id)
);

create table tipousuario(
    id              bigint not null auto_increment,
    nome            varchar(20) not null,

    primary key(id)
);

INSERT INTO tipousuario (nome) VALUES ('USUARIO');
INSERT INTO tipousuario (nome) VALUES ('ADMINISTRADOR');

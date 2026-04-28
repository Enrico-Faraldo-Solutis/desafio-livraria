create database if not exists livraria;
use livraria;

create table if not exists vendas (
    numero int primary key auto_increment,
    cliente varchar(255),
    valor decimal(19,4)
);

create table if not exists livro_impresso (
	id int primary key auto_increment,
    titulo varchar(255),
    autores varchar(255),
    editora varchar(255),
    preco decimal(19,4),
    frete decimal(19,4),
    estoque int
);

create table if not exists livro_eletronico (
	id int primary key auto_increment,
    titulo varchar(255),
    autores varchar(255),
    editora varchar(255),
    preco decimal(19,4),
    tamanho int
);

create table if not exists livro_impresso_vendas(
    fk_livro_impresso int,
    fk_vendas int,
    primary key(fk_livro_impresso, fk_vendas),
    foreign key (fk_vendas) references vendas(numero),
    foreign key (fk_livro_impresso) references livro_impresso(id)
);

create table if not exists livro_eletronico_vendas(
    fk_livro_eletronico int,
    fk_vendas int,
    primary key(fk_livro_eletronico, fk_vendas),
    foreign key (fk_vendas) references vendas(numero),
    foreign key (fk_livro_eletronico) references livro_eletronico(id)
);
# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table contato (
  id                            integer auto_increment not null,
  nome                          varchar(255),
  email                         varchar(255),
  telefone                      varchar(255),
  constraint pk_contato primary key (id)
);


# --- !Downs

drop table if exists contato;


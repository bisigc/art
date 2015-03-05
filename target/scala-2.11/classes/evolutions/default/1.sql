# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table eeppidata (
  id                        bigint not null,
  from_service              varchar(255),
  json_data                 varchar(255),
  created                   timestamp,
  constraint pk_eeppidata primary key (id))
;

create sequence eeppidata_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists eeppidata;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists eeppidata_seq;


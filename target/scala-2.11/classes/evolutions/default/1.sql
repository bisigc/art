# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table eeppidata (
  id                        bigint auto_increment not null,
  from_service              varchar(255),
  json_data                 varchar(255),
  created                   datetime,
  constraint pk_eeppidata primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table eeppidata;

SET FOREIGN_KEY_CHECKS=1;


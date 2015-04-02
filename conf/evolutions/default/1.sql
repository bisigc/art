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

create table property (
  id                        bigint auto_increment not null,
  categorie                 varchar(255),
  key                       varchar(255),
  name                      varchar(255),
  description               varchar(255),
  orderidx                  integer,
  constraint pk_property primary key (id))
;

create table smell (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  description               varchar(255),
  keywords                  varchar(255),
  weight                    double,
  group_id                  bigint,
  tecdebtidx                varchar(255),
  modified                  timestamp,
  created                   timestamp,
  constraint pk_smell primary key (id))
;

create sequence eeppidata_seq;

alter table smell add constraint fk_smell_group_1 foreign key (group_id) references property (id) on delete restrict on update restrict;
create index ix_smell_group_1 on smell (group_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists eeppidata;

drop table if exists property;

drop table if exists smell;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists eeppidata_seq;


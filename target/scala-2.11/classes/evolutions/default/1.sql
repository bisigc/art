# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table menuitem (
  id                        bigint auto_increment not null,
  menuitem_id               bigint not null,
  name                      varchar(255),
  fullname                  varchar(255),
  tooltip                   varchar(255),
  image                     varchar(255),
  type                      varchar(255),
  url                       varchar(255),
  pos                       varchar(255),
  ordering                  integer,
  constraint pk_menuitem primary key (id))
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

alter table menuitem add constraint fk_menuitem_menuitem_1 foreign key (menuitem_id) references menuitem (id) on delete restrict on update restrict;
create index ix_menuitem_menuitem_1 on menuitem (menuitem_id);
alter table smell add constraint fk_smell_group_2 foreign key (group_id) references property (id) on delete restrict on update restrict;
create index ix_smell_group_2 on smell (group_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists menuitem;

drop table if exists property;

drop table if exists smell;

SET REFERENTIAL_INTEGRITY TRUE;


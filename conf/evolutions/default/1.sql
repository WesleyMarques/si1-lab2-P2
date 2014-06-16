# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table meta (
  id                        bigint not null,
  priority                  integer,
  name_meta                 varchar(255),
  week                      integer,
  is_done                   boolean,
  constraint pk_meta primary key (id))
;

create sequence meta_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists meta;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists meta_seq;


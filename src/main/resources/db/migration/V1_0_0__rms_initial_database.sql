create schema if not exists rms;

set search_path to rms;

create table if not exists user_role(
    id                  numeric(19, 0) primary key,
    name                varchar(64) not null unique
);
create sequence if not exists user_role_seq increment by 1 minvalue 1 maxvalue 999999999999999999 cache 10 no cycle;

create table if not exists rms.user(
    id                  numeric(19, 0) primary key,
    first_name          varchar(64),
    last_name           varchar(64),
    email               varchar(124) not null unique,
    phone               varchar(16) unique,
    image               bytea,
    user_role_id        numeric(19, 0) not null references user_role (id)
);
create sequence if not exists user_seq increment by 1 minvalue 1 maxvalue 999999999999999999 cache 10 no cycle;

create table if not exists room(
    id                  numeric(19, 0) primary key,
    number              integer not null unique,
    capacity            integer not null,
    daily_cost          float not null,
    surface             float not null
);
create sequence if not exists room_seq increment by 1 minvalue 1 maxvalue 999999999999999999 cache 10 no cycle;

create table if not exists room_status(
    id                  numeric(19, 0) primary key,
    name                varchar(64) not null unique
);
create sequence if not exists room_status_seq increment by 1 minvalue 1 maxvalue 999999999999999999 cache 10 no cycle;

create table if not exists user_room(
    user_id             numeric(19, 0) references rms.user (id) not null,
    room_id             numeric(19, 0) references room (id) not null,
    date_from           date not null,
    date_to             date not null,
    room_status_id      numeric(19 ,0) references room_status (id) not null
);

create table if not exists room_images(
    id                  numeric(19, 0) primary key,
    image               bytea not null unique,
    room_id             numeric(19, 0) not null references room (id)
);
create sequence if not exists room_images_seq increment by 1 minvalue 1 maxvalue 999999999999999999 cache 10 no cycle;
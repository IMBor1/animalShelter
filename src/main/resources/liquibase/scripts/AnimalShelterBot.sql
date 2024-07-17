-- liquibase formatted sql

--changeset BIlya:1
create table Client (
id Serial,
chat_Id Integer primary key,
name Text,
has_pet Boolean,
phone Text,
timer timeStamp,
probationary_period Integer);

--changeset anton22582258:create_photo
create table photo
(
    id         bigserial primary key,
    file_size  bigint,
    media_type text,
    path       text,
    dog_id     bigint
);

--changeset anton22582258:create_dog
create table dog
(
    id                         bigserial primary key,
    name                       varchar(255),
    age                        int,
    is_healthy                 boolean,
    is_adopted                 boolean,
    client_id                    bigint,
    photo_id                     bigint
);

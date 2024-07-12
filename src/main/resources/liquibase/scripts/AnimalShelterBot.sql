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


-- liquibase formatted sql

--changeset BIlya:1
create table Client (
id Serial,
chat_Id Integer primary key,
name Text,
has_pet Boolean,
phone Text,
timer timeStamp);

--changeset anton22582258:create_shelter
create table shelter
(
    id                                      bigserial primary key,
    greeting                                text,
    info                                    text,
    dating_rules                            text,
    adoption_documents                      text,
    transportation_recommendations          text,
    recommendations_arranging_baby          text,
    recommendations_arranging_adult         text,
    recommendations_arranging_with_features text
);
--changeset anton22582258:create_photo
create table photo
(
    id         bigserial primary key,
    file_size  bigint,
    media_type text,
    path       text
);
-- liquibase formatted sql
--changeset anton22582258:insert_shelter
insert into shelter (greeting, info, dating_rules, adoption_documents, transportation_recommendations,
                         recommendations_arranging_baby, recommendations_arranging_adult,
                         recommendations_arranging_with_features)
values ('Вас приветствует приют Петя. Пожалуйста выберите интересующее Вас действие:',
    'Тут сведения о местоположении',
    'Правила как взять животное',
    'Необходимые документы',
    'Рекомендации по транспортировке',
    'Рекомендации по обустройству дома для щенка',
    'Рекомендации по обустройству дома для взрослой собаки',
    'Рекомендации по обустройству дома для собаки с особенностями')

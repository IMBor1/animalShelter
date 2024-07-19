package com.ourteam.animal_shelter.constants;

/**
 * @author Ilya Boriskin
 * The Class contains constants
 */
public class Constants {
    /**
     * Константа приветствия
     */
    public static final String MEET = "Привет! Я телеграм бот, Петя! Я взаимодействую с приютами и помогаю найти дом для собак.";
    /**
     * Информация о приюте
     */


    public static final String INFO_SHELTER = "Наш приют был основан в феврале 2019 года. За первый год мы сменили несколько локаций. С 2020 года мы базируемся здесь. Если раньше помещения не были адаптированы, то здесь подход был принципиально иным. Все было создано для животных, поэтому для них было комфортно";
    /**
     * График работы
     */
    public static final String SHEDULE = "Адрес приюта: Камергерский пер., 5/6, стр. 4, Москва, 125009. \n " +
            "Наш приют работает ежедневно с 9 до 20 часов";
    /**
     * Контакты для закзаза пропуска
     */
    public static final String GUARD_CONTACTS = " Для заказа пропуска свяжитесь с охраной по телефону 235-56-54";
    /**
     * Правила нахождения в приюте
     */
    public static final String RULES = """
            После входа и выхода из вольеров тщательно следите, чтобы двери были хорошо закрыты на щеколду.
                        
            "Перед прогулкой с собакой за территорией приюта проверьте целостность поводка, надёжность карабина, насколько туго затянут ошейник.\n" +
                        
            "Для угощения собак можно приносить только специальные собачьи лакомства.
                        
            "Перед тем, как взять на прогулку новую (незнакомую) собаку, спросите у старших волонтеров или работников, можно ли с ней гулять.\n" +
                        
            "Если у вас есть свои домашние питомцы и они случайно заболели, воздержитесь от приезда в приют.
                        
            "Перед началом проведения работ уточните у руководства, какие дела запланированы на сегодня.
                        
            "Если планируете помочь с уборкой, выгулом собак и делами по хозяйству, нужно брать с собой сменную одежду.
                        
            "Не заходите без опытных сопровождающих в вольеры с незнакомыми собаками.
                        
            "По территории приюта передвигайтесь спокойно, не бегайте, не машите руками, говорите спокойно.
                        
            "Если при вас собаки начали драку, не лезьте голыми руками их разнимать. Сразу зовите на помощь! Вам помогут опытные волонтеры или работники.
            """;
    /**
     * Номер волонтера
     */
    public static final String PHONE_VOLUNTEER = " Для связи с волонтером позвоните по телефону +7-900-100-20-10";
    /**
     * Запись контактных данных
     */
    public static final String CALL_BACK = "С вами свяжется волонтер в телеграме. Вы также можете оставить контактный телефон для обратного звонка.";
    /**
     * Правила знакомства с животным
     */
    public static final String RULES_FOR_MEETING_ANIMALS = """
            Если вы решили забрать собаку домой, просто приехать в приют и заявить о своем желании недостаточно. Как правило, человеку предстоит пройти несколько этапов.
                        
            "Знакомство с собакой. Важно, чтобы будущий владелец провел какое-то время с животным — узнал чуть больше о его характере и повадках.
                        
            "На первой встрече рекомендуется узнать как можно больше о биографии собаки у волонтеров и сотрудников приюта: как животное попало в приют, что известно о его происхождении и прошлой жизни, есть ли у него хронические заболевания, поведенческие проблемы и другие особенности. Исходя из этого, человек может более трезво оценить свои возможности.
            """;
    /**
     * Список документов для того чтобы взять питомца
     */
    public static final String DOCUMENTS_FOR_ADOPTION = """
            Какие документы нужны чтобы взять собаку из приюта?
            Какие документы нужны чтобы взять кошку из приюта?
            Если вы решились обзавестись новым членом семьи, ниже представлен список основных шагов и документов на собаку или кошку из приюта, которые у вас могут запросить (НЕ ВЕЗДЕ ДЕЙСТВУЮТ ОДИНАКОВЫЕ УСЛОВИЯ):
                        
            Заявление на усыновление:
            Вам нужно предоставить заявление в приют, в котором вы хотите усыновить собаку. В некоторых приютах это можно сделать онлайн, а в других — лично. Мы предоставляем универсальный образец стандартного заявления (шаблон договора о передаче животного).
            Документы, удостоверяющие личность:
            Паспорт гражданина России или иной документ, удостоверяющий личность. Копия и оригинал могут потребоваться для проверки личности.
            Документы о месте жительства:
            Справка о регистрации по месту жительства. Возможно, приют захочет удостовериться, что у вас достаточно места для содержания животного.
            Справка о доходах:
            В ряде приютов могут попросить предоставить справку о вашем финансовом положении. Это может быть необходимо для обеспечения достойного ухода за животным.
            Согласие членов семьи:
            Если у вас есть члены семьи, они также должны дать согласие на усыновление. Некоторые приюты могут попросить вас предоставить письменное согласие всех членов семьи, либо могут взять номера их телефонов, чтобы позвонить и убедиться в том, что они не против принятия нового члена семьи.\n" +
            Фотографии места проживания:
            Некоторые приюты могут попросить предоставить фотографии места, где будет проживать собака. Это делается для того, чтобы удостовериться, что условия будут комфортными для животного.
            Справка от ветеринара (если есть):
            Если у вас уже есть другие домашние животные, приют может запросить справку от ветеринара об их здоровье и прививках.
            Обязательство об уходе за животным:
            Некоторые приюты могут попросить вас подписать обязательство о том, что вы обеспечите должный уход за собакой. Такие обязательства могут быть прописаны в стандартном договоре о передаче животного.
            """;
    /**
     * Правила транспортировки животного
     */
    public static final String RULES_TRANSPORTATION = """
            Общие советы
                        
            Животные ни в коем случае не должны свободно перемещаться по салону автомобиля — они могут отвлекать вас от дороги или даже залезть под педали. Если вам кажется, что зверь будет мешать вести машину, откажитесь от поездки.
                        
            Как перевозить собак
                        
            Собак перевозят в наморднике с поводком или шлейкой. Если собака небольшая, её можно возить без поводков и намордников — в переноске.
                        
            Не все псы переносят поездки легко — у некоторых бывает стресс. Если у пассажира с собой подстилка, попросите постелить её на сиденье.
            """;
    /**
     * Рекомендации по обусртойству дома для щенка
     */
    public static final String RECOMENDATIONS_FOR_HOUSE_FOR_PUPPY = """
            Вот некоторые рекомендации по обустройству дома для щенка:
                        
            Выберите место для щенка в жилой комнате, а не в кладовке или прихожей.
                        
            Положите на это место мягкую подстилку или матрасик и какие-то личные вещи.
                        
            Позаботьтесь о том, чтобы в доме был корм для щенков.
                        
            С первого дня у щенка должна быть своя посуда для воды и для корма.
                        
            Позаботьтесь о безопасности щенка: уберите с пола мелкие предметы, которые он может случайно проглотить, электрические и телефонные провода, купите специальные игрушки.
                        
            В первые дни старайтесь не упускать щенка из виду.
                        
            Закажите для своего питомца индивидуальный жетон с именем и контактными данными.
                        
            С момента появления в доме приучайте щенка к порядку.
                        
            Подготовьте к приезду щенка аптечку, поводок и ошейник.
                        
            Если у вас есть дети, проведите с ними разъяснительную беседу и расскажите о том, как вести себя со щенком, чтобы не навредить ему.
            """;
    /**
     * Рекомендации по обустройству дома для взрослой собаки
     */
    public static final String RECOMENDATIONS_FOR_HOUSE_FOR_DOG = """
            Список рекомендаций по обустройству дома для взрослого животного:**\n" +
            "\n" +
            "**Обеспечение укрытия и безопасности:**\n" +
            "\n" +
            "* **Мягкая кровать или лежанка:** Убедитесь, что у вашего питомца есть удобное и безопасное место для сна и отдыха.\n" +
            "* **Потайные места:** Предоставьте своему питомцу закрытые пространства, такие как домик для кошки или кошачье дерево, где он может чувствовать себя в безопасности и защищенности.\n" +
            "\n" +
            "**Питание и вода:**\n" +
            "\n" +
            "* **Миски для еды и воды:** Выберите миски из нержавеющей стали или керамики, которые легко чистить. Расположите их в тихом и легкодоступном месте.\n" +
            "* **Автоматическая кормушка и поилка:** Если вы часто отсутствуете дома, рассмотрите возможность использования автоматической кормушки и поилки, чтобы обеспечить вашего питомца пищей и водой в ваше отсутствие.\n" +
            "\n" +
            "**Туалетные принадлежности:**\n" +
            "\n" +
            "* **Лоток или песочница:** Для кошек и мелких млекопитающих обеспечьте чистый и просторный лоток или песочницу. Для собак оборудуйте безопасную зону вне дома для туалета.\n" +
            "* **Мешки для мусора и совок:** Держите под рукой достаточное количество мешков для мусора и совок, чтобы регулярно убирать отходы.\n" +
            "\n" +
            "**Активизация и обогащение:**\n" +
            "\n" +
            "* **Игрушки:** Предоставьте вашему питомцу разнообразные игрушки, подходящие для его вида и возраста. Игрушки помогают стимулировать ум и предотвращать скуку.\n" +
            "* **Когтеточка или столбик для царапания:** Кошки нуждаются в возможности точить когти. Обеспечьте их когтеточкой или столбиком для царапания, чтобы предотвратить порчу мебели.\n" +
            "* **Поводок и ошейник:** Для собак необходимы надежный поводок и ошейник для прогулок и дрессировки.\n" +
            "\n" +
            "**Уход и гигиена:**\n" +
            "\n" +
            "* **Щетки и расчески:** Регулярно расчесывайте своего питомца, чтобы удалить спутанные волосы и улучшить кровообращение.\n" +
            "* **Купальное оборудование:** Для домашних животных, требующих купания, обеспечьте специальный шампунь, кондиционер и полотенца.\n" +
            "* **Средства для ухода за зубами:** Обеспечьте своего питомца зубной пастой и щеткой для поддержания здоровья зубов и десен.\n" +
            "\n" +
            "**Здоровье и безопасность:**\n" +
            "\n" +
            "* **Аптечка первой помощи:** Соберите аптечку первой помощи для животных с основными медикаментами и инструкциями по оказанию первой помощи.\n" +
            "* **Микрочип и идентификационный жетон:** Убедитесь, что ваш питомец имеет микрочип или идентификационный жетон с актуальной информацией для связи.\n" +
            "* **Ветеринарная клиника:** Найдите ближайшую ветеринарную клинику и держите под рукой ее контакты в случае возникновения чрезвычайной ситуации.
            """;
    /**
     * Рекомендации по обустройству дома для собак с огрниченными возможностями.
     */
    public static final String RECOMENDATIONS_FOR_HOUSE_FOR_INVALID_PETS = """
            Список рекомендаций по обустройству дома для животного с ограниченными возможностями (зрение, передвижение):
                        
            *Для животных с ограниченным зрением:
                        
            *Яркое освещение:** Убедитесь, что в доме достаточно света, чтобы животное могло легко ориентироваться.
            *Устранение препятствий:** Удалите все препятствия с пути животного, такие как мебель, провода и напольные покрытия со скользкой поверхностью.
            *Контрастные цвета:** Используйте контрастные цвета для стен, мебели и предметов, чтобы помочь животному различать объекты.
            *Звуковые сигналы:** Рассмотрите возможность использования звуковых сигналов, таких как колокольчики или звуковые маячки, чтобы помочь животному ориентироваться.
                        
            *Для животных с ограниченной подвижностью:
                        
            *Рампы и пандусы:** Обеспечьте рампы или пандусы для доступа к различным уровням дома.
            *Нескользящие поверхности:** Убедитесь, что полы и покрытия не скользкие, чтобы предотвратить падения.
            *Мягкая подстилка:** Обеспечьте обильную мягкую подстилку в местах, где животное проводит много времени, чтобы предотвратить образование пролежней.
            *Специальная мебель:** Рассмотрите возможность использования специальной мебели, такой как ортопедические кровати или инвалидные коляски для животных, для поддержки и комфорта.
                        
            *Общие рекомендации для животных с ограниченными возможностями:
                        
            *Безопасное пространство:** Создайте безопасное и свободное от стресса пространство, где животное может отдыхать и чувствовать себя защищенным.
            *Гигиена: Регулярно убирайте дом, чтобы поддерживать чистоту и предотвращать инфекции.
            *Питание и вода:** Убедитесь, что у животного есть легкий доступ к еде и воде.
            *Уход: Животным с ограниченными возможностями может потребоваться дополнительный уход, такой как помощь в купании, чистке зубов и уходе за шерстью.
            *Любовь и внимание:** Самое главное - обеспечить животному много любви, внимания и поддержки.
            """;
    /**
     * Советы кинологов по первичному взаимодействию с собакой.
     */
    public static final String DOGS_HANDLERS_ADVICE_ON_PRIMARY_COMUNICATION = """
            Советы кинолога по первичному общению с собакой:
                        
            *Понимание языка тела собаки:
                        
            * Учитесь распознавать признаки страха, агрессии, возбуждения и расслабления в языке тела собаки.
            * Обращайте внимание на положение ушей, хвоста, глаз и тела.
                        
            *Спокойный и уверенный подход:
                        
            "* Приближайтесь к собаке спокойно и не спеша.
            "* Избегайте прямых зрительных контактов, так как это может восприниматься как угроза.
            "* Присядьте или встаньте на колени, чтобы казаться менее устрашающим.
                        
            *Уважение личного пространства:
                       
            * Дайте собаке время и пространство для знакомства с вами на ее условиях.
            * Не навязывайте свое внимание и не пытайтесь сразу погладить ее.
                        
            *Положительное подкрепление:
                        
            * Вознаграждайте собаку угощениями, похвалами и игрой за хорошее поведение.
            * Избегайте наказаний, так как они могут подорвать доверие и сделать собаку более агрессивной.\n" +
                        
            "**Общение через игру:
                        
            * Игра - отличный способ установить связь с собакой и укрепить ваши отношения.
            * Выбирайте игры, которые подходят для возраста, размера и темперамента собаки.
                        
            *Четкие команды:
                        
            * Используйте короткие, четкие команды и жесты для общения с собакой.
            * Будьте последовательны в своих командах и вознаграждайте собаку за выполнение.
                        
            "**Социализация:
                        
            * Постепенно знакомьте собаку с другими людьми, животными и окружающей средой.
            * Положительные впечатления во время социализации помогут собаке стать более уверенной и менее реактивной.\n" +
                        
            *Терпение и понимание:
                        
            * Каждая собака уникальна, поэтому наладить общение с ней может потребоваться время и терпение.\n" +
            * Не расстраивайтесь, если собака не реагирует сразу, продолжайте работать над установлением связи в положительной и уважительной манере.
            """;
    /**
     * Список проверенных кинологов.
     */
    public static final String DOG_HANDLERS = """
            Проверенные кинологи для дальнейшего обращения:
                        
            "*Россия:
                        
            *Российская кинологическая федерация (РКФ)**: https://rkf.org.ru/experts/
            *Московский городской кинологический центр (МГКЦ)**: https://mgkc.ru/
            *Ассоциация практикующих кинологов (АПК)**: https://apkrf.ru/experts/
                        
            *Украина:
                        
            *Кинологический союз Украины (КСУ)**: https://kcu.org.ua/ru/experts/
            *Украинская кинологическая ассоциация (УКА)**: http://uka.com.ua/experts/
                        
            *Беларусь:
                        
            *Белорусский кинологический союз (БКС)**: https://bks.by/experts/
                        
            *Международные организации:
                        
            *Международная кинологическая федерация (FCI)**: https://www.fci.be/en/
            *Американский клуб собаководства (AKC): https://www.akc.org/
            *Канадский кинологический клуб (CKC)**: https://www.ckc.ca/
                        
            "При выборе кинолога рекомендуется учитывать его специализацию, опыт, отзывы и местоположение. Вы можете связаться с кинологическими организациями в вашем регионе, чтобы получить рекомендации или найти сертифицированных кинологов." +
            """;
    /**
     * Возможные причины для отказа в усыновлении.
     */
    public static final String REASONS_FOR_REFUSAL = """ 
            Список причин, почему могут отказать в выдаче собаки из приюта:
                        
             *Несоответствие требованиям:
              Приют может установить определенные требования к потенциальным владельцам, такие как возраст, образ жизни и опыт содержания животных. Если вы не соответствуете этим требованиям, вам могут отказать в выдаче собаки.
            *Неподходящий дом:** Приют проверит ваш дом, чтобы убедиться, что он безопасен и подходит для собаки. Если ваш дом не соответствует стандартам приюта, вам могут отказать в выдаче собаки.
            *Недостаточный опыт:** Если у вас нет опыта содержания собак или вы не можете продемонстрировать, что вы готовы взять на себя ответственность за собаку, вам могут отказать в выдаче.
            *Негативная история обращения с животными:** Если у вас есть история жестокого обращения с животными или пренебрежения ими, вам могут отказать в выдаче собаки.
            *Сомнения относительно мотивов: Приют может отклонить вашу заявку, если у них есть сомнения относительно ваших мотивов для получения собаки, например, если вы планируете использовать собаку для разведения или в качестве сторожевого животного.
            *Негативные рекомендации: Если приют получит негативные рекомендации от ваших предыдущих арендодателей, соседей или ветеринаров, вам могут отказать в выдаче собаки.
            *Слишком много домашних животных: Приют может ограничить количество домашних животных, которых может содержать один человек. Если у вас уже есть много домашних животных, вам могут отказать в выдаче собаки.
            *Медицинские ограничения:** Если у вас аллергия на собак или другие медицинские ограничения, которые могут помешать вам обеспечить надлежащий уход за собакой, вам могут отказать в выдаче.
            *Финансовые проблемы: Приюты могут потребовать доказательства того, что у вас есть финансовые возможности, чтобы обеспечить собаке надлежащий уход. Если вы не можете продемонстрировать финансовую стабильность, вам могут отказать в выдаче собаки.
            *Другие факторы: Каждый приют может иметь свои собственные дополнительные факторы, которые могут повлиять на решение о выдаче собаки. Например, некоторые приюты могут отдавать предпочтение семьям с детьми или людям, имеющим большой опыт содержания определенных пород собак.
            """;
    /**
     * Поздравление с усыновлением.
     */
    public static final String CONGRATULATIONS = "Поздравляем! Свяжитесь, пожалуйста с нашим питомником по телефону 235-13-42";
    /**
     * Напоминание клиенту о непредоставлении отчета.
     */
    public static final String REMINDER = "Здравствуйте! Сегодня от вас не пришло отчета, просьба прислать отчет. Напоминаю о необходимости присылать отчет ежедневно.";
    /**
     * Напоминание волонтеру о непредоставлении клиентом отчета.
     */
    public static final String REMINDER_TO_VOLUNTEER = " пользователь не присылал отчет уже 2 дня.";
    /**
     * Просьба связаться волонтера с клиентом.
     */
    public static final String MESSAGE_TO_CLIENT = " у этого пользователя возникли вопросы. Пожалуйста, свяжитесь с ним.";
    /**
     * Сообщение волонтеру, что испытательный срок 30 дней прошел.
     */
    public static final String PROBATIONARY_PERIOD_30_DAYS_HAS_ENDED = "Испытательный срок 30 дней прошел";
    /**
     * Сообщение волонтеру, что испытательный срок 14 дней прошел.
     */
    public static final String PROBATIONARY_PERIOD_14_DAYS_HAS_ENDED = "Испытательный срок 14 дней прошел";
    public final static String WARNING_NO_DESCRIPTION = "Добавьте описание, чтобы завершить отчет о вашем питомце! Иначе отчет не сохранится!";
    public final static String WARNING_REPORT_NOT_CORRECT = "Дорогой усыновитель, мы заметили, что ты заполняешь отчет не так подробно, как необходимо. \n " +
            "Пожалуйста, подойди ответственнее к этому занятию. В противном случае волонтеры приюта будут обязаны самолично проверять условия содержания животного";
    public final static String YOU_ARE_NOT_CLIENT = "Отчеты могут отправлять только усыновители! Усыновите питомца, для отправки отчетов!";
}

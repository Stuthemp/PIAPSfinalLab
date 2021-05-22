package com.example.piapslastlabs.data;

import com.example.piapslastlabs.R;
import com.example.piapslastlabs.model.QuestionImage;
import com.example.piapslastlabs.model.QuestionInterface;
import com.example.piapslastlabs.model.QuestionMusic;
import com.example.piapslastlabs.model.QuestionText;
import com.example.piapslastlabs.model.Theme;
import com.example.piapslastlabs.model.ThemeType;
import com.example.piapslastlabs.model.theme.ThemeFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuestionsDatabase implements Serializable {

    public  List<QuestionInterface> questionsList;

    private static QuestionsDatabase questionsDatabase;

    private QuestionsDatabase(){
        questionsList = new ArrayList<>();
        questionsList.add(new QuestionText("В каком городе проводились олимпийские игры 1980г.?","Москва","Пекин",
                "Афины","Токио",200, ThemeFactory.createTheme(ThemeType.SPORT)));
        questionsList.add(new QuestionText("Длительность хоккейного матча?","60 мин.","70 мин.",
                "80 мин.","90 мин.",200, ThemeFactory.createTheme(ThemeType.SPORT)));
        questionsList.add(new QuestionText("Обладатель мирового рекорда в беге на 200 метров у мужчин?","Усейн Болт","Уолтер Дикс",
                "Йохан Блейк","Майкл Марш",100, ThemeFactory.createTheme(ThemeType.SPORT)));
        questionsList.add(new QuestionText("Сколько очков начисляют в баскетболе за штрафной бросок?","1","2",
                "3","4",200, ThemeFactory.createTheme(ThemeType.SPORT)));
        questionsList.add(new QuestionText("Победители АПЛ 2003/04?","Арсенал","Манчестер Юнайтед",
                "Челси","Лестер Сити",400, ThemeFactory.createTheme(ThemeType.SPORT)));
        questionsList.add(new QuestionText("На лого какой команды изображен бык?","Чикаго Булз","Юта Джаз",
                "Лос-Анджелес Лайкерс","Денвер Наггетс",100, ThemeFactory.createTheme(ThemeType.SPORT)));
        questionsList.add(new QuestionText("Второй по популярности спорт в мире?","Крикет","Баскетбол",
                "Бейсбол","Хоккей",200, ThemeFactory.createTheme(ThemeType.SPORT)));
        questionsList.add(new QuestionImage("Faker","Jankos","Perkz","Nemesis",200,
                ThemeFactory.createTheme(ThemeType.SPORT), R.drawable.faker_question));
        questionsList.add(new QuestionImage("Японский","Китайский","Корейский","Вьетнамский",
                200, ThemeFactory.createTheme(ThemeType.SCIENCE), R.drawable.japanese_question));
        questionsList.add(new QuestionImage("Арабский","Иврит","Турецкий","Монгольский",
                100, ThemeFactory.createTheme(ThemeType.SCIENCE), R.drawable.arabic_question));
        questionsList.add(new QuestionImage("Шумерский","Рванда-рунди","Филипинский","Кмерский",
                400, ThemeFactory.createTheme(ThemeType.SCIENCE), R.drawable.shumer_question));
        questionsList.add(new QuestionImage("Кожухов","Павлов","Смирнов","Щербаков",
                400, ThemeFactory.createTheme(ThemeType.SCIENCE), R.drawable.kojan));
        questionsList.add(new QuestionImage("Крылья Советов","Тамбов","Арсенал","Зенит",
                400, ThemeFactory.createTheme(ThemeType.SPORT), R.drawable.krilia_sowetow));
        questionsList.add(new QuestionImage("Роналду К.","Мэсси Л.","Пепе","Роналдиньо",
                100, ThemeFactory.createTheme(ThemeType.SPORT), R.drawable.ronaldo_question));
        questionsList.add(new QuestionImage("02","20","13","22",
                100, ThemeFactory.createTheme(ThemeType.ENTERTAINMENT), R.drawable.zero_two_question));
        questionsList.add(new QuestionImage("Унесенные призараками","Ходячий замок","Мой сосед Тоторо","Форма голоса",
                100, ThemeFactory.createTheme(ThemeType.ENTERTAINMENT), R.drawable.unesennye_prizrakami));
        questionsList.add(new QuestionImage("Криминальное чтиво","Бешеные псы","Омерзительная восьмерка","Славные парни",
                100, ThemeFactory.createTheme(ThemeType.ENTERTAINMENT), R.drawable.pulp_fiction));
        questionsList.add(new QuestionImage("loltyler1","s1mple","kliluk","yamatosdeath1",
                200, ThemeFactory.createTheme(ThemeType.ENTERTAINMENT), R.drawable.tyler1));
        questionsList.add(new QuestionImage("DotA","LoL","HotS","SMITE",
                100, ThemeFactory.createTheme(ThemeType.ENTERTAINMENT), R.drawable.dota_question));
        questionsList.add(new QuestionImage("LoL","DotA","HotS","SMITE",
                100, ThemeFactory.createTheme(ThemeType.ENTERTAINMENT), R.drawable.league_question));
        questionsList.add(new QuestionImage("Словения","Словакия","Хорватия","Сербия",
                400, ThemeFactory.createTheme(ThemeType.GEOGRAPHY), R.drawable.slovenia_question));
        questionsList.add(new QuestionImage("Польша","Индонезия","Монако","Сингапур",
                100, ThemeFactory.createTheme(ThemeType.GEOGRAPHY), R.drawable.polsha_question));
        questionsList.add(new QuestionImage("Уганда","Замбия","Лесото","Нигерия",
                200, ThemeFactory.createTheme(ThemeType.GEOGRAPHY), R.drawable.uganda_question));
        questionsList.add(new QuestionImage("Уинстон Черчилль","Рихард Зорге","Лирой Дженкинс","Нильсон Манделла",
                100, ThemeFactory.createTheme(ThemeType.HISTORY), R.drawable.cherchil));
        questionsList.add(new QuestionImage("Рихард Зорге","Лирой Дженкинс","Сильвернейм","Нильсон Манделла",
                400, ThemeFactory.createTheme(ThemeType.ART), R.drawable.riharb));
        questionsList.add(new QuestionMusic("Смертокрыл","Лирой Дженкинс","Алтран","Паллатин",
                200, ThemeFactory.createTheme(ThemeType.ENTERTAINMENT), R.raw.death_wing));
        questionsList.add(new QuestionMusic("Украина","СССР","РФ","Беларусь",
                100, ThemeFactory.createTheme(ThemeType.GEOGRAPHY), R.raw.ukrain_gimn));
        questionsList.add(new QuestionMusic("Токийский гуль","Евангелион","Наруто","Саске",
                400, ThemeFactory.createTheme(ThemeType.GEOGRAPHY), R.raw.tokyo_ghoul));

        questionsList.add(new QuestionText("Какое место заняла россия на чм 2018 по футболу?","8","3",
                "11","5",200, ThemeFactory.createTheme(ThemeType.SPORT)));

        questionsList.add(new QuestionText("Максимальное количество побед в Формуле-1 принадлежит?","Ferrari","Renault",
                "McLaren","Mercedes",400, ThemeFactory.createTheme(ThemeType.SPORT)));

        questionsList.add(new QuestionText("Какая команда выиграла The International 2 раза подряд?","OG","Evil Geniuses",
                "Alliance","Natus Vincere",400, ThemeFactory.createTheme(ThemeType.SPORT)));

        questionsList.add(new QuestionText("C2H5OH","Этиловый спирт","Глюкоза",
                "Серная кислота","Соляная кислота",100, ThemeFactory.createTheme(ThemeType.SCIENCE)));

        questionsList.add(new QuestionText("Первая кислота с которой познакомился человек?","Уксусная","Муравьинная",
                "Серная","Этиловая",400, ThemeFactory.createTheme(ThemeType.SCIENCE)));

        questionsList.add(new QuestionText("Седьмая планета от Солнца","Уран","Земля",
                "Марс","Юпитер",100, ThemeFactory.createTheme(ThemeType.SCIENCE)));

        questionsList.add(new QuestionText("Верхняя кора Земли называется","Литосфера","Астеносфера",
                "Стратосфера","Атмосфера",100, ThemeFactory.createTheme(ThemeType.SCIENCE)));

        questionsList.add(new QuestionText("Наименьшие частицы","Кварки","Протоны",
                "Электроны","Фароны",100, ThemeFactory.createTheme(ThemeType.SCIENCE)));

        questionsList.add(new QuestionText("Языком высокого уровня является","Фортран","Ассемблер",
                "Макроассемблер","Английский",200, ThemeFactory.createTheme(ThemeType.SCIENCE)));

        questionsList.add(new QuestionText("Cамый плотный металл","Осмий","Родий",
                "Вольфрам","Титан",200, ThemeFactory.createTheme(ThemeType.SCIENCE)));

        questionsList.add(new QuestionText("Самый легкий газ","Водород","Гелий",
                "Кислород","Хлор",100, ThemeFactory.createTheme(ThemeType.SCIENCE)));

        questionsList.add(new QuestionText("Диапозон типа byte","-127 128","-255 256",
                "-128 128","-256 256",100, ThemeFactory.createTheme(ThemeType.SCIENCE)));

        questionsList.add(new QuestionText("Что такое сёдзё?","аниме для девушек","аниме со сценами битвы",
                "самурай","механический человек",100, ThemeFactory.createTheme(ThemeType.ENTERTAINMENT)));

        questionsList.add(new QuestionText("Имя главного героя аниме Yuri!!! On Ice","Юрий","Иван",
                "Хатсуне","Мирай",100, ThemeFactory.createTheme(ThemeType.ENTERTAINMENT)));

        questionsList.add(new QuestionText("Самое длинное аниме имеет серий","7000","4000",
                "1200","700",200, ThemeFactory.createTheme(ThemeType.ENTERTAINMENT)));

        questionsList.add(new QuestionText("Количество вышедших игр в стим в 2019","8920","9236",
                "9500","9754",400, ThemeFactory.createTheme(ThemeType.ENTERTAINMENT)));

        questionsList.add(new QuestionText("Игра года в 2020 году","The Last of Us Part II","Hades",
                "Ghost of Tsushima","Doom Eternal",200, ThemeFactory.createTheme(ThemeType.ENTERTAINMENT)));

        questionsList.add(new QuestionText("Фильм, получивший оскар в 2019","Зеленая книга","Рома",
                "Богемская рапсодия","Власть",200, ThemeFactory.createTheme(ThemeType.ENTERTAINMENT)));















        questionsList.add(new QuestionText("У какого бога древние греки просили успешного плавания кораблю?","Посейдон","Зевс",
                "Деметра","Арес",100, ThemeFactory.createTheme(ThemeType.HISTORY)));

        questionsList.add(new QuestionText("Какая династия стоит в основании истории России?","Рюриковичи","Романовы",
                "Мономахи","Владимировичи",100, ThemeFactory.createTheme(ThemeType.HISTORY)));

        questionsList.add(new QuestionText("Вокруг какого торгового пути возникли первые княжества?","Из варяг в греки","Путь благовений",
                "Великий шелковый путь","Треугольная торговля",200, ThemeFactory.createTheme(ThemeType.HISTORY)));

        questionsList.add(new QuestionText("Какой город был северными торговыми воротами Руси?","Киев","Новгород",
                "Смоленск","Рязань",400, ThemeFactory.createTheme(ThemeType.HISTORY)));

        questionsList.add(new QuestionText("Какой век в России называют бунташным","17","15",
                "13","12",200, ThemeFactory.createTheme(ThemeType.HISTORY)));

        questionsList.add(new QuestionText("Главный бог славян был","Перун","Велес",
                "Даждьбог","Вантил",200, ThemeFactory.createTheme(ThemeType.HISTORY)));

        questionsList.add(new QuestionText("Ермак освоил эту область","Сибирь","Америку",
                "Японию","Кавказ",200, ThemeFactory.createTheme(ThemeType.HISTORY)));

        questionsList.add(new QuestionText("В 862 году начал править Русью","Рюрик","Игорь",
                "Иван","Петр",400, ThemeFactory.createTheme(ThemeType.HISTORY)));

        questionsList.add(new QuestionText("Вече проходило в ","Новгороде","Суздале",
                "Москве","Киеве",400, ThemeFactory.createTheme(ThemeType.HISTORY)));

        questionsList.add(new QuestionText("Внук Чингис-хана","Батый","Янг",
                "Монгол","Нубай",400, ThemeFactory.createTheme(ThemeType.HISTORY)));

        questionsList.add(new QuestionText("Столица Древнего Египта","Мемфис","Каир",
                "Вавилон","Персия",100, ThemeFactory.createTheme(ThemeType.HISTORY)));

        questionsList.add(new QuestionText("Какой титул получил Наполеон в 1804 году:","император","царь",
                "король","Арес",100, ThemeFactory.createTheme(ThemeType.HISTORY)));

        questionsList.add(new QuestionText("В каком году в России произошли 2 революции:","1917","1914",
                "1905","1931",200, ThemeFactory.createTheme(ThemeType.HISTORY)));

        questionsList.add(new QuestionText("Как назывался первый русский аэродром:?","Ходынское поле","Куликово поле",
                "Марсово поле","Иваново поле",400, ThemeFactory.createTheme(ThemeType.HISTORY)));

        questionsList.add(new QuestionText("Сколько корон изображено на гербе России:","три","две",
                "одна","четыре",200, ThemeFactory.createTheme(ThemeType.HISTORY)));

        questionsList.add(new QuestionText("Своё государство жители Китая называли:","Поднебесная империя","Благородная империя",
                "Непобедимая империя","Солнечная залия",100, ThemeFactory.createTheme(ThemeType.HISTORY)));

        questionsList.add(new QuestionText("Автором поэмы Илиада был","Гомер","Эсхил",
                "Аристофан","Аонтатий",200, ThemeFactory.createTheme(ThemeType.HISTORY)));



        questionsList.add(new QuestionText("Вторая по площади страна","Канада","США",
                "Австралия","Китай",200, ThemeFactory.createTheme(ThemeType.GEOGRAPHY)));

        questionsList.add(new QuestionText("Первая по площади страна","Россия","Канада",
                "Китай","США",100, ThemeFactory.createTheme(ThemeType.GEOGRAPHY)));

        questionsList.add(new QuestionText("Самая маленька по площади страна","Ватикан","Монако",
                "Сан-Марино","Лихтенштейн",100, ThemeFactory.createTheme(ThemeType.GEOGRAPHY)));

        questionsList.add(new QuestionText("Самая большая по населению страна ","Китай","Индия",
                "США","Россия",200, ThemeFactory.createTheme(ThemeType.GEOGRAPHY)));

        questionsList.add(new QuestionText("Где находится водопад Анхель","Венесуэла","Замбия",
                "Колумбия","Бразилия",400, ThemeFactory.createTheme(ThemeType.GEOGRAPHY)));

        questionsList.add(new QuestionText("Столица Польши","Варшава","Полтава",
                "Краков","Катовице",200, ThemeFactory.createTheme(ThemeType.GEOGRAPHY)));

        questionsList.add(new QuestionText("Сколько стран в мире","197","185",
                "173","169",400, ThemeFactory.createTheme(ThemeType.GEOGRAPHY)));

        questionsList.add(new QuestionText("Сколько штатов в США","50","49",
                "48","51",200, ThemeFactory.createTheme(ThemeType.GEOGRAPHY)));

        questionsList.add(new QuestionText("Какой канал перекрыло судно компании Evergrenn","Суэцкий","Панамский",
                "КИМ","Кильский",100, ThemeFactory.createTheme(ThemeType.GEOGRAPHY)));

        questionsList.add(new QuestionText("Сколько часовых поясов в России на 2021 год","11","12",
                "10","9",400, ThemeFactory.createTheme(ThemeType.GEOGRAPHY)));



        questionsList.add(new QuestionText("Как называлась центральная часть древнегреческого храма, где находилось изображение божества?","наос","пронаос",
                "перистиль","ольтер",200, ThemeFactory.createTheme(ThemeType.ART)));

        questionsList.add(new QuestionText("Назовите автора произведений \"Последний поклон\", \"Царь- рыба\"","В.Астафьев.","В.Распутин.",
                "С.Залыгин.","В.Белов.",100, ThemeFactory.createTheme(ThemeType.ART)));

        questionsList.add(new QuestionText("Настоящая фамилия Максима Горького?","Пешков","Лужин",
                "Алексеев","Иванов",200, ThemeFactory.createTheme(ThemeType.ART)));

        questionsList.add(new QuestionText("Кем по профессии был А.П.Чехов?","Врач","Учитель",
                "Бакалейщик","Юрист",400, ThemeFactory.createTheme(ThemeType.ART)));

        questionsList.add(new QuestionText("Назовите автора трагедии Aриадна","М.Цветаева","Б.Пастернак",
                "К.Бальмонт","А.Ахматова",200, ThemeFactory.createTheme(ThemeType.ART)));

        questionsList.add(new QuestionText("Как называется комедия Д.И. Фонвизина? ","Бригадир","Прораб",
                "Мастер","Подсобник",100, ThemeFactory.createTheme(ThemeType.ART)));

        questionsList.add(new QuestionText("Как называется комедия Н.В. Гоголя?","Ревизор","Аудитор",
                "Инспектор","Рэкетир",100, ThemeFactory.createTheme(ThemeType.ART)));

        questionsList.add(new QuestionText("Какая пьеса есть у В.В. Маяковского?","Баня","Сауна",
                "Душ","Мойдодыр",100, ThemeFactory.createTheme(ThemeType.ART)));

        questionsList.add(new QuestionText("Как называется часть костюма балерины?","Пачка","Кипа",
                "Стопка","Пучок",100, ThemeFactory.createTheme(ThemeType.ART)));

        questionsList.add(new QuestionText("В скольких км от Петербурга находилась Саарская мыза?","25","15",
                "50","75",200, ThemeFactory.createTheme(ThemeType.ART)));

        questionsList.add(new QuestionText("Кем являлся Н.А. Львов?","архитектором-дилетантом","скульптором",
                "архитектором-профессионалом","писателем",200, ThemeFactory.createTheme(ThemeType.ART)));


    }

    public static QuestionsDatabase getInstance(){
        if(questionsDatabase == null){
            questionsDatabase = new QuestionsDatabase();
        }
        return questionsDatabase;
    }


}

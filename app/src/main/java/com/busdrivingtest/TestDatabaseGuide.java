package com.busdrivingtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.busdrivingtest.TestConnecter.*;



import java.util.ArrayList;

public class TestDatabaseGuide extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Data.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase database;

    public TestDatabaseGuide(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //creating new database
    @Override
    public void onCreate(SQLiteDatabase database) {
        this.database = database;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER1 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER2 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER3 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
                ")";
        database.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();
    }


    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(database);
    }

    //filling it with questions
    private void fillQuestionsTable() {
        Question q1 = new Question("Kiedy silnik uzyskuje maksymalną moc?", "przy optymalnym zużyciu paliwa", "przy optymalnej emisji spalin", "przy maksymalnej użytkowej prędkości obrotowej", 3);
        addQuestion(q1);
        Question q2 = new Question("Kiedy powinna odbywać się zmiana biegów?", "przy prędkości obrotowej maksymalnej mocy", "przy każdej zmianie prędkości pojazdu", "w warunkach wynikających z charakterystyki ruchu drogowego", 3);
        addQuestion(q2);
        Question q3 = new Question("Kiedy jest minimalne zużycie paliwa?", "przy jeździe z pełnym obciążeniem", "przy jeździe ze stałą prędkością bez obciążenia", "dla jazdy dynamicznej, z pełnym wykorzystaniem parametrów silnika", 2);
        addQuestion(q3);
        Question q4 = new Question("Na czym polega korzystanie z obrotomierza?", "na słuchaniu dźwięku silnika", "na ciągłym porównywaniu wskazań obrotomierza i innych wskaźników", "na obserwacji wskazań gdy nie powoduje to zmniejszenia bezpieczeństwa kierowania pojazdem", 3);
        addQuestion(q4);
        Question q5 = new Question("Czy duże obciążenie pojazdu ma wpływ na zdolność do przyspieszeń?", "powoduje zmniejszenie zdolności pojazdu do przyspieszeń", "powoduje zwiększenie zdolności pojazdu do przyspieszeń", "nie ma wpływu", 1);
        addQuestion(q5);
        Question q6 = new Question("Czy gwałtowne hamowanie ma wpływ na zużycie paliwa?", "powoduje zwiększenie zużycia paliwa", "nie ma", "powoduje zmniejszenie zużycia paliwa", 1);
        addQuestion(q6);
        Question q7 = new Question("Co zaleca się dla zapewnienia stateczności autobusu?", "umieszczenie bagażu w lukach oraz rozmieszczenie pasażerów na miejscach do tego przeznaczonych", "umieszczenie bagaży po jednej stronie autobusu a pasażerów po drugiej", "rozmieszczenie bagażu i pasażerów nie ma wpływu na stateczność pojazdu", 1);
        addQuestion(q7);
        Question q8 = new Question("Czy stosowanie osłon aerodynamicznych ma wpływ na zużycie paliwa?", "tak, ponieważ powoduje zmniejszenie zużycia paliwa", "tak, ponieważ powoduje zwiększenie zużycia paliwa", "nie ma wpływu", 1);
        addQuestion(q8);
        Question q9 = new Question("Czy w normalnych warunkach jazdy dopuszczalne jest używanie retardera w połączeniu z hamulcem roboczym?", "nie, retarder używany jest tylko podczas zjazdu", "tak, dozwolone jest używanie w każdych warunkach", "tak, ale tylko w przypadku pełnego obciążenia pojazdu", 2);
        addQuestion(q9);
        Question q10 = new Question("Czy obciążenie pojazdu ma wpływ na długość drogi hamowania?", "tak", "nie", "tak, ale tylko przy betonowej nawierzchni", 1);
        addQuestion(q10);
        Question q11 = new Question("Jakie jest dopuszczalne odchylenie osi pojazdu względem kierunku początkowego podczas hamowania od prędkości 30km/h do zatrzymania?", "0,5 m", "0,6 m", "0,7 m", 2);
        addQuestion(q11);
        Question q12 = new Question("Czy i w jaki sposób przed rozpoczęciem jazdy należy sprawdzić stan i działanie poszczególnych urządzeń oświetleniowych?", "tak, przez oględziny wzrokowe i stwierdzenie świecenia poszczególnych świateł", "tak, poprzez kontrolę wskaźników na desce rozdzielczej", "nie, kontrola świateł jest zbędna", 1);
        addQuestion(q12);
        Question q13 = new Question("Czy zabrudzenie kloszy reflektorów lub lamp sygnałowych spowoduje pogorszenie skuteczności ich działania?", "tak, ale tylko podczas deszczu", "nie ma istotnego wpływu", "tak ze względu na pochłanianie światła", 3);
        addQuestion(q13);
        Question q14 = new Question("Kiedy należy używać świateł mijania?", "podczas jazdy w warunkach normalnej przejrzystości powietrza", "według uznania kierowcy", "tylko podczas jazdy nocą", 1);
        addQuestion(q14);
        Question q15 = new Question("Czy można holować autobus turystyczny z pasażerami?", "tak", "nie", "tak, ale pod warunkiem, że prędkość pojazdu nie przekracza 10 km/h", 2);
        addQuestion(q15);
        Question q16 = new Question("Co należy zrobić w przypadku awarii układu hamulcowego?", "spróbować naprawić awarię na drodze i w przypadku powodzenia kontynuować jazdę", "wezwać pomoc drogową celem odholowania pojazdu do warsztatu naprawczego", "zjechać do bazy i naprawić awarię samodzielnie", 2);
        addQuestion(q16);
        Question q17 = new Question("Czym charakteryzują się wzdłużne ruchy pojazdu?", "falowaniem pojazdu", "drganiem pojazdu", "pojazd zachowuje się neutralnie", 1);
        addQuestion(q17);
        Question q18 = new Question("Kiedy kierowca autokaru jeżdżąc w górach powinien używać zwalniacza prędkości?", "zawsze podczas hamowania", "nie ma takiej potrzeby", "tylko przy wjeździe na wzniesienie", 1);
        addQuestion(q18);
        Question q19 = new Question("Czy kierujący autobusem turystycznym może jechać pasem oznaczonym znakiem poziomym - literami \"BUS\"?", "tak", "nie", "tak, jeśli na sąsiednich pasach występuje znaczne natężenie ruchu", 2);
        addQuestion(q19);
        Question q20 = new Question("Co powinien zrobić kierujący autobusem turystycznym znak pionowy \"początek pasa ruchu dla autobusów\"?", "kontynuować jazdę pasem dla autobusów", "nie zajmować pasa dla autobusów", "jechać dowolnym pasem", 2);
        addQuestion(q20);
        Question q21 = new Question("Na ile i jakich okresów można zgodnie z prawem podzielić regularny dzienny odpoczynek kierowcy?", "na dwa: minimum 9 h + minimum 3 h", "na trzy: 1 h + 2 h + minimum 9 h", "na dwa: minimum 3 h + minimum 9 h", 3);
        addQuestion(q21);
        Question q22 = new Question("Kto odpowiada za prawidłową obsługę tachografu podczas realizacji przewozu?", "pracodawca", "kierowca", "technik warsztatu", 2);
        addQuestion(q22);
        Question q23 = new Question("Do której szczeliny tachografu cyfrowego powinien włożyć kartę kierowca aktualnie prowadzący autobus?", "do znajdującej się po lewej stronie", "do znajdującej się po prawej stronie", "nie ma to znaczenia", 1);
        addQuestion(q23);
        Question q24 = new Question("Kto składa wniosek o wydanie karty kierowcy?", "wyłącznie kierowca jest uprawniony do złożenia wniosku", "kierowca lub właściciel przedsiębiorstwa transportowego, na rzecz którego kierowca wykonuje pracę", "dowolna osoba z rodziny kierowcy", 1);
        addQuestion(q24);
        Question q25 = new Question("Jak często kierowca wykonujący przewóz drogowy podlega badaniom lekarskim?", "do czasu ukończenia przez kierowcę 50 lat - co 5 lat, od 50 do 60 lat - co 3 lata, powyżej 60 roku życia co 1 rok", "do czasu ukończenia przez kierowcę 60 lat - co 5 lat, po ukończeniu 60 roku życia - co 30 miesięcy", "do czasu ukończenia przez kierowcę 55 lat - co 5 lat, od 55 do 65 lat co 3 lata, powyżej 65 roku życia - co 18 miesięcy", 2);
        addQuestion(q25);
        Question q26 = new Question("Który autobus może być wyposażony w siedzenia skierowane bokiem do kierunku jazdy?", "autobus miejski", "autobus turystyczny", "autobus międzymiastowy", 1);
        addQuestion(q26);
        Question q27 = new Question("W jakie pasy bezpieczeństwa powinien być wyposażony autobus turystyczny?", "co najmniej trzypunktowe", "co najmniej dwupunktowe", "nie ma takiego obowiązku", 2);
        addQuestion(q27);
        Question q28 = new Question("Do wykonania jakich czynności zobowiązany jest kierujący pojazdem przewożącym zorganizowaną grupę dzieci lub młodzieży w wieku 18 lat, podczas ich wsiadania lub wysiadania z pojazdu?", "włączenie świateł awaryjnych", "włączenie świateł awaryjnych oraz wyjście z pojazdu", "włączenie świateł pozycyjnych oraz unieruchomienie silnika pojazdu", 1);
        addQuestion(q28);
        Question q29 = new Question("W jakim miejscu wydarza się największa liczba wypadków drogowych w Polsce?", "poza obszarem zabudowanym", "na obszarze zabudowanym", "na obszarze zabudowanym, z wyjątkiem miast o liczbie mieszkańców przekraczającej 1 milion", 2);
        addQuestion(q29);
        Question q30 = new Question("Ile wypadków powstaje corocznie z winy kierujących pojazdami w Polsce?", "około 40 tysięcy", "około 20 tysięcy", "około 10 tysięcy", 1);
        addQuestion(q30);
        Question q31 = new Question("W jakim przedziale wiekowym najczęściej występują kierowcy uczestniczący w wypadkach w Polsce?", "18-24 lata", "25-39 lat", "powyżej 70 lat", 2);
        addQuestion(q31);
        Question q32 = new Question("Jak często kierowcy autobusów przyczyniają się do powstawania wypadków drogowych w Polsce?", "rzadziej niż inni kierowcy", "częściej niż inni kierowcy", "w tym samym stopniu co inni kierowcy", 1);
        addQuestion(q32);
        Question q33 = new Question("Co oznacza skrót KWS?", "Kodeks Wykonawczy Schengen", "Krajowy Wydział Schengen", "Konwencja Wykonawcza Schengen", 3);
        addQuestion(q33);
        Question q34 = new Question("Czym jest SIS?", "systemem zbierania i transferu informacji o osobach niepożądanych na terenie państw Schengen", "krajowym systemem informatycznym gromadzącym informacje o osobach z państw trzecich", "rejestrem odcisków linii papilarnych", 1);
        addQuestion(q34);
        Question q35 = new Question("Czego dotyczy wpis zgodnie z art. 100 KWS?", "odmowy wjazdu", "poszukiwania osób celem zatrzymania i ustalenia miejsca pobytu", "poszukiwania skradzionych, przywłaszczonych lub w inny sposób zaginionych przedmiotów", 3);
        addQuestion(q35);
        Question q36 = new Question("Które z wymienionych poniżej państw nie były pierwotnymi sygnatariuszami Układu z Schengen?", "Austria", "Belgia", "Francja", 1);
        addQuestion(q36);
        Question q37 = new Question("W jaki sposób może być ukarany przedsiębiorca stosujący ceny dumpingowe?", "mandatem karnym przez policję", "karą grzywny nałożoną przez ITD", "karą nałożoną w drodze decyzji administracyjnej przez UOKiK", 3);
        addQuestion(q37);
        Question q38 = new Question("Co oznacza zasada ograniczonego zaufania do innych uczestników ruchu drogowego?", "przewidywanie, że zachowają się racjonalnie w każdej sytuacji", "zwrócenie uwagi, że mogą zachować się w sposób nieprzewidywalny, mogący zagrażać bezpieczeństwu", "nie ma takiej zasady", 2);
        addQuestion(q38);
        Question q39 = new Question("Czy podczas jazdy kierowca może rozmawiać trzymając w ręku telefon komórkowy?", "tak", "tak, pod warunkiem, że rozmowa trwa do 1 minuty", "nie, jest to zabronione", 3);
        addQuestion(q39);
        Question q40 = new Question("Jakim stanem psychicznym jest agresja?", "pozytywnym", "neutralnym", "negatywnym", 3);
        addQuestion(q40);
        Question q41 = new Question("W jaki sposób kierowca powinien zareagować na agresję pasażera?", "zignorować jego zachowanie i czekać aż sam się uspokoi", "zareagować równie agresywnie", "jeśli to możliwe, zminimalizować przyczynę agresji lub przeprosić za niedogodności", 3);
        addQuestion(q41);
        Question q42 = new Question("Czy kierowca w sytuacji zagrożenia przez agresora bezpieczeństwa swojego i pasażerów może skorzystać z pomocy Policji lub ITD?", "tak", "nie, ITD nie jest uprawniona do interwencji", "tak, ale tylko w przypadku jeśli agresor jest uzbrojony", 2);
        addQuestion(q42);
        Question q43 = new Question("Czy przekroczenie czasu jazdy kierowcy ma wpływ na bezpieczeństwo ruchu drogowego?", "tak, ale tylko jeżeli to więcej niż 1 godzina", "tak", "nie", 2);
        addQuestion(q43);
        Question q44 = new Question("Czy jadąc w trasę należy mieć ze sobą coś lekkostrawnego \"do przegryzienia”?", "nie ma takiej potrzeby", "tak, zawsze może dojść do sytuacji nieprzewidzianej", "to zależy od długości trasy", 2);
        addQuestion(q44);
        Question q45 = new Question("Czy w trasie należy pić więcej, czy mniej napojów niż zazwyczaj?", "więcej, ponieważ powietrze w kabinie jest bardziej suche", "mniej, z racji ograniczonych możliwości skorzystania z toalety", "tyle samo", 1);
        addQuestion(q45);
        Question q46 = new Question("Jaka jest szybkość rozkładu (spalania) alkoholi u kobiet?", "8-10 gramów czystego alkoholu w ciągu godziny", "10-12 gramów czystego alkoholu w ciągu godziny", "14-16 gramów czystego alkoholu w ciągu godziny", 1);
        addQuestion(q46);
        Question q47 = new Question("Czy nadzorowanie naprawy serwisowej autobusu w trakcie kursu ma wpływ na zmęczenie kierowcy?", "tak, ponieważ jest to praca wymagająca uwagi i wysiłku", "nie, ponieważ kierowca nie prowadzi wówczas pojazdu", "nie, ponieważ taki nadzór nie wymaga na ogół wysiłku", 1);
        addQuestion(q47);
        Question q48 = new Question("Czy sytuacja w domu lub w miejscu pracy ma wpływ na sprawność i zachowanie się kierowcy?", "nie, to nie powinno mieć wpływu, jadąc koncentrujemy się wyłącznie na drodze", "tak, niektórych problemów nie da się oddzielić i \"zostawić w domu”", "dla sprawnego i dobrego kierowcy nie powinno to mieć znaczenia", 2);
        addQuestion(q48);
        Question q49 = new Question("Czy można holować autobus z pasażerami?", "tak, ale tylko przez pojazd do tego przeznaczony", "tak, ale tylko autobus turystyczny", "nie", 3);
        addQuestion(q49);
        Question q50 = new Question("Ile minimalnie gaśnic powinno znajdować się w autobusie, jeżeli jego długość przekracza 6 metrów?", "dwie", "trzy", "cztery", 1);
        addQuestion(q50);
        Question q51 = new Question("Do czego jest zobowiązany kierowca jeżeli uczestniczył w wypadku w którym jest zabity lub ranny?", "do udzielenia niezbędnej pomocy ofiarom wypadku oraz wezwania pogotowia ratunkowego i policji", "do niepodejmowania działań i oczekiwania na reakcję świadków zdarzenia", "do niezwłocznego usunięcia pojazdu z miejsca zdarzenia", 1);
        addQuestion(q51);
        Question q52 = new Question("Co zawsze powinien mieć przy sobie ratownik?", "rękawiczki jednorazowe", "kamizelkę odblaskową", "legitymację ratowniczą", 1);
        addQuestion(q52);
        Question q53 = new Question("W jakiej odległości za pojazdem należy umieścić trójkąt ostrzegawczy w celu zabezpieczenia miejsca wypadku na autostradzie i drodze ekspresowej?", "100 m", "30-50 m", "1 m", 1);
        addQuestion(q53);
        Question q54 = new Question("Czy kierowca autobusu ma obowiązek pomóc osobie poruszającej się na wózku inwalidzkim przy wsiadaniu do autobusu i wysiadaniu?", "nie", "tak", "decyzja należy do kierowcy", 2);
        addQuestion(q54);
        Question q55 = new Question("Co jest celem konserwacji pojazdu?", "przedłużenie żywotności pojazdu i zmniejszenie jego kosztów eksploatacji", "nie ma ona znaczenia dla normalnej eksploatacji pojazdu", "spełnienie wymagań prawnych", 1);
        addQuestion(q55);
        Question q56 = new Question("Do jakich czynności należą czynności zdawczo-odbiorcze związane z rozpoczęciem lub zakończeniem pracy pojazdu?", "do obsługi codziennej pojazdu", "do obsługi technicznej pojazdu", "nie istnieje takie pojęcie w eksploatacji pojazdu", 1);
        addQuestion(q56);
        Question q57 = new Question("Kiedy policjant umundurowany może zatrzymać pojazd do kontroli drogowej?", "tylko w obszarze zabudowanym", "w każdych warunkach i sytuacji", "w każdym miejscu i sytuacji pod warunkiem, że nie utrudnia to ruchu i nie zagraża bezpieczeństwu ruchu drogowego", 3);
        addQuestion(q57);
        Question q58 = new Question("Jak powinien zachować się kierowca w przypadku zatrzymania pojazdu przez policjanta w celu kontroli?", "wyjść z pojazdu i podejść do kontrolującego policjanta z odpowiednimi dokumentami pojazdu i kierowcy", "nie wysiadać z pojazdu, trzymać ręce na kierownicy i oczekiwać na policjanta", "wyjść i oczekiwać na policjanta w odległości około 1 metra od pojazdu", 2);
        addQuestion(q58);
        Question q59 = new Question("Co należy do obowiązków przewoźnika osób?", "podjęcie działań ułatwiających korzystanie ze środków transportu, punktów odprawy i przystanków osobom niepełnosprawnym", "zapewnienie odpowiedniej rentowności przewozu w celu możliwości odprowadzenia właściwych podatków do urzędu skarbowego", "zapewnienie podróżnym cen biletów konkurencyjnych w stosunku do cen stosowanych przez innych przewoźników", 1);
        addQuestion(q59);
        Question q60 = new Question("Który z wymienionych rodzajów transportu pasażerskiego cechuje się największą stabilnością?", "lotniczy", "samochodowy", "kolejowy", 2);
        addQuestion(q60);
        Question q61 = new Question("Czy przedsiębiorca wykonujący przewozy osób na potrzeby własne może wykonywać zarobkowe przewozy okazjonalne?", "tak, jeżeli wykonuje je bardzo rzadko", "nie, ponieważ przy takich przewozach zawsze wymagana jest licencja", "tak, jeżeli pobierze zapłatę za przewóz gotówką", 2);
        addQuestion(q61);
        Question q62 = new Question("Czy kierowca obsługujący międzynarodową pasażerską linię regularną do Niemiec powinien posiadać w autobusie wypis z zezwolenia na obsługę tej linii?", "nie, ponieważ nie są wymagane zezwolenia na linie regularne wewnątrz Unii Europejskiej", "nie, ponieważ w przewozach osób nie są wymagane żadne zezwolenia", "tak, ponieważ takie zezwolenia są prawnie wymagane ze względu na koordynację rozkładów jazdy", 3);
        addQuestion(q62);
        Question q63 = new Question("Czy polski przewoźnik realizujący okazjonalny przewóz z Francji do Niemiec wykonuje przewóz międzynarodowy?", "tak, ponieważ w tym przewozie występuje przekroczenie granicy między dwoma państwami", "nie, ponieważ przewoźnik nie prowadzi działalności na terenie żadnego z tych państw", "nie, jest to przewóz kabotażowy", 1);
        addQuestion(q63);
        Question q64 = new Question("Przez jaki okres od momentu skazania prawomocnym wyrokiem sądu za przestępstwo przeciwko bezpieczeństwu w komunikacji, kierowca zawodowy może nadal wykonywać swój zawód?", "przez 6 miesięcy", "przez 3 miesiące", "następuje natychmiastowy zakaz", 3);
        addQuestion(q64);
        Question q65 = new Question("Na których przystankach może zatrzymywać się autobus, którym wykonywany jest przewóz regularny?", "na dowolnych, pod warunkiem że leżą na trasie przewozu", "nie ma to żadnego znaczenia", "tylko na zawartych w rozkładzie jazdy", 3);
        addQuestion(q65);
        Question q66 = new Question("Czy autobus z awarią hamulca roboczego może poruszać się po drodze publicznej?", "tak", "nie", "tak, pod warunkiem nieprzekraczania prędkości 30 km/h", 2);
        addQuestion(q66);
        Question q67 = new Question("Do wykonania jakiej czynności zobowiązany jest kierujący pojazdem przeznaczonym konstrukcyjnie do przewozu osób niepełnosprawnych podczas ich wsiadania lub wysiadania z pojazdu?", "włączenia świateł awaryjnych", "włączenia świateł pozycyjnych oraz wyjścia z pojazdu", "włączenia świateł pozycyjnych oraz unieruchomieniu silnika", 1);
        addQuestion(q67);
        Question q68 = new Question("Który opatrunek można położyć bezpośrednio na ranę?", "watę", "ligninę", "jałową gazę", 3);
        addQuestion(q68);
        Question q69 = new Question("Kierowca widząc osobę na wózku ma obowiązek:", "wystawić rampę", "wystawić rampę i wprowadzić wózek", "wystawiać rampę na każdym przystanku", 1);
        addQuestion(q69);
        Question q70 = new Question("Po jakim czasie następują nieodwracalne zmiany w mózgu na skutek niedotlenienia?", "po 3 min.", "po 9 min.", "po 4,5 min.", 3);
        addQuestion(q70);
        Question q71 = new Question("Czy sprawność fizyczna ma wpływ na zdolność koncentracji?", "tak", "nie", "dla sprawnego kierowcy nie powinno mieć to znaczenia", 1);
        addQuestion(q71);
        Question q72 = new Question("Czy niskie ciśnienie w ogumieniu wpływa na bezpieczeństwo?", "nie", "tak, powoduje zwiększenie zagrożenia", "tak, powoduje zmniejszenie zagrożenia", 2);
        addQuestion(q72);
        Question q73 = new Question("Czy przeładowanie pojazdu wpływa na drogę hamowania?", "tak, wydłuża ją", "tak, skraca ją", "nie ma znaczenia", 1);
        addQuestion(q73);
        Question q74 = new Question("W którym z wymienionych przypadków wymagane jest zezwolenie na wykonywanie krajowego transportu drogowego osób?", "przy wykonywaniu przewozów okazjonalnych", "przy wykonywaniu przewozów regularnych", "przy wykonywaniu przewozów wahadłowych", 2);
        addQuestion(q74);
        Question q75 = new Question("Czy kierowca wykonujący przewozy dla przedsiębiorcy na potrzeby własne może być ukarany sądownie za przestępstwo przeciwko umyślnemu szkodzeniu środowisku?", "nie", "jedynie po ukończeniu 23 roku życia", "tak", 3);
        addQuestion(q75);
        Question q76 = new Question("Kiedy należy sprawdzić ustawienie lusterek zewnętrznych?", "przed rozpoczęciem jazdy", "raz w tygodniu", "podczas przeglądu technicznego", 1);
        addQuestion(q76);
        Question q77 = new Question("Jakie pojazdy powinny być oznakowane tablicą przedstawiającą sylwetki dzieci na żółtym tle?", "jedynie autobusy szkolne dowożące lub odwożące dzieci ze szkół", "wszystkie pojazdy przewożące zorganizowaną grupę młodzieży do 18 roku życia", "nie istnieje prawny obowiązek używania takiej tablicy", 2);
        addQuestion(q77);
        Question q78 = new Question("Kiedy kierowca w warunkach normalnej przejrzystości powietrza może używać świateł przeciwmgłowych?", "zawsze, według własnej decyzji", "w żadnym wypadku", "na specjalnie oznakowanych drogach krętych od zmierzchu do świtu", 3);
        addQuestion(q78);
        Question q79 = new Question("Od jakiego momentu należy liczyć rozpoczęcie spalania alkoholu w organizmie?", "w momencie rozpoczęcia picia", "w momencie zakończenia picia", "po upływie godziny od zakończenia picia", 3);
        addQuestion(q79);
        Question q80 = new Question("W jakich warunkach ruchu istotna jest maksymalna moc silnika?", "podczas jazdy ze stałą prędkością", "podczas zjazdu z wzniesienia", "podczas podjazdu na wzniesienie", 3);
        addQuestion(q80);
        Question q81 = new Question("Jaką prędkość obrotową silnika należy utrzymywać jadąc pojazdem ze stałą prędkością?", "1000-1200 obr./min.", "1500-1700 obr./min.", "zgodną z instrukcją obsługi pojazdu", 3);
        addQuestion(q81);
        Question q82 = new Question("Z czym może być związane nadmierne zużycie paliwa?", "z używaniem retardera na zjazdach", "z niewłaściwą techniką jazdy", "z występowaniem w pojeździe blokady mechanizmu różnicowego", 2);
        addQuestion(q82);
        Question q83 = new Question("Jaki jest najważniejszy cel łagodnego zakończenia hamowania?", "zmniejszenie zużycia okładzin hamulcowych", "zmniejszenie zużycia opon", "zwiększenie komfortu podróżnych", 3);
        addQuestion(q83);
        Question q84 = new Question("Z czego wynika wzrost hałasu emitowanego przez pojazd?", "ze wzrostu masy pojazdu", "ze wzrostu prędkości obrotowej silnika", "ze zmniejszenia prędkości pojazdu", 2);
        addQuestion(q84);
        Question q85 = new Question("Z czego wynika zmniejszenie hałasu emitowanego przez pojazd?", "ze zmniejszenia prędkości pojazdu", "ze wzrostu masy pojazdu", "ze zwiększenia prędkości obrotowej silnika", 1);
        addQuestion(q85);
        Question q86 = new Question("Czy gwałtowne hamowanie ma wpływ na bezpieczeństwo?", "tak, powoduje zwiększenie bezpieczeństwa", "tak, powoduje zmniejszenie bezpieczeństwa", "nie ma wpływu", 2);
        addQuestion(q86);
        Question q87 = new Question("Jaki wpływ na zużycie paliwa ma gwałtowne przyspieszanie?", "powoduje zwiększenie zużycia paliwa", "powoduje zmniejszenie zużycia paliwa", "w sprawnym pojeździe nie powinno mieć wpływu na zużycie paliwa", 1);
        addQuestion(q87);
        Question q88 = new Question("Czy zbyt małe ciśnienie w ogumieniu ma wpływ na zużycie paliwa?", "nie ma wpływu", "tak, powoduje zwiększenie zużycia paliwa", "tak, powoduje zmniejszenie zużycia paliwa", 2);
        addQuestion(q88);
        Question q89 = new Question("Czy brak osłon aerodynamicznych ma wpływ na zużycie paliwa?", "nie ma wpływu", "tak, powoduje zmniejszenie zużycia paliwa", "tak, powoduje zwiększenie zużycia paliwa", 3);
        addQuestion(q89);
        Question q90 = new Question("Czy konfiguracja drogi (płaski teren, mało zakrętów) ma wpływ na zużycie paliwa?", "nie ma wpływu", "tak, powoduje zmniejszenie zużycia paliwa", "tak, powoduje zwiększenie zużycia paliwa", 2);
        addQuestion(q90);
        Question q91 = new Question("Ile wynosi regularny dzienny okres odpoczynku w załodze kilkuosobowej?", "co najmniej 8 godzin", "co najmniej 9 godzin", "co najmniej 11 godzin", 2);
        addQuestion(q91);
        Question q92 = new Question("Jaką kategorię prawa jazdy powinien posiadać kierowca kierujący pojazdem homologowanym przeznaczonym konstrukcyjnie do przewozu nie więcej niż 16 osób łącznie z kierowcą?", "wyłącznie B", "minimum D", "minimum D1", 3);
        addQuestion(q92);
        Question q93 = new Question("W przypadku przewozów regularnych na odległość większą niż 50 km, ile razy w ciągu tygodnia kierowca autobusu może przedłużyć prowadzenie pojazdu z 9 do 10 godzin?", "tylko dwukrotnie", "trzykrotnie, jeśli kolejne 2 odpoczynki dobowe będą trwały nieprzerwanie nie mniej niż 11 godzin", "trzykrotnie, jeśli kierowca nie odbierał w danym tygodniu żadnego skróconego odpoczynku dobowego (9-godzinnego)", 1);
        addQuestion(q93);
        Question q94 = new Question("Czy pracodawca ma obowiązek zrekompensowania kierowcy skróconego czasu dziennego odpoczynku?", "tak", "przepisy tego nie określają", "nie", 3);
        addQuestion(q94);
        Question q95 = new Question("Kiedy kierowca, niepodlegający kwalifikacji wstępnej, wykonujący przewozy drogowe, ma obowiązek wykonać badania lekarskie i psychologiczne w celu stwierdzenia istnienia lub braku przeciwwskazań zdrowotnych do wykonywania pracy na stanowisku kierowcy?", "po ukończeniu pierwszego szkolenia okresowego", "najpóźniej do chwili ukończenia pierwszego szkolenia okresowego i uzyskania Świadectwa Kwalifikacji Zawodowej", "przed ukończeniem pierwszego szkolenia okresowego", 1);
        addQuestion(q95);
        Question q96 = new Question("Jaka jest wysokość kary dla kierowcy za przekroczenie maksymalnego czasu prowadzenia pojazdu bez przerwy o czas powyżej 15 minut do 30 minut?", "50 zł", "150 zł", "200 zł", 1);
        addQuestion(q96);
        Question q97 = new Question("Jaki obecnie wydawany podstawowy dokument uprawnia do wykonywania zarobkowego transportu drogowego osób autobusem na terytorium Polski?", "licencja na wykonywania krajowego transportu drogowego", "zezwolenie na wykonywanie zawodu przewoźnika drogowego", "zaświadczenie o wykonywaniu przewozów na potrzeby własne", 2);
        addQuestion(q97);
        Question q98 = new Question("Z jaką maksymalną prędkością może poruszać się autobus spełniający dodatkowe warunki techniczne, na drodze dwujezdniowej o przynajmniej 2 pasach ruchu dla tego samego kierunku poza obszarem zabudowanym (droga inna niż autostrada lub ekspresowa)?", "100 km/h", "70 km/h", "80 km/h", 3);
        addQuestion(q98);
        Question q99 = new Question("Czy w celu zmniejszenia zużycia paliwa wolno dodawać do oleju napędowego dodatki uszlachetniające?", "nie, ponieważ zawsze grozi to uszkodzeniem układu wtryskowego", "jest to wskazane, ale wyłącznie zimą przy ujemnych temperaturach otoczenia", "tak, ale wyłącznie gdy producent dopuszcza ich użycie", 3);
        addQuestion(q99);
        Question q100 = new Question("Jak nazywa się konwencja dotycząca pracy załóg kierowców, wykonujących międzynarodowe przewozy drogowe?", "ATP", "ADR", "AETR", 3);
        addQuestion(q100);
        Question q101 = new Question("Jaki jest maksymalny tygodniowy czas jazdy dla kierowcy zatrudnionego przez więcej niż jedno przedsiębiorstwo transportowe?", "58 godzin", "56 godzin", "48 godzin", 2);
        addQuestion(q101);
        Question q102 = new Question("Od czego zależny jest poziom emitowanego hałasu zewnętrznego autobusu?", "od dopuszczalnej liczby miejsc", "od rodzaju opon", "od prędkości obrotowej silnika", 3);
        addQuestion(q102);
        Question q103 = new Question("Czy pracodawca ma obowiązek zrekompensowania kierowcy skróconego czasu dziennego odpoczynku?", "tak", "przepisy tego nie określają", "nie", 3);
        addQuestion(q103);
        Question q104 = new Question("Ile godzin wynosi regularny dzienny odpoczynek kierowców w załodze dwuosobowej?", "minimum 8 godzin", "minimum 9 godzin", "minimum 11 godzin", 2);
        addQuestion(q104);
        Question q105 = new Question("Z jaką maksymalną dopuszczalną prędkością masz prawo kierować autobusem na obszarze zabudowanym w godzinach od 23.00 do 5.00?", "40 km/h", "50 km/h", "60 km/h", 3);
        addQuestion(q105);
        Question q106 = new Question("Ile wynosi maksymalna dopuszczalna prędkość autobusu, który nie spełnia dodatkowych warunków technicznych, na drodze ekspresowej?", "80 km/h", "90 km/h", "100 km/h", 1);
        addQuestion(q106);
        Question q107 = new Question("Z jaką maksymalną dopuszczalną prędkością możesz jechać na autostradzie, kierując autobusem spełniającym dodatkowe warunki techniczne określone w przepisach?", "100 km/h", "120 km/h", "140 km/h", 1);
        addQuestion(q107);
        Question q108 = new Question("Który z tych elementów stanowi obowiązkowe wyposażenie autobusu szkolnego?", "sygnał akustyczny ostrzegający na zewnątrz o cofaniu pojazdu", "minimum trzy przenośne pachołki do umieszczania za autobusem", "kabinę dla kierowcy wydzieloną z przestrzeni pasażerskiej", 1);
        addQuestion(q108);
        Question q109 = new Question("Który z tych elementów stanowi obowiązkowe wyposażenie autobusu miejskiego wykorzystywanego w komunikacji miejskiej?", "zasłony w bocznych oknach, jeżeli nie jest wyposażony w szyby przeciwsłoneczne", "apteczka doraźnej pomocy", "lusterko wewnętrzne zapewniające kierowcy widoczność wnętrza autobusu", 3);
        addQuestion(q109);
        Question q110 = new Question("Czy zanim rozpoczniesz jazdę autobusem miejskim wyposażonym w wyjścia awaryjne, masz obowiązek upewnić się, że dostęp do nich nie jest utrudniony?", "nie", "nie, jeśli liczba miejsc dla pasażerów nie przekracza 35", "tak", 3);
        addQuestion(q110);
        Question q111 = new Question("Jaka jest maksymalna dopuszczalna długość zespołu pojazdów złożonego z autobusu i przyczepy?", "22 m", "18,75 m", "16,5 m", 2);
        addQuestion(q111);
        Question q112 = new Question("W jakim przypadku pasy bezpieczeństwa będą mogły spełnić swoją funkcję?", "jeżeli będą właściwie wyregulowane i zapięte", "jeżeli będą zapięte z dużym luzem w odcinku biodrowym", "jeżeli będą przeprowadzone na wysokości szyi", 1);
        addQuestion(q112);
        Question q113 = new Question("W którym z wymienionych przypadków masz prawo użyć awaryjnego wyłącznika silnika?", "podczas pokonywania ostrego górskiego zakrętu", "w razie uszkodzenia hamulców podczas jazdy na spadku drogi", "podczas zatrzymania pojazdu", 3);
        addQuestion(q113);
        Question q114 = new Question("W jakim celu użyjesz hamulca przystankowego?", "do unieruchomienia pojazdu na drodze o nachyleniu powyżej 10%", "do zmniejszenia zapotrzebowania na sprężone powietrze w czasie postoju na przystanku", "do zmniejszenia prędkości podczas dojeżdżania do przystanku", 2);
        addQuestion(q114);
        Question q115 = new Question("W jaki sposób uruchomisz hamulec przystankowy?", "przez wciśnięcie i przytrzymanie pedału hamulca podczas postoju pojazdu", "przez zaciągnięcie dźwigni hamulca postojowego do połowy", "przez otwarcie drzwi autobusu", 3);
        addQuestion(q115);
        Question q116 = new Question("Co stanowi obowiązkowe wyposażenie autobusu, którego dopuszczalna prędkość wynosi 100 km/h?", "opony o głębokości rzeźby bieżnika co najmniej 6 mm", "apteczka doraźnej pomocy", "trzypunktowe pasy bezpieczeństwa na wszystkich siedzeniach", 2);
        addQuestion(q116);
        Question q117 = new Question("Jakiej prędkości nie pozwala przekroczyć homologowany ogranicznik prędkości, w który jest wyposażony autobus?", "80 km/h", "90 km/h", "100 km/h", 3);
        addQuestion(q117);
        Question q118 = new Question("W ile minimalnie gaśnic powinien być wyposażony autobus o długości przekraczającej 6 metrów?", "jedną", "dwie", "trzy", 2);
        addQuestion(q118);
        Question q119 = new Question("Który z przedmiotów stanowi obowiązkowe wyposażenie autobusu używanego w komunikacji miejskiej?", "ogumione koło zapasowe", "apteczka doraźnej pomocy", "trójkąt ostrzegawczy", 3);
        addQuestion(q119);
        Question q120 = new Question("Ile osób wolno Ci przewozić autobusem przegubowym komunikacji miejskiej?", "nie więcej niż liczba określona przez przewoźnika", "nie więcej niż liczba miejsc określona w dowodzie rejestracyjnym", "tyle, ile faktycznie zmieści się w pojeździe, pod warunkiem zachowania widoczności kierowcy na drogę oraz możliwości zamknięcia drzwi", 2);
        addQuestion(q120);
        Question q121 = new Question("W ile wyjść awaryjnych powinien być wyposażony autobus posiadający 32 miejsca dla pasażerów?", "2", "3", "4", 3);
        addQuestion(q121);
        Question q122 = new Question("Który z wymienionych czynników w zasadniczy sposób decyduje o długości drogi hamowania autobusu?", "system kontroli trakcji, jeżeli pojazd jest w niego wyposażony", "czas reakcji kierującego pojazdem", "rodzaj nawierzchni, po której porusza się pojazd", 3);
        addQuestion(q122);
        Question q123 = new Question("Do którego z wymienionych czynników należy dostosować odległość autobusu od poprzedzającego go pojazdu?", "do doświadczenia kierującego", "do panujących warunków atmosferycznych i stanu nawierzchni", "do dopuszczalnej prędkości na danym odcinku drogi", 2);
        addQuestion(q123);
        Question q124 = new Question("Jak, w przybliżeniu, wzrasta długość drogi hamowania autobusu przy dwukrotnie większej prędkości?", "dwukrotnie", "trzykrotnie", "czterokrotnie", 3);
        addQuestion(q124);
        Question q125 = new Question("Od czego, w zasadniczy sposób, zależy przyczepność opon autobusu do suchej jezdni?", "od rodzaju nawierzchni tej jezdni", "od mocy silnika", "od sprawności układu kierowniczego", 1);
        addQuestion(q125);
        Question q126 = new Question("Z jaką prędkością możesz jechać kierując autobusem?", "dopuszczalną na danym odcinku drogi, niezależnie od panujących warunków", "określoną przez ogranicznik prędkości, niezależnie od panujących warunków", "zapewniającą panowanie nad pojazdem", 3);
        addQuestion(q126);
        Question q127 = new Question("Jaki minimalny odstęp od poprzedzającego pojazdu musisz zachować kierując autobusem poza obszarem zabudowanym w tunelu o długości przekraczającej 500 m?", "30 m", "50 m", "80 m", 2);
        addQuestion(q127);
        Question q128 = new Question("Jaki odstęp od poprzedzającego pojazdu powinieneś zachować na drodze jednojezdniowej dwukierunkowej poza obszarem zabudowanym, kierując autobusem o długości powyżej 7 m?", "co najmniej 50 m", "umożliwiający pojazdom wyprzedzającym bezpieczny wjazd przed autobus", "co najmniej 80 m", 2);
        addQuestion(q128);
        Question q129 = new Question("Jaka odległość powinna być zachowana pomiędzy zorganizowanymi kolumnami autobusów?", "co najmniej 100 m", "co najmniej 200 m", "co najmniej 500 m", 3);
        addQuestion(q129);
        Question q130 = new Question("Kierujesz autobusem. Który z wymienionych czynników powinieneś uwzględnić przede wszystkim przy ustalaniu odstępu od jadącego przed Tobą pojazdu?", "natężenie ruchu", "liczbę przewożonych pasażerów", "warunki atmosferyczne i stan nawierzchni", 3);
        addQuestion(q130);
        Question q131 = new Question("Ile metrów odstępu od poprzedzającego pojazdu należy zachować podczas zatrzymania wynikającego z zatoru drogowego w tunelu?", "nie mniej niż 3 metry", "nie mniej niż 5 metrów", "nie mniej niż 10 metrów", 2);
        addQuestion(q131);
        Question q132 = new Question("W którym z wymienionych przypadków hamulec silnikowy wyłącza się automatycznie?", "gdy prędkość obrotowa silnika jest mniejsza niż 1500 obr./min.", "gdy prędkość pojazdu jest mniejsza niż 30 km/h", "gdy uruchomił się system ABS", 3);
        addQuestion(q132);
        Question q133 = new Question("Jak najskuteczniej hamować pojazdem z systemem ABS?", "pulsacyjnie", "maksymalnie wciskając pedał hamulca", "nie wciskając do końca pedału hamulca", 2);
        addQuestion(q133);
        Question q134 = new Question("W jakiej pozycji powinien być ustawiony fotel kierującego autobusem?", "tak, by plecy kierującego nie przylegały do oparcia fotela", "tak, by podczas wciskania pedału sprzęgła noga była całkowicie wyprostowana", "tak, by podczas całkowitego wciskania pedału sprzęgła noga była lekko zgięta w kolanie", 3);
        addQuestion(q134);
        Question q135 = new Question("Co, kierując autobusem, powinieneś widzieć w prawidłowo ustawionych lusterkach zewnętrznych (bocznych)?", "tylko boki pojazdu", "obszar za pojazdem i boki pojazdu", "tylko sąsiedni pas ruchu", 2);
        addQuestion(q135);
        Question q136 = new Question("Na którym biegu rozpoczniesz jazdę autobusem do przodu w dobrych warunkach drogowych na płaskim terenie?", "najniższym określonym przez producenta", "trzecim, jeśli autobus nie jest obciążony", "pierwszym skrzyni górnej", 1);
        addQuestion(q136);
        Question q137 = new Question("Jaki jest najbardziej efektywny sposób rozpędzania autobusu?", "poprzez osiąganie maksymalnych obrotów silnika na kolejnych biegach", "poprzez taką zmianę biegów, by obroty silnika nie były niższe niż wartość rozpoczynająca zielone pole obrotomierza", "poprzez wykorzystywanie kolejno wszystkich biegów, nawet jeśli wskaźnik obrotomierza jest na czerwonym polu", 2);
        addQuestion(q137);
        Question q138 = new Question("W jaki sposób kierując autobusem skręcisz w prawo na skrzyżowaniu?", "wybierzesz tor jazdy uwzględniający \"zachodzenie\" tyłu autobusu", "skręcisz pod kątem zbliżonym do prostego z użyciem hamulca pomocniczego", "skręcisz w prawo po zbliżeniu się do prawej krawędzi jezdni bez względu na wymiary pojazdu", 1);
        addQuestion(q138);
        Question q139 = new Question("Którą z wymienionych czynności, kierując autobusem, powinieneś wykonać w celu uzyskania największej skuteczności hamowania silnikiem?", "włączyć w miarę możliwości jak najwyższy bieg", "wcisnąć do oporu pedał sprzęgła", "włączyć w miarę możliwości jak najniższy bieg", 3);
        addQuestion(q139);
        Question q140 = new Question("Jak powinieneś kierować autobusem podczas jazdy po łuku drogi?", "płynnie korygować tor jazdy uwzględniając krzywiznę łuku", "pokonywać łuk z wciśniętym pedałem sprzęgła", "utrzymywać maksymalne obroty silnika na całej długości łuku", 1);
        addQuestion(q140);
        Question q141 = new Question("Którą z wymienionych czynności, kierując autobusem, powinieneś wykonać w celu uzyskania największej skuteczności nagłego hamowania?", "od początku do końca hamowania wciskać pedał hamulca do oporu i nie puszczać w momencie wystąpienia poślizgu", "wyłączyć zapłon", "wcisnąć jednocześnie pedał hamulca z pedałem sprzęgła", 3);
        addQuestion(q141);
        Question q142 = new Question("W jaki sposób powinieneś zwiększać prędkość jazdy autobusu, chcąc jechać ekonomicznie?", "tak dobierając bieg, aby wskazówka obrotomierza po zmianie biegu na wyższy nie spadała poniżej zakresu zielonego pola", "jak najszybciej osiągając maksymalne prędkości na każdym biegu", "zmieniając kolejne biegi wtedy, gdy wskazówka obrotomierza wychyla się do maksimum", 1);
        addQuestion(q142);
        Question q143 = new Question("Który ze sposobów zatrzymania autobusu przed skrzyżowaniem na jezdni suchej jest właściwy?", "jednoczesne wciśnięcie pedału sprzęgła i hamulca", "wciśnięcie pedału hamulca, a w końcowej fazie hamowania także pedału sprzęgła", "wciśnięcie pedału sprzęgła, a następnie hamulca", 2);
        addQuestion(q143);
        Question q144 = new Question("W którym z wymienionych przypadków, uzyskuje się największą skuteczność hamowania autobusu przy pomocy hamulca silnikowego?", "przy niskich obrotach silnika", "przy wysokich obrotach silnika", "przy niskiej prędkości autobusu", 2);
        addQuestion(q144);
        Question q145 = new Question("Jak zachowasz się w sytuacji, która zmusi Cię do kontynuuowania jazdy za pojazdem nauki jazdy, bez możliwości bezpiecznego wykonania manewru wyprzedzania?", "zachowam odpowiednią odległość, mając na uwadze błędy jakie może popełnić kierujący pojazdem nauki jazdy", "użyję sygnału dźwiękowego, aby kierujący tym pojazdem mnie zauważył", "włączę światła awaryjne, jadąc w bezpiecznej odległości za nim", 1);
        addQuestion(q145);
        Question q146 = new Question("W jaki sposób możesz zmniejszyć zanieczyszczenie powietrza podczas postoju na dworcu autobusowym?", "będę utrzymywać niskie obroty silnika", "będę utrzymywać wysokie obroty silnika", "wyłączę silnik", 3);
        addQuestion(q146);
        Question q147 = new Question("Czego nie możesz robić kierując autobusem przewożącym osoby?", "słuchać muzyki", "rozmawiać przez telefon głośnomówiący", "palić tytoniu", 3);
        addQuestion(q147);
        Question q148 = new Question("Co masz obowiązek zrobić kierując autobusem przewożącym osoby przed ruszeniem z miejsca postoju?", "zawsze włączyć kierunkowskaz", "upewnić się o zamknięciu drzwi autobusu", "poinformować pasażerów o miejscu następnego postoju", 2);
        addQuestion(q148);
        Question q149 = new Question("Czy wolno Ci spożywać posiłek podczas kierowania autobusem?", "nie, jest to zawsze zabronione", "tak, jeśli w autobusie nie jest przewożona inna osoba", "tak, zawsze, pod warunkiem zachowania szczególnej ostrożności", 2);
        addQuestion(q149);
        Question q150 = new Question("Jakiego pojazdu nie wolno Ci holować?", "autobusu z przyczepą", "autobusu przegubowego", "autobusu z bagażnikiem zewnętrznym", 1);
        addQuestion(q150);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_ANSWER1, question.getAnswer1());
        cv.put(QuestionsTable.COLUMN_ANSWER2, question.getAnswer2());
        cv.put(QuestionsTable.COLUMN_ANSWER3, question.getAnswer3());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        database.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    //taking questions from the database
    public ArrayList<Question> getQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        database = getReadableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setAnswer1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER1)));
                question.setAnswer2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER2)));
                question.setAnswer3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
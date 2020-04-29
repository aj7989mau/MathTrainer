# MathTrainer
 MathTrainer is an application that helps young studens learn math in a fun and interactive way!

Komma igång:
Än så länge finns det ingen koppling mellan server och klient, då klienten enbart är GUI utan funktionalitet just nu och servern testas med en egen testmetod. Därför behöver enbart klienten laddas ner för att testköra programmet som det kommer att se ut för slutanvändaren, men servern kan vara relevant att ladda ner om man vill granska koden eller köra servertester.

För att köra klienten så laddar ni först ner MathTrainer. När ni öppnar applikationen i IntelliJ så öppna bara MathTrainerClient, inte hela MathTrainerMappen (som även innehåller servern). Klienten körs med Main.java i main-paketet, men det är inte säkert att allt fungerar direkt.

Denna applikation är skapad med JavaFX, och detta finns med i Java-mappen och projektet. Det ni lär behöva göra är dels att lägga till Java FX. Detta gör ni under File --> Project Structure --> Libraries. Det finns ett + uppe till vänster i vyn som ni kan klicka på. Där navigerar ni in i MathTrainer (mappen för detta projekt) --> Java --> JavaFX och markerar "lib"-mappen. Lägg till denna. Om ni har problem med ogiltig SDK så kan ni även lägga till Java 12 eller senare under Project-fliken här.

Efter detta så finns det en sak till som sannolikt behöver fixas. Längst uppe till höger (bredvid "play"-knappen för att köra applikationen) så kan ni trycka på den lilla pilen bredvid Main och välja "Edit configuration...".
Här inne under "VM options" skriver ni detta:

--module-path "D:\Program Files\Java\javafx-sdk-14\lib" --add-modules javafx.controls,javafx.fxml

OBS!!! Allt inom "citationstecknen" behöver bytas till eran egen path. Den ska alltså peka på den tidigare nämnda "lib"-mappen som tillhör JavaFX och ligger i MathTrainer-mappen ni laddad hem från github. 

När detta är klart bör det bara vara att köra Main-filen.


Om MathTrainer:

Syftet med projektet MathTrainer är att få grundläggande förståelse hur det är att arbeta med sina teoretiska kunskaper i praktiken. MathTrainer har som mål att hjälpa elever att bli bättre på matematik med hjälp av ett onlinebaserat matematikspel.

Projektets effekt är att fördjupa oss i projektprocessen. Samtliga gruppmedlemmar har olika syn på om den slutliga produkten ska färdigställas, några vill ha en färdig produkt medans andra är flexibla. Men en gemensam nämnare som samtliga gruppmedlemmar har är ambitionen att lära oss. Men huvudsyftet är att under en begränsad tid utveckla en produkt, hitta lösningar eller en tjänst för produkten Mathtrainer.

Omfattning
Den grundläggande omfattningen kommer bestå av enklare spel som är till hjälpmedel för elever i årskursen 6, men fokus åligger att produkten ska bli verkställd. Därför kommer fokuset inte specifikt vara att alla årskurserna integreras i systemet utan att kvaliteten ska bli optimal för att kunna presenteras. När det gäller de externa begränsningarna handlar det om tid(220h), kunskapsnivån, och budget. Projektgruppen har vid projektets början räknat med interna begränsningar såsom personalbortfall samt olika kunskapsnivåer.

Mål
MathTrainer har som gemensamt mål är av lärande karaktär knutet till projektprocessen som används i det faktiskt livet. Projektgruppen kommer öva på att använda spelkoncept i pedagogiskt syfte. Utgångspunkten är att få skapa en mindre produkt som är färdig nog att kunna användas fullt ut, hellre än att göra en större prototyp som saknar praktisk funktionalitet och därmed är obrukbar. Mindre färdig produkt innebär för projektgruppen att kunna dela med sig av produkten till eventuella intressenter och göra den användbar i praktiken, även om alla planerade funktioner inte är på plats.

Intressenter
De aktuella intressenter i projektet för MathTrainer kommer i huvudsak att vara utvecklare, malmö universitet(lärare, examinator, handledare), användare. En presumtiv kund kan vara skolmyndigheten och eventuellt föräldrar eller läxstödsverksamheter. Utvecklare påverkar och ser till  att projektet blir genomfört och ansvarar för den dagliga kommunikationen med övriga intressenter. Malmö universitet är de som ställer de grundläggande riktlinjerna/kraven för processen och användaren är den som avser att använda produkten. Projektet kommer att anpassas efter de kunskaper som slutanvändarna behöver besitta, och behöver därför följa skolmyndighetens kunskapsmål och läroplan för eleverna i målgruppen.

Målgrupp
Målgruppen är de som använder produkten i form av matematiklärare samt elever i årskursen 6. Skolorna kommer vara målgrupp i form av tillhandahållare/köpare av produkten.

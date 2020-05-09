# MathTrainer
 MathTrainer is an application that helps young studens learn math in a fun and interactive way!

Komma igång:
MathTrainer är delvis byggt med JavaFX (som finns med i projektmappen ni laddar hem). Det blir lite extra att pilla med men det ska nog gå bra!

Den enkla biten:
1 - Ladda ner zip-filen från repositoryn och extrahera mappen där du vill ha den.
2 - Öppna MathTrainerServer och MathTrainerClient separat, dvs öppna inte hela MathTrainer-master, utan bara de två projekten inne i denna mapp i varsitt IntelliJ-fönster.
3 - Lägg till SDK i vardera projekt om detta inte sker automatiskt. Detta görs i IntelliJ via File --> Project Structure --> Project. Vi kör båda projekten i Java 13.

När detta är klart bör Servern vara körbar. Denna ska förstås köras först, och startas med klassen Main (övriga klasser med Main-metoder är bara för intern testning, så ni behöver ej köra dessa).

Nu den lite krångligare biten, som bara ska göras i MathTrainerClient:
1 - Tryck på "Run" i IntelliJ (detta hittas i menyn högst upp, långt till höger om File), sedan på "Edit configurations..."
2 - I fältet "VM options" ändrar ni början av filepathen (bara filepathen, den som står inom "citationstecken"). Ändra bara den bit som kommer före "\Java" till den mapp du extraherade projektet MathTrainer i (själva huvudmappen, inte specifikt klienten).

Exempel: Om ni har extraherat projektet i C:\Program Files så blir pathen "C:\Program Files\MathTrainer-master\Java\javafx-sdk-14\lib"
Hela VM Options raden skulle då bli:
--module-path "C:\Program Files\MathTrainer-master\Java\javafx-sdk-14\lib" --add-modules javafx.controls,javafx.fxml

När detta är gjort trycker ni på OK, och klienten bör också vara körbar! Körning startas via Main-klassen.


Notis: Alla knappar är ej i bruk, och all logik är inte implementerad ännu. Men det märker ni nog! Det är bara "Övningar" som är implementerad någorlunda färdigt.


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

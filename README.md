# Zadaća iz predmeta "Razvoj programskih rješenja"
# OPIS ZADATKA
Potrebno je napraviti Java Maven konzolnu aplikaciju koja će se koristiti za parsiranje i izračunavanje artmetičkih izraza korištenjem Dijkstra algoritma za evaluaciju izraza opisanog u paragrafu ispod. 

Za implementaciju je potrebno uraditi slijedeće:

Potrebno je napraviti klasu ExpressionEvaluator koja će imati jednu javnu metodu evaluate koja prima parametar tipa String i vraća rezultat tipa Double.
Klasa ExpressionEvaluator treba da koristi dvije instance klase java.util.Stack kako bi implementirala Dijkstra algoritam.  
Potrebno je napraviti klasu App koja ce imati main methodu koja parsira ulaz s konzole iz parametra args i vrši njegovu validaciju. 
Potrebno je napraviti klasu ExpressionEvaulatorTest koja ce imati minimalno 5 unit testova za provjeru ispravnosti rada algoritma. 
Projekat mora imati javadoc dokumentaciju na svim klasama i metodama. Takođe je potrebno dodati maven javadoc plugin kako bi se mogla izgenerisati HTML dokumentacija.
Ulazna klasa s main metodom kora biti deklarisana u maven jar pluginu kako bi se kompajlirani jar program mogao poreknuti iz komandne linije. 
U slučaju da uneseni izraz nije aritmetički validan program treba da baci izuzetak tipa RuntimeException. Jedan od unit testova mora pokriti ovaj slučaj. 
Potrebno je uraditi samo implementaciju algoritma za izraze koji su omeđeni zagradama i koji nema podršku za prioritet operatora. 
Možete pretpostaviti da će svi izrazi biti razdvojeni spaceom radi lakšeg parsiranja ulaznog izraza. Izraz ( 1 + ( 5 * 20 ) ) se smatra validnim dok se izraz ( 1 + ( 5* 20)) smatra nevalidnim.

# wireworld game
## 1. Feladat: Wireworld
A választott feladat egy sejtautomata, amely úgy működik, hogy egy 2D rács minden mezője 
(cellája, sejtje) egy adott állapotban van (ez nem csak kettő, hanem többféle is lehet), majd 
minden egyes iterációban a környezettől függően változik a cellák állapota.
Egy többszínű automatát valósítok meg, amivel szimulálni lehet a kábeleken futó 
elektromosságot, és igy fel lehet építeni vele logikai kapukat és akár egy teljes számítógépet.
Négy fajta állapotot különböztetek meg:
• 0-üres
• 1-elektronfej
• 2-elektronfarok
• 3-vezeték
A szabályok a következők:
• 0 → 0 [az üres üres marad]
• 1 → 2 [az elektron továbbmegy, és a fejből farok lesz]
• 2 → 3 [az elektron továbbmegy, és a farok eltűnik, a helyén vezeték lesz]
• 3 → 1, ha pontosan 1 vagy 2 szomszédos elektronfej van [ettől megy előre az 
elektron, illetve így egyesül két elektron]
## 2. Feladatspecifikáció
A játékos a programot elindítva a menübe lép. A menüben a következő menüpontok közül 
választhat: 
• Játék indítása
• Fájlok kezelése
• Kilépés
A játék indítása menüpontot választva lépünk a szimulációba, ahogy 2D-s cellák jelenik 
meg. A játéktér 20x20 cellából áll. Amiken az egérrel a megfelelő cellára kattintva
végezhetünk egyfajta műveltet, ami a cella állapotának módosítása. A szimulációt el tudjuk 
indítani, majd megállítani. A cellák az 1. pontban leírt szabályok alapján viselkednek, amikor 
a szimuláció el van indítva.
A fájlok kezelése menüpontban lehetőség van a legutóbbi játékállást fájlba menteni vagy 
pedig fájlból beolvasni egy állást, a fájl nevének megadásával. A fájlformátum a következő:
Egyes sorokban a megengedett állapotok számai (0, 1, 2, 3) egymás mellett szóköz nélkül. 
Minden egyes sor 20 számjegyet tartalmaz és összesen 20 sor van.
A kilépés menüpontot kiválasztva a program bezár
## 3. Felhasználói kézikönyv
A programot elindítva egy 30x30-as négyzetrács fogad minket. Ennek az ablaknak a jobb 
oldalán helyezkedik el egy Start/Stop gomb, valamint a bal felső sarokban egy File feliart, 
melyre kattintva az Import és Export fülek nyílnak le.
A középen található négyzetrácsokra kattintva tudjuk változtatni a cellák állapotát, melyet a 
program különböző színekkel jelez. Az üres cella fekete, a vezeték sárga, az elektronfej kék, 
míg az elektronfarok piros.
A Start/Stop gombot lenyomva indul el a szimuláció, amikoris a cellák a játék működésének 
megfelelően változtatják színüket, azaz
• üres cella → üres cella [az üres, üres marad]
• elektronfej → elektronfarok [az elektron továbbmegy, és a fejből farok lesz]
• elektronfarok → vezeték [az elektron továbbmegy, és a farok eltűnik, a helyén vezeték 
lesz]
• vezeték → elektronfej, ha pontosan 1 vagy 2 szomszédos elektronfej van [ettől megy 
előre az elektron, illetve így egyesül két elektron]
A szimulációt a Start/Stop gomb ismételt megnyomásával állíthatjuk le. A cellák csak akkor 
kattinthatók, ha a szimuláció áll.
A File feliratra kattintva az Importot választva a játékban egy korábban elmentett állást 
tudunk betölteni a számítógépen lévő fájlok között keresve vagy pedig név szerint megadható 
a fájl, amit be szeretnénk tölteni.
Az Export menüpontot választva az adott állást tudjuk elmenteni egy általunk megadott 
néven.


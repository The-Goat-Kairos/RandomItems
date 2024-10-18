### Plugin voor ElfElf123

# DIT IS ALLEN VOOR ELVEN OOGJES; ANDEREN ZIJN NIET TOEGESTAAN
Oke dus dit is een minigame, volgens mij? 
Het idee is dat iedereen elke minuut ofzo een willekeurige hoeveelheid van een willekeurig voorwerp krijgt.
Er zijn ook een paar andere non-vanilla items (wel met vanilla textures) die zijn te zien door de custom naam en de gloei van enchantments. Deze items doen leuke dingen.

Ik moet nog wel uitvogelen hoe ik de JAR file (de daadwerkelijke plugin die je in de server folder stopt) bij jou ga krijgen als ik hier iets update.
Je kan het ook zelf compilen maar dat zal even kosten om uit te leggen hoe.

Qua hoe de plugin werkt:
Er zijn 2 belangrijke commands: startevent en stopevent die alleen jij (Elf) en ik kunnen gebruiken. Deze starten en stoppen het evenement respectievelijk.
/startEvent kan alleen gebruikt worden als het spel nog niet is begonnen en /stopEvent kan alleen gebruikt worden als het evenement is begonnen om bugs te voorkomen.
Elke 60 seconden krijgt elke player een random hoeveelheid van een random item waarmee ze dan van alles kunnen doen. Idealiter zitten ze in een void wereld met ieder een 3x3 bedrock platform ofzo, maar dat heb ik nog niet geregeld. 

Er zijn een paar items verbannen en die zijn ook onmogelijk om te krijgen. Deze kan je vinden bij de main file structure en dan op "src/main" te drukken, dan op "java/com/kairos/randomItems" en dan zit het in "BannedItems.java"
Dit is technisch gezien code maar het is ook gewoon een lijst die je heus wel kan begrijpen. Alles is in de vorm "Material.*item in caps\*". Ik heb gekozen om spawn eggs niet te verbannen want die leken me grappig

Er is een command die de tijd aanpast: /klok *nummer\* *t/s/m/h/d\*. Deze tijd is in seconden. Zonder het aan te passen staat deze tijd op 60s. De letters achter het nummer bepalen de tijdeenheid. t is voor ticks, s is voor secondes, m is voor minuten, h is voor uur (hour) en d is voor dag. 

Als je geinteresseerd bent kan je wel even door de code kijken, is wel grappig lol
De "Main" file zit in "src/main/java/com/kairos/randomItems" en heet RandomItems.java. Hierin staan de enable en disable functions die zeggen wat er gebeurt als de server aan en uit gaat. De RandomItemGiver geeft de spelers de daadwerkelijke items.
De CommandManager zorgt dat alle commands bestaan (kijk maar in "src/main/java/com/kairos/randomItems/commands/CommandManager.java". Je kan ook kijken hoe de start en stop commands werken.

Dat was 'em wel

package ooe;
/**
 * ERLÄUTERUNG
 * Dieses Paket ist das Spiel Waldlauf mit dem objektorientierten Programmierparadigma
 * 
 * Durch dieses Programmierparadigma wird ein wesentlicher Nachteil ausgeglichen: die Hantierung mit dem Array.
 * Der zweidimensionale Array ist bislang eine praktikable Lösung gewesen, um die Begegnungen zu speichern.
 * 
 * Der Quellcode ist dennoch schwer zu lesen, ohne sich mit diesem zuvor gründlich zu beschäftigen
 *  - die Inhalte der Begegnung sind nicht namhaft, sondern reine "Koordinaten". Man muss sich zuvor
 *    mit der Struktur des Arrays beschäftigen und ggf. immer wieder nachlesen, welche "Spalte" welchen
 *    Inhalt hat, um zu verstehen, welcher Inhalt abgerufen wird. Selbsterklärend ist hier nichts.
 *    
 *  - der Lebensabzug muss immer wieder gecastet werden, da es sich um ein String[][]-Array handelt.
 *    zum einen wird der Quellcode hier ebenfalls unleserlicher durch die Zusatzanweisungen,
 *    zum anderen werden hier zusätzliche Ressourcen für das Umwandeln verbraucht
 * 
 * Ein weiterer Vorteil ist der optimale Einsatz einer Liste. Natürlich könnte man auch eine Liste voller 
 * eindimensionaler Arrays erstellen und verwalten. Das fühlt sich aber ein wenig an, wie hochwertiges istrisches Olivenöl
 * aus Zadar mit Essigessenz aus der Plastikflasche für ein Dressing zu panschen.
 * 
 * Eine Liste voller Objekte hingegen ist eine perfekte Verwaltung. Insofern das Prinzip der Kapselung verstanden wurde,
 * sollte der Quellcode und die Verarbeitung viel leichter zu lesen sein und der Ablauf ebenso eingängiger.
 * Für den Entwickler ist hier ebenfalls viel weniger Fehlerpotenzial. Alleine das Verrutschen im Index des Begegnungsarrays.
 * 
 * Durch die hier eingesetzte Liste bieten sich zusätzliche Möglichkeiten, insofern der Entwickler wert drauf legt. Listen
 * sind dynamisch. Das hat zur Folge, dass eine Begegnung nur einmal in einem Spiel vorkommen kann. Oder man einen Counter bei dem 
 * Objekt einfügen könnte, dass wenn man z.B. 3x dem Hulk begegnet ist, ihn dann rauswirft.
 * 
 * Eine Sache, die hier verändert wurde ist der Lebensabzug. Das hätte man auch zuvor genauso mittels 0 und 1 regeln können, ist 
 * hier aber durch die Eigenschaften noch natürlicher zu hinterlegen. Daher wird das Leben nicht einfach so oder so abgezogen,
 * sondern bei jeder Begegnung sind boolsche Werte hinterlegt, die abgefragt werden.
 * 
 * Unwesentlich ist, ob die Daten zuvor aus einer externen Quelle gelesen werden mussten - für die Verarbeitung müssen die Daten
 * zumindest während der Laufzeit importiert werden, um verarbeitet werden zu können.
 * Hier ist also kein Vorteil durch den OO-Ansatz gegeben. Der import von Daten von einem DBserver wäre bei jedem bisherigen 
 * Paradigma möglich gewesen.
 * 
 * Wichtig ist: Das Objektorientierte Paradigma ist NICHT dazu da, um den Code zu vereinfachen. Vergleicht man dieses Programm mit 
 * dem strukturierten Programmierparadigma, wird man zweifelslos feststellen: "Uff, das ist echt viel Code! Wesentlich mehr!! Warum
 * soll ich das denn so machen, wenn es doch anders kürzer geht?"
 * 
 * Die Antwort: muss man nicht. Beide Paradigmen sind absolut legitim. (und jetzt mal ehrlich, warum macht man das dann?) 
 * Die Antwort: Wenn man das Programm irgendwann erweitern, ändern möchte oder - unglaublich - Code wiederverwenden möchte, ist das
 * strukturierte Programmierparadigma die Pest in Dosen. 2 Wochen später muss man sich durch den Code kämpfen, analysieren, was man wo 
 * gemacht hat. Reines Copy & Paste führt häufig dazu, dass unnötige Variablen mitkopiert werden, die schlimmstenfalls Nebeneffekte mit
 * sich bringen, wobei hier häufig die IDE noch hilft (aber mal ehrlich, will man stoisch einem Programm vertrauen?)
 * Beim OOP ist dagegen alles säuberlich aufgeteilt, dass man genau weiß, was man wo ändert und was hingegen nicht beeinflusst wird.
 * Man kann prinzipiell eine komplette Klasse wiederverwenden, leicht anpassen und direkt nutzen.
 * 
 * In anderen Worten: funktionieren tut alles. Wenn man aber weiß, dass man gerade etwas programmiert, was danach nicht direkt in den Müll
 * landet und man nie wieder sehen wird, ist das OOP definitiv der bessere Ansatz.
 * 
 * --------------------------------------------------------------------------------------------------------
 * Wichtig ist beim objektorientierten Ansatz: 
 * Die Strukturierung hätte auch anders sein können. Die Bildung von Klassen ist häufig subjektiv, da Personen eine
 * unterschiedliche Wahrnehmung haben, was ein Objekt ist, was ein Objekt von einem Objekt ist ...
 * (kein Scherz, es gibt komplette Vorlesungen zur Ontologie und ich danke hier Prof. Dr. Dirk Rustemeyer dafür, 
 * dass ich nicht mal fehlerfrei eindeutig eine Klasse "Tisch" definieren könnte).
 * Genauso schwer ist es häufig zu bestimmen, welche Klassen mit welchen kommunizieren sollen. 
 * 
 * Daher Tipps für die Ansätze zur Bildung von Klassen:
 * 1. Benötigte Variablen herausarbeiten und sie zu sinnigen Objekten entsprechend der Welt zusammenfassen
 * 2. Bei Eigenschaften herausstellen, ob man diese mit 1, 2, 3... hochzählen würde
 *   (z.B. : Ein Spiel hat 4 Spieler, ein Getränk besteht aus 1 oder mehr Zutaten, eine Person hat 1 oder mehrere Telefonnummern...)
 *   bei einer 1...n Multiplizität ist es meistens sinnig, eine neue Klasse zu bilden. 
 *   Also anstelle in der Klasse Spiel die Eigenschaften spieler1, spieler2, spieler3, spieler4 zu haben, lieber eine Klasse Spieler zu erstellen.
 *   WICHTIG: Auch dieses ist nicht in Stein gemeißelt. Wenn ich ein 1-Runden Tic-Tac-Toe-Spiel erstelle und brauche nur die Namen der 
 *     Spieler (und es sind definitiv immer 2 Spieler), würde ich nicht eine Klasse Spieler erstellen, die nur aus der Eigenschaft "spielername" besteht.
 *     Wenn ich allerdings noch pro Spieler die Gewinnquote speichern wollen würde oder das Spiel über mehrere Runden läuft, wobei der am Ende gewinnt,
 *     der die meisten Runden gewonnen hat, DANN würde ich eine Klasse Spieler erstellen, da dieser nicht nur einen Namen hat, sondern auch die Anzahl 
 *     der gewonnen Spiele in Folge
 *  3. Wenn man die 1:n Multiplizität / Kardinalität hat, ist das meist ein Indikator für eine Liste mit Aggregation oder Komposition (Teile-Ganzes-Beziehung)
 *  4. Das Verbinden von Klassen funktioniert genauso wie bei Datenbanken. Wenn man die Eigenschaften zu Klassen geclustert hat, kann man
 *     genauer definieren, welche Klasse eine andere Klasse als Untereigenschaft hat oder was wie aufeinander zugreift oder wo Knotenpunkte sind.
 *  5. Was ist noch zu beachten
 *     - man sollte immer überlegen, in wieweit ein Programm noch erweitert werden sollte. Feststehende Klassen erneut aufzusplitten ist sehr viel Arbeit
 *       Ein Beispiel: In einem Computerspiel gibt es eine Klasse mit einem Charakter mit einer Waffe und einer Rüstung. Es genügt hier eine Klasse "SpielerCharakter" 
 *       zu erstellen. Wenn man vorhat, dass dieser Charakter Rüstungen mit sich führen kann, die er immer wieder austauschen können soll genauso wie die Waffen,
 *       sollte man direkt die jeweiligen Klassen erstellen
 *     - nicht zu viel erstellen: Wenn ich nicht vorhabe, den Charakter mehrere Waffen und Rüstungen mit sich führen zu lassen, erstelle ich das nicht! Das ist nur 
 *       unnötiger Code, der Ressourcen aufgrund unnötiger Klassen und Parameterübergaben verschwendet. Daher konkret überlegen, was das Programm konkret benötigt 
 *		 ( Kundenauftrag konkret im Visier haben) und NICHT alle unnötigen Eventualitäten miteinschließen, die keiner will.
 *
 ***********************************************************************************************/ 
/**
 * @version 1.0
 * @author C. Frantzen
 * @since 1.0
 **/
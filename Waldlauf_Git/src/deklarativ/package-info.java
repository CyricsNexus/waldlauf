package deklarativ;
/**
 * ERLÄUTERUNG
 * Dieses Paket übernimmt Inhalte aus dem deklarativen Programmierparadigma
 * 
 * Das deklarative Programmierparadigma ist ergebnisbezogen statt algorithmus. Statt Bedingungen und Schleifen
 * werden bestenfalls nur Parameter eingegeben und der Compiler erledigt den Rest.
 * z.B. anstelle einen Sortieralgorithmus selber zu schreiben, wird der Algorithmus anderweitig geschrieben
 * und durch einen Befehl wie arr.sort() sieht jeder sofort, was da gemacht wird. Auch Vorselektion durch SQL-Abfragen gehört dazu.
 * 
 *  Damit das funktioniert, müssen sämtliche Methoden / Funktionen bereits zur Verfügung stehen. Teilweise wirkt der Code
 *  dadurch wie Pseudocode
 *  
 *   Dieses Paket ist eine Erweiterung von dem Paket ooe. Was hier verändert wurde ist, dass hier der Import der Daten aus einer 
 *   Datenbank simuliert wurde. Daher befinden sich die Dummy-Daten in einer eigenen Klasse "BegegnungsDB" und werden von einem
 *   Array in eine ArrayList übertragen. Dadurch sollte es in zukünftigen Projekten einfacher fallen, externe Daten zu importieren.
 *   
 *   Was auffällt: durch den deklarativen Ansatz überlegt man sich häufig "Verschlankungen". So wurden bei Begegnungen nicht lediglich
 *   Getter hinterlegt, sondern ein Algorithmus, der die korrekten Ausgaben zurückgibt. 
 *
 ***********************************************************************************************/ 
/**
 * @version 2.0
 * @author C. Frantzen
 * @since 2.0
 **/
package deklarativ;
/**
 * ERL�UTERUNG
 * Dieses Paket �bernimmt Inhalte aus dem deklarativen Programmierparadigma
 * 
 * Das deklarative Programmierparadigma ist ergebnisbezogen statt algorithmus. Statt Bedingungen und Schleifen
 * werden bestenfalls nur Parameter eingegeben und der Compiler erledigt den Rest.
 * z.B. anstelle einen Sortieralgorithmus selber zu schreiben, wird der Algorithmus anderweitig geschrieben
 * und durch einen Befehl wie arr.sort() sieht jeder sofort, was da gemacht wird. Auch Vorselektion durch SQL-Abfragen geh�rt dazu.
 * 
 *  Damit das funktioniert, m�ssen s�mtliche Methoden / Funktionen bereits zur Verf�gung stehen. Teilweise wirkt der Code
 *  dadurch wie Pseudocode
 *  
 *   Dieses Paket ist eine Erweiterung von dem Paket ooe. Was hier ver�ndert wurde ist, dass hier der Import der Daten aus einer 
 *   Datenbank simuliert wurde. Daher befinden sich die Dummy-Daten in einer eigenen Klasse "BegegnungsDB" und werden von einem
 *   Array in eine ArrayList �bertragen. Dadurch sollte es in zuk�nftigen Projekten einfacher fallen, externe Daten zu importieren.
 *   
 *   Was auff�llt: durch den deklarativen Ansatz �berlegt man sich h�ufig "Verschlankungen". So wurden bei Begegnungen nicht lediglich
 *   Getter hinterlegt, sondern ein Algorithmus, der die korrekten Ausgaben zur�ckgibt. 
 *
 ***********************************************************************************************/ 
/**
 * @version 2.0
 * @author C. Frantzen
 * @since 2.0
 **/
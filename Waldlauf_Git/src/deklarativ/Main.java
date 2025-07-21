package deklarativ;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	/*********************************************************************************
	 *  Ein Unterschied zu dem prozeduralen Beispiel ist, dass ich die Main-Methode nicht ganz so entschlackt habe.
	 *  	Während ich im Prozeduralen Programmierp. zeigen wollte, wie weit man Prozeduren verschachteln kann, ist mir hier
	 *  die generelle Lesbarkeit wichtiger. Hier wurden nur Prozeduren in der Main-Methode erstellt, 
	 *  die Fehler abfangen sollen oder die Daten bereitstellen. 
	 *  
	 *  Viele Methoden sind hier nicht mehr aufgeführt, weil diese Teil des Spiels (Klasse Spiel) sind und nicht Teil des Ablaufs
	 *  
	 *  Man hätte hier noch Sicherheitsmaßnahmen zulasten des Speichers und der Verarbeitungszeit einbauen können, wie z.B. 
	 *  ein Switch-Case nach der Entscheidung, dass die Benutzerauswahl einen String "streicheln", "fuettern" oder "hauen" übergibt 
	 *  der dann von der Klasse ListeBegegnung ausgewertet wird, statt die direkte Eingabe 1, 2 oder 3, um Programmierfehler zu vermeiden.
	 *  Hier gibt es kein konkretes "richtig" oder "falsch". Da dieses in einem Zug verarbeitet werden konnte und nicht davon
	 *  auszugehen ist, dass dieses zukünftig erweitert werden soll, wurde auf die Sicherheitsmaßnahme zugunsten Ressourcen verzichtet
	 * ******************************************************************************/
	
	public static void main(String[] args) throws IOException {
		//----------------------------------------
		// INIT
		
		Scanner sc = new Scanner(System.in);							// Instanziierung Benutzereingabe
		
		int leben = 3;
		int anzahlRunden = 10;
		
		Spiel meinSpiel = new Spiel(leben, anzahlRunden); 			// Spiel mit 3 Leben und 10 Runden
		List<Begegnung> listeDB = BegegnungsDB.getBegegnungsDB();		// Simuliert das Erhalten einer Liste aus einer Datenbank

/*		
		List<Begegnung> listeBegegnungen = 							// Hier wäre ein Beispiel, wie man den Array komplett in eine ArrayList
				listeDB.stream()										// übertragen könnte. Allerdings soll hier der Vorteil des Arrays
				.collect(Collectors.toList());						// genutzt werden: Es existieren exakt 10 Runden. Nicht mehr und nicht weniger
*/
		
		List<Begegnung> begegnungen = new ArrayList<Begegnung>();		// Fügt jeder Runde eine Begegnung hinzu
		for(int i = 0; i < meinSpiel.getAnzahlRunden(); i++) {		// leider lässt sich nicht jede Schleife deklarativ abkürzen
			begegnungen.add(getZufallsBegegnung(listeDB));
		}
		
		//----------------------------------------		
	    // SPIELABLAUF
		
		Spiel.ausgebenIntro();										// Spielintro
		
		// Schleife, welche so lange durchlaufen wird, bis kein Leben vorhanden ist oder die letzte Runde geschafft wurde  
		for(Begegnung einzelneBegegnung : begegnungen) {
			Spiel.ausgebenFolgebegegnung();																// Nachteil bei foreach: Rundenindex müsste als Extravariable deklariert werden - dadurch kann nicht ohne Extravariable überprüft werden, ob es die 1. Runde ist
			byte entscheidung = eingabeBenutzer(sc);														// Benutzerauswahl + Überprüfung der gültigen Benutzereingabe 1 (streicheln), 2 (füttern) oder 3 (hauen)
			Spiel.leerenKonsole();																		// Bildschirm vor Auswirkung leeren, damit bessere Lesbarkeit in der Konsole vorhanden ist
			einzelneBegegnung.getReaktion(entscheidung); 													// Ausgabe der Reaktion der Begegnung auf Benutzereingabe
			if(einzelneBegegnung.isLebensabzug(entscheidung)) meinSpiel.lebenVerringern();				// Wenn Benutzerauswahl schlecht war, dann Leben verringern
			
			if(!meinSpiel.lebenVorhanden()) break;														// Vorzeitiger Abbruch, falls kein Leben mehr vorhanden
		}
		
		meinSpiel.ausgebenNachrichtEnde();																// Ausgabe, ob man gewonnen oder verloren hat
		
		//----------------------------------------		
	    // AUFRÄUMEN - HEAP LEEREN
		sc.close();
		sc = null;
		meinSpiel = null;
		listeDB = null;
		begegnungen = null;
	}
	
	/*********************************************************************************	
	* Um die Main-Methode nicht unnötig aufzublähen, wurden die Begegnungen in diese Methode
	* extrahiert. Zurückgegeben wird eine Liste mit Begegnungen
	* 
	* Durch die Vorgabe der Parameter und Unterstützung der IDE, ist eine fehlerhafte Eingabe hier wesentlich schwieriger.
	* Auch ist es bereits bei der Eingabe nicht mehr möglich, falsche Datentypen beim Lebensabzug einzugeben. 
	* Die Fehlermeldung würde direkt hier aufploppen, wo die Ursache ist und nicht später bei der Verarbeitung.
	*********************************************************************************/

	// Gibt eine der Zufallsbegegnungen zurück
	private static Begegnung getZufallsBegegnung(List<Begegnung> listeDB) {
		Random zufallszahl = new Random();
		return listeDB.get(zufallszahl.nextInt(listeDB.size()));
	}

	/*********************************************************************************	
	* Diese Methode habe ich nicht in die Klasse Spiel verschoben, da es lediglich um die Überprüfung einer 
	* korrekten Eingabe (1, 2 oder 3) geht und das keine spezielle Mechanik des Spiel-Objekts ist, sonder den 
	* korrekten Ablauf in der Main-Methode sichert.
	* *******************************************************************************/
	
	private static byte eingabeBenutzer(Scanner sc) throws IOException {

		byte eingabe = 0;
		boolean eingabeGueltig = false;									// für Errorhandling, dass Benutzer 1, 2 oder 3 eingibt

		// Eingabe des Benutzers + Errorhandling
		while(!eingabeGueltig) {					// Solange keine gültige Eingabe vorhanden ist, soll die Eingabe wiederholt werden
			try {									// Überprüfe, ob Fehler gemacht wurde
				eingabe = sc.nextByte();		// BenutzerEingabe 1, 2 oder 3
				if (eingabe >=1 && eingabe <=3) {	// Falls Eingabe=Byte, dann überprüfen, ob Wert zwischen 1-3
					eingabeGueltig = true;
				} else {							// 		Wenn Wert nicht zwischen 1-3 Fehlermeldung und Wiederholung
					Spiel.ausgebenNachrichtEingabefehler();
				}					
			} catch (InputMismatchException e) {	// Wenn Eingabe kein Byte-Datentyp
				Spiel.ausgebenNachrichtEingabefehler();
				sc.next();
			}
		}
		return eingabe;
	}

}

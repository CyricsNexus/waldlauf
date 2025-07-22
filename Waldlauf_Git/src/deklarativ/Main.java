package deklarativ;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	/*********************************************************************************
	 *  Hier wurde ein funktionales Interface (Ausgabe) hinzugef�gt, um den Vergleich zu einer
	 *  Prozedur zu machen (ob das hier schlanker/verst�ndlicher ist, als eine simple Prozedur 
	 *  mit Parametern, sei in diesem Beispiel dahingestellt)
	 *  
	 *  Der deklarative Ansatz ist vor allem erneut in den Methodenaufrufen zu sehen sowie in der
	 *  forEach-Schleife, dem Bef�llen des Arrays 
	 *  
	 * ******************************************************************************/

	@FunctionalInterface									// Dieses wurde erstellt, um die Ausgabe zu �bernehmen
															// und vorher Leerzeilen einzuf�gen
	interface Ausgabe {
	    public void ausgeben(int zeilen, String nachricht);
	}

	
	public static void main(String[] args) throws IOException {
		//----------------------------------------
		// INITIALISIERUNG
		
		// Was das funktionale Interface mit den Parametern machen soll
        Ausgabe info = (zeilen, nachricht) -> {
        	for(int i = 0; i < zeilen; i++) System.out.print("\n");		// Anzahl der Leerzeilen vor der Nachricht
            System.out.println(nachricht); 								// Ausgabe der Nachricht
        }; 

		Scanner sc = new Scanner(System.in);							
				
		int leben = 3;
		int anzahlRunden = 10;
		
		Spiel meinSpiel = new Spiel(leben, anzahlRunden); 				// Spiel mit 3 Leben und 10 Runden
		final List<Begegnung> listeDB = BegegnungsDB.getBegegnungsDB();	// Simuliert das Erhalten einer Liste aus einer Datenbank
		
		Begegnung[] begegnungen = new Begegnung[10];
		Arrays.setAll(begegnungen, v -> getZufallsBegegnung(listeDB));	// F�llt den Array mit Zufallsbegegnungen
		

		//----------------------------------------		
	    // SPIELABLAUF

		info.ausgeben(1,"Du bist in einem Wald und hast einen Wanderstab sowie einen Rucksack voll "		//Ausgabe Intro
				+ "mit Eier-Tomaten-Gurken-Sandwiches. \nEs ist sehr dunkel und du kannst kaum die "
				+ "Hand vor Deinen Augen sehen.");
		  
		for(Begegnung einzelneBegegnung : begegnungen) {
			info.ausgeben(1,"Du setzt Deinen Weg fort. Aber - was ist das? Eine Begegnung. Du kannst sie "	// Nachteil bei foreach: Rundenindex m�sste als Extravariable deklariert werden - dadurch kann nicht ohne Extravariable �berpr�ft werden, ob es die 1. Runde ist
					+ "nicht erkennen. M�chtest Du die Begegnung \n1) streicheln?\n2) f�ttern?\n"
					+ "3) oder mit dem Stock hauen?");
			
			byte entscheidung = eingabeBenutzer(sc);													// Benutzerauswahl + �berpr�fung der g�ltigen Benutzereingabe 1 (streicheln), 2 (f�ttern) oder 3 (hauen)
			info.ausgeben(10,einzelneBegegnung.getReaktion(entscheidung)); 												// Ausgabe der Reaktion der Begegnung auf Benutzereingabe
			if(einzelneBegegnung.isLebensabzug(entscheidung)) meinSpiel.lebenVerringern();				// Wenn Benutzerauswahl schlecht war, dann Leben verringern
	
			if(!meinSpiel.lebenVorhanden()) break;														// Vorzeitiger Abbruch, falls kein Leben mehr vorhanden
		}
		
		if (meinSpiel.getLeben() == 0)
			info.ausgeben(2,"Du hast es leider nicht aus dem Wald geschafft. Viel Gl�ck beim n�chsten Mal.");
		else
			info.ausgeben(2,"Der Wald lichtet sich. \nFroh am leben zu sein, setzt Du Deinen Weg fort."); // Ausgabe, ob man gewonnen oder verloren hat
		
		//----------------------------------------		
	    // AUFR�UMEN - HEAP LEEREN
		sc.close();
		sc = null;
		meinSpiel = null;
		begegnungen = null;
	}
	
	// Gibt eine der Zufallsbegegnungen zur�ck
	private static Begegnung getZufallsBegegnung(List<Begegnung> listeDB) {
		Random zufallszahl = new Random();
		return listeDB.get(zufallszahl.nextInt(listeDB.size()));
	}

	/*********************************************************************************	
	* Hier wurde die Ausgabe wie gehabt belassen
	* *******************************************************************************/
	
	private static byte eingabeBenutzer(Scanner sc) throws IOException {

		byte eingabe = 0;
		boolean eingabeGueltig = false;									// f�r Errorhandling, dass Benutzer 1, 2 oder 3 eingibt

		// Eingabe des Benutzers + Errorhandling
		while(!eingabeGueltig) {					// Solange keine g�ltige Eingabe vorhanden ist, soll die Eingabe wiederholt werden
			try {									// �berpr�fe, ob Fehler gemacht wurde
				eingabe = sc.nextByte();			// BenutzerEingabe 1, 2 oder 3
				if (eingabe >=1 && eingabe <=3) {	// Falls Eingabe=Byte, dann �berpr�fen, ob Wert zwischen 1-3
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

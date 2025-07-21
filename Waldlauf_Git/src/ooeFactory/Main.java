package ooeFactory;

import java.io.IOException;
import java.util.InputMismatchException;
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
	 * @throws Exception 
	 * ******************************************************************************/
	
	public static void main(String[] args) throws Exception {
		//----------------------------------------
		// INIT
		
		Scanner sc = new Scanner(System.in);							// Instanziierung Benutzereingabe
		Random random = new Random();								// Instanziierung Zufallszahl für Zufallsbegegnungen
		
		Spiel meinSpiel = new Spiel(3, 10); 							// Spiel mit 3 Leben und 10 Runden
		ListeBegegnung listeBegegnung = addBegegnungenImSpiel();		// diese ist dynamisch und benötigt daher keine vorherige Angabe, wie viele Begegnungen vorhanden sind
		
		//----------------------------------------		
	    // SPIELABLAUF
		
		Spiel.ausgebenIntro();										// Spielintro
		
		// Schleife, welche so lange durchlaufen wird, bis kein Leben vorhanden ist oder die letzte Runde geschafft wurde  
		for(int runde = 1; runde <= meinSpiel.getMaxRunde(); runde++) {
			int zufallsBegegnung = random.nextInt(listeBegegnung.getListeBegegnung().size());				// Zufällige Auswahl der Begegnung
			if (runde > 1) Spiel.ausgebenFolgebegegnung();												// Rundenanfangstext, wenn Intro aus Spielbeginn nicht angezeigt wurde
			byte entscheidung = eingabeBenutzer(sc);														// Benutzerauswahl + Überprüfung der gültigen Benutzereingabe 1 (streicheln), 2 (füttern) oder 3 (hauen)
			Spiel.leerenKonsole();																		// Bildschirm vor Auswirkung leeren, damit bessere Lesbarkeit in der Konsole vorhanden ist
			listeBegegnung.ausgabeReaktion(zufallsBegegnung, entscheidung); 								// Ausgabe der Reaktion der Begegnung auf Benutzereingabe
			if(listeBegegnung.isAbzugLeben(zufallsBegegnung, entscheidung)) meinSpiel.lebenVerringern();	// Wenn Benutzerauswahl schlecht war, dann Leben verringern
			
			if(!meinSpiel.lebenVorhanden()) break;														// Vorzeitiger Abbruch, falls kein Leben mehr vorhanden
		}
		
		meinSpiel.ausgebenNachrichtEnde();																// Ausgabe, ob man gewonnen oder verloren hat
		
		//----------------------------------------		
	    // AUFRÄUMEN - HEAP LEEREN
		random = null;
		sc.close();
		sc = null;
		meinSpiel = null;
		listeBegegnung = null;
	}
	
	/*********************************************************************************	
	* Um die Main-Methode nicht unnötig aufzublähen, wurden die Begegnungen in diese Methode
	* extrahiert. Zurückgegeben wird eine Liste mit Begegnungen
	* 
	* Durch die Vorgabe der Parameter und Unterstützung der IDE, ist eine fehlerhafte Eingabe hier wesentlich schwieriger.
	* Auch ist es bereits bei der Eingabe nicht mehr möglich, falsche Datentypen beim Lebensabzug einzugeben. 
	* Die Fehlermeldung würde direkt hier aufploppen, wo die Ursache ist und nicht später bei der Verarbeitung.
	 * @throws Exception 
	*********************************************************************************/
	
	public static ListeBegegnung addBegegnungenImSpiel() throws Exception {
		ListeBegegnung listeBegegnung = new ListeBegegnung();
		
		listeBegegnung.addBegegnung("LebensabzugStreichelnHauen", "Hulk", 
				"Der Hulk erwiedert deine Zärtlichkeit und drückt dich mal ganz dolle - ohoh! (-1 Leben).", // reaktionSteicheln 
				"Der Hulk freut sich über das Essen und zieht weiter.", // reaktionFuettern 
				"HULK SMASH!(-1 Leben)."// reaktionHauen 
				);

		listeBegegnung.addBegegnung("LebensabzugHauen", "Dr. Snuggles", 
				"Dr. Snuggles drückt Dir zum Abschied freundlich die Hand und hüpft auf seinem Pogo-Schirm weiter.",  // reaktionSteicheln 
				"Dr. Snuggles bedankt sich höflich für das Essen und hüpft auf seinem Pogo-Schirm weiter.", // reaktionFuettern 	
				"Na, das ist aber nicht nett, Dr. Snuggles zu verhauen. Die Tiere des Waldes sind erbost und \nvermoppern dich dafür gründlich. (-1 Leben)."	// reaktionHauen 
				);

		listeBegegnung.addBegegnung("LebensabzugHauen","Batman", 
				"Batman nickt dir aufmunternd zu. \"Freundlichkeit gegenüber Unbekannten kann nie schaden. Wie sagte \nnoch einst ein weiser Mann aus dem gebildeten Orient...\" Du wachst nach einiger Zeit benommen auf und \nsetzt Deinen Weg fort.", // reaktionSteicheln 
				"Batman freut sich sehr für das Essen. \"Ein gutgenährter Magen  ist die Grundvoraussetzung für einen \ngut genährten Geist. Vergiss das niemals, Robin!\" Bevor du etwas sagen kannst, ist er schon entfleucht.",  // reaktionFuettern 
				"Oh nein! Du hast Batman gehauen. Heiliger Konterschlag! (-1 Leben)"	// reaktionHauen 
				);
		
		listeBegegnung.addBegegnung("LebensabzugStreichelnFuettern","Pennywise", 
				"\"Komm mit! Mit uns kannst Du fliiiieeegeeeen!\" Der gruselige Clown winkt und schon bist Du im Gulli (-1 Leben)", // reaktionSteicheln 
				"\"Magst Du auch Popcorn? Dann komm mit! Bei uns gibt es ganz viel davon!\" Der gruselige Clown gibt \nDir einen roten Ballon und zieht dich in den Gulli. (-1 Leben)", // reaktionFuettern  	
				"Du knüppelst auf Pennywise drauf. Du magst eh keine Ballons."// reaktionHauen 
				);
		
		listeBegegnung.addBegegnung("LebensabzugStreichelnFuettern","T-Rex", 
				"Der T-Rex mag es, gestreichelt zu werden. Dann verschlingt er Dich. (-1 Leben)", // reaktionSteicheln 
				"Der T-Rex guckt hungrig. Du bist das Essen. (-1 Leben)", // reaktionFuettern 
				"Der T-Rex rennt weinend weg." // reaktionHauen 
				);
		
		listeBegegnung.addBegegnung("LebensabzugHauen","Baum", 
				"Der Baum streichelt nicht zurück.", // reaktionSteicheln 
				"Der Baum ist unbeeindruckt vom Essen.", // reaktionFuettern 
				"Der Baum kippt um. Bumm. (-1 Leben)"	// reaktionHauen 
				);
		
		listeBegegnung.addBegegnung("LebensabzugHauen","Lama", 
				"Das Lama macht \"Bääääh?\"", // reaktionSteicheln 
				"Das Lama macht \"Bääää!\" *Mampf*",  	// reaktionFuettern 
				"Das Lama spuckt. (-1 Leben)"	// reaktionHauen 
				);
		
		/* VORLAGE für weitere Begegnungen	
		// Factories: LebensabzugHauen, LebensabzugStreichelnFuettern, LebensabzugStreichelnHauen
		listeBegegnung.addBegegnung("", 
				"",  // reaktionSteicheln 
				"",  // reaktionFuettern 
				"",  // reaktionHauen 
				);
		 */		
		
		return listeBegegnung;
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

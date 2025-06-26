package prozedural;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
 
/*******************************************************
 * VARIABLEN
 *  begegnung : String[anzahlBegegnungenmax][6]				| Die Begegnungen, welche man im dunklen Wald hat
 *  anzahlBegegnungenmax : int								| Wieviele Begegnungen in diesem Spiel vorhanden sind
 *  leben : int	= 3											| Anzahl der Leben zu Beginn
 *  runde : int 												| die aktuelle Runde
 *  maxRunde : int = 10										| die Anzahl der zu bewältigen Runden, bis das Spiel gewonnen ist
 ******************************************************/
/*******************************************************
 * METHODEN
 *  + main() : void			| Hauptmethode, welche die Spielparameter (Leben & Rundenanzahl) setzt
 *  							| Gibt das Intro aus, steuert die Rundenanzahl, gibt das Ergebnis aus
 *  
 *  - durchlaufRunde(anzahlBegegnungenmax : int, begegnung : String[][], ersteRunde : boolean  ) : int
 *							| Steuert, was jede Runde passiert:
 *							| 1. Zufallsbegegnung erfassen
 *							| 2. Benutzereingabe erhalten
 *							| 3. Handlungsergebnis mitteilen
 *							| 4. Zurückgeben, ob 1 oder 0 Leben abgezogen werden
 *  							| Benötigt Parameter
 *  							|    o anzahlBegegnungenmax für Zufallsbegegnungen
 *  							|	 o begegnung, um die Auswertung durchzuführen 
 *   						|    o ersteRunde für Überprüfung, ob Nachricht für Folgerunde ausgegeben werden soll oder nicht
 *   
 *  - initBegegnung(int anzahlBegegnungenmax) : String[][] 
 *							| Füllt begegnungen[][] mit den literalen Begegnungen / Werten
 * 							| Benötigt Parameter anzahlBegegnungenmax für Arrayerstellung
 * 
 * - erstelleBegegnung(int index, String[][] begegnung, String fuetternReaktion, String streichelnReaktion, String kloppenReation, 
 * 									String punktAbzugFuettern, String punktAbzugStreicheln, String punktAbzugKloppen)
 *							| füllt in der Methode initBegegnung() aus den Literalen den Array begegnung[][] und hilft durch Parameter gegen Fehleingaben 
 *
 * - auswertungLebensabzug(String[][] begegnung, int zufallszahl,  byte eingabe)
 * 							| gibt eine 1 zurück, wenn Leben abgezogen werden soll oder 0, wenn kein Leben abgezogen werden soll
 * 
 * - eingabeBenutzer() : byte 
 *  							| gibt zurück, ob der Spieler 1) Füttern, 2) Streicheln oder 3) Kloppen eingegeben hat und fängt fehlerhafte Eingaben ab
 *  
 *   METHODEN FÜR NACHRTICHTEN-AUSGABEN

 *   - ausgebenIntro() : void						| Ausgabe zum Spielbeginn, Erklärung
 *   - ausgebenFolgebegegnung() : void				| Ausgabe zur neuen Runde
 *   - ausgebenNachrichtEntscheidung(String[][] begegnung, int zufallszahl,  byte eingabe) : void
 *   												| Ausgabe, welche Begegnung es war und was die Entscheidung gemacht hat
 *   - ausgebenNachrichtEnde(leben) : void			| Ausgabe ob gewonnen oder verloren
 *   - ausgebenNachrichtEingabefehler() : void		| Ausgabe Fehlermeldung, wenn Benutzer nicht 1, 2 oder 3 eingegeben hat
 *   - leerenKonsole() : void						| "leert" die Konsole durch Zeilenumbrüche
 ******************************************************/

public class waldlauf {

	// Hauptmethode mit Rundenschleife
	public static void main(String[] args) throws IOException{

		/**************************************
		* VARIABLEN
		**************************************/
		// Initiale Werte, die den Spielablauf bedingen
		int leben = 3;													// Anzahl der Leben
		int maxRunde = 10;												// zu durchlaufende Runden

		// Weitere Variablen / Objekte
		Scanner sc = new Scanner(System.in);
		int anzahlBegegnungenmax = 8;									// Anzahl der existierenden Begegnungen

		String begegnung[][] = initBegegnung(anzahlBegegnungenmax);		// Begegnungen erstellen
		
		/**************************************
		* SPIELABLAUF
		**************************************/
		ausgebenIntro();													// Nachricht zum Spielbeginn
		
		// Schleife, welche so lange durchlaufen wird, bis Leben = 0 oder aktuelle Runde = maxRunde  
		for(int runde=1; runde <= maxRunde; runde++) {
			leben -= durchlaufRunde(anzahlBegegnungenmax, begegnung, runde == 1, sc);		// Rundenaufruf + Leben abziehen, falls Entscheidung falsch
			if(leben == 0) break;														// Vorzeitiger Abbruch, falls kein Leben mehr vorhanden
		}
		
		ausgebenNachrichtEnde(leben); 				// Ausgabe Nachricht, ob Spieler gewonnen oder verloren hat
		
		// Aufräumen
		sc.close();
		sc = null;

	}
	
	// Einzelner Rundenablauf 
	private static int durchlaufRunde(int anzahlBegegnungenmax, String[][] begegnung, boolean ersteRunde, Scanner sc ) throws IOException {

		Random random = new Random();									// Instanziierung Zufallszahl
		int zufallszahl = random.nextInt(anzahlBegegnungenmax);			// Zufällige Auswahl der Begegnung
		if (!ersteRunde) ausgebenFolgebegegnung();						// Anfangstext für 2. bis letzte Runde
		byte eingabe = eingabeBenutzer(sc);									// Handlung Benutzer + Sicherstellung, dass Eingabe vom Benutzer 1, 2 oder 3
		leerenKonsole();													// Bildschirm vor Auswirkung leeren
		ausgebenNachrichtEntscheidung(begegnung, zufallszahl, eingabe);
		random = null;
		return auswertungLebensabzug(begegnung, zufallszahl, eingabe); 	// Leben abziehen
	}
	
	// Daten für den Begegnungsarray
	private static String[][] initBegegnung(int anzahlBegegnungenmax){
		
		String begegnung[][] = new String[anzahlBegegnungenmax][6];		// Array mit Begegnungen
		
		/******************************************************************************************
		* ERSTELLUNG DER BEGEGNUNGEN
		* ****************************************************************************************
		* Struktur der Methode erstelleBegegnung: Index der Begegnung, Begegnungsarray, 
		* 				Ausgabe Füttern,
		* 				Ausgabe Streicheln,
		* 				Ausgabe Hauen,
		* 				Lebensabzug Füttern, Lebensabzug Streicheln, Lebensabzug Hauen 
		*/
		
		//Der Hulk
		begegnung = erstelleBegegnung(0, begegnung, 
				"Der Hulk freut sich über das Essen und zieht weiter.", 
				"Der Hulk erwiedert deine Zärtlichkeit und drückt dich mal ganz dolle - ohoh! (-1 Leben).", 
				"Der HULK SMASH!(-1 Leben).", 
				"0", "0", "1");
		

		//Dr. Snuggles
		begegnung = erstelleBegegnung(1, begegnung, 
				"Dr. Snuggles bedankt sich höflich für das Essen und hüpft auf seinem Pogo-Schirm weiter.", 
				"Dr. Snuggles drückt Dir zum Abschied freundlich die Hand und hüpft auf seinem Pogo-Schirm weiter.", 
				"Na, das ist aber nicht nett, Dr. Snuggles zu verhauen. Die Tiere des Waldes sind erbost und \nvermoppern dich dafür gründlich. (-1 Leben).", 
				"0", "0", "1");

		
		//Batman
		begegnung = erstelleBegegnung(2, begegnung, 
				"Batman freut sich sehr für das Essen. \"Ein gutgenährter Magen  ist die Grundvoraussetzung für einen \ngut genährten Geist. Vergiss das niemals, Robin!\" Bevor du etwas sagen kannst, ist er schon entfleucht.", 
				"Batman nickt dir aufmunternd zu. \"Freundlichkeit gegenüber Unbekannten kann nie schaden. Wie sagte \nnoch einst ein weiser Mann aus dem gebildeten Orient...\" Du wachst nach einiger Zeit benommen auf und \nsetzt Deinen Weg fort.", 
				"Oh nein! Du hast Batman gehauen. Heiliger Konterschlag! (-1 Leben)", 
				"0", "0", "1");

		//Pennywise
		begegnung = erstelleBegegnung(3, begegnung, 
				"Magst Du auch Popcorn? Dann komm mit! Bei uns gibt es ganz viel davon!\" Der gruselige Clown gibt \nDir einen roten Ballon und zieht dich in den Gulli. (-1 Leben)", 
				"Komm mit! Mit uns kannst Du fliiiieeegeeeen!\" Und schon bist Du im Gulli (-1 Leben)", 
				"Du knüppelst auf Pennywise drauf. Du magst eh keine Ballons.", 
				"1", "1", "0");
		
		//Frantzen
		begegnung = erstelleBegegnung(4, begegnung, 
				"\"Boah, ey, endlich was zu essen!!\"", 
				"\"IIIIIIIH!\" (-1 Leben)", 
				"\"Das gibt drei Klausurfragen mehr!!\" (-1 Leben) ", 
				"0", "1", "1");

		//Das Lama
		begegnung = erstelleBegegnung(5, begegnung, 
				"Das Lama macht \"Bääää!\" *Mampf*", 
				"Das Lama mach \"Bääääh?\"", 
				"Das Lama spuckt. (-1 Leben) \"", 
				"0", "0", "1");
		
		//Der Baum
		begegnung = erstelleBegegnung(5, begegnung, 
				"Der Baum ist unbeeindruckt vom Essen.", 
				"Der Baum streichelt nicht zurück.", 				"Der Baum kippt um. Bumm. (-1 Leben)", 
				"0", "0", "1");
		
		//T-Rex
		begegnung = erstelleBegegnung(5, begegnung, 
				"Der T-Rex guckt hungrig. Du bist das Essen. (-1 Leben)", 
				"Der T-Rex mag es, gestreichelt zu werden. Dann verschlingt er Dich. (-1 Leben)", 
				"Der T-Rex rennt weinend weg.", 
				"1", "1", "0");

		return begegnung;
	}
	
	// Füllt den Array mit den Daten - wird von initBegegnung bei jedem Tupel aufgerufen
	private static String [][] erstelleBegegnung(int index, String[][] begegnung, String fuetternReaktion, String streichelnReaktion, String kloppenReation, String punktAbzugFuettern, String punktAbzugStreicheln, String punktAbzugKloppen) {
		begegnung[index][0] = fuetternReaktion; 
		begegnung[index][1] = streichelnReaktion;
		begegnung[index][2] = kloppenReation;
		begegnung[index][3] = punktAbzugFuettern; 
		begegnung[index][4] = punktAbzugStreicheln;
		begegnung[index][5] = punktAbzugKloppen;
		return begegnung;
	}
	
	// Gibt den Wert (0 oder 1) zurück, der das Leben abzieht
	private static int auswertungLebensabzug(String[][] begegnung, int zufallszahl,  byte eingabe) {
		return  Integer.parseInt(begegnung[zufallszahl][eingabe+2]);
	}
	
	// Eingabe des Benutzers inkl. Fehlerbehandlung, wenn keine 1, 2 oder 3 eingegeben wurde
	// Methode wird nur bei gültigen Wert verlassen
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
					ausgebenNachrichtEingabefehler();
				}					
			} catch (InputMismatchException e) {	// Wenn Eingabe kein Byte-Datentyp
				ausgebenNachrichtEingabefehler();
				sc.next();
			}
		}
		return eingabe;

	}
	
	/*******************************************************
	 * METHODEN, DIE NUR NACHRICHTEN AUSGEBEN
	********************************************************/

	// Ausgabe Spielbeginn
	private static void ausgebenIntro() {
		System.out.println("Du bist in einem Wald und hast einen Wanderstab sowie einen Rucksack voll mit Eier-Tomaten-Gurken-Sandwiches. \nEs ist sehr dunkel und du kannst kaum die Hand vor Deinen Augen sehen, als Dir plötzlich etwas begegnet. \nDu hast keine Ahnung, wer oder was es ist. Möchtest du es:\n\n1) Füttern?\n2) Streicheln?\n3) Mit dem Stock hauen?");
	}
	
	// Ausgabe jede neue Runde
	private static void ausgebenFolgebegegnung() {
		System.out.println("\nDu setzt Deinen Weg fort. Aber - was ist das? Eine weitere Begegnung. Du entschließt sich die Begegnung: "
				+ "\n1) zu füttern?\n2) zu streicheln?\n3) mit dem Stock zu hauen?");
	}
	
	// Ausgabe Auswirkung nach Benutzereingabe
	private static void ausgebenNachrichtEntscheidung(String[][] begegnung, int zufallszahl,  byte eingabe) {
		System.out.println(begegnung[zufallszahl][eingabe-1]);					// Ausgabe des Arrayswerts
	}

	// Ausgabe Spielende ob gewonnen oder verloren
	private static void ausgebenNachrichtEnde(int leben) {
		if (leben == 0)
			System.out.println("\n\nDu hast es leider nicht aus dem Wald geschafft. Viel Glück beim nächsten Mal.");
		else
			System.out.println("\n\nDer Wald lichtet sich. \nFroh am leben zu sein, setzt Du Deinen Weg fort.");
	}
	
	// Ausgabe nach fehlerhafter Eingabe
	private static void ausgebenNachrichtEingabefehler() {
		System.out.print("\nEingabe ungültig. Möchtest Du die Begegnung: \n"
				+ "1) füttern?\n2) streicheln?\n3) mit dem Stock hauen?");
	}
	
	// Macht Zeilenumbrüche, dass es nach Neuer Seite aussieht
	private static void leerenKonsole() {
		for(int i=1; i<10;i++)				// Screen durch 10 Zeilenumbrüche "leeren"
			System.out.println("\n");
	}
}

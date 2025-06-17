package strukturiert_mit_errhand.copy;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*******************************************************
 * VARIABLEN
 *  begegnung : String[anzahlBegegnungenmax][6]				| Die Begegnungen, welche man im dunklen Wald hat
 *  anzahlBegegnungenmax : int								| Wieviele Begegnungen in diesem Spiel vorhanden sind
 *  leben : int	= 3											| Anzahl der Leben zu Beginn
 *  runde : int 											| die aktuelle Runde
 *  maxRunde : int = 10										| die Anzahl der zu bewältigen Runden, bis das Spiel gewonnen ist
 ******************************************************/
public class waldlauf {

	public static void main(String[] args) throws IOException {
		/******************************************************************************************
		* DEKLARATION UND INITIALISIERUNG VON VARIABLEN
		* /***************************************************************************************/
		Scanner sc = new Scanner(System.in);
		Random random = new Random();									// Instanziierung Zufallszahl
		int leben = 3;													// Anzahl der Leben
		int runde = 1; 													// die aktuelle Runde
		int maxRunde = 10;												// zu durchlaufende Runden
		int anzahlBegegnungenmax = 6;									// Anzahl der existierenden Begegnungen
		String begegnung[][] = new String[anzahlBegegnungenmax][6];		// Array mit Begegnungen
		byte eingabe = 0;													// Benutzereingabe
		boolean eingabeGueltig = false;									// für Errorhandling, dass Benutzer 1, 2 oder 3 eingibt				 
		
		/******************************************************************************************
		* ERSTELLUNG DER BEGEGNUNGEN
		* ****************************************************************************************
		* ERLÄUTERUNG ZUM INDEX
		* Erster Index: Anzahl vorhandener Begegnungen
		* Zweiter Index: 
		* 	0: Ausgabe Füttern
		* 	1: Ausgabe Streicheln
		* 	2: Ausgabe Hauen
		* 	3: Abzug Leben Füttern
		* 	4: Abzug Leben Streicheln
		* 	5: Abzug Leben Hauen
		*/
		
		//Der Hulk
		begegnung[0][0] = "Der Hulk freut sich über das Essen und zieht weiter."; 
		begegnung[0][1] = "Der Hulk erwiedert deine Zärtlichkeit und drückt dich mal ganz dolle - ohoh! (-1 Leben)." ;
		begegnung[0][2] = "Der HULK SMASH!(-1 Leben)." ;
		begegnung[0][3] = "0"; 
		begegnung[0][4] = "1";
		begegnung[0][5] = "1";		

		//Dr. Snuggles
		begegnung[1][0] = "Dr. Snuggles bedankt sich höflich für das Essen und hüpft auf seinem Pogo-Schirm weiter." ;  
		begegnung[1][1] = "Dr. Snuggles drückt Dir zum Abschied freundlich die Hand und hüpft auf seinem Pogo-Schirm weiter.";
		begegnung[1][2] = "Na, das ist aber nicht nett, Dr. Snuggles zu verhauen. Die Tiere des Waldes sind erbost und \nvermoppern dich dafür gründlich. (-1 Leben)." ;
		begegnung[1][3] = "0"; 
		begegnung[1][4] = "0";
		begegnung[1][5] = "1";
		
		//Batman
		begegnung[2][0] = "Batman freut sich sehr für das Essen. \"Ein gutgenährter Magen  ist die Grundvoraussetzung für einen \ngut genährten Geist. Vergiss das niemals, Robin!\" Bevor du etwas sagen kannst, ist er schon entfleucht." ;   
		begegnung[2][1] = "Batman nickt dir aufmunternd zu. \"Freundlichkeit gegenüber Unbekannten kann nie schaden. Wie sagte \nnoch einst ein weiser Mann aus dem gebildeten Orient...\" Du wachst nach einiger Zeit benommen auf und \nsetzt Deinen Weg fort.";
		begegnung[2][2] = "Oh nein! Du hast Batman gehauen. Heiliger Konterschlag! (-1 Leben)" ;
		begegnung[2][3] = "0"; 
		begegnung[2][4] = "0";
		begegnung[2][5] = "1";

		//Pennywise
		begegnung[3][0] = "\"Magst Du auch Popcorn? Dann komm mit! Bei uns gibt es ganz viel davon!\" Der gruselige Clown gibt \nDir einen roten Ballon und zieht dich in den Gulli. (-1 Leben)" ;  
		begegnung[3][1] = "\"Komm mit! Mit uns kannst Du fliiiieeegeeeen!\" Und schon bist Du im Gulli (-1 Leben)";
		begegnung[3][2] = "Du knüppelst auf Pennywise drauf. Du magst eh keine Ballons." ;
		begegnung[3][3] = "1"; 
		begegnung[3][4] = "1";
		begegnung[3][5] = "0";
		

		//Frantzen
		begegnung[4][0] = "\"Boah, ey, endlich was zu essen!!\"" ;  
		begegnung[4][1] = "\"IIIIIIIH!\" (-1 Leben)";
		begegnung[4][2] = "\"Das gibt drei Klausurfragen mehr!! (-1 Leben) \"" ;
		begegnung[4][3] = "0"; 
		begegnung[4][4] = "1";
		begegnung[4][5] = "1";

		//Das Lama
		begegnung[5][0] = "Das Lama macht \"Bääää!\" *Mampf*" ;  
		begegnung[5][1] = "Das Lama mach \"Bääääh?\"";
		begegnung[5][2] = "Das Lama spuckt. (-1 Leben) \"" ;
		begegnung[5][3] = "0"; 
		begegnung[5][4] = "0";
		begegnung[5][5] = "1";	
		
		
		/******************************************************************************************
		* SPIELBEGINN
		* /***************************************************************************************/

		// Intro
		System.out.println("Du bist in einem Wald und hast einen Wanderstab sowie einen Rucksack voll mit Eier-Tomaten-Gurken-Sandwiches. \nEs ist sehr dunkel und du kannst kaum die Hand vor Deinen Augen sehen, als Dir plötzlich etwas begegnet. \nDu hast keine Ahnung, wer oder was es ist. Möchtest du es:\n\n1) Füttern?\n2) Streicheln?\n3) Mit dem Stock hauen?");
		
		// Schleife, welche so lange durchlaufen wird, bis keine Leben oder maxRunde geschafft 
		do {
			int zufallszahl = random.nextInt(anzahlBegegnungenmax);		// Zufallszahl zwischen 0 und anzahlBegegnungenmax-1
																		// um den 1. Index für Zufallsbegegnung auszuwählen
			// Text für 2. bis letzte Runde
			if (runde != 1) {		
				System.out.println("\nDu setzt Deinen Weg fort. Aber - was ist das? Eine weitere Begegnung. Du entschließt sich die Begegnung: "
						+ "\n1) zu füttern?\n2) zu streicheln?\n3) mit dem Stock zu hauen?");
			}
			
			// Eingabe des Benutzers + Errorhandling
			while(!eingabeGueltig) {					// Solange keine gültige Eingabe vorhanden ist, soll die Eingabe wiederholt werden
				try {									// Überprüfe, ob Fehler gemacht wurde
					eingabe = sc.nextByte();		// BenutzerEingabe 1, 2 oder 3
					if (eingabe >=1 && eingabe <=3) {	// Falls Eingabe=Byte, dann überprüfen, ob Wert zwischen 1-3
						eingabeGueltig = true;			// 		Wenn Eingabe zwischen 1-3, weitermachen
					} else {							// 		Wenn Wert nicht zwischen 1-3 Fehlermeldung und Wiederholung
						System.out.print("\nEingabe ungültig.Möchtest Du die Begegnung: \n"
								+ "1) füttern?\n2) streicheln?\n3) mit dem Stock hauen?");
					}					
				} catch (InputMismatchException e) {	// Wenn Eingabe kein Byte-Datentyp
					System.out.print("\nEingabe ungültig. Möchtest Du die Begegnung: \n"
							+ "1) füttern?\n2) streicheln?\n3) mit dem Stock hauen?");
					sc.next();
				}
			}
			eingabeGueltig = false;				// boolschen Wert nochmal auf false für die nächste Runde setzen

				
			for(int i=1; i<10;i++)				// Screen durch 10 Zeilenumbrüche "leeren"
				System.out.println("\n");
			
			// Es soll von der Begegnung der Benutzereingabe-1 als 2. Index ausgegeben werden
			// begegnung[zufallszahl][eingabe-1]
			// Beispiel: Zufallszahl 0 = Hulk; Eingabe Hauen = 3
			//  = begegnung[0][3-1] = begegnung[0][2] = Hulk wird gehauen
			System.out.println(begegnung[zufallszahl][eingabe-1]);					// Ausgabe des Arrayswerts
			
			// Es wird der Wert abgezogen, der bei der Begegnung für die Entscheidung steht
			// Bei Hulk begegnung[0][3] = "0", begegnung[0][4] = "0", begegnung[0][5] = "1"
			// Der Index wird durch die Eingabe des Benutzers ermittelt, indem Index = Eingabe +2 .
			// Hätte der Benutzer eine 1 eingegeben, wäre der Index 1+2 = 3. 
			// Der Wert bei begegnung[0][3] = 0, und es würde leben-0 gerechnet werden, also nichts abgezogen werden.
			// Da der Benutzer aber eine 3 eingegeben hat, ist der Index 3+2 = 5.
			// begegnung[0][5] = 1, dadurch wird leben - 1 gerechnet und 1 Leben wird abgezogen.
			leben = leben - Integer.parseInt(begegnung[zufallszahl][eingabe+2]); 	// Leben abziehen
			
			runde++;					// Eine Runde weiter
			
		}
		while (runde <= maxRunde && leben > 0);
		
		
		// ERGEBNIS - WHILE-SCHLEIFE WURDE UNTERBROCHEN
		if (leben == 0)
			System.out.println("\n\nDu hast es leider nicht aus dem Wald geschafft. Viel Glück beim nächsten Mal.");
		else
			System.out.println("\n\nDer Wald lichtet sich. \nFroh am leben zu sein, setzt Du Deinen Weg fort.");
		
		// HEAP leeren
		random = null;
		sc.close();
	}

}

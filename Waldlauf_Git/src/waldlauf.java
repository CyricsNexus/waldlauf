import java.io.IOException;
import java.util.Scanner;

public class waldlauf {

	public static void main(String[] args) throws IOException {
		/* Erster Index: Anzahl vorhandener Begegnungen
		* Zweiter Index: 
		* 0 Ausgabe Füttern
		* 1 Ausgabe Streicheln
		* 2 Ausgabe Hauen
		* 3 Abzug Leben Füttern
		* 4 Abzug Leben Streicheln
		* 5 Abzug Leben Hauen
		*/
		int anzahlBegegnungenmax = 4;
		
		String begegnung[][] = new String[anzahlBegegnungenmax][6];

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
		begegnung[3][1] = "\"Komm mit! Mit uns kannst Du fliiiieeeegeeeen!\" Und schon bist Du im Gulli (-1 Leben)";
		begegnung[3][2] = "Du knüppelst auf Pennywise drauf. Du magst eh keine Ballons." ;
		begegnung[3][3] = "1"; 
		begegnung[3][4] = "1";
		begegnung[3][5] = "0";
		
		
		
		// Generelle Variablen
		int leben = 3;	// Anzahl der Leben
		int runde = 1; // zu durchlaufende Runden
		int maxRunde = 5;


		int zufallszahl;
		//System.out.print(zufallszahl);
		
		//Eingabe Scanner und eingabe zur Auswertung der Aktion 
		// sowie des Arrays Nachricht (eingabe-1) & Leben(eingabe+2)
		Scanner sc = new Scanner(System.in);
		byte eingabe;

		System.out.println("Du bist in einem Wald und hast einen Wanderstab sowie einen Rucksack voll mit Eier-Tomaten-Gurken-Sandwiches. \nEs ist sehr dunkel und du kannst kaum die Hand vor Deinen Augen sehen, als Dir plötzlich etwas begegnet. \nDu hast keine Ahnung, wer oder was es ist. Möchtest du es:\n\n1) Füttern?\n2) Streicheln?\n3) Mit dem Stock hauen?");
		
		do {

			zufallszahl = (int)(Math.random()*anzahlBegegnungenmax);

			if (runde != 1) {		// Wenn es nicht die 1. Runde ist, braucht es einen anderen Satz
				System.out.println("\nDu setzt Deinen Weg fort. Aber - was ist das? Eine weitere Begegnung. Du entschließt sich die Begegnung: "
						+ "\n1) zu füttern?\n2) zu streicheln?\n3) mit dem Stock zu hauen?");
			}
			
			eingabe = sc.nextByte();		// Eingabe 1, 2, 3
			for(int i=1; i<10;i++)			//"Screen durch 10 Zeilenumbrüche leeren"
				System.out.println("\n");
			
			System.out.println(begegnung[zufallszahl][eingabe-1]);					// Textausgabe
			leben = leben - Integer.parseInt(begegnung[zufallszahl][eingabe+2]); 	// Leben abziehen
			// System.out.println(leben);	
			
			runde++;					// Eine Runde weiter
			
		}
		while (runde <= maxRunde && leben > 0);
		
		if (leben == 0)
			System.out.println("\n\nDu hast es leider nicht aus dem Wald geschafft. Viel Glück beim nächsten Mal.");
		else
			System.out.println("\n\nDer Wald lichtet sich. \nFroh am leben zu sein, setzt Du Deinen Weg fort.");
		
		sc.close();
	}

}

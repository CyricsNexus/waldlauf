package deklarativ;

/* Das Spiel selbst fungiert hier ebenfalls als Objekt mit eigenen Eigenschaften.
 * Hätte man das nicht weiterhin in der Main-Klasse als Eigenschaften lassen können? Prinzipiell ja.
 * Es ist einfach sauberer in der Objektorientierten Welt, in der wir alles als Objekte definieren. Und es wird
 * lesbarer, da wir immer angeben müssen, mit welchem Objekt etwas gemacht wird und welche Objekte sich
 * gegenseitig bedingen.
 * 
 * Die Main-Methode soll streng genommen nur das Spiel starten. In unserem Fall belassen wir in der Main-Methode aber
 * auch die Algorithmik, da das Spiel so simpel ist - es gibt quasi nichts anderes als den einen Ablauf.
 * Nach meinem persönlichen Ermessen würde es sich anfühlen wie eine Schachtel zu kaufen, um eine kleinere Schachtel
 * reinzutun. Es wäre etwas anderes, wenn dieses Spiel eines von mehreren wäre, welches man im Waldlauf machen kann
 * (z.B. rasten, trainieren, etc.). In diesem Fall hätte ich definitv die Klasse main als reine Startklasse genommen
 * und ggf. die anderen Parts sogar in eigene Packages sortiert, um diese modular hinzufügen oder entfernen zu können.
 */

public class Spiel {
	
	private int leben = 0;							// Anzahl der Leben
	private int anzahlRunden = 0;					// zu durchlaufende Runden
	
	public Spiel(int leben, int anzahlRunden) {
		this.leben = leben;
		this.anzahlRunden = anzahlRunden;
	}
	
	// Benutzer hat falsche Entscheidung getroffen, das Leben wird verringert
	public void lebenVerringern() {
		leben--;
	}
	
	// Überprüfung, ob Spieler noch Leben hat
	public boolean lebenVorhanden() {
		return (leben > 0) ? true : false; 
	}

	public int getLeben() {
		return leben;
	}

	public int getAnzahlRunden() {
		return anzahlRunden;
	}
	
	/*******************************************************
	 * METHODEN, DIE NUR NACHRICHTEN AUSGEBEN
	********************************************************/
	// Diese Ausgaben sind Klassenmethoden, da sie sich nicht auf ein konkretes Spiel beziehen, sondern
	// generell für jedes Spiel gelten. Sie sind nicht abhängig von der aktuellen Runde oder restlichen Leben, die
	// der Spieler hat.
	// Ausnahme ist ausgebenNachrichtEnde() - hier ändert sich die Nachricht, je nachdem ob der Benutzer leben > 0 hat.
	
	// Ausgabe Spielbeginn
	public static void ausgebenIntro() {
		System.out.println("Du bist in einem Wald und hast einen Wanderstab sowie einen Rucksack voll mit Eier-Tomaten-Gurken-Sandwiches. \nEs ist sehr dunkel und du kannst kaum die Hand vor Deinen Augen sehen.");
	}
	
	// Ausgabe jede neue Runde
	public static void ausgebenFolgebegegnung() {
		System.out.println("\nDu setzt Deinen Weg fort. Aber - was ist das? Eine Begegnung. Du kannst sie nicht erkennen. Möchtest Du die Begegnung "
				+ "\n1) streicheln?\n2) füttern?\n3) oder mit dem Stock hauen?");
	}

	// Ausgabe Spielende ob gewonnen oder verloren
	public void ausgebenNachrichtEnde() {
		if (leben == 0)
			System.out.println("\n\nDu hast es leider nicht aus dem Wald geschafft. Viel Glück beim nächsten Mal.");
		else
			System.out.println("\n\nDer Wald lichtet sich. \nFroh am leben zu sein, setzt Du Deinen Weg fort.");
	}
	
	// Ausgabe nach fehlerhafter Eingabe
	public static void ausgebenNachrichtEingabefehler() {
		System.out.print("\nEingabe ungültig. Möchtest Du die Begegnung: \n"
				+ "\n1) zu streicheln?\n2) zu füttern?\n3) mit dem Stock zu hauen?");
	}
	
	// Macht Zeilenumbrüche, dass es nach Neuer Seite aussieht
	public static void leerenKonsole() {
		for(int i=1; i<10;i++)				// Screen durch 10 Zeilenumbrüche "leeren"
			System.out.println("\n");
	}
	

}

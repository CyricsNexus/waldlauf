package deklarativ;

import java.util.function.Consumer;

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
	
	// Ausgabe nach fehlerhafter Eingabe
	public static void ausgebenNachrichtEingabefehler() {
		System.out.print("\nEingabe ungültig. Möchtest Du die Begegnung: \n"
				+ "\n1) zu streicheln?\n2) zu füttern?\n3) mit dem Stock zu hauen?");
	}

}

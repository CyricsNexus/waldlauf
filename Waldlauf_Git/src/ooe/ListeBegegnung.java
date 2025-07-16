package ooe;

import java.util.ArrayList;

/************************************************************************************************************************
* Man könnte diese Liste auch in der Main-Klasse anlegen. Tatsächlich ist es üblich,
* Listen als eigene Klassen zu handhaben, da diese meistens eigene Methoden haben.
*
* Die Klasse Main greift also nicht direkt selbst auf die Begegnung zu, sondern die Liste speichert die
* Begegnung und die Main bekommt die Liste
*
* In diesem Fall hätte man auf diese Klasse verzichten können, da diese Klasse wirklich keinen Mehrwert bietet, sondern nur 
* doppelten Code. Und damit unnötige Wartung bei Änderung.
* Aus Schulungszwecken - und da Listen häufig wirklich eigene Methoden und Eigenschaften haben - wurde es hier so umgesetzt,
* um den Zugriff von Klasse zur nächsten Klasse zu demonstrieren
* *********************************************************************************************************************/
/***********************************************************************************************************************
 *  Klasse ListeBegegnung
 * ---------------------------------------------------------------------------------------
 *  listeBegegnung : ArrayList<Begegnung>						| Eine Liste mit allen Begegnungen
 *  --------------------------------------------------------------------------------------
 *  addBegegnung(String begegnungsBezeichnung,						| Erhält von der Klasse Main die gewünschten Begegnungen  
 *			String reaktionSteicheln, boolean streichelnLebensabzug,	| als Parameter und übergibt sie dem Konstruktor der 
 *			String reaktionFuettern, boolean fuetternLebensabzug,		| Klasse Begegnung, um eine neue Begegnung in der Liste
 *			String reaktionHauen, boolean hauenLebensabzug)			| abzuspeichern
 *
 *  ausgabeReaktion(int indexDurchZufallszahl, int auswahlBenutzer) : void	| Gibt den Text von der aktuellen Zufallsbegegnung
 *  																			| zu der Benutzereingabe aus 
 *  
 *  abzugLeben(int indexDurchZufallszahl, int auswahlBenutzer) : boolean		| Gibt zurück, ob ein Leben abgezogen werden soll
 *  
 *  getListeBegegnung() : ArrayList<Begegnung>						| GETTER	 
 */



public class ListeBegegnung {

	private ArrayList<Begegnung> listeBegegnung = new ArrayList<Begegnung>();			
	
	// Hier sieht man einen Nachteil, die Liste aus der Main zu extrahieren: Der Code ist beinahe redundant zur Klasse Begegnung.
	// Man muss Parameter erstellen, um dieselben Parameter in der Klasse Begegnung zu füllen
	public void addBegegnung(String begegnungsBezeichnung, 
			String reaktionSteicheln, boolean streichelnLebensabzug,
			String reaktionFuettern, boolean fuetternLebensabzug,
			String reaktionHauen, boolean hauenLebensabzug) {
		listeBegegnung.add(new Begegnung(begegnungsBezeichnung, reaktionSteicheln, streichelnLebensabzug, 
				reaktionFuettern, fuetternLebensabzug, reaktionHauen, hauenLebensabzug));
	}
	
	// Gibt die Reaktion der Begegnung zurück
	public void ausgabeReaktion(int indexDurchZufallszahl, int auswahlBenutzer) {
		switch (auswahlBenutzer) {
		case 1: System.out.println(listeBegegnung.get(indexDurchZufallszahl).getReaktionSteicheln());
			break;
		case 2: System.out.println(listeBegegnung.get(indexDurchZufallszahl).getReaktionFuettern());
			break;
		default: System.out.println(listeBegegnung.get(indexDurchZufallszahl).getReaktionHauen());
		}
	}
	
	// Gibt zurück, ob ein Leben abgezogen werden soll
	public boolean isAbzugLeben(int indexDurchZufallszahl, int auswahlBenutzer) {
		boolean lebenAbziehen = false;
		
		switch (auswahlBenutzer) {
		case 1: lebenAbziehen = listeBegegnung.get(indexDurchZufallszahl).isStreichelnLebensabzug();
			break;
		case 2: lebenAbziehen = listeBegegnung.get(indexDurchZufallszahl).isFuetternLebensabzug();
			break;
		default: lebenAbziehen = listeBegegnung.get(indexDurchZufallszahl).isHauenLebensabzug();
		}
		
		return lebenAbziehen;
	}
	
	public ArrayList<Begegnung> getListeBegegnung() {
		return listeBegegnung;
	}
}

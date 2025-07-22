package ooeFactory;

import java.util.ArrayList;

import ooeFactory.begegnungen.Begegnung;

/************************************************************************************************************************
* Nutzt die create-Methode der Klasse FactoryListeBegegnungen, um Begegnungsobjekte erstellen zu lassen und diese in der
* Liste zu speichern  
* *********************************************************************************************************************/
/***********************************************************************************************************************
 *  Klasse ListeBegegnung
 * ---------------------------------------------------------------------------------------
 *  listeBegegnung : ArrayList<Begegnung>							| Eine Liste mit allen Begegnungen
 *  --------------------------------------------------------------------------------------
 *  addBegegnung(String begegnungsart, 								| Erhält von der Klasse Main die gewünschten Begegnungen
 *  			String begegnungsname,								  	| als Parameter und übergibt sie dem Konstruktor der 
 *			String reaktionSteicheln									| Klasse Begegnung, um eine neue Begegnung in der Liste
 *			String reaktionFuettern									| abzuspeichern
 *			String reaktionHauen)									
 *
 *  ausgabeReaktion(int indexDurchZufallszahl, int auswahlBenutzer) : void	| Gibt den Text von der aktuellen Zufallsbegegnung
 *  																			| zu der Benutzereingabe aus 
 *  
 *  abzugLeben(int indexDurchZufallszahl, int auswahlBenutzer) : boolean		| Gibt zurück, ob ein Leben abgezogen werden soll
 *  
 *  getListeBegegnung() : ArrayList<Begegnung>								| GETTER	 
 */



public class ListeBegegnung  extends FactoryListeBegegnung{

	private ArrayList<Begegnung> listeBegegnung = new ArrayList<Begegnung>();			
	
	// Hier wird die Factory aufgerufen, deren Create-Methode geerbt wurde.
	// Ein gültiges Objekt wird zurückgegeben und der Liste hinzugefügt
	public void addBegegnung(String begegnungsart, String begegnungsname,
			String reaktionSteicheln, 
			String reaktionFuettern, 
			String reaktionHauen) throws Exception {
		listeBegegnung.add(createBegegnung(begegnungsart, begegnungsname, reaktionSteicheln, reaktionFuettern, reaktionHauen));
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

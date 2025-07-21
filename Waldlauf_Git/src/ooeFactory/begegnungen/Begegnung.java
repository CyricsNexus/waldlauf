package ooeFactory.begegnungen;

public class Begegnung {

	/*************************************************************************
	 * Eine einzelne Begegnung mit den Reaktionen für streicheln, füttern und hauen 
	 *   inkl boolean ob Lebensabzug bei der aktuellen Auswahl erfolgt 
	 * ----------------------------------------------------------------------
	 * 
	 * Im Gegensatz zum OOE wurden die Lebensabzug-Eigenschaften auf protected gesetzt,
	 * damit die Kindsklassen diese Werte verändern dürfen. Diese wurden auch aus dem Konstruktor 
	 * entfernt, da sie beim Erstellen der konkreten Klasse bereits gesetzt werden
	 */
	
	
	@SuppressWarnings("unused")
	private String begegnungsBezeichnung = "";			// Name der Begegnung	
	
	private String reaktionSteicheln = "";				// Reaktion fürs Streicheln
	protected boolean streichelnLebensabzug = false;		// gibt Stricheln Lebensabzug?
	private String reaktionFuettern = "";				// Reaktion fürs Streicheln
	protected boolean fuetternLebensabzug = false;			// gibt Füttern Lebensabzug?
	private String reaktionHauen = "";					// Reaktion fürs Streicheln
	protected boolean hauenLebensabzug = false;			// gibt Hauen Lebensabzug?
	

	public Begegnung(String begegnungsBezeichnung, 
			String reaktionSteicheln,
			String reaktionFuettern,
			String reaktionHauen
			){
		this.begegnungsBezeichnung = begegnungsBezeichnung;
		this.reaktionSteicheln = reaktionSteicheln;
		this.reaktionFuettern = reaktionFuettern;
		this.reaktionHauen = reaktionHauen;
	}
	
	// Ausgabe der Reaktionen
	public String getReaktionSteicheln() {
		return reaktionSteicheln;
	}
	public String getReaktionFuettern() {
		return reaktionFuettern;
	}
	public String getReaktionHauen() {
		return reaktionHauen;
	}

	// Boolsche Getter für Lebensabzug
	public boolean isStreichelnLebensabzug() {
		return streichelnLebensabzug;
	}
	public boolean isFuetternLebensabzug() {
		return fuetternLebensabzug;
	}
	public boolean isHauenLebensabzug() {
		return hauenLebensabzug;
	}
	
	

}

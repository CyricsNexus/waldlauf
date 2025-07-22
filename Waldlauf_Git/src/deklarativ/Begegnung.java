package deklarativ;

public class Begegnung {

	/*************************************************************************
	 * Eine einzelne Begegnung mit den Reaktionen für streicheln, füttern und hauen 
	 *   inkl boolean ob Lebensabzug bei der aktuellen Auswahl erfolgt 
	 * ----------------------------------------------------------------------
	 * 
	 * Siehe Erläuterungen aus dem strukturierten PPs
	 */
	
	
	@SuppressWarnings("unused")
	private String begegnungsBezeichnung = "";			// Name der Begegnung	
	
	private String reaktionSteicheln = "";				// Reaktion fürs Streicheln
	private boolean streichelnLebensabzug = false;		// gibt Stricheln Lebensabzug?
	private String reaktionFuettern = "";				// Reaktion fürs Streicheln
	private boolean fuetternLebensabzug = false;		// gibt Füttern Lebensabzug?
	private String reaktionHauen = "";					// Reaktion fürs Streicheln
	private boolean hauenLebensabzug = false;			// gibt Hauen Lebensabzug?
	

	public Begegnung(String begegnungsBezeichnung, 
			String reaktionSteicheln, boolean streichelnLebensabzug,
			String reaktionFuettern, boolean fuetternLebensabzug,
			String reaktionHauen, boolean hauenLebensabzug
			){
		this.begegnungsBezeichnung = begegnungsBezeichnung;
		this.reaktionSteicheln = reaktionSteicheln;
		this.streichelnLebensabzug = streichelnLebensabzug;
		this.reaktionFuettern = reaktionFuettern;
		this.fuetternLebensabzug = fuetternLebensabzug;
		this.reaktionHauen = reaktionHauen;
		this.hauenLebensabzug = hauenLebensabzug;
	}
	
	// Ausgabe der Reaktionen
	public String getReaktion(int benutzereingabe) {
		switch(benutzereingabe) {
		case 1: return reaktionSteicheln;
		case 2: return reaktionFuettern;
		default: return reaktionHauen;		
		}
	}

	// Boolsche Getter für Lebensabzug
	public boolean isLebensabzug(int benutzereingabe) {
		switch(benutzereingabe) {
		case 1: return streichelnLebensabzug;
		case 2: return fuetternLebensabzug;
		default: return hauenLebensabzug;		
		}
	}

	
	

}

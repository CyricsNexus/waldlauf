package ooe;

public class Begegnung {

	/*************************************************************************
	 * Eine einzelne Begegnung mit den Reaktionen für streicheln, füttern und hauen 
	 *   inkl boolean ob Lebensabzug bei der aktuellen Auswahl erfolgt 
	 * ----------------------------------------------------------------------
	 * 
	 * Auf Setter wird hier verzichtet, da alle Werte per Konstruktor festgelegt werden.
	 * 
	 * zu begegnungsBezeichnung : String |  wird im Spiel nicht genutzt, ggf. für Abfragen des Entwicklers interessant
	 * Es kann sein, dass der Entwickler diese Variable zur Kontrolle haben möchte, um festzustellen, ob die Reaktion 
	 * zu der Begegnung passt. Die Anpassung im Konstruktor und das Einholen der Daten würde maßgebliche Wartungsarbeit 
	 * in der Main-Klasse und der Datenquelle bedeuten. Daher wird die Eigenschaft generell vorsichthalber gespeichert, 
	 * so dass die Begegnung durch einen simplen Getter in dieser Klasse später hinzugefügt werden kann. 
	 * Hier gilt die Voraussicht für CleanCode-Prinzipien: Hinzufügen ist erwünscht, Änderungen des vorhandenen Codes nicht.
	 */
	
	
	@SuppressWarnings("unused")
	private String begegnungsBezeichnung = "";			// Name der Begegnung	
	
	private String reaktionSteicheln = "";				// Reaktion fürs Streicheln
	private boolean streichelnLebensabzug = false;		// gibt Stricheln Lebensabzug?
	private String reaktionFuettern = "";				// Reaktion fürs Streicheln
	private boolean fuetternLebensabzug = false;			// gibt Füttern Lebensabzug?
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

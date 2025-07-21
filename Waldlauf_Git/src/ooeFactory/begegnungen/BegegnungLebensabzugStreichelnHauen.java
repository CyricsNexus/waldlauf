package ooeFactory.begegnungen;

public class BegegnungLebensabzugStreichelnHauen extends Begegnung{

	/* 
	 *  Lebensabzug (es muss nur true gesetzt werden, da es bei Elternklasse alles false ist):
	 *  Streicheln: ja
	 *  Füttern: nein
	 *  Hauen: ja
	 */
	
	public BegegnungLebensabzugStreichelnHauen(String begegnungsBezeichnung, String reaktionSteicheln,
			String reaktionFuettern, String reaktionHauen) {
		super(begegnungsBezeichnung, reaktionSteicheln, reaktionFuettern, reaktionHauen);
		streichelnLebensabzug = true;
		hauenLebensabzug = true;
	}


}

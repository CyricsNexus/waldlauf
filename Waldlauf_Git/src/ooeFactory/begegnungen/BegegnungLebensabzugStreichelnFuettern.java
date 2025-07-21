package ooeFactory.begegnungen;

public class BegegnungLebensabzugStreichelnFuettern extends Begegnung{

	/* 
	 *  Lebensabzug (es muss nur true gesetzt werden, da es bei Elternklasse alles false ist):
	 *  Streicheln: ja
	 *  Füttern: ja
	 *  Hauen: nein
	 */
	
	public BegegnungLebensabzugStreichelnFuettern(String begegnungsBezeichnung, 
			String reaktionSteicheln, String reaktionFuettern, String reaktionHauen) {
		super(begegnungsBezeichnung, reaktionSteicheln, reaktionFuettern, reaktionHauen);
		streichelnLebensabzug = true;
		fuetternLebensabzug = true;
	}


}

package ooeFactory.begegnungen;

public class BegegnungLebensabzugHauen extends Begegnung{

	/* 
	 *  Lebensabzug (es muss nur true gesetzt werden, da es bei Elternklasse alles false ist):
	 *  Streicheln: nein
	 *  Füttern: nein
	 *  Hauen: ja
	 */
	
	public BegegnungLebensabzugHauen(String begegnungsBezeichnung, String reaktionSteicheln,
			String reaktionFuettern, String reaktionHauen) {
		super(begegnungsBezeichnung, reaktionSteicheln, reaktionFuettern, reaktionHauen);
		hauenLebensabzug = true;
	}


}

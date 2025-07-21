package ooeFactory;
import ooeFactory.begegnungen.*;

public class FactoryListeBegegnung {
	
	// Hier wird anhand begegnungsart ausgewählt, welches konkrete Objekt erstellt werden sollte.
	// anschließend wird genau das zurückgegeben.
	
	// Um eine neue Klasse einzubinden, kopiert man ein else if + return-statement und fügt das hinter das letzte else if-statement ein.
	// Anschließend bestimmt man den Parameter der begegnungsart und nennt die Klasse um, welche bei diesem Parameter neu 
	// aufgerufen werden soll.
	public Begegnung createBegegnung(String begegnungsart, String begegnungsname, String reaktionStreicheln, String reaktionFuettern, String reaktionHauen) throws Exception {
		
		 if (begegnungsart.equals("LebensabzugHauen"))  
         	return new BegegnungLebensabzugHauen(begegnungsname, reaktionStreicheln, reaktionFuettern, reaktionHauen); 
         else if (begegnungsart.equals("LebensabzugStreichelnFuettern")) 
        	 	return new BegegnungLebensabzugStreichelnFuettern(begegnungsname, reaktionStreicheln, reaktionFuettern, reaktionHauen);
         else if (begegnungsart.equals("LebensabzugStreichelnHauen")) 
        	 	return new BegegnungLebensabzugStreichelnHauen(begegnungsname, reaktionStreicheln, reaktionFuettern, reaktionHauen);
		 return null;
	}

}

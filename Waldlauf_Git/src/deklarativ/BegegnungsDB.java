package deklarativ;

import java.util.Arrays;
import java.util.List;

// Hier wurden die Begegnungen als Dummy-DB ausgelagert



public class BegegnungsDB {

	public static List<Begegnung> getBegegnungsDB() {
		return Arrays.asList(
			new Begegnung("Hulk", 
					"Der Hulk erwiedert deine Zärtlichkeit und drückt dich mal ganz dolle - ohoh! (-1 Leben).", true, // reaktionSteicheln + Lebensabzug
					"Der Hulk freut sich über das Essen und zieht weiter.", false, // reaktionFuettern + Lebensabzug					
					"HULK SMASH!(-1 Leben).", true	// reaktionHauen + Lebensabzug
			),
			
			new Begegnung("Dr. Snuggles", 
					"Dr. Snuggles drückt Dir zum Abschied freundlich die Hand und hüpft auf seinem Pogo-Schirm weiter.", false, // reaktionSteicheln + Lebensabzug
					"Dr. Snuggles bedankt sich höflich für das Essen und hüpft auf seinem Pogo-Schirm weiter.", false, // reaktionFuettern + Lebensabzug	
					"Na, das ist aber nicht nett, Dr. Snuggles zu verhauen. Die Tiere des Waldes sind erbost und \nvermoppern dich dafür gründlich. (-1 Leben).", true	// reaktionHauen + Lebensabzug
					),

			new Begegnung("Batman", 
					"Batman nickt dir aufmunternd zu. \"Freundlichkeit gegenüber Unbekannten kann nie schaden. Wie sagte \nnoch einst ein weiser Mann aus dem gebildeten Orient...\" Du wachst nach einiger Zeit benommen auf und \nsetzt Deinen Weg fort.", false, // reaktionSteicheln + Lebensabzug
					"Batman freut sich sehr für das Essen. \"Ein gutgenährter Magen  ist die Grundvoraussetzung für einen \ngut genährten Geist. Vergiss das niemals, Robin!\" Bevor du etwas sagen kannst, ist er schon entfleucht.", false, // reaktionFuettern + Lebensabzug
					"Oh nein! Du hast Batman gehauen. Heiliger Konterschlag! (-1 Leben)", true	// reaktionHauen + Lebensabzug
					),
			
			new Begegnung("Pennywise", 
					"\"Komm mit! Mit uns kannst Du fliiiieeegeeeen!\" Der gruselige Clown winkt und schon bist Du im Gulli (-1 Leben)", true, // reaktionSteicheln + Lebensabzug
					"\"Magst Du auch Popcorn? Dann komm mit! Bei uns gibt es ganz viel davon!\" Der gruselige Clown gibt \nDir einen roten Ballon und zieht dich in den Gulli. (-1 Leben)", true, // reaktionFuettern + Lebensabzug 	
					"Du knüppelst auf Pennywise drauf. Du magst eh keine Ballons.", false	// reaktionHauen + Lebensabzug
					),
			
			new Begegnung("T-Rex", 
					"Der T-Rex mag es, gestreichelt zu werden. Dann verschlingt er Dich. (-1 Leben)", true, 	// reaktionSteicheln + Lebensabzug
					"Der T-Rex guckt hungrig. Du bist das Essen. (-1 Leben)", true, // reaktionFuettern + Lebensabzug
					"Der T-Rex rennt weinend weg.", false	// reaktionHauen + Lebensabzug
					),
			
			new Begegnung("Baum", 
					"Der Baum streichelt nicht zurück.", false, // reaktionSteicheln + Lebensabzug
					"Der Baum ist unbeeindruckt vom Essen.", false, 	// reaktionFuettern + Lebensabzug
					"Der Baum kippt um. Bumm. (-1 Leben)", true	// reaktionHauen + Lebensabzug
					),
			
			new Begegnung("Lama", 
					"Das Lama macht \"Bääääh?\"", false, // reaktionSteicheln + Lebensabzug
					"Das Lama macht \"Bääää!\" *Mampf*", false, 	// reaktionFuettern + Lebensabzug
					"Das Lama spuckt. (-1 Leben)", true	// reaktionHauen + Lebensabzug
					)
			
			/* VORLAGE für weitere Begegnungen	
			listeBegegnung.addBegegnung("", 
					"", false, 	// reaktionSteicheln + Lebensabzug
					"", false, // reaktionFuettern + Lebensabzug
					"", false	// reaktionHauen + Lebensabzug
					)
			 */	

			
			
		);
	}
}

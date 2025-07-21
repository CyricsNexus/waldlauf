package ooeFactory;
/**
 * ## ERLÄUTERUNG ##
 * Dieses Paket soll das Factory-Method-Pattern erläutern. Für den Waldlauf ist das Pattern tatsächlich eher 
 * unggeignet, da es kaum einen Mehrwert zu der ooe-Version bietet.
 * 
 * Zu dem ooeFactory-Paket gehört zusätzlich das Paket ooeFactory.begegnungen, in welchem die Begegnungen
 * gespeichert werden.
 * 
 * ## Welchen Vorteil bietet das Factory-Method-Pattern? ##
 * Das Factory-Method-Pattern erlaubt, einfach und ohne den Algorithmus zu verändern, einfach 
 * neue konkrete Objekte einzubinden. Dazu wird eine konkrete Klasse erstellt und diese in der
 * abstrakten Fabrik ohne großen Aufwand hinzugefügt.
 * Dadurch kann man den Algorithmus fertig erstellen und nachträglich nach Lust und Laune neue
 * Klassen hinzufügen.
 * 
 * ## Welche Begegnungen werden konkret erstellt? ##
 * Die folgenden Begegnungen existieren (unter der Bedingung, dass mindestens eine Entscheidung immer
 * korrekt und eine Entscheidung immer falsch sein muss):
 * 1. streicheln, füttern, !hauen
 * 2. streicheln, !füttern, hauen
 * 3. streicheln, !füttern, !hauen
 * 4. !streicheln, füttern, !hauen
 * 5. !streicheln, !füttern, hauen
 *
 * Gehen wir davon aus, dass ich keine Lust habe, andauernd beim Bestimmen der Begegnungen diese trues & false
 * anzugeben, sondern dass ich nur die Texte einpflegen will. Beim Erstellen der Klasse soll bereits feststehen,
 * welche Entscheidung gut und schlecht sind.
 * 
 * Bislang habe ich nur Situationen, in denen der Lebensabzug nach den Entscheidungen (s.o.) 1., 2. und 5. passiert.
 * Das bedeutet nicht, dass die anderen Begegnungen nicht kommen. Aber durch das Factory-Pattern kann ich diese leicht
 * hinzufügen, indem ich eine der Begegnungen kopiere, die Werte anpasse und einen Eintrag in der Factory hinzufüge.
 * Der Rest bleibt gleich. 
 * 
 * Das Ganze hat den Nachteil, dass sehr viele Parameter geschubst werden. Sie werden in der Main zum ersten Mal angegeben,
 * müssen dann zur Liste, diese gibt sie dann in der Fabrik ein, so dass daraus endlich das Objekt erstellt wird.
 * 
 * Der Vorteil ist: wenn es einmal eingerichtet wurde, muss man sich nicht mehr damit befassen, warum. Man muss nur eine neue Klasse
 * erstellen und einen eindeutigen Bezeichner erzeugen. Der Rest wird durch Copy & Paste übernommen.
 *  
 ***********************************************************************************************/ 
/**
 * @version 2.0
 * @author C. Frantzen
 * @since 2.0
 **/
/**
 * das prozedurale package ist die Erweiterung zu "strukturiert_mit_err".
 * hier wird gezeigt, wie durch Prozeduren eine bessere Übersichtlichkeit kommen kann
 * 
 * Die Begegnungsprozedur hakt noch sehr. Der Index muss manuell eingetragen werden und auch die Begegnungen einzufügen sind recht steif. 
 * Hier ist nicht wirklich ein Vorteil durch die Prozedur ersichtlich, außer dass durch die Parameter eine Eingabe erleichtert wird
 *
 * Vorteil dieser Variante sind...
 * 1. insofern man dieses möchte, der deklarative Ansatz (z.B. Methodenaufrufe mit aufschlussreichen Namen statt Ausgaben, um den Ablauf leichter lesen zu können
 * 2. die Abgeschlossenheit der Methoden, um Inhalte zu bearbeiten, ohne die Befürchtung zu haben, aus Versehen etwas in der Hauptstruktur zu ändern
 * 3. sich wiederholende Quellcode kann durch einen Methodenaufruf ersetzt werden, so dass es schlanker ist (in diesem Beispiel nicht gegeben)
 * 
 *  Vorteil #1 ist KEIN deklaratives Programmierparadigma. Das deklarative Programmierparadigma basiert allerdings auf dieser Vorgehensweise
 *     Zum deklarativen Programmierparadigma gehören standardmäßig die Lambda-Programmierung und ebenfalls OOE
 *     Gleich ist, dass anstelle des ausführenden Quellcodes Methodenaufrufe vorhanden sind, welche den Quellcode verarbeiten, dass ein Leser
 *     sich die Algorithmik aus dem herunterlesen der Methoden erschließen kann, ohne explizit zu wissen, wie der Quellcode in den Methoden lautet
 *     Der Vorteil hierbei ist, dass seltener Ablauffehler in der Algorithmik passieren
 *     
 *  Vorteil #2 findet man üblicherweise in einem anderen Programmierparadigma, wobei dieses nicht lediglich einfache Methoden betrifft, sondern ganze Module
 *       Dieses nennt sich Modulare Programmierung und basiert darauf, dass ganze Module (z.B. pdf-converter) unabhängig vom Artefakt (das Programm) sind und so leicht
 *         - ausgetauscht werden können
 *         - bei Fehlern editiert/entfernt werden können, ohne dass das Hauptprogramm zu betreffen
 */
/**
 * @version 1.0
 * @author C. Frantzen
 * @since 1.0
 **/
package prozedural;
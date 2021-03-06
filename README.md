# ProjektarbeitPizza
THIS IS A GROUP PROJECT, NOT MY OWN WORK ONLY!!! 

Bestellsystem als Abschlussarbeit für den Programmierkurs in Java.

Die Projektbeschreibung ist als .docx-Datei in diesem Projekt zu finden.

# Informationen zum Code
Das Projekt ist im Model-View-Controller-Muster implementiert. Die Idee ist, dass so wenig Klassen wie möglich verwendet werden und der Code so übersichtlich wie möglich ist.

Abgesehen von den Testklassen gibt es zwei ausführbare Klassen: Main.java und MainKonsole.java. Beide befinden sich im Ordner control und greifen auf dasselbe Bestellsystem zu, das in model implementiert ist.

MainKonsole.java enthält das konsolenbasierte Pizzabestellsystem. Hierin können Benutzer*innen per Tastatureingabe Pizzen belegen, in den Warenkorb setzen und bezahlen. Dabei spielt die Groß- und Kleinschreibung ebenso wie die Anzahl an Leerzeichen keine Rolle. 

Bei Ausführung von Main.java hingegen öffnet sich ein eigenes Fenster mit einer grafischen Oberfläche (GUI) des Bestellsystems. Zuerst ist eine neue Pizza auszuwählen. Anschließend kann diese Pizza mit Zutaten und einer Sauce belegt werden. Bei "In den Warenkorb" landet die Pizza im Warenkorb. Dabei kann zuvor per Tastatureingabe und Enter-Eingabe die jeweilige Pizza nach Belieben im entsprechenden Textfeld benannt werden. Sobald auf diese Weise der Warenkorb fertig ist, kann die Bestellung abgeschlossen werden und die Zahlung erfolgt. Das Bestellsystem ist dabei so gebaut, dass falsche Klicks (z.B. "In den Warenkorb", bevor eine neue Pizza erstellt wurde) nicht zu einem Programmabsturz, sondern zu einem entsprechenden Hinweis auf der Oberfläche führen.

Die GUI ist im Ordner view mit Swing implementiert. Gegebenenfalls muss die Bildschirmauflösung sehr hoch gesetzt werden, damit alle Knöpfe und Textfelder sichtbar sind.

Mit JUnit4 getestet werden alle Methoden, in denen gerechnet oder Informationen zur Pizza bzw. zum Warenkorb als Text ausgegeben werden. Somit werden die Klassen Pizza.java und PizzenList.java getestet. Ebenfalls wird getestet, ob die Saucen- und Zutatendaten korrekt von den jeweiligen .csv-Dateien eingelesen werden.

 
## Aufgabe 1: Testarten in der Informatik <br><br>
 
1. **Unit-Test** (Einheitentest): 
   - Testet einzelne Komponenten, z. B. eine Funktion oder Methode.
   - Wird oft von Entwicklern geschrieben, um sicherzustellen, dass einzelne Teile der Software wie vorgesehen funktionieren.
 
2. **Integrationstest**:
   - Testet das Zusammenspiel mehrerer Module oder Systeme.
   - Ein Beispiel ist die Kommunikation zwischen Frontend und Backend.
 
3. **Systemtest**:
   - Testet das gesamte System, um zu prüfen, ob alle Anforderungen erfüllt sind.
   - Die Software wird in einer möglichst realen Umgebung getestet, bevor sie an die Endbenutzer weitergegeben wird.
 
Diese Tests lassen sich im V-Modell den verschiedenen Entwicklungsphasen zuordnen. Unit-Tests sind in den frühen Entwicklungsphasen sinnvoll, während Integrationstests und Systemtests später im Entwicklungsprozess durchgeführt werden.
 
## Aufgabe 2: Beispiele für Software-Fehler und -Mängel
 
In der Theorie wird zwischen Fehlern und Mängeln unterschieden:
 
- **Fehler (Bug)**: Ein Fehler entsteht durch eine falsche Implementierung und führt dazu, dass die Software nicht wie erwartet funktioniert.
- **Mangel**: Ein Mangel ist ein unzureichend erfülltes Kriterium und kann durch fehlende oder unklare Anforderungen entstehen.
 
**Beispiele**:
- **Software-Fehler**: Ein Online-Banking-Portal zeigt falsche Kontostände an, was durch einen Programmierfehler verursacht wird.
- **Software-Mangel**: Eine Funktion zur Passwort-Zurücksetzung fehlt in der Benutzeroberfläche, obwohl sie in den Anforderungen stand.
 
**Beispiel für hohen Schaden:** Ein Fehler in einer Buchhaltungssoftware könnte falsche Steuerberichte erzeugen, was zu erheblichen finanziellen Konsequenzen führt.
 
## Aufgabe 3: Beispiel zur Preisberechnung und Testtreiber
 
Die Preisberechnungsklasse berücksichtigt Rabatte und Zuschläge abhängig von verschiedenen Faktoren. Der gegebene Code enthält jedoch einen Fehler. Ein möglicher Fehler könnte sein, dass die Berechnung des `addon_discount` nicht korrekt ist, da der `discount` eventuell den Sonderrabatt überschreibt.
 
Ein möglicher Testtreiber könnte so aussehen:
 
```java
boolean test_calculate_price(){
    double result = calculatePrice(200.0, 30.0, 50.0, 3, 5.0);  // Beispielwerte
    double expected = /* exakt berechneter Wert basierend auf Formel */;
    return Math.abs(result - expected) < 0.01; // Toleranz bei Gleitkommazahlen
}
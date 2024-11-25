# Lösungen für die Übungen zur Verkaufssoftware

## Übung 1: Testfälle zur Verkaufssoftware

### Teststrategie
Gemäß der Theorie ist eine klare Teststrategie erforderlich. Dazu erstellen wir **funktionale** und **nicht-funktionale Testfälle** für die Rabattregeln der Verkaufssoftware.

### Abstrakte Testfälle
Hier verwenden wir logische Operatoren, um die Rabattregelungen allgemein zu beschreiben:

| Testfall | Kaufpreis-Bereich             | Erwarteter Rabatt (%) |
|----------|--------------------------------|------------------------|
| 1        | Kaufpreis < 15'000             | 0                      |
| 2        | 15'000 ≤ Kaufpreis < 20'000    | 5                      |
| 3        | 20'000 ≤ Kaufpreis < 25'000    | 7                      |
| 4        | Kaufpreis ≥ 25'000             | 8.5                    |

### Konkrete Testfälle
In dieser Tabelle werden konkrete Werte eingesetzt, um die abstrakten Regeln zu überprüfen:

| Testfall | Kaufpreis (CHF) | Erwarteter Rabatt (%) | Erwarteter Endpreis (CHF) |
|----------|------------------|-----------------------|---------------------------|
| 1        | 14'999           | 0                     | 14'999                    |
| 2        | 15'000           | 5                     | 14'250                    |
| 3        | 19'999           | 5                     | 18'999.05                 |
| 4        | 20'000           | 7                     | 18'600                    |
| 5        | 24'999           | 7                     | 23'249.07                 |
| 6        | 25'000           | 8.5                   | 22'875                    |
| 7        | 30'000           | 8.5                   | 27'450                    |

---

# Lösung für Übung 2: Funktionale Black-Box-Tests für die Webseite luxuscar.ch

| ID  | Testfallbeschreibung                                                             | Erwartetes Ergebnis                                                                                       |
|-----|----------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| 1   | **Navigation zur Startseite**: Aufrufen der URL `https://www.luxuscar.ch/`       | Die Startseite wird korrekt geladen und angezeigt.                                                        |
| 2   | **Fahrzeugübersicht anzeigen**: Klick auf den Menüpunkt "Autos"                  | Eine Liste aller verfügbaren Luxusfahrzeuge wird angezeigt.                                               |
| 3   | **Fahrzeugdetails einsehen**: Auswahl eines spezifischen Fahrzeugs aus der Liste | Detaillierte Informationen zum ausgewählten Fahrzeug werden angezeigt, einschließlich Bilder und Spezifikationen. |
| 4   | **Kontaktformular nutzen**: Aufrufen der Kontaktseite und Ausfüllen des Formulars| Das Kontaktformular wird erfolgreich versendet, und eine Bestätigungsmeldung erscheint.                   |
| 5   | **AGB einsehen**: Klick auf den Menüpunkt "AGB"                                  | Die Seite mit den Allgemeinen Geschäftsbedingungen wird korrekt angezeigt.                                |
| 6   | **Telefonischer Kontakt**: Nutzung der angegebenen Telefonnummer                 | Die angegebene Telefonnummer ist erreichbar, und Anfragen werden professionell bearbeitet.                |
| 7   | **Social-Media-Links prüfen**: Klick auf die Social-Media-Icons                  | Die entsprechenden Social-Media-Seiten von Luxuscar werden in einem neuen Tab geöffnet.                   |
| 8   | **Responsive Design testen**: Zugriff auf die Webseite über ein mobiles Gerät    | Die Webseite passt sich dem kleineren Bildschirm an und bleibt benutzerfreundlich.                        |
| 9   | **Seitenladezeit messen**: Aufrufen der Startseite                               | Die Seite lädt innerhalb von 3 Sekunden vollständig.                                                      |
| 10  | **Fehlerseiten-Handling**: Aufrufen einer nicht existierenden Seite (z.B. `/xyz`)| Eine benutzerfreundliche 404-Fehlerseite wird angezeigt.                                                  |


---

## Übung 3: Funktionale und Nicht-funktionale Testfälle

### Analyse des Bankprojekts

#### Mögliche Black-Box Testfälle
Diese basieren auf Benutzeraktionen und stellen sicher, dass das System wie erwartet funktioniert, ohne den Code direkt zu betrachten.

Bei der Eingabe ist es unübersichtlich, da nicht klar hervorgehoben wird, dass man auch eine Zahl eingeben kann. Dies könnte durch eine klarere Benutzerführung verbessert werden, beispielsweise durch eine explizite Information im Menü, die darauf hinweist, dass neben den Buchstabenoptionen auch Kontonummern eingegeben werden können.

**Kontenerstellung**
- Erstelle ein Konto mit einem gültigen Namen, einer Währung und einem Startguthaben.
- Teste ungültige Eingaben (z. B. leere Namen, unbekannte Währungen).

**Wechselkursabfrage**
- Abfrage des Wechselkurses zwischen zwei unterstützten Währungen.
- Teste ungültige oder nicht unterstützte Währungen.

**Benutzerinteraktion**
- Navigiere durch das Menü und prüfe die Reaktion auf jede Option.
- Teste ungültige Eingaben (z. B. Buchstaben, die nicht vorgesehen sind).

---

#### Mögliche White-Box Testfälle

**`Account`-Klasse**
- Teste `withdraw()` und `deposit()`-Methoden auf korrekte Berechnungen.
- Teste `pseudoDeleteAccount()`, um sicherzustellen, dass alle Felder korrekt zurückgesetzt werden.

**`Bank`-Klasse**
- Teste `createAccount()` und `deleteAccount()`, um sicherzustellen, dass Konten korrekt hinzugefügt und entfernt werden.
- Teste `getAccount(int nr)`, um sicherzustellen, dass Konten basierend auf der ID korrekt abgerufen werden.

**`Counter`-Klasse**
- Teste `chooseAccount()` und prüfe, ob Benutzeraktionen korrekt verarbeitet werden.
- Teste `transferAmount()` auf korrekte Berechnungen bei Wechselkursen.

**`ExchangeRateOkhttp`**
- Teste `getExchangeRate()`, um sicherzustellen, dass die API-Abfrage korrekt funktioniert.
- Simuliere Fehler wie ungültige Antworten oder Netzwerkfehler.

---

#### Code-Verbesserungen und Best Practices

**Fehlerbehandlung**
- Ersetze `System.out.println` durch ein konsistentes Logging-System.
- Füge robustere Fehlerbehandlungen hinzu, insbesondere bei der API-Abfrage in `ExchangeRateOkhttp`.

**Modularisierung**
- Zerlege die großen Methoden in kleinere, besser lesbare Methoden. Zum Beispiel in der `Counter`-Klasse.

**API-Key-Schutz**
- Der API-Key in `ExchangeRateOkhttp` sollte nicht im Code hinterlegt sein. Verwende Umgebungsvariablen oder eine sichere Konfiguration.

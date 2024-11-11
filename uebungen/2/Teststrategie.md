## Übung 1: Testfälle zur Verkaufssoftware

### Teststrategie
Gemäß der Theorie ist eine klare Teststrategie erforderlich. Dazu erstellen wir **funktionale** und **nicht-funktionale Testfälle** für die Rabattregeln der Verkaufssoftware:

#### Funktionale Testfälle
Die Funktionalität der Rabattregelung wird geprüft. Es gibt:
- **Abstrakte Testfälle**: Beschreiben die Regeln allgemein.
- **Konkrete Testfälle**: Geben genaue Werte und erwartete Ergebnisse an.

#### Funktionale Testfälle für Rabattregeln

| Testfall | Kaufpreis (CHF) | Erwarteter Rabatt (%) | Erwarteter Endpreis (CHF) |
|----------|------------------|-----------------------|---------------------------|
| 1        | 14'999           | 0                     | 14'999                    |
| 2        | 15'000           | 5                     | 14'250                    |
| 3        | 19'999           | 5                     | 18'999.05                 |
| 4        | 20'000           | 7                     | 18'600                    |
| 5        | 24'999           | 7                     | 23'249.07                 |
| 6        | 25'000           | 8.5                   | 22'875                    |
| 7        | 30'000           | 8.5                   | 27'450                    |

#### Nicht-funktionale Testfälle
1. **Leistungstest**: Testen, wie gut die Software viele Rabattberechnungen in kurzer Zeit verarbeitet.
2. **Usability-Test**: Überprüfen, ob die Benutzeroberfläche für die Rabattregelung verständlich und benutzerfreundlich ist.
3. **Sicherheitstest**: Sicherstellen, dass unberechtigte Benutzer die Rabattregeln nicht ändern können.

---

## Übung 2: Abstrakte und Konkrete Testfälle

### Theorie zu abstrakten und konkreten Testfällen
- **Abstrakte Testfälle**: Geben eine allgemeine Beschreibung des Testziels, aber keine genauen Werte.
- **Konkrete Testfälle**: Basieren auf den abstrakten Fällen, enthalten jedoch spezifische Werte und erwartete Ergebnisse.

### Anwendung der Theorie
Wir erstellen aus den Rabattregelungen der Verkaufssoftware sowohl abstrakte als auch konkrete Testfälle.

#### Abstrakte Testfälle
1. **Kein Rabatt**, wenn der Kaufpreis unter 15'000 CHF liegt.
2. **5% Rabatt** für Kaufpreise bis zu 20'000 CHF.
3. **7% Rabatt** für Kaufpreise unter 25'000 CHF.
4. **8,5% Rabatt** für Kaufpreise ab 25'000 CHF.

#### Konkrete Testfälle

| Testfall | Kaufpreis (CHF) | Erwarteter Rabatt (%) | Erwarteter Endpreis (CHF) |
|----------|------------------|-----------------------|---------------------------|
| 1        | 14'999           | 0                     | 14'999                    |
| 2        | 17'500           | 5                     | 16'625                    |
| 3        | 22'500           | 7                     | 20'925                    |
| 4        | 26'000           | 8.5                   | 23'790                    |

---

## Übung 3: Funktionale und Nicht-funktionale Testfälle

### Theorie zu funktionalen und nicht-funktionalen Testfällen
- **Funktionale Testfälle**: Prüfen die Funktionsweise der Software gemäß den Spezifikationen.
- **Nicht-funktionale Testfälle**: Prüfen andere Aspekte wie Leistung, Benutzerfreundlichkeit und Sicherheit.

### Funktionale Testfälle für die Rabattsoftware
Hier testen wir die korrekte Umsetzung der Rabattregeln.

| Testfall | Kaufpreis (CHF) | Erwarteter Rabatt (%) | Erwarteter Endpreis (CHF) |
|----------|------------------|-----------------------|---------------------------|
| 1        | 15'000           | 5                     | 14'250                    |
| 2        | 20'000           | 7                     | 18'600                    |
| 3        | 25'000           | 8.5                   | 22'875                    |

### Nicht-funktionale Testfälle für die Rabattsoftware
1. **Leistungstest**: Prüft die Reaktionszeit, wenn die Software mehrere Rabattberechnungen in kurzer Zeit durchführt.
2. **Usability-Test**: Überprüft, ob Verkäufer die Rabattregeln einfach verstehen und anwenden können.
3. **Sicherheitstest**: Stellt sicher, dass nur berechtigte Benutzer auf die Rabattkonfiguration zugreifen und diese ändern können.


## Übung 1

Um die REST-Schnittstelle eines Backends automatisiert zu testen, habe ich mich für **Postman** entschieden. Dieses Tool erlaubt es, REST-APIs effizient und strukturiert zu testen. Mit der Möglichkeit, Tests als Skripte zu schreiben und in Collections zu organisieren, lassen sich wiederholbare und automatisierte Tests einfach umsetzen. Zusätzlich habe ich einen einfachen **Newman CLI Workflow** erstellt, um die Tests auch in einer CI/CD-Pipeline auszuführen.

Dies ermöglicht eine kontinuierliche Überprüfung der Schnittstellen und gewährleistet eine stabile API-Integration. Für zusätzliche Kreativität könnte man Tests mit **JMeter** simulieren, um auch Performance und Last zu messen.


## Übung 2 
Cypress Tests

## Übung 3
### Testumgebung
- **Tool**: Postman
- **Backend-URL**: `http://localhost:8081/`
- **Endpoints getestet**:
    - `GET /students`
    - `POST /students`

## Testkonfiguration
- **Iterationsanzahl**: 100
- **Body für POST**:
  ```json
  {
    "id": 10,
    "name": "Max Muster",
    "email": "max.muster@example.com"
  }

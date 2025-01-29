# Wer wird Millionär – Konsolenspiel in Java

**Hinweis:** Für Dokumentation --> **[Wiki](https://github.com/DEIN-REPO/wiki)**

Dies ist eine Java-Implementierung des bekannten Spiels **"Wer wird Millionär"**, basierend auf den originalen Spielregeln. Das Spiel bietet 15 Fragen, mehrere Joker und Gewinnstufen sowie die Möglichkeit, den aktuellen Gewinn jederzeit mitzunehmen oder das Risiko einzugehen, alles zu verlieren.

## Features

- **15 Fragen:** Jede Frage hat vier Antwortmöglichkeiten, von denen eine korrekt ist.
- **15 Gewinnstufen:** Spieler können sich mit jeder korrekt beantworteten Frage zu höheren Gewinnstufen hocharbeiten.
- **2 Sicherheitsstufen:** Die Sicherheitsstufen schützen den Spieler vor dem kompletten Verlust.
- **4 Joker:**
  - **50:50** – Zwei falsche Antworten werden entfernt.
  - **Publikumsjoker** – Zeigt eine prozentuale Verteilung der Antworten.
  - **Telefonjoker** – Gibt eine mögliche Antwort.
  - **Spieler-eigener Joker** – Eine kreative, zusätzliche Joker-Funktion.
- **Spielende:** 
  - Möglichkeit, das Spiel nach jeder korrekt beantworteten Frage zu beenden, um den aktuellen Gewinn mitzunehmen.
  - Maximaler Gewinn bei richtiger Beantwortung aller 15 Fragen.
  - Verlust des gesamten Geldbetrags, wenn die erste Sicherheitsstufe nicht erreicht wird.

## Details

- **Programmiersprache:** Java
- **Eingabe:** `Scanner` wird für die Spielereingaben verwendet.
- **Fragen-Logik:** Die Fragen und Antworten werden mit `switch-case` oder `if-else` implementiert.
- **Schleifen:** Eine `do-while`-Schleife steuert das Spiel, bis es beendet wird.
- **Saubere Code-Struktur:** 
  - Globale Variablen für das gesamte Spiel.
  - Methoden für einzelne Funktionen (z. B. Joker-Einsatz).

## Ziel

Das Ziel des Spiels ist es, alle 15 Fragen korrekt zu beantworten und den maximalen Gewinn zu erzielen – oder zum richtigen Zeitpunkt auszusteigen, bevor alles verloren geht.

---

package ch.bbcag.werwirdmillionaer;

import java.util.*;

public class WerWirdMillionaer {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static List<String[]> fragenUndAntworten = new ArrayList<>(Arrays.asList(
            new String[]{"Wie heisst die Hauptstadt von Frankreich?", "Berlin", "Madrid", "Paris", "Rom", "3"},
            new String[]{"Welches Element hat das chemische Symbol 'O'?", "Gold", "Silber", "Sauerstoff", "Helium", "3"},
            new String[]{"Wer schrieb 'Faust'?", "Goethe", "Schiller", "Lessing", "Kafka", "1"},
            new String[]{"Was ist die Quadratwurzel von 64?", "6", "7", "8", "9", "3"},
            new String[]{"Welcher Planet ist der Sonne am naechsten?", "Venus", "Mars", "Merkur", "Jupiter", "3"},
            new String[]{"Wie viele Kontinente gibt es?", "5", "6", "7", "8", "3"},
            new String[]{"Wer malte die Mona Lisa?", "Van Gogh", "Michelangelo", "Da Vinci", "Rembrandt", "3"},
            new String[]{"Wie heisst der hoechste Berg der Welt?", "Kilimandscharo", "Mount Everest", "Mont Blanc", "K2", "2"},
            new String[]{"Welches Tier ist das Wappentier von Deutschland?", "Baer", "Adler", "Loewe", "Wolf", "2"},
            new String[]{"Wann begann der Zweite Weltkrieg?", "1914", "1939", "1945", "1961", "2"},
            new String[]{"Wie viele Beine hat eine Spinne?", "6", "8", "10", "12", "2"},
            new String[]{"Welcher Fluss fliesst durch Aegypten?", "Amazonas", "Nil", "Rhein", "Donau", "2"},
            new String[]{"Wie viele Spieler hat eine Fussballmannschaft auf dem Feld?", "9", "10", "11", "12", "3"},
            new String[]{"Wer ist der Autor von 'Harry Potter'?", "J.R.R. Tolkien", "J.K. Rowling", "George R.R. Martin", "Stephen King", "2"},
            new String[]{"Wie viele Planeten hat unser Sonnensystem?", "7", "8", "9", "10", "2"}
    ));

    static int[] gewinnstufen = {
            0, 100, 200, 300, 500,
            1_000, 2_000, 4_000, 8_000, 16_000,
            32_000, 64_000, 125_000, 250_000, 500_000,
            1_000_000
    };

    static int sicherheitsstufe1 = 5;
    static int sicherheitsstufe2 = 10;

    static boolean[] jokerVerfuegbar = {true, true, true, true};
    static int kontostand = 0;
    static boolean geheimjokerAktiv = false;

    static class AnswerOption {
        String text;
        boolean isCorrect;
        public AnswerOption(String text, boolean isCorrect) {
            this.text = text;
            this.isCorrect = isCorrect;
        }
    }

    public static void main(String[] args) {
        System.out.println(" __          ________ _____   __          _______ _____  _____    __  __ _____ _      _      _____ ____  _   _  _   _  _____  ");
        System.out.println(" \\ \\        / /  ____|  __ \\  \\ \\        / /_   _|  __ \\|  __ \\  |  \\/  |_   _| |    | |    |_   _/ __ \\| \\ | |(_)_(_)|  __ \\ ");
        System.out.println("  \\ \\  /\\  / /| |__  | |__) |  \\ \\  /\\  / /  | | | |__) | |  | | | \\  / | | | | |    | |      | || |  | |  \\| |  / \\  | |__) |");
        System.out.println("   \\ \\/  \\/ / |  __| |  _  /    \\ \\/  \\/ /   | | |  _  /| |  | | | |\\/| | | | | |    | |      | || |  | | . ` | / _ \\ |  _  / ");
        System.out.println("    \\  /\\  /  | |____| | \\ \\     \\  /\\  /   _| |_| | \\ \\| |__| | | |  | |_| |_| |____| |____ _| || |__| | |\\  |/ ___ \\| | \\ \\ ");
        System.out.println("     \\/  \\/   |______|_|  \\_\\     \\/  \\/   |_____|_|  \\_\\_____/  |_|  |_|_____|______|______|_____|\\____/|_| \\_/_/   \\_\\_|  \\_\\");
        System.out.println("                                                                                                                              ");
        System.out.println("                                                                                                                              ");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Collections.shuffle(fragenUndAntworten);
        int aktuelleFrage = 0;
        boolean weiterspielen;

        do {
            stelleFrage(aktuelleFrage);
            System.out.println("\nMoechten Sie weitermachen (j/n)?");
            String wahl = scanner.next();
            if (wahl.equalsIgnoreCase("n")) {
                System.out.println("\nSie gehen mit " + kontostand + " Euro nach Hause!");
                return;
            }
            clearScreen();
            aktuelleFrage++;
            weiterspielen = (aktuelleFrage < 15);
        } while (weiterspielen);

        System.out.println("\nFantastisch! Sie haben alle 15 Fragen richtig beantwortet!");
        System.out.println("Sie gewinnen " + gewinnstufen[15] + " Euro!");
    }

    static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    static void stelleFrage(int questionIndex) {
        String[] frage = fragenUndAntworten.get(questionIndex);
        String fragetext = frage[0];
        int korrekteAntwortIndex = Integer.parseInt(frage[5]);
        List<AnswerOption> options = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            boolean correct = (i == korrekteAntwortIndex);
            options.add(new AnswerOption(frage[i], correct));
        }
        Collections.shuffle(options);
        System.out.println("\n-----------------------------------------------------");
        System.out.println("Frage " + (questionIndex + 1) + ": " + fragetext);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ") " + options.get(i).text);
        }
        System.out.println("\nMoechten Sie einen Joker benutzen? (j/n),");
        System.out.println("oder direkt (1-4), um die Frage sofort zu beantworten:");
        String eingabe = scanner.next();

        int antwortIndex;
        if (eingabe.equalsIgnoreCase("j")) {
            nutzeJoker(fragetext, questionIndex, options);
            antwortIndex = frageAntwortEingeben();
        } else if (eingabe.equalsIgnoreCase("n")) {
            antwortIndex = frageAntwortEingeben();
        } else if (eingabe.matches("[1-4]")) {
            antwortIndex = Integer.parseInt(eingabe) - 1;
        } else {
            System.out.println("Ungueltige Eingabe! Bitte 'j', 'n' oder (1-4).");
            stelleFrage(questionIndex);
            return;
        }
        pruefeAntwort(options, antwortIndex, questionIndex, fragetext);
    }

    static int frageAntwortEingeben() {
        System.out.print("Bitte waehlen Sie (1-4) als Antwort: ");
        int ant;
        try {
            ant = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Fehler: Bitte eine Zahl von 1 bis 4 eingeben.");
            scanner.nextLine();
            return frageAntwortEingeben();
        }
        if (ant < 1 || ant > 4) {
            System.out.println("Bitte eine Zahl von 1 bis 4 eingeben.");
            return frageAntwortEingeben();
        }
        return ant - 1;
    }

    static void pruefeAntwort(List<AnswerOption> options, int index, int questionIndex, String fragetext) {
        if (index < 0 || index >= options.size()) {
            System.out.println("Ungueltige Eingabe!");
            stelleFrage(questionIndex);
            return;
        }
        AnswerOption chosen = options.get(index);
        if (chosen.isCorrect) {
            kontostand = gewinnstufen[questionIndex + 1];
            System.out.println("Richtig! Neuer Kontostand: " + kontostand + " Euro.");
        } else {
            if (geheimjokerAktiv) {
                System.out.println("Falsch! Aber dein Geheimjoker hat dich einmal gerettet.");
                geheimjokerAktiv = false;
                stelleFrage(questionIndex);
                return;
            }
            int verlust = ermittleVerlust(questionIndex);
            System.out.println("Leider falsch! Sie gehen mit " + verlust + " Euro nach Hause.");
            System.exit(0);
        }
    }

    static int ermittleVerlust(int questionIndex) {
        if (questionIndex < sicherheitsstufe1) {
            return 0;
        } else if (questionIndex < sicherheitsstufe2) {
            return gewinnstufen[sicherheitsstufe1];
        } else {
            return gewinnstufen[sicherheitsstufe2];
        }
    }

    static void nutzeJoker(String fragetext, int questionIndex, List<AnswerOption> options) {
        System.out.println("\nWelchen Joker moechten Sie nutzen?");
        if (jokerVerfuegbar[0]) System.out.println("1) 50:50");
        if (jokerVerfuegbar[1]) System.out.println("2) Publikumsjoker");
        if (jokerVerfuegbar[2]) System.out.println("3) Telefonjoker");
        if (jokerVerfuegbar[3]) System.out.println("4) Geheimjoker (1x falsche Antwort verziehen)");

        int wahl;
        try {
            wahl = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Bitte eine gueltige Joker-Nummer eingeben (1-4)!");
            scanner.nextLine();
            nutzeJoker(fragetext, questionIndex, options);
            return;
        }

        switch (wahl) {
            case 1:
                if (jokerVerfuegbar[0]) {
                    removeTwoWrongAnswers(options);
                    jokerVerfuegbar[0] = false;
                    System.out.println("\n-----------------------------------------------------");
                    System.out.println("\nNach dem 50:50-Joker bleibt die Frage mit 2 Antworten:");
                    System.out.println("Frage " + (questionIndex + 1) + ": " + fragetext);
                    for (int i = 0; i < options.size(); i++) {
                        System.out.println((i + 1) + ") " + options.get(i).text);
                    }
                } else {
                    System.out.println("Diesen Joker haben Sie schon benutzt!");
                }
                break;

            case 2:
                if (jokerVerfuegbar[1]) {
                    jokerVerfuegbar[1] = false;
                    int correctIndex = -1;
                    for (int i = 0; i < options.size(); i++) {
                        if (options.get(i).isCorrect) {
                            correctIndex = i;
                            break;
                        }
                    }
                    int publikumIndex;
                    int chance = random.nextInt(100);
                    if (chance < 70) {
                        publikumIndex = correctIndex;
                    } else {
                        publikumIndex = findeZufaelligenFalschenIndex(options, correctIndex);
                    }
                    System.out.println("\n-----------------------------------------------------");
                    System.out.println("Das Publikum tippt auf Antwort " + (publikumIndex + 1) + ".");
                    System.out.println("Frage " + (questionIndex + 1) + ": " + fragetext);
                    for (int i = 0; i < options.size(); i++) {
                        System.out.println((i + 1) + ") " + options.get(i).text);
                    }
                } else {
                    System.out.println("Diesen Joker haben Sie schon benutzt!");
                }
                break;

            case 3:
                if (jokerVerfuegbar[2]) {
                    jokerVerfuegbar[2] = false;

                    int correctIndex = -1;
                    for (int i = 0; i < options.size(); i++) {
                        if (options.get(i).isCorrect) {
                            correctIndex = i;
                            break;
                        }
                    }
                    int telefonIndex;
                    int zufall = random.nextInt(100);
                    if (zufall < 70) {
                        telefonIndex = correctIndex;
                    } else {
                        telefonIndex = findeZufaelligenFalschenIndex(options, correctIndex);
                    }

                    System.out.println("\n-----------------------------------------------------");
                    System.out.println("Der Telefonjoker meint: 'Ich glaube, es ist " + (telefonIndex + 1) + ".'");
                    System.out.println("Frage " + (questionIndex + 1) + ": " + fragetext);
                    for (int i = 0; i < options.size(); i++) {
                        System.out.println((i + 1) + ") " + options.get(i).text);
                    }
                } else {
                    System.out.println("Diesen Joker haben Sie schon benutzt!");
                }
                break;


            case 4:
                if (jokerVerfuegbar[3]) {
                    geheimjokerAktiv = true;
                    jokerVerfuegbar[3] = false;
                    System.out.println("\n-----------------------------------------------------");
                    System.out.println("Geheimjoker aktiviert! Eine falsche Antwort wird einmal verziehen.");
                    System.out.println("Frage " + (questionIndex + 1) + ": " + fragetext);
                    for (int i = 0; i < options.size(); i++) {
                        System.out.println((i + 1) + ") " + options.get(i).text);
                    }
                } else {
                    System.out.println("Diesen Joker haben Sie schon benutzt!");
                }
                break;

            default:
                System.out.println("Ungueltige Joker-Wahl. Bitte nochmal versuchen.");
                break;
        }
    }

    static int findeZufaelligenFalschenIndex(List<AnswerOption> options, int correctIndex) {
        List<Integer> falsche = new ArrayList<>();
        for (int i = 0; i < options.size(); i++) {
            if (i != correctIndex) {
                falsche.add(i);
            }
        }
        return falsche.get(random.nextInt(falsche.size()));
    }

    static void removeTwoWrongAnswers(List<AnswerOption> options) {
        List<Integer> wrongIndexes = new ArrayList<>();
        for (int i = 0; i < options.size(); i++) {
            if (!options.get(i).isCorrect) {
                wrongIndexes.add(i);
            }
        }
        if (wrongIndexes.size() > 2) {
            Collections.shuffle(wrongIndexes);
            int remove1 = wrongIndexes.get(0);
            int remove2 = wrongIndexes.get(1);
            int maxIndex = Math.max(remove1, remove2);
            int minIndex = Math.min(remove1, remove2);
            options.remove(maxIndex);
            options.remove(minIndex);
        } else if (wrongIndexes.size() == 2) {
            Collections.sort(wrongIndexes);
            options.remove(wrongIndexes.get(1).intValue());
            options.remove(wrongIndexes.get(0).intValue());
        }
    }
}

import java.util.Random;
import java.util.Scanner;

public class SchereSteinPapier {
    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);

        //kleine Introduction

        System.out.println("Willkommen zum weltbekannten Schere, Stein, Papier- Spiel! Wie ist dein Name?");
        System.out.print("Mein Name ist: ");
        String name = scanner.nextLine();
        System.out.println("Alles klar, bist du bereit, " + name + "?");
        System.out.println("Wähle bitte aus folgenden 3 Optionen und gebe deine Auswahl ein");
        System.out.println("Schere, Stein, Papier");

        //computer entscheidet sich
        String[] auswahl = new String []{"Schere", "Stein", "Papier"};
        String computerInput = auswahl[new Random().nextInt(auswahl.length)];
        String spielerInput;




        //Abfrage ob der Spieler auch richtiges eingibt

        while (true){
            spielerInput = scanner.nextLine();
            if (spielerInput.equals("Schere") || spielerInput.equals("Papier") || spielerInput.equals("Stein")) {
                break;
            }
            System.out.println(spielerInput + "ist keine mögliche Option! Versuche es erneut.");
        }



        //einzelne Fallunterscheidungen

        if (spielerInput.equals("Schere")){
            if (computerInput.equals("Schere")){
                System.out.println("Unentschieden! Ihr habt beide Schere genommen!");
            }
            else if (computerInput.equals("Stein")){
                System.out.println("Leider verloren! Der PC hat Stein gewählt und schlägt damit Schere! Versuche es gerne nochmal.");
            }
            else if(computerInput.equals("Papier")){
                System.out.println("Du hast gewonnen! Der PC entschied sich für Papier und du schneidest Papier!");
            }
        }
        else if (spielerInput.equals("Papier")){
            if (computerInput.equals("Schere")){
                System.out.println("Leider verloren! Du wurdest mit Schere geschlagen!");
            }
            else if (computerInput.equals("Stein")){
                System.out.println("Du hast gewonnen! Papier wickelt sich um Stein!");
            }
            else if(computerInput.equals("Papier")){
                System.out.println("Unentschieden! Ihr habt beide Papier gewählt!");
            }
        }
        else if (spielerInput.equals("Stein")){
            if (computerInput.equals("Schere")){
                System.out.println("Du hast gewonnen! Stein zerschlägt die Schere!");
            }
            else if (computerInput.equals("Stein")){
                System.out.println("Unentschieden! Ihr habt beide Stein ausgesucht!");
            }
            else if(computerInput.equals("Papier")){
                System.out.println("Leider verloren! Der Computer entschied sich für Papier...");
            }
        }
    }
}

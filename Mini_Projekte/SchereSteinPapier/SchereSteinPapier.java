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

        if (spielerInput.equals(computerInput)){
            System.out.println("Unentschieden!");
        }
        else if (spielerInput.equals("Schere")){
            if (computerInput.equals("Papier")){
                System.out.println("Du hast gewonnen!");
            }
            else {
                System.out.println("Du hast verloren!");
            }
        }
        else if (spielerInput.equals("Papier")){
            if (computerInput.equals("Schere")){
                System.out.println("Du hast gewonnen!");
            }
            else {
                System.out.println("Du hast verloren!");
            }
        }
        else {
            if (computerInput.equals("Schere")){
                System.out.println("Du hast gewonnen!");
            }
            else {
                System.out.println("Du hast verloren!");
            }
        }
    }
}
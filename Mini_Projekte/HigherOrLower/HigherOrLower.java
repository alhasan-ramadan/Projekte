import java.util.Scanner;

public class HigherOrLower {
    public static void main (String[] args){

        //Spieler prompten und Regeln erklären
        System.out.println("Willkommen zum Higher or Lower Spiel!");
        System.out.println("Du musst nun versuchen, die Zahl zwischen 0-100 zu erraten, die dein PC sich ausgesucht hat.");
        System.out.println("Wenn du richtig rätst, gewinnst du. Liegst du daneben, gibt der PC dir einen Tipp: >>Höher, oder niedriger<<");

        //Vordefinition
        Integer a;
        Integer b = (int)Math.round(Math.random() * 100);
        Scanner scanner = new Scanner (System.in);

        //Tatsächliches Spiel
        while (true) { 
            a = scanner.nextInt();
            if (a.equals(b)){
                break;
            }
            else if(a < b){
                System.out.println("Höher!");
            }
            else{
                System.out.println("Tiefer!");
            }
        }
        
        System.out.println("Du hast gewonnen! Die Zahl war tatsächlich " + b + "!");
    }
}


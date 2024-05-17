import java.text.NumberFormat;
import java.util.Scanner;

public class HypothekRechner {
    public static void main(String[] args){
        //Abfrage der Daten
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dein gewünschtes Darlehen: ");
        long pricipal = scanner.nextLong();
        System.out.print("Der Prozentsatz: ");
        int percent = scanner.nextInt();
        System.out.print("Die Dauer der Rückzahlung in Jahren: ");
        int years = scanner.nextInt();

        //Festlegung der einzelnen Rechenergebnissen
        float r = ((float)percent / 100) / 12; //wir teilen durch 100, da wir Prozent haben und dann noch durch 12 wegen Monatsanzahl
        int months = years * 12;
        float x = 1+r;
        double y = (Math.round((Math.pow(x, (float)months))*10000))/(double)10000;
        double monatszahlung = (Math.round(((double)(pricipal*((r*y)/(y-1))))*100))/(double)100;
        NumberFormat währung = NumberFormat.getCurrencyInstance();
        String ergebnis = währung.format(monatszahlung);


        //zum Test
        /*System.out.println(r);
        System.out.println(monatetest);
        System.out.println(months);
        System.out.println(x);
        System.out.println(y); */

        //Ergebnis
        System.out.println("Deine monatliche Rückzahlung beträgt: " + ergebnis);
    }
}
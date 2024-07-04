import java.util.ArrayList;
import java.util.Arrays;

public class Arraylist {
    public static void main(String[] args) {
        System.out.println(ersterAufDerListe());

    }

    public static int rechneAus(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("Du musst Argumente mitgeben");
        } else {
            int er = 7;
            int zr = 3;
            int r = zr + er;
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = a + b;
            return c;
        }
    }

    public static String ersterAufDerListe() {
        ArrayList<String> spielerListe = new ArrayList<>(Arrays.asList("Jakob", "Jonas", "Josef"));
        spielerListe.add(0, "Hallo");
        for (int i = 0; i < spielerListe.size(); i++) {
                System.out.println(spielerListe.get(i));
        }
        return spielerListe.get(0);
    }
}
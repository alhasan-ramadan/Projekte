public class PrimZähler {
    public static void main(String[] args) {
        int[] mem = new int[100];
        System.out.println("Die Primzahlen von 1 bis " + mem.length + " sind:");
        prim(mem);
    }
    public static int[] prim(int[] liste){
        for(int x=0; x<liste.length; x++){
            liste[x] = 1;
        }
        for(int i=2; i <= 10; i++){
            for(int j = 2; j <= 50; j++){
                int sum = j*i;
                if((sum <= 99) && (liste[sum]==1)){
                liste[sum] = 0;
                }
            }
        }
        for (int i = 0; i < 100; i++) {
            if(liste[i] == 1){
                System.out.print(i + ", ");
            }
        }
        return liste;
    }
}
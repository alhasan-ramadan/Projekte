package Mini_Projekte.TikTakToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] grid = { { " ", "|", " ", "|", " " },
                { "-", "+", "-", "+", "-" },
                { " ", "|", " ", "|", " " },
                { "-", "+", "-", "+", "-" },
                { " ", "|", " ", "|", " " }, };

        printGrid(grid);
        while (true) {
            spielerZug(grid, scanner);
            if (isWinner(grid)) {
                break;
            }
            cpuZug(grid);
            if (isWinner(grid)) {
                break;
            }
            printGrid(grid);
        }
    }

    private static boolean isWinner(String[][] grid) {
        if (kombi(grid, "X")) {
            System.out.println("Du hast gewonnen!");
            printGrid(grid);
            return true;
        }
        if (kombi(grid, "O")) {
            System.out.println("Der Computer hat gewonnen! Versuche es erneut!");
            printGrid(grid);
            return true;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == " ") {
                    return false;
                }
            }
        }
        printGrid(grid);
        System.out.println("Unentschieden! Alle Felder sind voll!");
        return false;
    }

    private static boolean kombi(String[][] grid, String symbol) {
        boolean b = (((grid[0][0] == symbol) && (grid[0][2] == symbol) && (grid[0][4] == symbol)) ||
                ((grid[2][0] == symbol) && (grid[2][2] == symbol) && (grid[2][4] == symbol)) ||
                ((grid[4][0] == symbol) && (grid[4][2] == symbol) && (grid[4][4] == symbol))) ||

                (((grid[0][0] == symbol) && (grid[2][0] == symbol) && (grid[4][0] == symbol)) ||
                        ((grid[0][2] == symbol) && (grid[2][2] == symbol) && (grid[4][2] == symbol)) ||
                        ((grid[0][4] == symbol) && (grid[2][4] == symbol) && (grid[4][4] == symbol)))
                ||

                ((grid[0][0] == symbol) && (grid[2][2] == symbol) && (grid[4][4] == symbol)) ||
                ((grid[4][0] == symbol) && (grid[2][2] == symbol) && (grid[0][4] == symbol));
        return b;
    }

    private static void cpuZug(String[][] grid) {
        Random rand = new Random();
        int pcAuswahl;
        while (true) {
            pcAuswahl = rand.nextInt(9) + 1;
            if (abfrage(grid, pcAuswahl)) {
                break;
            }
        }
        platziereZug(grid, pcAuswahl, "O");
    }

    public static void printGrid(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void spielerZug(String[][] grid, Scanner scanner) {
        int antwort;
        while (true) {
            System.out.print("Wähle ein unbelegtes Feld von 1-9: ");
            antwort = scanner.nextInt();
            if (abfrage(grid, antwort)) {
                break;
            } else {
                System.out.println(antwort + " ist keine mögliche Antwort!");
            }
        }
        platziereZug(grid, antwort, "X");
    }

    private static void platziereZug(String[][] grid, int position, String symbol) {
        switch (position) {
            case 1:
                grid[0][0] = symbol;
                break;
            case 2:
                grid[0][2] = symbol;
                break;
            case 3:
                grid[0][4] = symbol;
                break;
            case 4:
                grid[2][0] = symbol;
                break;
            case 5:
                grid[2][2] = symbol;
                break;
            case 6:
                grid[2][4] = symbol;
                break;
            case 7:
                grid[4][0] = symbol;
                break;
            case 8:
                grid[4][2] = symbol;
                break;
            case 9:
                grid[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static boolean abfrage(String[][] grid, int position) {
        switch (position) {
            case 1:
                return (grid[0][0] == " ");

            case 2:
                return (grid[0][2] == " ");

            case 3:
                return (grid[0][4] == " ");

            case 4:
                return (grid[2][0] == " ");

            case 5:
                return (grid[2][2] == " ");

            case 6:
                return (grid[2][4] == " ");

            case 7:
                return (grid[4][0] == " ");

            case 8:
                return (grid[4][2] == " ");

            case 9:
                return (grid[4][4] == " ");

            default:
                return false;
        }
    }

}
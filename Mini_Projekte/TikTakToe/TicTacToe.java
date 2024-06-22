package Mini_Projekte.TikTakToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        String[][] grid = { { " ", "|", " ", "|", " " },
                { "-", "+", "-", "+", "-" },
                { " ", "|", " ", "|", " " },
                { "-", "+", "-", "+", "-" },
                { " ", "|", " ", "|", " " }, };
        while (true) {
            abfrage(grid);
            if (abfrage(grid) == true) {
                printGrid(grid);
                spielerZug(grid);
            }
        }

    }

    public static void printGrid(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void spielerZug(String[][] grid) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wähle ein unbelegtes Feld von 1-9: ");
        int antwort = scanner.nextInt();
        switch (antwort) {
            case 1:
                if (grid[0][0].equals(" ")) {
                    grid[0][0] = "X";
                    break;
                }
            case 2:
                if (grid[0][2].equals(" ")) {
                    grid[0][2] = "X";
                    break;
                }
            case 3:
                if (grid[0][4].equals(" ")) {
                    grid[0][4] = "X";
                    break;
                }
            case 4:
                if (grid[2][0].equals(" ")) {
                    grid[2][0] = "X";
                    break;
                }
            case 5:
                if (grid[2][2].equals(" ")) {
                    grid[2][2] = "X";
                    break;
                }
            case 6:
                if (grid[2][4].equals(" ")) {
                    grid[2][4] = "X";
                    break;
                }
            case 7:
                if (grid[4][0].equals(" ")) {
                    grid[4][0] = "X";
                    break;
                }
            case 8:
                if (grid[4][2].equals(" ")) {
                    grid[4][2] = "X";
                    break;
                }
            case 9:
                if (grid[4][4].equals(" ")) {
                    grid[4][4] = "X";
                    break;
                }
            default:
                break;
        }
    }

    public static boolean abfrage(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].equals(" ")) {
                    return true;
                }
            }
        }
        return false;
    }

}
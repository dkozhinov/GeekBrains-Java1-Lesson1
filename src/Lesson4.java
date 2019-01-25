/**
 * Java. Level 1. Lesson 4. Homework.
 * @author Dmitry Kozhinov
 * @version dated Jan 25, 2019
 */

import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    final int SIZE = 5;             // Размер Игрового поля SIZExSIZE
    final int SIZE_LINE_WIN = 4;    // Размер выйгрышной линии
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY = '.';
    char[][] map;
    int lastX, lastY;               // Для запоминания последнего хода
    Random random;
    Scanner scanner;

    public static void main(String[] args) {
        new Lesson4().game();
    }


    void game() {
        initMap();
        random = new Random();
        scanner = new Scanner(System.in);

        while (true) {

            humanTurn();
            if (checkWinNew(DOT_X)) {
                System.out.println("YOU WON!");
                break;
            }

            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }

            aiTurn();
            printMap();
            if (checkWinNew(DOT_O)) {
                System.out.println("AI WON!");
                break;
            }

            if (isMapFull()) {
                System.out.println("Sorry, DRAW!");
                break;
            }
        }
        printMap();
        System.out.println("GAME OVER");

    }


    void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                map[i][j] = DOT_EMPTY;
    }

    void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }

    void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter X and Y (1.." + SIZE + "):");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
        lastX = x;
        lastY = y;
    }

    void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
        lastX = x;
        lastY = y;
    }

    // 3. * Попробовать переписать логику проверки победы, чтобы она работала
    // для поля 5х5 и количества фишек 4. Очень желательно не делать это просто
    // набором условий для каждой из возможных ситуаций;
    boolean checkWinNew(char dt) {
        int checkHorizontalCounter, checkVerticalCounter;
        int checkMainDiagonalCounter, checkSideDiagonalCounter;

        checkMainDiagonalCounter   = 0;
        checkSideDiagonalCounter   = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == dt)         { checkMainDiagonalCounter++; }
            if (map[SIZE-i-1][i] == dt)  { checkSideDiagonalCounter++; }
            if (checkMainDiagonalCounter == SIZE_LINE_WIN || checkSideDiagonalCounter == SIZE_LINE_WIN) return true;

            checkHorizontalCounter = 0;
            checkVerticalCounter   = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == dt)     { checkHorizontalCounter++; }
                if (map[i][j] == dt)     { checkVerticalCounter++; }

                if (checkHorizontalCounter == SIZE_LINE_WIN || checkVerticalCounter == SIZE_LINE_WIN)   return true;
            }

        }


        return false;
    }

    // 2. Переделать проверку победы, чтобы она не была реализована
    // просто набором условий, например, с использованием циклов.
    boolean checkWin(char dt) {
        boolean checkHorizontal;
        boolean checkVertical;
        boolean checkMainDiagonal, checkSideDiagonal;

        checkMainDiagonal = true;
        checkSideDiagonal = true;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] != dt)         { checkMainDiagonal = false; }
            if (map[SIZE-i-1][i] != dt)  { checkSideDiagonal = false; }

            checkHorizontal = true;
            checkVertical = true;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] != dt)     { checkHorizontal   = false; }
                if (map[i][j] != dt)     { checkVertical     = false; }
            }
            if (checkHorizontal || checkVertical)   return true;

        }
        if (checkMainDiagonal || checkSideDiagonal) return true;


        return false;
    }

    boolean isMapFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == DOT_EMPTY)
                    return false;
        return true;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        return map[y][x] == DOT_EMPTY;
    }


}

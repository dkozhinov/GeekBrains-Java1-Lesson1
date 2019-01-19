/**
 * Java. Level 1. Lesson 3. Homework.
 * @author Dmitry Kozhinov
 * @version dated Jan 19, 2019
 */

import java.util.Scanner;
import java.util.Random;

public class Lesson3 {

    public static void main (String[] args) {
        doMethod1(3);
    }

    // 1 Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3
    //попытки угадать это число. При каждой попытке компьютер должен сообщить больше ли
    //указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
    //выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    static void doMethod1 (int count) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int x = random.nextInt(10);
        boolean myReazult = false;

        System.out.println("\nУгадайте загаданное число от 0 до 9. Вам дается " + count + " попытки.");

        for (int i=1; i<=count; i++) {
            System.out.println("Введите число: ");
            if ( x == scanner.nextInt()) {
                myReazult = true;
                break;
            }
            else {
                if (i != count) {
                    System.out.println("Попробуй еще раз. Осталось попыток= " + (count - i));
                }
            }
        }

        if (myReazult) {
            System.out.println("Поздравляю, Вы угадали!");
        }
        else {
            System.out.println("К сожалению, Вы не угадали!");
        }

    }

}

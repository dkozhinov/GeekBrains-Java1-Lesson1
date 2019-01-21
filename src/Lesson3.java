/**
 * Java. Level 1. Lesson 3. Homework.
 * @author Dmitry Kozhinov
 * @version dated Jan 19, 2019
 */

import java.util.Scanner;
import java.util.Random;

public class Lesson3 {

    public static void main (String[] args) {
        //doMethod1(3);
        doMethod2();
    }


    // 1 Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3
    // попытки угадать это число. При каждой попытке компьютер должен сообщить больше ли
    // указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
    // выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    static void doMethod1 (int count) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int x = random.nextInt(10);
        boolean myReazult = false;
        int y;
        System.out.println("\nУгадайте загаданное число от 0 до 9. Вам дается " + count + " попытки.");

        for (int i=1; i<=count; i++) {
            System.out.println("Введите число: ");
            y = scanner.nextInt();

            if ( x == y) {
                myReazult = true;
                break;
            }
            else {
                if (x > y) {
                    System.out.print("Загаданное число больше Вашего! ");
                }
                else {
                    System.out.print("Загаданное число меньше Вашего! ");
                }
                if (i != count) {
                     System.out.println("Попробуй еще раз. Осталось попыток= " + (count - i));
                }
            }
        }

        if (myReazult) {
            System.out.println("Поздравляю, Вы угадали - это число " + x + "!");
        }
        else {
            System.out.println("К сожалению, Вы не угадали - это число " + x + "!");
        }

    }


    // 2 * Создать массив из слов
    // String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
    // "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
    // "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    // При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    // сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если
    // слово не угадано, компьютер показывает буквы которые стоят на своих местах.
    // apple – загаданное
    // apricot - ответ игрока
    // ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    // Для сравнения двух слов посимвольно, можно пользоваться:
    // String str = "apple";
    // str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    // Играем до тех пор, пока игрок не отгадает слово
    // Используем только маленькие буквы
    static void doMethod2() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                          "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
                          "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        char[] userOutputString = new char[15];

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String userInputString, word;
        int userInputStringLength, wordLength;
        int index, counter;
        boolean flagMatchWords = false;

        // Выберем слово из массива случайным образом
        index = random.nextInt(25);
        word =words[index];
        wordLength = word.length();

        do {
            System.out.println("Введите слово:");
            userInputString = scanner.nextLine();
            userInputStringLength= userInputString.length();

            // Инициализация масива символов (я по-другому пока не знаю)
            for (int i=0; i<15; i++) {
                userOutputString[i] = '#';
            }

            // Сравниваем посимвольно слова: введенное пользователем и выбранное случайным образом
            counter=0;
            for (int i=0; i < userInputStringLength; i++) {
                if (word.charAt(i) == userInputString.charAt(i)) {
                    userOutputString[i]=word.charAt(i);
                    counter++;
                }
                else {
                    break;
                }
            }

            // Проверяем результат сравнения
            if (counter == wordLength) {
                flagMatchWords = true;
                System.out.println("Вы угадали слово - это " + word + ". Поздравляем!");
            }
            else {
                System.out.println(userOutputString);
            }


        } while ( !flagMatchWords );
    }

}

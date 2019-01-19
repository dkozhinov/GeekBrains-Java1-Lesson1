/**
 * Java. Level 1. Lesson 1. Homework.
 * @author Dmitry Kozhinov
 * @version dated Jan 15, 2019
 */

public class Lesson1 {

    // Урок 1 курса Java Уровень 1

    public static void main(String[] args) {
        System.out.println("myMethod3=" + myMethod3(1,2,3,4));
        System.out.println("myMethod4=" + myMethod4(1,10));
        myMethod5(-2);
        System.out.println("myMethod6=" + myMethod6(1));
        myMethod7("Дмитрий");
        myMethod8(2020);
        myMethod8(1900);
    }

    //2. Создать переменные всех пройденных типов данных, и инициализировать их значения
    byte myByte=127;
    short myShort=32767;
    int myInt=2147483647;
    long myLong=9223372036854775807L;
    float myFloat = 120.0f;
    double myDouble = 15.72775;
    boolean myBoolean = true;
    char myChar = 'A';


    //3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    //где a, b, c, d – входные параметры этого метода
    private static float myMethod3 (int a,int b,int c,int d){

        return (float)a * ((float)b + ((float)c / (float)d));
    }

    //4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в
    //пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false
    private static boolean myMethod4 (int a,int b){
        int mySum = a+b;
        return (mySum >= 10 && mySum <=20);
     }

    //5. Написать метод, которому в качестве параметра передается целое число, метод должен
    //напечатать в консоль положительное ли число передали, или отрицательное; Замечание:
    //ноль считаем положительным числом.
    private static void myMethod5 (int a){
        if (a >= 0)
            System.out.println("myMethod5 Число " +a + " положительное.");
        else
            System.out.println("myMethod5 Число " +a + " отрицательное.");
    }

    //6. Написать метод, которому в качестве параметра передается целое число, метод должен
    //вернуть true, если число отрицательное
    private static boolean myMethod6 (int a){
        return (a < 0);
    }

    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    //метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    private static void myMethod7 (String myStr){

        System.out.println("myMethod7 Привет, " + myStr + "!");
    }


    //8*. Написать метод, который определяет является ли год високосным, и выводит сообщение в
    //консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й –
    //високосный.
    private static void myMethod8 (int year){
        boolean myLeapYear=false;

        if ( (year % 4 == 0) && ( (year % 100 != 0) || (year % 400 == 0) ) ) myLeapYear=true;

        if (myLeapYear)
            System.out.println("myMethod8* Год " + year + " високосный!");
        else
            System.out.println("myMethod8* Год " + year + " не високосный!");
    }


}

package ru.geekbrains.java1;

public class Lesson1 {

    // Урок 1 курса Java Уровень 1

    public static void main(String[] args) {
        System.out.println("mymethod3=" + mymethod3(1,2,3,4));
        System.out.println("mymethod4=" + mymethod4(1,10));
        mymethod5(-2);
        System.out.println("mymethod6=" + mymethod6(1));
        mymethod7("Дмитрий");
        mymethod8(2020);
    }

    //2. Создать переменные всех пройденных типов данных, и инициализировать их значения
    byte mybyte=127;
    short myshort=32767;
    int myint=2147483647;
    long mylong=9223372036854775807L;
    float myfloat = 120.0f;
    double mydouble = 15.72775;
    boolean myboolean = true;
    char mychar = 'A';


    //3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    //где a, b, c, d – входные параметры этого метода
    private static float mymethod3 (int a,int b,int c,int d){
        return (float)a * ((float)b + ((float)c / (float)d));
    }

    //4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в
    //пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false
    private static boolean mymethod4 (int a,int b){
        int mysum = a+b;
        if (mysum >= 10 && mysum <=20)
            return true;
        else
            return false;
    }

    //5. Написать метод, которому в качестве параметра передается целое число, метод должен
    //напечатать в консоль положительное ли число передали, или отрицательное; Замечание:
    //ноль считаем положительным числом.
    private static void mymethod5 (int a){
        if (a >= 0)
            System.out.println("mymethod5 Число " +a + " положительное.");
        else
            System.out.println("mymethod5 Число " +a + " отрицательное.");
    }

    //6. Написать метод, которому в качестве параметра передается целое число, метод должен
    //вернуть true, если число отрицательное
    private static boolean mymethod6 (int a){
        if (a < 0)
            return true;
        else
            return false;
    }

    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    //метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    private static void mymethod7 (String mystr){
        System.out.println("mymethod7 Привет, " + mystr + "!");
    }


    //8*. Написать метод, который определяет является ли год високосным, и выводит сообщение в
    //консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й –
    //високосный.
    private static void mymethod8 (int year){
        boolean myLeapYear=false;

        if ( (year % 4 == 0) && ( (year % 100 != 0) || (year % 400 == 0) ) ) myLeapYear=true;

        if (myLeapYear)
            System.out.println("mymethod8* Год " + year + " високосный!");
        else
            System.out.println("mymethod8* Год " + year + " не високосный!");
    }


}

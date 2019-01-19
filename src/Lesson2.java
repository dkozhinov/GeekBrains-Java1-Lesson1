/**
 * Java. Level 1. Lesson 2. Homework.
 * @author Dmitry Kozhinov
 * @version dated Jan 17, 2019
 */

import java.util.Arrays;

public class Lesson2 {


    public static void main (String[] args){
        doMethod1();
        doMethod2();
        doMethod3();
        doMethod4();
        doMethod5();

        System.out.println("\ndoMethod6");
        int[] myArrayAsParameter1 = {1, 1, 1, 2, 1};
        System.out.println(Arrays.toString(myArrayAsParameter1));
        System.out.println("Balance is " + doMethod6(myArrayAsParameter1));
        int[] myArrayAsParameter2 = {2, 1, 1, 2, 1};
        System.out.println(Arrays.toString(myArrayAsParameter2));
        System.out.println("Balance is " + doMethod6(myArrayAsParameter2));
        int[] myArrayAsParameter3 = {10, 10};
        System.out.println(Arrays.toString(myArrayAsParameter3));
        System.out.println("Balance is " + doMethod6(myArrayAsParameter3));


        System.out.println("\ndoMethod7");
        int[] myArrayAsParameter4 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(myArrayAsParameter4)+ " is original array");
        int n=1;
        System.out.println(Arrays.toString(doMethod7(myArrayAsParameter4,n))+ " shift by n=" + n);
        n=-2;
        System.out.println(Arrays.toString(doMethod7(myArrayAsParameter4,n))+ " shift by n=" + n);
        n=2;
        System.out.println(Arrays.toString(doMethod7(myArrayAsParameter4,n))+ " shift by n=" + n);
        n=7;
        System.out.println(Arrays.toString(doMethod7(myArrayAsParameter4,n))+ " shift by n=" + n);

        System.out.println("\ndoMethod7S");
        System.out.println(Arrays.toString(myArrayAsParameter4)+ " is original array");
        n=-2;
        System.out.println(Arrays.toString(doMethod7S(myArrayAsParameter4,n))+ " shift by n=" + n);

    }


    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0;
    private static void doMethod1 (){
        int[] myArray = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };

        System.out.println("\ndoMethod1");
        System.out.println(Arrays.toString(myArray));

        for (int i=0; i < myArray.length; i++) {
            if (myArray[i] == 0) {
                myArray[i] = 1;
            } else if (myArray[i] == 1) {
                myArray[i] = 0;
            }
        }
        System.out.println(Arrays.toString(myArray));
    }


    // 2 Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его
    // значениями 0 3 6 9 12 15 18 21;
    private static void doMethod2(){
        int[] myArray = new int[8];
        System.out.println("\ndoMethod2");

        for (int i=0; i< myArray.length; i++)  myArray[i]=i*3;

        System.out.println(Arrays.toString(myArray));
    }

    // 3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
    // умножить на 2;
    private static void doMethod3 (){
        int[] myArray = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        System.out.println("\ndoMethod3");
        System.out.println(Arrays.toString(myArray));

        for (int i=0; i < myArray.length; i++) if (myArray[i] < 6) myArray[i] *= 2;

        System.out.println(Arrays.toString(myArray));
    }

    // 4 Создать квадратный двумерный целочисленный массив (количество строк и столбцов
    // одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    private static void doMethod4(){
        final int SIZE_ARRAY=5;
        int[][] myArray = new int[SIZE_ARRAY][SIZE_ARRAY];
        System.out.println("\ndoMethod4");

        for (int i=0; i< SIZE_ARRAY; i++) {
            for (int j=0; j< SIZE_ARRAY; j++) {
                if ( i==j ) myArray[i][j]= 1;
            }
        }

        System.out.println(Arrays.deepToString(myArray));
    }

    // 5 ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без
    // помощи интернета);
    private static void doMethod5 (){
        int[] myArray = { 1, 5, 3, 2, 11, 4, -5, 2, 4, 8, 9, 1 };
        int minElement, maxElement;

        System.out.println("\ndoMethod5");
        System.out.println(Arrays.toString(myArray));

        minElement = myArray[0];
        maxElement = myArray[0];
        for (int i=0; i < myArray.length; i++) {
            if (myArray[i] < minElement) minElement = myArray[i];
            if (myArray[i] > maxElement) maxElement = myArray[i];
        }
        System.out.println("Min element is " + minElement);
        System.out.println("Max element is " + maxElement);
    }


    // 6** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части
    // массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) →
    // false, checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не
    // входят.
    private static boolean doMethod6 (int[] myArray){
        int myLeftPartArray, myRightPartArray;

        myLeftPartArray  = 0;
        for (int i=0; i < myArray.length; i++) {
            myLeftPartArray += myArray[i];
            myRightPartArray = 0;
            for (int j=myArray.length-1; j>i; j--) {
                myRightPartArray += myArray[j];
            }
            if (myLeftPartArray == myRightPartArray) {
                return true;
            }
        }
        return false;
    }



    // 7 **** Написать метод, которому на вход подаётся одномерный массив и число n (может быть
    // положительным, или отрицательным), при этом метод должен сместить все элементы
    // массива на n позиций.
    private static int[] doMethod7 (int[] myArray, int n) {
        int myArrayLength = myArray.length;
        int myShiftArray= n % myArrayLength;
        int[] myArrayTemp = new int[myArray.length];

        if (myShiftArray < 0)  myShiftArray += myArrayLength;


        for (int i=0, j = myShiftArray; i < myArrayLength; i++, j++) {
            if (j >= myArrayLength)  j=0;
            myArrayTemp[j] = myArray[i];
        }

        return myArrayTemp;
    }


    // 7S **** Написать метод, которому на вход подаётся одномерный массив и число n (может быть
    // положительным, или отрицательным), при этом метод должен сместить все элементы
    // массива на n позиций.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    private static int[] doMethod7S (int[] myArray, int n) {
        int myArrayLength = myArray.length;
        int myShiftArray= n % myArrayLength;
        int prev, temp;

        if (myShiftArray < 0)  myShiftArray += myArrayLength;

        prev = myArray[0];
         for (int i=0, j=myShiftArray; i < myArrayLength; i++) {
            temp = myArray[j];
            myArray[j] = prev;
            j += myShiftArray;
            if (j >= myArrayLength)  j-=myArrayLength;
            prev = temp;
         }

        return myArray;
    }




}

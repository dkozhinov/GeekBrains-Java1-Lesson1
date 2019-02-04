/**
 * Java. Level 1. Lesson 7. Homework.
 * @author Dmitry Kozhinov
 * @version dated Feb 04, 2019
 */

public class Lesson7 {

     public static void main(String[] args) {
         Cat7[] cat =  { new Cat7("Barsik",  5), new Cat7("Murzik",  20), new Cat7("Tom",  10)};
         Plate plate = new Plate(30);


         System.out.println(plate);
         for (Cat7 c: cat) {
             System.out.print(c.getName() + " был " + c.getSatietyString());
             if (c.eat(plate)) {
                System.out.print(". Поел!");
             }
             else {
                 System.out.print(". Не поел!");
             }
             System.out.println(" Стал " + c.getSatietyString());
         }

         System.out.println(plate);


         System.out.println("Добавим еды в тарелку.");
         plate.increaseFood(6);
         System.out.println(plate);

         for (Cat7 c: cat) {
             System.out.print(c.getName() + " был " + c.getSatietyString());
             if (c.eat(plate)) {
                 System.out.print(". Поел!");
             }
             else {
                 System.out.print(". Не поел!");
             }
             System.out.println(" Стал " + c.getSatietyString());
         }

         System.out.println(plate);
    }

}


//  1. Расширить задачу про котов и тарелки с едой.
//  2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
//     (например, в миске 10 еды, а кот пытается покушать 15-20).
//  3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
//     удалось покушать (хватило еды), сытость = true.
//  4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть
//     наполовину сыт ( это сделано для упрощения логики программы ).
//  5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и
//     потом вывести информацию о сытости котов в консоль.
//  6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.


class Cat7 {
    private String name;
    private int appetite;
    private boolean satiety;    // Сытость

    Cat7(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    // Кот ест, только если он голодный
    // Возвращает true если коту удалось поесть
    boolean eat(Plate plate) {
        if (!this.satiety && plate.dicreaseFood(appetite)) {
            this.satiety = true;    // Если кот поел, то он становится сытым
            return true;
        }
        return false;
    }

    public String getName(){
        return this.name;
    }

    public String getSatietyString(){
        return (this.satiety) ? "Сытый" : "Голодный";
    }

}


class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    // Метод, описывающий как едет из тарелки
    // Возвращает true если удалось поесть
    boolean dicreaseFood(int food) {
        if (this.food >= food) {
            this.food -= food;
            return true;
        }
        return false;
    }


    // Метод, описывающий как добавляют еду в тарелку
    void increaseFood(int food) {
        if (food >0) {
            this.food += food;
        }
    }


    @Override
    public String toString() {
        return "Food: " + food;
    }
}

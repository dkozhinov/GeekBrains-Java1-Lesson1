/**
 * Java. Level 1. Lesson 6. Homework.
 * @author Dmitry Kozhinov
 * @version dated Feb 02, 2019
 */



// У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот
// 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.)
// При попытке животного выполнить одно из этих действий, оно должно сообщить результат в
// консоль. (Например, dog1.run(150); -> результат: run: true)
// Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег
// может быть 400 м., у другой 600 м.
public class Lesson6 {

    public static void main(String[] args) {
        Cat cat = new Cat("Кот", "Барсик", 200, 2, 0);
        Dog dog = new Dog("Собака", "Майл", 500, 0.5,10);
        Dog dog2 = new Dog("Собака", "Бобик", 400, 0.5,10);
        Dog dog3 = new Dog("Собака", "Барбос", 600, 0.5,10);

        Animal animal;
        double i;

        i=150;
        animal = cat;
        System.out.println(animal.getType() + " " + animal.getName() + ": Результат бег на " + i + "м. - " + (animal.run(i)? "true" : "false") );

        i=500;
        animal = dog;
        System.out.println(animal.getType() + " " + animal.getName() + ": Результат бег на " + i + "м. - " + (animal.run(i)? "true" : "false") );
        animal = dog2;
        System.out.println(animal.getType() + " " + animal.getName() + ": Результат бег на " + i + "м. - " + (animal.run(i)? "true" : "false") );

        i=550;
        animal = dog;
        System.out.println(animal.getType() + " " + animal.getName() + ": Результат бег на " + i + "м. - " + (animal.run(i)? "true" : "false") );
        animal = dog3;
        System.out.println(animal.getType() + " " + animal.getName() + ": Результат бег на " + i + "м. - " + (animal.run(i)? "true" : "false") );

        i=1;
        animal = cat;
        System.out.println(animal.getType() + " " + animal.getName() + ": Результат плавания на " + i + "м. - " + (animal.swim(i)? "true" : "false") );

    }

}




// Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве
// параметра каждому методу передается величина, означающая или длину препятствия (для
// бега и плавания), или высоту (для прыжков).
class Animal {
    protected String type;                                      // Вид животного (кот, собака, жираф...)
    protected String name;                                      // Имя животного
    protected double sizeRunLimit, sizeJumpLimit, sizeSwimLimit;   // Органичения в подвижности животного

    // конструктор
    Animal(String type, String name, double sizeRunLimit, double sizeJumpLimit, double sizeSwimLimit) {
        this.type = type;
        this.name = name;
        if (sizeRunLimit >= 0) {
            this.sizeRunLimit = sizeRunLimit;
        }
        if (sizeJumpLimit >= 0) {
            this.sizeJumpLimit = sizeJumpLimit;
        }
        if (sizeSwimLimit >= 0) {
            this.sizeSwimLimit = sizeSwimLimit;
        }
    }

    public boolean run(double value) {
        if (value > 0 && value <= sizeRunLimit) {
            return true;
        }
        return false;
    }

    public boolean jump(double value) {
        if (value > 0 && value <= sizeJumpLimit) {
            return true;
        }
        return false;
    }

    public boolean swim(double value) {
        if (value > 0 && value <= sizeSwimLimit) {
            return true;
        }
        return false;
    }

    public String getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }

    public void voice() {
        System.out.println("Звук!");
    }


}


class Cat extends Animal {

    Cat(String type, String name, double sizeRunLimit, double sizeJumpLimit, double sizeSwimLimit) {
        super(type, name, sizeRunLimit, sizeJumpLimit, sizeSwimLimit);
    }

    @Override
    public void voice() {
        System.out.println("Мяу!");
    }

}


class Dog extends Animal {

    Dog(String type, String name, double sizeRunLimit, double sizeJumpLimit, double sizeSwimLimit) {
        super(type, name, sizeRunLimit, sizeJumpLimit, sizeSwimLimit);
    }

    @Override
    public void voice() {
        System.out.println("Гав!");
    }

}



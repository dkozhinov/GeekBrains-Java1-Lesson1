/**
 * Java. Level 1. Lesson 6. Homework.
 * @author Dmitry Kozhinov
 * @version dated Feb 02, 2019
 */



// У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот
// 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
public class Lesson6 {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Кот", "Нора", 200, 2, 0);
    }

}




// Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве
// параметра каждому методу передается величина, означающая или длину препятствия (для
// бега и плавания), или высоту (для прыжков).
class Animal {
    protected String type;                                      // Вид животного (кот, собака, жираф...)
    protected String name;                                      // Имя животного
    protected int sizeRunLimit, sizeJumpLimit, sizeSwimLimit;   // Органичения в подвижности животного

    // конструктор
    Animal(String type, String name, int sizeRunLimit, int sizeJumpLimit, int sizeSwimLimit) {
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

    public boolean run(int value) {
        if (value >= 0 && value < sizeRunLimit) {
            return true;
        }
        return false;
    }

    public boolean jump(int value) {
        if (value >= 0 && value < sizeJumpLimit) {
            return true;
        }
        return false;
    }

    public boolean swim(int value) {
        if (value >= 0 && value < sizeSwimLimit) {
            return true;
        }
        return false;
    }



    public void voice() {
        System.out.println("Звук!");
    }


}


class Cat extends Animal {

    Cat(String type, String name, int sizeRunLimit, int sizeJumpLimit, int sizeSwimLimit) {
        super(type, name, sizeRunLimit, sizeJumpLimit, sizeSwimLimit);
    }

    @Override
    public void voice() {
        System.out.println("Мяу!");
    }

}


class Dog extends Animal {

    Dog(String type, String name, int sizeRunLimit, int sizeJumpLimit, int sizeSwimLimit) {
        super(type, name, sizeRunLimit, sizeJumpLimit, sizeSwimLimit);
    }

    @Override
    public void voice() {
        System.out.println("Гав!");
    }

}



/**
 * Java. Level 1. Lesson 7. Example of homework
 *
 * @author Sergey Iryupin
 * @version dated Oct 20, 2017
 */
class HW7Lesson {

    public static void main(String[] args) {
        CatHW7[] cats = {
                new CatHW7("Barsik", 15), new CatHW7("Murzik", 10), new CatHW7("Vasily", 20)
        };
        PlateHW7 plate = new PlateHW7(50, 30);
        System.out.println(plate);

        // feeding cats first time
        for (CatHW7 cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }

        // adding food in the plate
        System.out.println(plate);
        plate.add(40);
        System.out.println(plate);

        // feeding cats second time
        for (CatHW7 cat : cats) {
            cat.setFullness(false);
            cat.eat(plate);
            System.out.println(cat);
        }
        System.out.println(plate);
    }
}

class CatHW7 {
    protected String name;
    protected int appetite; // ability to eat for 1 time
    protected boolean fullness; // satiety status

    CatHW7(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        fullness = false;
    }

    void setFullness(boolean status) {
        fullness = status;
    }

    void eat(PlateHW7 plate) {
        if (!fullness)
            fullness = plate.decreaseFood(appetite);
    }

    @Override
    public String toString() {
        return "{name=" + name + ", appetite=" +
                appetite + ", fullness=" + fullness + "}";
    }
}

class PlateHW7 {
    protected int volume;
    protected int food;

    PlateHW7(int volume, int food) {
        this.volume = volume;
        this.food = food;
    }

    boolean decreaseFood(int portion) {
        if (food < portion) return false;
        food -= portion;
        return true;
    }

    void add(int food) {
        if (this.food + food <= volume)
            this.food += food;
    }

    @Override
    public String toString() {
        return "plate: " + food;
    }
}

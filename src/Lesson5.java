/**
 * Java. Level 1. Lesson 5. Homework.
 * @author Dmitry Kozhinov
 * @version dated Jan 27, 2019
 */

/**
 * Создать массив из 5 сотрудников:
 * Пример:
 * Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 * persArray[0] = new Person("Ivanov Ivan", "Engineer", " ivivan@mailbox.com ", "892312312", 30000,
 * 30); // потом для каждой ячейки массива задаем объект
 * persArray[1] = new Person(...);
 * ...
 * persArray[4] = new Person(...);
 * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 */



public class Lesson5 {

    public static void main (String[] args) {
        Person[] personArray = new Person[5];
        personArray[0] = new Person("Ivanov Maxim", "Actor", "m.ivanov@mail.ru", "1239888", 200000, 34);
        personArray[1] = new Person("Petrov Ivan", "Taxi Driver", "i.petrov@mail.ru", "1237766", 80000, 54);
        personArray[2] = new Person("Gregory House", "Doctor of medicine", "g.house@mail.ru", "1237700", 800000, 49);
        personArray[3] = new Person("Kozhinov Dmitry", "Engineer", "d.kozhinov@mail.ru", "1234567", 100000, 44);
        personArray[4] = new Person("Bill Green", "Ticher", "b.green@mail.ru", "1230066", 70000, 24);

        for (int i=0; i<5; i++) {
            if (personArray[i].getAge() >40) {
                System.out.println(personArray[i].getPerson());
            }
        }

        personArray[4].setAge(41);
        System.out.println(personArray[4]);

    }
}

/**
 * Java. Level 1. Lesson 5. Homework.
 * @author Dmitry Kozhinov
 * @version dated Jan 27, 2019
 */

/**
 *  Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
 *  Конструктор класса должен заполнять эти поля при создании объекта;
 *  Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
 *  Создать массив из 5 сотрудников.
 */


public class Person {

    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    // Конструктор класса Person
    public Person (String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        if (salary > 0) {
            this.salary = salary;
        }
        if (age > 0) {
            this.age = age;
        }
    }

    // Get-методы для полей (геттеры)
    public String getPerson() {
        return "Person: " + name + ", " + position + ", " +  email + ", Phone: " +  phone + ", Salary: " +  salary + ", Age: " +  age;
    }

    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.position;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public int getSalary() {
        return this.salary;
    }

    public int getAge() {
        return this.age;
    }


    // Set-методы для полей (сеттеры)
    public void setName(String field) {
        this.name=field;
    }

    public void setPosition(String field) {
        this.position=field;
    }

    public void setEmail(String field) {
        this.email=field;
    }

    public void setPhone(String field) {
        this.phone=field;
    }

    public void setSalary(int field) {
        if (field>0) {
            this.salary = field;
        }
    }

    public void setAge(int field) {
        if (field>0) {
            this.age = field;
        }
    }




    @Override
    public String toString() {
        return name + ", " + position + ", " +  email + ", " +  phone + ", " +  salary + ", " +  age;
    }
}

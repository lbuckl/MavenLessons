package Lesson6_OOP;

//Супер класс
abstract class Animals {
    String name;

    private int id;
    private static int counter = 1;

    {
        id = counter++;
    }

    public Animals(String name) {
        this.name = name;
    }

    protected int AnimalCount(){
        return id;
    }
}

//Класс наследник
class Dog extends Animals{

    final int runLimit = 500;
    final int swimLimit = 10;

    //Обязательный конструктор
    public Dog(String name){
        super(name);
    }

    //Так собака бежит
    public void run(int distance) {

        if (distance <= runLimit) System.out.println(name + " пробежал " + distance + " метров ");
        else System.out.println(name + " пробежал " + runLimit + " метров и выдохся. Кажется, ему нужен отдых");
    }

    //Так собака плавает
    public void swim(int distance) {

        if (distance <= swimLimit) System.out.println(name + " проплыл " + distance + " метров и выбрался на берег");
        else System.out.println(name + " проплыл " + swimLimit + " метров и выдохся. Кажется, ему нужен отдых");
    }


}

//Класс наследник
class Cat extends Animals{

    final int runLimit = 200;

    //Обязательный конструктор
    public Cat(String name){
        super(name);
    }

    //Так котик бежит
    public void run(int distance) {

        if (distance <= runLimit) System.out.println(name + " пробежал " + distance + " метров ");
        else System.out.println(name + " пробежал " + runLimit + " метров и выдохся. Кажется, ему нужен отдых");
    }

    //Так котик плавает
    public void swim(int distance) {
        System.out.println("Да какие " + distance + " метров? " + name + " и плавать то не умеет");
    }

}


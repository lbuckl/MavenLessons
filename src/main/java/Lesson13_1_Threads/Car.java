package Lesson13_1_Threads;

public class Car{
    String name;
    int speed;

    public Car(int num, int speed){
        this.name = "Авто №" + num;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}

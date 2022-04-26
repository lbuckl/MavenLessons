package Lesson8_OOP;

import java.util.Random;

interface Person {
    boolean Jump(double distance);
    boolean Run(double distance);
    String getName();
}

class Human implements Person{
    Random random = new Random();

    String name;
    double maxJump = random.nextDouble(1,2);
    double maxRun = random.nextInt(400,700);

    protected Human(String name){
        this.name = "Человек " + name;
    }

    @Override
    public boolean Jump(double distance) {
        if (distance > maxJump) {
            System.out.printf("%s не смог перебраться через стену в %.1f м\n",name, distance);
            return false;
        }
        else return true;
    }

    @Override
    public boolean Run(double distance) {
        if (distance > maxRun) {
            System.out.printf("%s не смог пробежать %.1f м\n",name, distance);
            return false;
        }
        else return true;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Cat implements Person{
    Random random = new Random();
    String name;
    double maxJump = random.nextDouble(1.5,2.5);
    double maxRun = random.nextInt(500,850);

    protected Cat(String name){
        this.name = "Котейка "  + name;
    }

    @Override
    public boolean Jump(double distance) {
        if (distance > maxJump) {
            System.out.printf("%s не смог перебраться через стену в %.1f м\n",name, distance);
            return false;
        }
        else return true;
    }

    @Override
    public boolean Run(double distance) {
        if (distance > maxRun) {
            System.out.printf("%s не смог пробежать %.1f м\n",name, distance);
            return false;
        }
        else return true;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Robot implements Person{
    Random random = new Random();
    String name;
    double maxJump = random.nextDouble(0.5,1.2);
    double maxRun = random.nextInt(500,1000);

    protected Robot(String name){
        this.name = "Робот " +  name;
    }

    @Override
    public boolean Jump(double distance) {
        if (distance > maxJump) {
            System.out.printf("%s не смог перебраться через стену в %.1f м\n",name, distance);
            return false;
        }
        else return true;
    }

    @Override
    public boolean Run(double distance) {
        if (distance > maxRun) {
            System.out.printf("%s не смог пробежать %.1f м\n",name, distance);
            return false;
        }
        else return true;
    }

    @Override
    public String getName() {
        return name;
    }
    
}

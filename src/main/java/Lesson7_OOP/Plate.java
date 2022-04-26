package Lesson7_OOP;

public class Plate {
    private int food;
    private int num;

    public Plate(int num ,int food) {
        this.food = food;
        this.num = num;
    }

    public boolean decreaseFood(String name, int n) {
        if (this.food >= n){
            food -= n;
            return true;
        }
        else{
            System.out.println("Осталось корма " + food + ", а котику " + name + " нужно " + n);
            return false;
        }

    }
    public void info() {
        System.out.println("Корма в тарелке: " + food);
    }

    public int getPlateNum(){
        return num;
    }

    public void addEat(int val){
        System.out.println("В тарелку " + num + " добавлено " + val + " корма");
        this.food = this.food + val;
    }
}

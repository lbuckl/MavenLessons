package Lesson7_OOP;

public class Cat {
    private String name;
    private int appetite;
    private boolean foolCat = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        boolean fool;
        fool = p.decreaseFood(name, appetite);

        if (fool){
            foolCat = true;
            System.out.println("Котик " + name + " покушал из тарелки " + p.getPlateNum());
            p.info();
        }
        else foolCat = false;
    }

    public boolean isFoolCat(){
        if (foolCat) System.out.println("Котик " + name + " сытый и довольный");
        else System.out.println("Котик " + name + " голодный и злой");
        return foolCat;
    }
}



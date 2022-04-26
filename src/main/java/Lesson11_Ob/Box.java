package Lesson11_Ob;

import java.util.ArrayList;

abstract class Box <T extends Fruit>{

    abstract void addFruit(T fruit);
    abstract T deletFruit();
    abstract float getBoxWeight();
    abstract int getNumFruits();
}

class AppleBox<T extends Apple> extends Box<T>{
    ArrayList<T> pool = new ArrayList<>();
    float SumWeight;
    Apple buf = new Apple();

    void addFruit(T apple){
        pool.add(apple);
        SumWeight = SumWeight + apple.getWeight();
    }

    T deletFruit() {
        buf = pool.get(pool.toArray().length-1);
        pool.remove(pool.toArray().length-1);
        return (T) buf;
    }

    float getBoxWeight(){
        calcFruitWeight();
        return SumWeight;
    }

    int getNumFruits(){
        return pool.toArray().length;
    }

    private void calcFruitWeight(){
        SumWeight = 0;
        for (T fruts:pool) {
            SumWeight = SumWeight + fruts.getWeight();
        }
    }
}


class OrangeBox<T extends Orange> extends Box<T>{
    ArrayList<T> pool = new ArrayList<>();
    float SumWeight;
    Orange buf = new Orange();

    void addFruit(T orange){
        pool.add(orange);
    }

    T deletFruit() {
        buf = pool.get(pool.toArray().length-1);
        pool.remove(pool.toArray().length-1);
        return (T) buf;
    }

    float getBoxWeight(){
        calcFruitWeight();
        return SumWeight;
    }

    int getNumFruits(){
        return pool.toArray().length;
    }

    //Никому не доступаня функци по подсчёту
    private void calcFruitWeight(){
        SumWeight = 0;
        for (T fruts:pool) {
            SumWeight = SumWeight + fruts.getWeight();
        }
    }
}

class CompareBox <T extends Box<?>>{

    public boolean compare(T boxOne, T boxTwo){
        if (boxOne.getBoxWeight() == boxTwo.getBoxWeight()){
            System.out.println("Коробки равны по весу");
            return true;
        }
        else {
            System.out.println("Коробки не равны по весу");
            return false;
        }
    }
}

class TransBox <T extends Box>{
    private T from;
    private T to;

    public TransBox(T from, T to) {
        this.from = from;
        this.to = to;
    }

    public void Transf(int val){
        if (from.getClass().equals(to.getClass())){
            if (from.getNumFruits() >= val){
                for (int i = 0;i < val ;i++){
                    //Вместо того,чтобы использовать буферный массив, просто вкладываем from в to.
                    //Лучшая моя идея за весь код
                    to.addFruit(from.deletFruit());
                }
            }
            else System.out.println("Вы пытаетесь переложить слишком много фруктов!!!\n" +
                    "фруктов в коробке " + from.getNumFruits());


        }
        else System.out.println("Нельзя перекладывать фрукты из разных типов коробок!!!");
    }
}




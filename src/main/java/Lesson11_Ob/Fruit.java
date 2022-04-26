package Lesson11_Ob;


public interface Fruit {

    float getWeight();
}

class Apple implements Fruit{
    private Float weight;

    {
        weight = 100.0f;
    }

    public Apple() {

    }

    public Apple(float weight){
        this.weight = weight;
    }

    @Override
    public float getWeight() {
        return weight;
    }

}

class Orange implements Fruit{
    private Float weight;
    {
        weight = 150f;
    }

    public Orange(){}
    public Orange(float weight){
        this.weight = weight;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}


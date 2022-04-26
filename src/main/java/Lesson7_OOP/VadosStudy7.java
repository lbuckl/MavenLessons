package Lesson7_OOP;

public class VadosStudy7 {
    public static void main(String[] args) {
        Cat cat[] = new Cat[4];
        cat[0] = new Cat("Barsik", 10);
        cat[1] = new Cat("Pushok", 15);
        cat[2] = new Cat("Musya", 12);
        cat[3] = new Cat("Milka", 5);

        Plate plate1 = new Plate(1,30);

        plate1.info();
        for (int i = 0; i <= cat.length-1;i++){
            cat[i].eat(plate1);
        }

        System.out.println();
        for (int i = 0; i <= cat.length-1;i++){
            cat[i].isFoolCat();
        }
    }

}



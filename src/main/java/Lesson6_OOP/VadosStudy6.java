package Lesson6_OOP;

public class VadosStudy6 {
    public static void main(String[] args) {

        Dog dogSharik = new Dog("Шарик");
        System.out.println(dogSharik.AnimalCount() + ": " + dogSharik.name);
        dogSharik.run(350);
        dogSharik.run(550);
        dogSharik.swim(7);
        dogSharik.swim(15);


        Cat catPusok = new Cat("Пушок");
        System.out.println(catPusok.AnimalCount() + ": " + catPusok.name);
        catPusok.run(150);
        catPusok.run(350);
        catPusok.swim(7);

        Animals dogBobik = new Dog("Бобик");
        //System.out.println(dogBobik.AnimalCount() + ": " + dogBobik.name);
        animalInfo(dogBobik);

        Animals catMusya = new Cat("Муся");
        //System.out.println(catMusya.AnimalCount() + ": " + catMusya.name);
        animalInfo(catMusya);
    }

    public static void animalInfo(Animals animal){
        if (animal instanceof Dog){
            System.out.println(animal.AnimalCount()+": Собаку зовут "+animal.name);
        }

        if (animal instanceof Cat){
            System.out.println(animal.AnimalCount()+": Кошку зовут "+animal.name);
        }
    }
}

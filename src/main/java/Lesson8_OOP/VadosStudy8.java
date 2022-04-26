package Lesson8_OOP;

import java.util.Arrays;
import java.util.Random;

public class VadosStudy8 {

    private static Random random = new Random();

    public static void main(String[] args) {

        Barrier runWays[] = new Barrier[6];
        runWays[0] = new RunWay(random.nextInt(300,800));
        runWays[1] = new Wal(random.nextDouble(1.5));
        runWays[2] = new RunWay(random.nextInt(300,800));
        runWays[3] = new Wal(random.nextDouble(1.5));
        runWays[4] = new RunWay(random.nextInt(300,800));
        runWays[5] = new Wal(random.nextDouble(1.5));

        System.out.println("Созданы препятсивя:");
        for (int i = 0; i <= runWays.length-1;i++){
            System.out.printf("%s размером %.1f м\n",runWays[i].GetBarrierName(), runWays[i].GetVal());
        }

        Person persons[] = new Person[6];
        persons[0] = new Cat("Пушок");
        persons[1] = new Cat("Персик");
        persons[2] = new Human("Вадик");
        persons[3] = new Human("Алина");
        persons[4] = new Robot("N001");
        persons[5] = new Robot("N002");

        System.out.println("\nНа полосу выходят участники: ");
        for (int i = 0; i <= persons.length-1;i++){
            System.out.println(persons[i].getName());
        }
        
        System.out.println("\nСтарт!!!");

        for (int i = 0; i <= persons.length-1;i++){
            boolean contin = true;
            int runnable = 0;
                for (int j = 0; j <= runWays.length-1;j++){
                    if (runWays[j].GetBarrierName() == "Дорожка")
                        if (!persons[i].Run(runWays[j].GetVal())){
                            contin = false;
                            break;
                        }
                    if (runWays[j].GetBarrierName() == "Стена")
                        if (!persons[i].Jump(runWays[j].GetVal())) {
                            contin = false;
                            break;
                        }
                }

            if (contin) System.out.println(persons[i].getName() + " успешно преодолел полосу препятствий (Победа!!!)");
        }
        System.out.println("Соревнования окончены");
    }


}
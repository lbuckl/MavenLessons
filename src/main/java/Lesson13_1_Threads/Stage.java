package Lesson13_1_Threads;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

import static Lesson13_1_Threads.VadosStudy13_1.BARRIER;
import static Lesson13_1_Threads.VadosStudy13_1.CARS_COUNT;

//Класс для создания элементов Трека
abstract public class Stage {
    protected int length;
    protected String description;

    public Stage(int lenght) {
        this.length = lenght;
    }

    public String getDescription() {
        return description;
    }
    public int getLength(){return length;}
}

// Обычная дорога
class Road extends Stage{

    public Road(int lenght) {
        super(lenght);
        description = "Прямая " + length + " метров";
    }

}

//Тонель
class Tunnel extends Stage{

    public Tunnel(int lenght) {
        super(lenght);
        description = "Тоннель " + length + " метров";
    }
}

class Track{
    private ArrayList<Stage> track;
    Car cars[];
    int winCount = 0;
    int startCount = 0;

    public Track(Car cars[],Stage... track){
        this.track = new ArrayList<>(Arrays.asList(track));
        this.cars = cars;
    }

    public void printInfo(){
        System.out.println("Список участников:");
        for (Car c:cars) {
            System.out.println(c.getName() + "/" + c.getSpeed());
        }
        System.out.println("Состав трека:");
        for (Stage tr:track) {
            System.out.println(tr.getDescription());
        }
        System.out.println("________________________________");
    }

    public void getReady(){
        Semaphore smp = new Semaphore(2);
        for (int i = 0; i < CARS_COUNT; i++) {
            final int w = i;
            new Thread(() -> {
                try {
                    System.out.println(cars[w].getName() + " готовится");
                    Thread.sleep(100 + (int) (3000 * Math.random()));
                    System.out.println(cars[w].getName() + " готов");
                    BARRIER.await();
                    startCount++;
                    CheckStart();
                    for (Stage step:track) {
                        if(step.getClass().getSimpleName().equals("Tunnel")){
                            smp.acquire();
                            System.out.println(cars[w].getName() + " выходит на участок " + step.getDescription());
                            int time = (int) 100L * step.getLength() / cars[w].speed; // вычисляем сколько ехать по времени участок
                            Thread.sleep(time);
                            System.out.println(cars[w].getName() + " проехал участок за " + time + "мс");
                            smp.release();
                        }
                        else {
                            System.out.println(cars[w].getName() + " выходит на участок " + step.getDescription());
                            int time = (int) 100L * step.getLength() / cars[w].speed; // вычисляем сколько ехать по времени участок
                            Thread.sleep(time);
                            System.out.println(cars[w].getName() + " проехал участок за " + time + "мс");
                        }

                    }

                    winCount++;
                    checkWin(cars[w].getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }

    private void checkWin(String name){
        if (winCount == 1)
        {
            System.out.println("УЧАСТНИК " + name + " ПОБЕДИТЕЛЬ!!!");
        }
        else System.out.println("УЧАСТНИК " + name + " ЗАНЯЛ " + winCount + " МЕСТО");
    }

    private void CheckStart(){
        if (startCount == CARS_COUNT){
            System.out.println("ВНИМАНИЕ! ГОНКА НАЧАЛАСЬ!!!");
        }
    }

}



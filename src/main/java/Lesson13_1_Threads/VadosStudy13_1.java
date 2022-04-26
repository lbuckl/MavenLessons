package Lesson13_1_Threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class VadosStudy13_1 {

    public static final int CARS_COUNT = 4; // Кол-во машин
    public static final CyclicBarrier BARRIER = new CyclicBarrier(CARS_COUNT);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        //Создаём участников
        Car cars[] = new Car[CARS_COUNT];
        for (int i = 1; i <= CARS_COUNT; i++) {
            cars[i-1] = new Car(i,20 + (int) (Math.random()*5));
        }

        //Создаём трек и определяем участников
        Track track = new Track(cars,new Road(100), new Tunnel(50), new Road(60));
        track.printInfo();

        //Выполняем подготовку
        track.getReady();

    }





}

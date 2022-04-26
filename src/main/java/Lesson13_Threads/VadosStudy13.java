package Lesson13_Threads;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class VadosStudy13 {

        public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
        public static final String RESET = "\033[0m";  // Text Reset

        public static final int CARS_COUNT = 4; // Кол-во машин
        // Мы будем использовать CyclicBarrier и метод getNumberWaiting()
        // метод getNumberWaiting() вернет нам кол-во потоков "достигших" барьера
        // [важно] При достижении барьера всеми потоками, метод getNumberWaiting() вернет 0
        // поэтому я объявляю предел барьера в CARS_COUNT + 1, т е "условно" в 5 машин
        // таким образом, мы всегда дождемся и будем знать, когда 4 машины достигли барьера,
        // после этого повторно вызовем BARRIER.await() и "сбросим" барьер
        public static final CyclicBarrier BARRIER = new CyclicBarrier(CARS_COUNT + 1);
        // Потокобезопасный клас Integer, будем использовать его для подсчета пришедших к финишу машин
        public static AtomicInteger WINNER_COUNTER = new AtomicInteger(0);

        public static void main(String[] args) {

            new VadosStudy13().doHomework();

        }

        void doHomework(){

            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
            // Подготовим маршрут гонки (дорога-тунель-дорога)
            Race race = new Race(new Road(60), new Tunnel(), new Road(40));
            // Подготовим массив автомобилей
            Car[] cars = new Car[CARS_COUNT];
            // Пронициализируем каждый элемент массива, укажем для каждого автомобиля
            // маршрут движения, случайную скорость движения и индекс (для формирования наименования участника гонки)
            for (int i = 0; i < cars.length; i++) {
                cars[i] = new Car(race, 20 + (int) (Math.random() * 10), i + 1);
            }
            // А теперь просто запустим потоки автомобилей
            for (Car car : cars) {
                new Thread(car).start();
            }

            try {
                // Сохраним кол-во потоков, достигших барьера, в переменную readyCarCount
                int readyCarCount = BARRIER.getNumberWaiting();
                // Если кол-во потоков автомобилей, достигших барьера, не равно 4, будем выполнять цикл
                while (readyCarCount != CARS_COUNT){
                    // Выводим отладочную информацию
                    System.out.printf("%s Готовы %d из %d машин. (Ждем в основном потоке 100 мс)%s\n", BLACK_BOLD_BRIGHT, readyCarCount, CARS_COUNT, RESET);
                    Thread.sleep(100); // Ждем 200 мс
                    // Получим актуальное значение достигших барьера потоков автомобилей
                    readyCarCount = BARRIER.getNumberWaiting();
                }
                // Выводим отладочную информацию
                System.out.printf("%s Готовы %d из %d машин.%s\n", BLACK_BOLD_BRIGHT, readyCarCount, CARS_COUNT, RESET);

                // Итак, все 4 автомобиля достигли барьера, но мы не забываем, что барьер был создан для
                // CARS_COUNT + 1, поэтому вручную вызываем BARRIER.await() и сбрасываем барьер
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                BARRIER.await(); // BARRIER.getNumberWaiting() -> + 1 == 5 => 0
                // Снова переинициализируем кол-во потоков, достигших барьера (пришедших к финишу автомобилей) в 0
                readyCarCount = 0;
                // Мы снова будем ожидать в главном потоке, на этот раз мы будем ждать, когда все автомобили
                // достигнут финиша
                while (readyCarCount != CARS_COUNT){
                    // Выводим отладочную информацию
                    System.out.printf("%s Машины на финише %d из %d машин. (Ждем в основном потоке 100 мс)%s\n", BLACK_BOLD_BRIGHT, readyCarCount, CARS_COUNT, RESET);
                    Thread.sleep(100); // Ждем 200 мс
                    // Получим актуальное значение достигших барьера (пришедших к финишу) потоков автомобилей
                    readyCarCount = BARRIER.getNumberWaiting();
                }
                // Выводим отладочную информацию
                System.out.printf("%s Машины на финише %d из %d машин.%s\n", BLACK_BOLD_BRIGHT, readyCarCount, CARS_COUNT, RESET);
                BARRIER.await(); // BARRIER.getNumberWaiting() -> + 1 == 5 => 0
                // Объявляем об окончании гонки и завершаем работу приложения
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }

        }

        /**
         * Автомобиль
         */
        public class Car implements Runnable {
            // Маршрут движения
            private final Race race;
            // Скорость автомобиля
            private final int speed;
            // Наименование автомобиля
            private final String name;

            /**
             * Получить наименование автомобиля
             * @return - наименование автомобиля
             */
            public String getName() {
                return name;
            }

            /**
             * Получить скорость автомобиля
             * @return - скорость автомобиля
             */
            public int getSpeed() {
                return speed;
            }

            /**
             * Основной конструктор для создания автомобиля
             * @param race - маршрут движения
             * @param speed - скорость автомобиля
             * @param index - индекс потока (для формирования наименования участника гонки)
             */
            public Car(Race race, int speed, int index) {
                this.race = race;
                this.speed = speed;
                this.name = "Участник #" + index;
            }

            @Override
            public void run() {
                try {
                    // Выводим информацию о готовности автомобиля к гонке
                    System.out.println(this.name + " готовится");
                    // Случайным образом определим время подготовки автомобиля к гонке и подождем
                    Thread.sleep(500 + (int) (Math.random() * 800));
                    // Время прошло, автомобиль готов, выводим соответствующую информацию на экран
                    System.out.println(this.name + " готов");
                    // "Сообщим барьеру" о готовности автомобиля к гонке, теперь ЖДЕМ
                    BARRIER.await(); // ЖДЕМ, ЖДЕМ когда барьер "пропустит" все автомобили
                    // После того, как барьер "пропустил" всех, запустим все автомобили по маршруту
                    for (int i = 0; i < race.getStages().size(); i++) {
                        race.getStages().get(i).go(this);
                    }
                    // Текущий поток завершает свою работу, автомобиль приходит к финишу, обратимся к
                    // потокобезопасной переменной WINNER_COUNTER, проанализируем ее значение и одновременно
                    // увеличим на 1. Если изначально счетчик был равен 0 - автомобиль пришел первым и он
                    // победил
                    if (WINNER_COUNTER.getAndIncrement() == 0) {
                        System.out.println("У нас есть победитель:  " + this.name);
                    } else {
                        System.out.println(this.name + " пришел " + WINNER_COUNTER.get() + "м!");
                    }
                    // ЖДЕМ остальных участников гонки ...
                    BARRIER.await(); // ЖДЕМ, после того как все придут к финишу завершим работу потока

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * Заезд
         */
        public class Race {
            private ArrayList<Stage> stages;
            private Object mon;
            public ArrayList<Stage> getStages() { return stages; }

            public Object getMon() {
                return mon;
            }

            public Race(Stage... stages) {
                this.stages = new ArrayList<>(Arrays.asList(stages));
                this.mon = new Object();
            }
        }

        /**
         * Участок трассы - дорога
         */
        public class Road extends Stage {

            public Road(int length) {
                this.length = length;
                this.description = "Дорога " + length + " метров";
            }
            @Override
            public void go(Car c) {
                try {
                    System.out.println(c.getName() + " начал этап: " + description);
                    Thread.sleep(length / c.getSpeed() * 1000L);
                    System.out.println(c.getName() + " закончил этап: " + description);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * Участок трассы - тоннель
         */
        public class Tunnel extends Stage {
            // Тоннель имеет пропускную способность в 2 автомобиля,
            // организуем очередь через класс Semaphore
            final Semaphore semaphore = new Semaphore(CARS_COUNT / 2);

            public Tunnel() {
                this.length = 80;
                this.description = "Тоннель " + length + " метров";
            }
            @Override
            public void go(Car car) {
                try {
                    try {
                        // Каждый раз, когда автомобиль заезжает в тоннель, мы вызываем semaphore.acquire(),
                        // если, при этом, места в тоннеле нет, другие автомобили ждут в очереди
                        System.out.println(car.getName() + " готовится к этапу(ждет): " + description);
                        semaphore.acquire();
                        System.out.println(car.getName() + " начал этап: " + description);
                        // Создаем искуственную задержку, автомобиль едет в тоннеле
                        Thread.sleep(length / car.getSpeed() * 1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println(car.getName() + " закончил этап: " + description);
                        // Автомобиль проехал через тоннель и освободил место semaphore.release()
                        semaphore.release();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * Базовый класс, описывает участок трассы (дорога, тоннель)
         */
        public abstract class Stage {
            protected int length;
            protected String description;
            public String getDescription() {
                return description;
            }
            public abstract void go(Car c);
        }

}

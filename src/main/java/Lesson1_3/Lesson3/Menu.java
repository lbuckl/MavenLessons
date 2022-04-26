package Lesson1_3.Lesson3;

import java.util.Scanner;


public class Menu {
    static  Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit){
            System.out.println("___________________");
            System.out.println("Выбор игры");
            System.out.println("1 - Угадай цифру");
            System.out.println("2 - Угадай слово");
            System.out.println("3 - Секретная игра");
            System.out.println("0 - Выход");
            System.out.println("___________________");
            System.out.print("Ваш выбор: ");

            if (scan.hasNextInt()){
                int choiсe = scan.nextInt();
                switch (choiсe){
                    case 0:
                        System.out.println("До новых встреч!");
                        exit = true;
                        break;
                    case 1:
                        VadosStudy3.Game1(); // Вызов программы из другого java файла не несёт никакой смысловой нагрузки
                        break;               // я просто игрался со взаимодействием java файлов
                    case 2:
                        VadosStudy3.Game2();
                        break;
                    case 3:
                        VadosStudy3.Game3();
                        break;
                    default:
                        System.out.println("Вы ввели число выходящее за диапазон 0 - 3");
                }

            }
            else
            {

                System.out.println("Вы ввели не корректное число");
                scan.nextLine();
            }
        }
        scan.close();
    }
}

package Lesson1_3.Lesson3;

import java.util.Random;
import java.util.Scanner;

public class VadosStudy3 {
    public static void Game1( ){

        Scanner scan = new Scanner(System.in);

        Random random = new Random();
        int search = random.nextInt(0,10);
        //System.out.println(search);
        System.out.println("Угадайте число от 0 до 9. У Вас 3 попытки:");
        boolean bingo = false;

        for (int i = 1; i <=3; i++){
            int turn;

            if (scan.hasNextInt()){
                 turn = scan.nextInt();
                 if (turn == search){
                     bingo = true;
                     System.out.println("BINGO!!! Вы угадали с " + i + " попытки!!!");
                     break;
                 }
                 else{
                     if (search < turn) System.out.println("Число меньше введённого, осталось попыток: " + (3-i));
                     else System.out.println("Число больше введённого, осталось попыток: " + (3-i));

                 }
            }
            else{
                System.out.println("Вы ввели не корректное число, осталось попыток: " + (3-i));
                scan.nextLine();
            }

        }

        if (!bingo) System.out.println("Загаданное число: " + search + ". Вы проиграли(((");
        //scan.close();
    }

    public static void Game2(){
        System.out.println("Мы загадали слово по тематике \"Еда\",");
        System.out.println("попробуй его отгадать!");
        String words[] = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        String fruct = words[rand.nextInt(0,25)];
        boolean ext = false;
        char buf[] = {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'};

        System.out.println(fruct);

        do{
            System.out.print("Введите слово, либо слово \"выход\" для выхода: ");
            String str = scan.nextLine();
            if (str.equals("выход")) {
                ext = true;
                System.out.println("Выход из игры");
            }
            else if (str.equals(fruct)){
                    System.out.println("Вы отгадали!!!");
                    ext = true;
                }
                else{
                    //чтобы не выйти за пределы массива при сравнении, выбираем наименьший
                    int len = 0;
                    if (str.length() <= fruct.length()) len = str.length();
                    else len = fruct.length();

                    for (int i = 0; i < len;i++){
                        if (str.charAt(i) == fruct.charAt(i)) buf[i] = str.charAt(i);
                    }

                    for (int j = 0;j < 15;j++){
                        System.out.print(buf[j]);
                    }
                System.out.println("");

                }

        }
        while (!ext);
    }

    public static void Game3(){
        System.out.println("Никакой секретной игры нет, это просто заглушка. Зато вот Вам зайчик");
        System.out.println(" ()_()");
        System.out.println(" (^.^)");
        System.out.println("'(\")(\")'");
    }
}

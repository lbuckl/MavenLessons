package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class VadosStudy4 {


    static final char DOT_HUMAN = 'X'; // Фишка игрока - человек
    static final char DOT_AI = '0'; // Фишка игрока - компьютер
    static final char DOT_EMPTY = '•'; // Признак пустого поля
    static final Scanner scanner = new Scanner(System.in);
    static final Random random = new Random();
    static char[][] field;
    static int fieldSize;
    static final int WIN_COUNT = 3; // Выигрышная комбинация

    /**
     * Инициализация объектов игры
     */
    static void initialize(){
        // Установим размерность игрового поля
        System.out.println("Введите размерность изрового поля 3 или 4: ");
        fieldSize = EnterCorrectInt();
        if (fieldSize < 3) fieldSize = 3;
        if (fieldSize > 4) fieldSize = 4;

        // Инициализация массива, описывающего игровое поле
        field = new char[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }

    }

    /**
     * Отрисовка игрового поля
     */
    static void printField(){
        System.out.print("+");

        for (int i = 0; i < fieldSize* 2 + 1; i++) {
            if (i % 2 == 0)
            {
                System.out.print("-");
            }
            else{
                System.out.printf("%d", i/2 + 1);
            }
        }
        System.out.println();

        for (int i = 0; i < fieldSize; i++) {
            System.out.print(i + 1 + "|");

            for (int j = 0; j < fieldSize; j++) {
                System.out.print(field[i][j] + "|");
            }

            System.out.println();
        }

        for (int i = 0; i <= fieldSize* 2 + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    static void humanTurn(){
        int x, y;
        do{
            System.out.println("Введите координаты хода X и Y (от 1 до 3) через пробел >>>");
            x = EnterCorrectInt() - 1;
            y = EnterCorrectInt() - 1;
        }
        while (!(isCellValid(x, y) && isCellEmpty(x, y)));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * ход ИИ
     */
    static void aiTurn(){
        int x, y;
        int checkBlock = checkHumanBlock();
        if (checkBlock == 0){
            RandomAiTurn();
        }
        else{
            x = checkBlock/10;
            y = checkBlock%10;
            field[x][y] = DOT_AI;
        }
    }

    /**
     * Вычисляет какой ход игрока блокировать
     */
    static int checkHumanBlock(){
        int check = 0;
        int blockXY = 0;

        // Проверка по трем горизонталям
        for (int i = 0; i <= fieldSize-1;i++){
            for (int j = 0; j <= fieldSize-1;j++){
                if (field[i][j] == DOT_HUMAN) check++;
                if (isCellEmpty(i,j)) {
                    blockXY = i*10 + j; // так вот костылим координату
                }
            }
            if (check == fieldSize-1) return blockXY;
            check = 0;
            blockXY = 0;
        }

        // Проверка по трем вертикалям
        for (int i = 0; i <= fieldSize-1;i++){
            for (int j = 0; j <= fieldSize-1;j++){
                if (field[j][i] == DOT_HUMAN) check++;
                if (isCellEmpty(j,i)) {
                    blockXY = j*10 + i; // так вот костылим координату
                }
            }
            if (check == fieldSize-1) return blockXY;
            check = 0;
            blockXY = 0;
        }

        // Проверка по диагонали верх,лево - низ право
        for (int i = 0; i <= fieldSize-1;i++){
            if (field[i][i] == DOT_HUMAN) check++;
            if (isCellEmpty(i,i)) {
                blockXY = i*10 + i; // так вот костылим координату
            }
        }
        if (check == fieldSize-1) return blockXY;
        check = 0;
        blockXY = 0;

        // Проверка по диагонали верх,право - низ,лево
        for (int i = 0; i <= fieldSize-1;i++) {
                if (field[i][fieldSize-1-i] == DOT_HUMAN) check++;
                if (isCellEmpty(i,fieldSize-1-i)) {
                    blockXY = i*10 + (fieldSize-1-i); // так вот костылим координату
                }
            if (check == fieldSize-1) return blockXY;
        }
        blockXY = 0;

        return blockXY;
    }

    /**
     * Совершает рандомный ход
     */
    static void RandomAiTurn(){
        int x, y;
        do{
            x = random.nextInt(fieldSize);
            y = random.nextInt(fieldSize);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }


    /**
     * Проверка, ячейка является пустой (DOT_EMPTY)
     * @param x
     * @param y
     * @return
     */
    static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать рамерность массива, описывающего игровое поле)
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y){
        return  x >= 0 && x < fieldSize && y >= 0 && y < fieldSize;
    }

    /**
     * Проверка на ничью (все поле заполнено фишками человека или компьютера)
     * @return
     */
    static boolean checkDraw(){
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (isCellEmpty(i, j))
                    return false;
            }
        }
        return true;
    }

    /**
     * Проверка победы
     * @param c
     * @return
     */
    static boolean checkWin(char c){
        int check = 0;
        // Проверка по трем горизонталям
        for (int i = 0; i <= fieldSize-1;i++){
            for (int j = 0; j <= fieldSize-1;j++){
                if (field[i][j] == c) check++;
            }
            if (check == fieldSize) {
                return true;
            }
            check = 0;
        }

        // Проверка по трем вертикалям
        for (int i = 0; i <= fieldSize-1;i++){
            for (int j = 0; j <= fieldSize-1;j++){
                if (field[j][i] == c) check++;
            }
            if (check == fieldSize){
                return true;
            }
            check = 0;
        }

        // Проверка по диагонали верх,лево - низ право
        for (int i = 0; i <= fieldSize-1;i++){
            if (field[i][i] == c) check++;
        }
        if (check == fieldSize){
            return true;
        }
        check = 0;

        // Проверка по диагонали верх,право - низ,лево
        for (int i = 0; i <= fieldSize-1;i++) {
                if (field[i][fieldSize-1-i] == c) check++;
        }
        if (check == fieldSize){
            return true;
        }

        return false;
    }

    static boolean checkXY(int x, int y, char c, int win){
        return false;
    }

    /**
     * Метод проверки состояния игры
     * @param dot
     * @param s
     * @return
     */
    static boolean gameChecks(char dot, String s){
        // Проверка победы игрока
        if (checkWin(dot)){
            System.out.println(s);
            return true;
        }
        // Проверка на ничью
        if (checkDraw()){
            System.out.println("Ничья!");
            return true;
        }

        // Продолжаем игру
        return false;
    }

    public static void main(String[] args) {

        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameChecks(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (gameChecks(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.println("Желаете сыграть еше раз? (Y - да)");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }

    }

    //функция для корретного ввода интовых значений
    public static int EnterCorrectInt(){
        int res;
        if (scanner.hasNextInt()){
            return scanner.nextInt();
        }
        else {
            System.out.println("Вы ввели не корректное число");
            scanner.nextLine();
            res = EnterCorrectInt();
        }
        return res;
    }

}

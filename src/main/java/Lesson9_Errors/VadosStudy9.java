package Lesson9_Errors;

import Lesson9_Errors.MyExeptions.MyArrayDataException;
import Lesson9_Errors.MyExeptions.MyArraySizeException;

import java.util.Random;

//import static Lesson9_Errors.MyArraySizeException.isArr4x4;

public class VadosStudy9 {
    public static void main(String[] args) {
        Random random = new Random();

        String arr[][] = new String[4][4];

        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[i].length - 1; j++) {
                arr[i][j] = String.valueOf(random.nextInt(0,2));
                arr[3][3] = "a";
                System.out.print(arr[i][j] + "  ");
                }
            System.out.println();

            }

        try {
            isArr4x4(arr); // Метод проверяющий размер массива 4х4
            System.out.println(SumArray4x4(arr));
            } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Здесь могла быть ваша реклама");
        }

    }

    //Функция суммирования всех элементов массива
    public static int SumArray4x4(String arr[][]) throws MyArrayDataException {
        int buf = 0, i = 0, j = 0;

        try {
            for (i = 0; i <= arr.length - 1; i++) {
                for (j = 0; j <= arr[i].length - 1; j++) {
                    buf = buf  + Integer.parseInt(arr[i][j]);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        } catch (NumberFormatException e){
            e.printStackTrace();
            throw new MyArrayDataException("Строка: " + i + ", столбец: " + j + ". Содержит не целочисленное значение");
        }
        return buf;
    }

    public static void isArr4x4(String arr[][]) throws MyArraySizeException{
        if (arr.length != 4){
            throw new MyArraySizeException("Количество строк не равно 4");
        }
        if (arr[0].length != 4){
            throw new MyArraySizeException("Количество столбцов не равно 4");
        }
    }
}

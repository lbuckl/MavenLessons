package Lesson1_3;

import java.util.Arrays;

public class VadosStudy2 {
    public static void main(String[] args) {

        //region Задание 1: заменить числа 1 и 0
        System.out.println("Задание 1:");
        int arr[] = {1, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length;i++){
            arr[i] = Math.abs(arr[i]-1);
        }
        System.out.println(Arrays.toString(arr) + "\n");
        //endregion

        //region Задание 2: Заполнить пустой массив
        System.out.println("Задание 2:");
        int arr2[] = new int[8];
        for (int i = 0; i < 8;i++){
            arr2[i] = i*3;
        }
        System.out.println(Arrays.toString(arr2) + "\n");
        //endregion

        //region Задание 3: если элемент мнеьше 6, то умножить его на 2
        System.out.println("Задание 3:");
        int arr3[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8 ,9, 1};
        System.out.println(Arrays.toString(arr3));
        for (int i = 0; i < arr.length;i++){
            if (arr3[i] < 6) arr3[i] *= 2;
        }
        System.out.println(Arrays.toString(arr3) + "\n");
        //endregion

        //region Задание 4: заполнить диагонали 2-мерного массива единицами
        System.out.println("Задание 4:");
        int arr4[][] = new int[5][5];
        for (int i = 0; i < 5; i++){
            arr4[i][i] = 1;
            arr4[i][4-i] = 1;
            System.out.println(Arrays.toString(arr4[i]));
        }
        System.out.println("");
        //endregion

        //region Задание 5: найти минимальный и максимальный элементы
        System.out.println("Задание 5:");
        double arr5[] = {1.55, -5.31, -3, 2.58, 11.11, 4, -5.28, 2.11, 4.44, 8.91 ,9.99 , -1};
        System.out.println(Arrays.toString(arr5));
        double min = arr5[0];
        double max = arr5[0];
        for (int i = 0; i < arr.length-1;i++){
            if (arr5[i+1]>max) max = arr5[i+1];
            if (arr5[i+1]<min) min = arr5[i+1];
        }
        System.out.println("Максимальное: " + max);
        System.out.println("Маинимальное: " + min + "\n");
        //endregion

        //region Задание 6: найти баланс
        System.out.println("Задание 6:");
        int arr6[] = {2, 2, 3, 1, 4, 2, 2};
        System.out.println(Arrays.toString(arr6));
        boolean res6 = checkBalance(arr6);
        System.out.println(res6);
        System.out.println("");
        //endregion

        //region Задание 7: сдвинуть элементы массива
        System.out.println("Задание 7:");
        int arr7[] = {1, 2, 3, 4, 5, 6};
        int moveNum = -5;
        int arr7res[] = doMove(arr7, moveNum);
        System.out.println(Arrays.toString(arr7res));

    }

    //Задание 6: найти баланс
    //Логика вычисления:
    //1. Сумма элементов может быть нечётной, только если одна из сумм слева или справа чётная,а вторая нечётная,
    //но тогда левая сторона никогда не будет равна правой - возвращаем false.
    //2. Сумма чётная, тогда середина будет равна полусумме и нужно её найти в массиве.
    //Если находим, то возвращаем true, если нет - false.

    public static boolean checkBalance(int data[]){
        int sum = Arrays.stream(data).sum();
        if (sum%2 > 0) return false;
        else{ // Из общей суммы вычитаем числа по очереди, пока она не будет равна полусумме
            int res = sum;
            for (int i = 0;i < data.length;i++){
                res = res - data[i];
                if (res == sum/2) return true;
                }
            }
            return false;
        }

    //Задание 7: сдвинуть элементы массива
    public static int[] doMove(int data[], int move){
        System.out.println(Arrays.toString(data) + " сдвиг на " + move);
        if (move < 0) { // сдвиг вправо
            for (int j = 0; j < Math.abs(move); j++) {
                int buf = data[0];
                for (int i = 0; i < data.length - 1; i++) {
                    data[i] = data[i + 1];
                }
                data[data.length - 1] = buf;
            }
        }
        else{ // сдвиг влево
            for (int j = 0; j < move; j++){
                int buf = data[data.length - 1];
                for (int i = data.length - 2; i >= 0 ; i--){
                    data[i + 1] = data[i];
                }
                data[0] = buf;
            }
        }
        return data;
    }

}
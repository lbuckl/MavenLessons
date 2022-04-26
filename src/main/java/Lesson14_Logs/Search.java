package Lesson14_Logs;

public class Search {
    /**
     * Функция для поиска содержания двух чисел в массиве
     * arr - массив
     * search1 - искомое число 1
     * search2 - искомое число 1
     */
    public static boolean chechNums(int arr[], int search1, int search2) {
        boolean flag1 = false;
        boolean flag2 = false;

        for (int el : arr) {
            if (el == search1) flag1 = true;
            if (el == search2) flag2 = true;
        }
        return flag1 && flag2;
    }
}

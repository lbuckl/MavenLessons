package Lesson14_Logs;

public class CutArray {
    /**
     *Функция для вывода массива после последнего заданного числа
     * arr - массив
     * search - искомое число
     */
    public static int[] returnCustomArr(int arr[], int search) throws NotFind4Exeption {
        int indexIn = -1;

        for (int i = 0;i < arr.length;i++){
            if (arr[i] == search) indexIn = i;
        }

        if (indexIn > -1) {
            int res[] = new int[arr.length-indexIn-1];
            System.out.println(indexIn);
            System.arraycopy(arr,indexIn+1,res,0,arr.length-indexIn-1);
            return res;
        }
        else {
            throw new NotFind4Exeption("Не найдена цифра " + search);
        }
    }
}

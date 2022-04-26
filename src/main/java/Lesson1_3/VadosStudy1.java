package Lesson1_3;


import java.util.GregorianCalendar;

public class VadosStudy1 {
    public static void main(String[] args) {

        //region задание 2: создание переменных
        byte byteVal = 1;
        short shortVal = 2;
        int intVal1 = -5;
        int intVal2 = 12;
        long longVal = 10;
        float floatVal1 = 20.5f;
        float floatVal2 = -12.7f;
        double doubleVal1 = 50.12;
        char charVal = 'Z';
        boolean boolVal = true;
        String  stringVal = "Vadim";
        System.out.println("Целые числа: " + byteVal + " " + shortVal + " " + intVal1 + " " + intVal2 + " " + longVal);
        System.out.println("Дробные числа: " + floatVal1 + " " + floatVal2 + " "  + doubleVal1);
        System.out.println("Символ: " + charVal);
        System.out.println("Дискретное значение: " + "\"" + boolVal + "\"");
        System.out.println("Строка: " + stringVal);
        System.out.println("");
        //endregion

        //region Вызов методов по заданям 3 - 8
        float res3 = expression1(floatVal1, floatVal2,floatVal2, floatVal1); // задание 3
        System.out.println("");

        boolean res4 = from10to20(intVal1, intVal2); // задание 4
        res4 = from10to20(10, 5); // задание 4
        System.out.println("");

        posOrNeg(intVal1); // задание 5
        posOrNeg(intVal2); // задание 5
        System.out.println("");

        boolean res6 =  posOrNegRetunt(intVal2); // задание 6
        System.out.println("Задание 6: Число " + intVal2 + " положительное? / " + res6);
        res6 =  posOrNegRetunt(intVal1); // задание 6
        System.out.println("Задание 6: Число " + intVal1 + " положительное? / " + res6);
        System.out.println("");

        printHallo(stringVal); // задание 7
        System.out.println("");

        //задание 8
        System.out.println("задание 8:");
        int year = 2032;
        visYear(year);
        //в GregorianCalendar() есть функция, которая отвечает исокосный ли год, ниже вставлю проверку по нему
        System.out.print("Результат из Библиотеки GregorianCalendar: ");
        System.out.println(new GregorianCalendar().isLeapYear(year));
        //endregion


    }

    //Задание 3: a * (b + (c / d))
    public static float expression1(float a, float b, float c,float d){
        String res = "Задание 3: " + a + "*" + "(" + b + "+("+ c + "/" + d +")) = ";
        System.out.print(res);
        System.out.printf("%.2f\n",a * (b + (c / d)));
        return a * (b + (c / d));
    }

    //Задание 4: лежит ли сумма в пределах от 10 до 20?
    public static boolean from10to20(int a, int b){
        int c = a + b;
        if (c >= 10 && c <= 20) {
            System.out.println("Задание 4: Сумма " + a + " и " + b + " = "+ c + " и принадлежит промежутку от 10 до 20");
            return true;
        }
        else {
            System.out.println("Задание 4: Сумма " + a + " и " + b + " = "+ c + " и не принадлежит промежутку от 10 до 20");
            return false;
        }
    }
    // задание 5: Положительное ли число передали или отрицательное?
    public static void posOrNeg (int a){
        if (a < 0) System.out.println("Задание 5: Число " + a + " отрицательное");
        else System.out.println("Задание 5: Число " + a + " положительное");
    }

    // задание 6: Положительное ли число передали или отрицательное? (вернуть бульку)
    public static boolean posOrNegRetunt (int a){
        if (a < 0) return false;
        else return true;
    }

    // задание 7 «Привет, указанное_имя!»
    public static void printHallo(String name){
        System.out.println("Задание 7: «Привет, " + name + "!»");
    }

    // задание 8 является ли год високосным
    public static void visYear(int year){
        if (year%400 == 0) System.out.println("Год " + year + " является високосным");
        else if (year%4 == 0 && year%100 > 0) System.out.println("Год " + year + " является високосным");
        else System.out.println("Год " + year + " не является високосным");

    }
}


package Lesson11_Ob;

import java.util.ArrayList;
import java.util.Scanner;

public class VadosStudy11 {
    public static void main(String[] args) {

        AppleBox appleBox01 = new AppleBox();
        OrangeBox orangeBox01 = new OrangeBox();
        OrangeBox orangeBox02 = new OrangeBox();

        //region генерируем колличество фруктов в коробках
        int appleNum = 6; // задаём колличество фруктов
        int orangeNum = 4; // задаём колличество фруктов

        for (int i = 0; i < appleNum;i++)
        appleBox01.addFruit(new Apple());

        for (int i = 0; i < orangeNum;i++){
            orangeBox01.addFruit(new Orange());
            orangeBox02.addFruit(new Orange());
        }
        //Создаём уникальный апельсин весом в 2
        Orange orangeTest = new Orange(200);
        orangeBox01.addFruit(orangeTest);
        //endregion


        System.out.printf("Коробка с яблоками 1 весит : %.1f\n",appleBox01.getBoxWeight());
        System.out.printf("Коробка с апельсинами 1 весит : %.1f\n",orangeBox01.getBoxWeight());
        System.out.printf("Коробка с апельсинами 2 весит : %.1f\n",orangeBox02.getBoxWeight());
        System.out.println();
        System.out.println("Сравниваем коробку с яблоками 1 и коробку с апельсинами 1:");
        new CompareBox<>().compare(appleBox01,orangeBox01);
        System.out.println("Сравниваем коробку с яблоками 1 и коробку с апельсинами 2:");
        new CompareBox<>().compare(appleBox01,orangeBox02);

        System.out.println("\nПерекладываем фрукты");

        System.out.println("Фруктов в коробке 1: " + orangeBox01.getNumFruits());
        System.out.println("Фруктов в коробке 2: " + orangeBox02.getNumFruits());
        System.out.println("Вес коробки 1: " + orangeBox01.getBoxWeight());
        System.out.println("Вес коробки 2: " + orangeBox02.getBoxWeight());

        TransBox trans1 = new TransBox<>(orangeBox01,orangeBox02);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько фруктов переложить?");
        int val = scanner.nextInt();
        trans1.Transf(val);

        System.out.println("Фруктов в коробке 1: " + orangeBox01.getNumFruits());
        System.out.println("Фруктов в коробке 2: " + orangeBox02.getNumFruits());
        System.out.println("Вес коробки 1: " + orangeBox01.getBoxWeight());
        System.out.println("Вес коробки 2: " + orangeBox02.getBoxWeight());

        System.out.println("\nПробуем пересыпать из коробки яблок в коробку апельсинов:");
        TransBox trans2 = new TransBox<>(appleBox01,orangeBox02);
        trans2.Transf(2);
    }
}

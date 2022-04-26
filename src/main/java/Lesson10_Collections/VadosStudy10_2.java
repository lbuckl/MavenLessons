package Lesson10_Collections;

import java.util.HashMap;
import java.util.Scanner;

public class VadosStudy10_2 {

    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, Person> phoneBook = new HashMap<String, Person>();

    public static void main(String[] args) {

        //Первичный набор пользователей
        Initialize();

        System.out.println("<<Телефонный справочник>>");
        boolean end = false;
        while (!end) {
            end = Menu();
        }
    }

    public static boolean Menu(){

            int choose;
            System.out.println("\nВыбирите действие:");
            System.out.println("1 - Найти абонента:");
            System.out.println("2 - Добавить абонента:");
            System.out.println("3 - Добавить номер для абонента:");
            System.out.println("4 - Выйти");
            choose = EnterCorrectInt();
            scanner.nextLine();
            if (choose < 1 || choose > 4){
                System.out.println("Повторите ввод");
                return false;
            }
            else {
                switch (choose){
                    case 1:
                        SearchPers();
                        break;
                    case 2:
                        AddPers();
                        break;
                    case 3:
                        AddNum();
                        break;
                    case 4:
                        return true;
                }
            }
        return false;
    }

    //функция для добавления нового абонента
    public static void AddPers(){
        System.out.println("Введите имя абонента");
        String name = scanner.nextLine();

        if (phoneBook.containsKey(name)){
            System.out.println("Такой абонент уже существует");
        }
        else {
            System.out.println("Введите телефонный номер абонента");
            String phoneNum = scanner.nextLine();
            phoneBook.put(name,new Person(name));
            phoneBook.get(name).setNumber(phoneNum);
        }

    }

    //функция для добавления номера аббоненту
    public static void AddNum(){
        System.out.println("Введите имя абонента");
        String name = scanner.nextLine();
        System.out.println("Введите телефонный номер абонента");
        String phoneNum = scanner.nextLine();
        if (phoneBook.containsKey(name)){
            phoneBook.get(name).setNumber(phoneNum);
        }
        else System.out.println("Абонент не найден");
    }

    //функция для поиска нового абонента
    public static void SearchPers(){
        System.out.println("Введите имя абонента");
        String name = scanner.nextLine();
        if (phoneBook.containsKey(name)){
            System.out.println(phoneBook.get(name).getNumbers());
        }
        else System.out.println("Абонент не найден");

    }

    public static void Initialize(){
        phoneBook.put("Vadim",new Person("Vadim"));
        phoneBook.put("Max",new Person("Max"));
        phoneBook.put("Sveta",new Person("Sveta"));

        phoneBook.get("Vadim").setNumber("+79171112233");
        phoneBook.get("Max").setNumber("+79173334455");
        phoneBook.get("Sveta").setNumber("+79175556677");

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
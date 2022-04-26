package Lesson5_OOP;

import java.util.Scanner;

public class VadosStudy5 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Employee persArray[] = new Employee[5];

        persArray[0] = new Employee("Molchanov", "Vadim","Nilolaevich",25,"Engineer3");
        persArray[1] = new Employee("Ivanov", "Pavel","Sergeevich",30,"Engineer2");
        persArray[1].salary = 30000;
        persArray[2] = new Employee("Sidorchuk", "Sergei","Ivanovich",40,"Engineer1");
        persArray[2].salary = 50000;
        persArray[2].email = "SidorchukSI@mail.ru";
        persArray[2].phoneNum = 9384058456l;
        persArray[3] = new Employee("Karimov", "Artur","Arslanovich",35,"Head_of_Department");
        persArray[3].salary = 80000;
        persArray[3].email = "KarimovAA@mail.ru";
        persArray[3].phoneNum = 9379876541l;
        persArray[4] = new Employee("Pavlov", "Artem","Viktorovich",55,"Director");
        persArray[4].salary = 120000;
        persArray[4].email = "PavlovAV@mail.ru";
        persArray[4].phoneNum = 9549364545l;

        int search = 0;
        while (search < 1 || search > 2) {
            System.out.println("Какую информацию вывести?:\n1: Общую\n2: Подробную");
            search = EnterCorrectInt();
        }

        System.out.println("Искать сотрудников возрастом");
        System.out.println("От: ");
        int searchFrom = EnterCorrectInt();
        System.out.println("До: ");
        int searchTo = EnterCorrectInt();

        for (int i = 0; i < persArray.length;i++){
            int searchAge;
            if (persArray[i].getAge() >= searchFrom && persArray[i].getAge() <= searchTo){
                if (search == 1) persArray[i].printInfo();
                else persArray[i].printAllInfo();
            }
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

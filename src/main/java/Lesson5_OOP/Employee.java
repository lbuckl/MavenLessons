package Lesson5_OOP;

public class Employee {
    /**
     * При создании сотрудника обязательными будут поля помеченные как (обязательное поле),
     * иначе в объекте нет никакого смысла
     */
    //Неизменяемые поля
    private String firstName; // имя (обязательное поле)
    private String secondName; // фамилия (обязательное поле)
    private String patronymic; // отчество (обязательное поле)
    //Изменяемые поля
    protected String position; // должность (обязательное поле)
    public String email; // мыло
    public long phoneNum; // номер телефона
    protected int salary; // зарплата
    protected int age; // возраст (обязательное поле)
    private int MROT; //Минимальный размер оплаты труда

    private int id;
    private static int counter = 1;

    {
        id = counter++;
    }

    //Инициализация данных не входящих в обязательные поля конструктора
    {
        email = "No"; // если емайл не указан
        phoneNum = 0; // если телефон не указан
        MROT = 15000; // МРОТ
        salary = MROT; // Минимальная зп в компании
    }

    //конструктор
    Employee(String secondName, String firstName, String patronymic, int age, String position){
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.age = age;
        this.position = position;
    }

    //region Сетеры для возможности внесения изменений в защищённые парпметры сотрудника

    //Изменяем возраст (но скорее всего это будет делать функция по дате)
    public void setAge(int age) {
        if (age <= 18){
            this.age = 18;
        }
        else
            this.age = age;
    }

    //Изменяем должность
    public void setPosition(String position) {
        this.position = position;
    }

    // Изменяем зарплату
    public void setSalary(int salary) {
        if (salary < MROT){
            this.salary = MROT;
        }
        else
            this.salary = salary;
    }
    //endregion

    //region Гетеры для возможности извлечь данные из защищённых параметров

    //Вернуть ФИО
    public String getName() {
        return (secondName + " " + firstName + " " + patronymic);
    }

    //Вернуть должность
    public String getPosition() {
        return position;
    }

    //Вернуть возраст
    public int getAge() {
        return age;
    }

    //Вернуть зарплату (комично получилось)
    public int getSalary() {
        return salary;
    }
    //endregion

    //region Вывод в консоль
    //Выводим только основную информацию
    public void printInfo(){
        System.out.printf("Id: %d\nФамилия: %s\tИмя: %s\tОтчество: %s\tДолжность: %s\n",
                id,secondName,firstName,patronymic,position);
    }

    // Выводим информацию с контактными данными
    public void printAllInfo(){
        String num;
        if (phoneNum == 0) num = "No";
        else num = "+" + phoneNum;

        System.out.printf("Id: %d\nФамилия: %s\tИмя: %s\tОтчество: %s\tВозраст: %s\n" +
                "Должность: %s\t/Зарплата: %d\t/Tелефон: %s\t/Email: %s\n",
                id,secondName,firstName,patronymic,age,position,salary,num,email);
    }
    //endregion
}
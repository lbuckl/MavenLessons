package Lesson14_Logs;

public class NotFind4Exeption extends Exception { // Наследуемся от Exeptions, чтобы можно было создать ловца
    public NotFind4Exeption(String message) {
        super(message);
    }

}
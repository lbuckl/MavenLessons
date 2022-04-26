package Lesson9_Errors.MyExeptions;

public class MyArrayDataException extends Exception { // Наследуемся от Exeptions, чтобы можно было создать ловца
    public MyArrayDataException(String message) {
        super(message);
    }

}

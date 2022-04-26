package Lesson9_Errors.MyExeptions;

public class MyArraySizeException extends Exception { // Наследуемся от Exeptions, чтобы можно было создать ловца
    public MyArraySizeException(String message) {
        super(message);
    }

}


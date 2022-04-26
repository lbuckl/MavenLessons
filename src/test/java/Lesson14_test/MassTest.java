package Lesson14_test;

import Lesson14_Logs.Search;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MassTest{

    Search search;

    @BeforeEach
    public void init(){
        search = new Search();
        //int arrTest1[] = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        //int arrTest2[] = new int[]{2, 3, 4, 1, 7};
    }

    @ParameterizedTest
    /*@CsvSource(
            {
                    "arrTest1, 1, 7",
                    "arrTest1, 1, 8",
                    "arrTest2, 2, 3",
                    "arrTest2, 3, 5",
            })*/
    @MethodSource("stringIntAndListProvider")
    public void massTestAdd(int tetsArr[], int a, int b){
        Assertions.assertTrue(search.chechNums(tetsArr,a,b));
    }

    static Stream stringIntAndListProvider() {
        int arrTest3[] = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        int arrTest4[] = new int[]{2, 3, 4, 1, 7};
        return Stream.of(arguments(arrTest3,1,7),
                arguments(arrTest3,1,8),
                arguments(arrTest4,2,3),
                arguments(arrTest4,3,5));
    }
}

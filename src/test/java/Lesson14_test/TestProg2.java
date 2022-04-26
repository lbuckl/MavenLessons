package Lesson14_test;

import Lesson14_Logs.Search;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

public class TestProg2 {
    Search search;

    @BeforeEach
    public void init(){
        new Search();
    }

    @Test
    public void Test1(){
        int arrTest[] = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        Assertions.assertTrue(search.chechNums(arrTest,1,2));
    }

    @Test
    public void Test2(){
        int arrTest[] = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        Assertions.assertTrue(search.chechNums(arrTest,9,2));
    }

    @Test
    public void Test3(){
        int arrTest[] = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        Assertions.assertFalse(search.chechNums(arrTest,9,2));
    }

    @Test
    public void Test4(){
        int arrTest[] = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        Assertions.assertFalse(search.chechNums(arrTest,4,7));
    }

    int arrTest1[] = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
    int arrTest2[] = new int[]{2, 3, 4, 1, 7};

}

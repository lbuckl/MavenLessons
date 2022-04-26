package Lesson14_test;

import Lesson14_Logs.CutArray;
import Lesson14_Logs.NotFind4Exeption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProg1 {

    CutArray cutArraytest;

    //private CutArray cutArrayTest;
    @BeforeEach
    public void init(){
        new CutArray();
    }

    @Test
    public void testReturnCustomArr1() throws NotFind4Exeption {
        int arrTest[] = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};

        Assertions.assertEquals(1,cutArraytest.returnCustomArr(arrTest,4)[0]);
        Assertions.assertEquals(7,cutArraytest.returnCustomArr(arrTest,4)[1]);
    }

    @Test
    public void testReturnCustomArr2() throws NotFind4Exeption {
        int arrTest[] = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};

        Assertions.assertEquals(2,cutArraytest.returnCustomArr(arrTest,4)[0]);
        Assertions.assertEquals(7,cutArraytest.returnCustomArr(arrTest,4)[1]);
    }

    @Test
    public void testReturnCustomArr3() throws NotFind4Exeption {
        int arrTest[] = new int[]{1, 2};

        Assertions.assertEquals(1,cutArraytest.returnCustomArr(arrTest,2)[0]);
        Assertions.assertEquals(7,cutArraytest.returnCustomArr(arrTest,2)[1]);
    }

    @Test
    public void testReturnCustomArr4() throws NotFind4Exeption {
        int arrTest[] = new int[]{1, 2};

        Assertions.assertEquals(2,cutArraytest.returnCustomArr(arrTest,1)[0]);
    }
}

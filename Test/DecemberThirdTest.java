import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DecemberThirdTest {

    DecemberThird test;

    @BeforeEach
    void initializeObject(){
       test = new DecemberThird();
    }

    @Test
    void shouldResetCounters() {
        //input
        test.setFaultCounter(5);

        //when
        test.resetCounters();

        //result
        assertEquals(0,test.getFaultCounter());
    }

    @Test
    void shouldReadFromFile() {
        //input

        //when
        test.setFile("Test/TestThird.txt");
        test.setScanner(test.getInputs());
        String line = test.getFileReader().nextLine();

        //result
        assertEquals("00100", line);
    }


    @Test
    void shouldCompareCountSetGamma() {
        //input
        ArrayList<Integer> test1 = new ArrayList<>(Arrays.asList(3,4,5));
        ArrayList<Integer> test0 = new ArrayList<>(Arrays.asList(1,2,3));
        test.setCountAll0(test0);
        test.setCountAll1(test1);

        //when
        test.compareCountSetGammaEpsilon();

        //result
        assertEquals("111", test.getGammaRate());
    }

    @Test
    void shouldCompareCountSetEpsilon() {
        //input
        ArrayList<Integer> test1 = new ArrayList<>(Arrays.asList(3,4,5));
        ArrayList<Integer> test0 = new ArrayList<>(Arrays.asList(1,2,3));
        test.setCountAll0(test0);
        test.setCountAll1(test1);

        //when
        test.compareCountSetGammaEpsilon();

        //result
        assertEquals("000", test.getEpsilonRate());
    }

    @Test
    void shouldFindFaultByComparing() {
        //input
        ArrayList<Integer> test1 = new ArrayList<>(Arrays.asList(3,4,5));
        ArrayList<Integer> test0 = new ArrayList<>(Arrays.asList(1,4,3));
        test.setCountAll0(test0);
        test.setCountAll1(test1);

        //when
        test.compareCountSetGammaEpsilon();

        //result
        assertEquals(1, test.getFaultCounter());
    }

    //add a test to check if the line.length() is always the same in each line
    //add a test to check if there are just 1 and 0 in each line
    //add a test to check empty lines

    @Test
    void shouldNotCountFaultsForEachIndexInLine() {
        //input
        int index = 0;
        test.setFile("Test/TestThird.txt");
        test.setScanner(test.getInputs());
        test.setLineLenght();

        //when
        test.countForEachIndexInLine(index);
        int result = test.getFaultCounter();

        //result
        assertEquals(0,result);
    }

    @Test
    void shouldCountForEachIndexInLine() {
        //input
        int index = 0;
        test.setFile("Test/TestThird.txt");
        test.setScanner(test.getInputs());
        test.setLineLenght();
        test.setScanner(test.getInputs());


        //when
        test.countForEachIndexInLine(index);
        int result = test.getIndexCountAll0(index);

        //result
        assertEquals(5,result);
    }

    @Test
    void fillCountArrays() {
    }

    @Test
    void stringToBinaryCode() {
    }

}
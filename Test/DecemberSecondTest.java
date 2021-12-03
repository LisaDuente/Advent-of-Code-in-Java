import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

class DecemberSecondTest {

    DecemberSecond testDecember;

    @BeforeEach
    void InitializeObject() {
        testDecember = new DecemberSecond();
    }

    @Test
    void shouldComputeTheRightAnswer() {
        //input
        testDecember.instructions = new File("Test/TestFile");

        //when
        int result = testDecember.DecemberSecondPart1();

        //result
        assertEquals(312,result);
    }

    @Test
    void shouldComputeRightDepth(){
        //input
        testDecember.instructions = new File("Test/TestFile");

        //when
        int result = testDecember.DecemberSecondPart1();

        //result
        assertEquals(26,testDecember.depth);
    }

    @Test
    void shouldComputeRightHorizontal(){
        //input
        testDecember.instructions = new File("Test/TestFile");

        //when
        int result = testDecember.DecemberSecondPart1();

        //result
        assertEquals(12,testDecember.horizontal);
    }

    @Test
    void shouldCountFaults(){
        //input
        testDecember.instructions = new File("Test/TestFile");

        //when
        int result = testDecember.DecemberSecondPart1();

        //result
        assertEquals(2,testDecember.faults);
    }

}
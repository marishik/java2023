package education;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskTest {
    @Test
    void EasyLevelCorrectCalcTaskScore(){
        String i = "easy";
        int expected = 1;
        int actual = education.Task.calcTaskScore(i);
        assertEquals(expected, actual);
    }

    @Test
    void MediumLevelCorrectCalcTaskScore(){
        String i = "medium";
        int expected = 2;
        int actual = education.Task.calcTaskScore(i);
        assertEquals(expected, actual);
    }

    @Test
    void HardLevelCorrectCalcTaskScore(){
        String i = "hard"; // hard or something else
        int expected = 3;
        int actual = education.Task.calcTaskScore(i);
        assertEquals(expected, actual);
    }
}
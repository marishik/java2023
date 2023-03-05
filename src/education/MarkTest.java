package education;
import education.Mark;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarkTest {
    @Test
    void ForwardEstimateIsUnsatisfactory() {
        long expected = 2;

        for (int i = 0; i<3; i++){
            int actual = education.Mark.CalcForwardEstimate(i, 6);
            assertEquals(expected, actual);
        }
    }

    @Test
    void ForwardEstimateIsSatisfactory() {
        int n = 3;
        long expected = 3;
        int actual = education.Mark.CalcForwardEstimate(n, 6);
        assertEquals(expected, actual);
    }

    @Test
    void ForwardEstimateIsGood() {
        int n = 4;
        long expected = 4;
        int actual = education.Mark.CalcForwardEstimate(n, 6);
        assertEquals(expected, actual);
    }

    @Test
    void ForwardEstimateIsExcellent() {
        int n = 5;
        int i = 6;
        long expected = 5;
        int actual = education.Mark.CalcForwardEstimate(n, 6);
        assertEquals(expected, actual);
        int deFacto = education.Mark.CalcForwardEstimate(i, 6);
        assertEquals(expected, actual);
    }

    @Test
    void DontHaveOppToPassExam(){
        int n = 1;
        boolean expected = false;
        boolean actual = education.Mark.HaveOppToPassExam(n);
        assertEquals(expected, actual);
    }

    void OppToPassExamIsYes(){
        int n = 5;
        boolean expected = true;
        boolean actual = education.Mark.HaveOppToPassExam(n);
        assertEquals(expected, actual);
    }

    @Test
    void CountPointsIsCorrect() {
        Task easy = new Task();
        Task medium = new Task();
        Task hard = new Task();
        Task[] testTasks = {easy, medium, hard};
        hard.setTaskScore("hard");
        int expected = 3;
        int actual = education.Mark.CalcResult(testTasks);
        assertEquals(expected, actual);
    }
}
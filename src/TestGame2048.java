import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestGame2048 extends Game {

    @Test
    void testGetColorByValue10(){
        //int[][] arr = {{10,20,30}, {5,7,8,99,14}, {}, {91}};
        Color expected = Color.NONE;
        Color actual = Game2048.getColorByValue(10);

        assertEquals(expected, actual);
    }

    @Test
    void testGetColorByValue2048(){
        //int[][] arr = {{10,20,30}, {5,7,8,99,14}, {}, {91}};
        Color expected = Color.MEDIUMVIOLETRED;
        Color actual = Game2048.getColorByValue(2048);

        assertEquals(expected, actual);
    }

    @Test
    void testCompressCouldBeDone(){
        int[] arr = {2, 0, 0, 2};
        boolean expected = true;
        boolean actual = Game2048.compressRow(arr);

        assertEquals(expected, actual);
    }

    @Test
    void testCompressRowCouldNotBeDone(){
        int[] arr = {2, 0, 0, 0};
        boolean expected = false;
        boolean actual = Game2048.compressRow(arr);

        assertEquals(expected, actual);
    }

//    @Test
//    void testMergeRowTrue(){
//        int[] arr = {2, 2, 0, 0};
//        boolean expected = true;
//        boolean actual = Game2048.mergeRow(arr);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testMergeRowFalse(){
//        int[] arr = {2, 0, 2, 0};
//        boolean expected = false;
//        boolean actual = Game2048.mergeRow(arr);
//
//        assertEquals(expected, actual);
//    }

}

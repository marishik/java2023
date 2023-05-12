import com.javarush.engine.cell.*;

import java.util.HashMap;

public class Game2048 extends Game{
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    public void initialize() {
        setScreenSize(SIDE, SIDE);
    }
}
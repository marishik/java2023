import com.javarush.engine.cell.*;

import java.util.HashMap;

public class Game2048 extends Game{
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame(){
        createNewNumber();
        createNewNumber();
    }

    private void drawScene(){

        for (int i = 0; i < SIDE; i++){
            for(int j = 0; j< SIDE; j++){
                setCellColoredNumber(i, j, gameField[j][i]);
            }
        }
    }

    /***
     * Генерирует с вероятностью 90% значение "2" и с вероятностью 10% значение "4" для первых значений в рандомную ячейку с координатами x и y.
     */
    private void createNewNumber(){
        int x = getRandomNumber(SIDE);
        int y = getRandomNumber(SIDE);
        int chance = getRandomNumber(10);

        while(true){
            if(gameField[x][y] == 0){
                if (chance == 9)
                    gameField[x][y] = 4;
                else
                    gameField[x][y] = 2;

                break;
            }
            else
            {
                while(gameField[x][y] != 0){
                    x = getRandomNumber(SIDE);
                    y = getRandomNumber(SIDE);
                }
            }
        }
    }

    /***
     * Метод устанавливает цвета для всех возможных значений (которые будут реализованы в игре) в клетке и возвращает цвет для необходимого значения
     * @param value - числовое значение в ячейке
     */
    private Color getColorByValue(int value){
        HashMap<Integer, Color> colorByValue = new HashMap<>();
        colorByValue.put(0, Color.LAVENDERBLUSH);
        colorByValue.put(2, Color.LAVENDER);
        colorByValue.put(4, Color.THISTLE);
        colorByValue.put(8, Color.ORCHID);
        colorByValue.put(16, Color.MEDIUMORCHID);
        colorByValue.put(32, Color.DARKORCHID);
        colorByValue.put(64, Color.BLUEVIOLET);
        colorByValue.put(128, Color.DARKVIOLET);
        colorByValue.put(264, Color.PURPLE);
        colorByValue.put(512, Color.DARKMAGENTA);
        colorByValue.put(1024, Color.MEDIUMVIOLETRED);
        colorByValue.put(2048, Color.VIOLET);

        return colorByValue.get(value);
    }

    /***
     * Метод вычисляет цвет клетки (используя метод getColorByValue) и отображает значение и цвет клетки на игровом поле.
     * @param x - координата x
     * @param y - координата y
     * @param value - значение в ячейке
     */
    private void setCellColoredNumber(int x, int y, int value){
        Color currentColor = getColorByValue(value);
        String currentValue = String.valueOf(value);
        if(value == 0)
            setCellValueEx(x, y, currentColor, "");
        else
            setCellValueEx(x, y, currentColor, currentValue);

    }

    /***
     * Метод "перебрасывает" все ненулевые элементы влево, а нули вправо
     * @param row
     * @return flag - сделана ли перестановка влево
     */
    private boolean compressRow(int[] row){
        boolean flag = false;
        for(int i = 0; i < row.length; i++){
            for (int j = 0; j < row.length - i - 1; j++) {
                if (row[j] == 0 && row[j + 1] == 0)
                    continue;
                if (row[j] == 0) {
                    row[j] = row[j + 1];
                    row[j + 1] = 0;
                    flag = true;
                }
            }
        }

        return flag;
    }
}
import com.javarush.engine.cell.*;

import java.util.HashMap;

public class Game2048 extends Game{
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;

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
        if(getMaxTileValue() == 2048){
            win();
        }
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
    public static Color getColorByValue(int value){
        switch (value) {
            case 0:
                return Color.WHITE;
            case 2:
                return Color.PLUM;
            case 4:
                return Color.SLATEBLUE;
            case 8:
                return Color.DODGERBLUE;
            case 16:
                return Color.DARKTURQUOISE;
            case 32:
                return Color.MEDIUMSEAGREEN;
            case 64:
                return Color.LIMEGREEN;
            case 128:
                return Color.DARKORANGE;
            case 256:
                return Color.SALMON;
            case 512:
                return Color.ORANGERED;
            case 1024:
                return Color.DEEPPINK;
            case 2048:
                return Color.MEDIUMVIOLETRED;
            default:
                return Color.NONE;
        }
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

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT) {
            moveLeft();
        }
        else if (key == Key.RIGHT) {
            moveRight();
        }
        else if (key == Key.DOWN) {
            moveDown();
        }
        else if (key == Key.UP) {
            moveUp();
        }
        else {
            return;
        }
        drawScene();
    }

    /***
     * Cдвигает элементы каждой строки матрицы gameField методом compressRow(int[]),
     * после соединяет их значения с помощью метода mergeRow(int[]),
     * а затем снова сдвигаем (так как после соединения могут образоваться пустые промежутки)
     */
    private void moveLeft() {
        boolean isNewNumberNeeded = false;
        for (int[] row : gameField) {
            boolean wasCompressed = compressRow(row);
            boolean wasMerged = mergeRow(row);
            if (wasMerged) {
                compressRow(row);
            }
            if (wasCompressed || wasMerged) {
                isNewNumberNeeded = true;
            }
        }
        if (isNewNumberNeeded) {
            createNewNumber();
        }
    }


    // moveRight, moveDown, moveUp реализованы так, что мы вращаем gameField до тех пор, пока не придется сдвигать элементы влево,
    // а метод для сдвигания влево уже есть, так что пользуемся им. В конце возвращем gameField в исходное положение
    private void moveRight() {
        rotateXtimes(2);
        moveLeft();
        rotateXtimes(2);
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateXtimes(3);
    }

    private void moveUp() {
        rotateXtimes(3);
        moveLeft();
        rotateClockwise();
    }

    /***
     * Метод "перебрасывает" все ненулевые элементы влево, а нули вправо
     * @param row
     * @return flag - сделана ли перестановка влево
     */
    public static boolean compressRow(int[] row){
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

    /***
     * Проверяет, были ли рядом в строке одинаковые значения, которые следует соединить
     * @return
     */
    public static boolean mergeRow(int[] row) {
        boolean flag = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] == row[i + 1] && row[i] != 0) {
                row[i] = row[i] * 2;
                row[i + 1] = 0;
                flag = true;
            }
        }

        return flag;
    }


    /***
     * Вращает матрицу gameField по часовой стрелке на 90 градусов
     */
    private void rotateClockwise(){
        int[][] newGameField = new int[SIDE][SIDE];
        for(int y = 0; y < gameField.length; y++){
            for (int i = 0; i < SIDE; i++) {
                for (int j = 0; j < SIDE; j++) {
                    newGameField[j][SIDE - 1 - i] = gameField[i][j];
                }
            }
        }
        gameField = newGameField;
    }

    /***
     * Считает максимальное значение, которое сейчас есть в матрице. Проверка на победу :)
     */
    public int getMaxTileValue(){
        int result = 0;

        for (int[] i : gameField) {
            for (int j : i)
                result = Math.max(result, j);
        }

        return result;
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.SILVER, "You win!", Color.TOMATO, 12);
    }

    private void rotateXtimes(int howManyTimes){
        while(howManyTimes > 0) {
            rotateClockwise();
            howManyTimes--;
        }
    }
}
package education;

import java.util.Random;

/*
Есть 3 задания с разной сложностью: легкое, среднее и сложное
Легкое - 1 балл, среднее - 2 балла, сложное - 3 балла
Чтобы получить оценку за задание, его необходимо выполнить (вау)
 */
public class Task {

    private int tasksCount = 6;
    private String difficulty;
    private Integer taskScore = 0; //есть метод который решает и сеттером устанавливается значение
    private Boolean isDone = decideToDo(); //есть метод который решает

    public int getTasksCount() {
        return tasksCount;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getTaskScore() {
        return taskScore;
    }

    public void setTaskScore(String difficulty) {
        this.taskScore = calcTaskScore(difficulty);
    }

    public boolean getIsDone() {
        return isDone;
    }

    /***
     * Метод рандомно выбирает, будет ли решено задание. Возвращает true/false
     */
    public static boolean decideToDo(){
        Random i = new Random();
        return i.nextBoolean();
    }

    /***
     * На вход подается параметр - название задания. В зависимости от имени (easy, medium, hard) происходит начисление баллов: 1, 2 или 3 балла соответственно
     */
    public static int calcTaskScore(String name){
        if (name == "easy")
            return 1;
        else if (name == "medium")
            return 2;
        else return 3;
    }

}

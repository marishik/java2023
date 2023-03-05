package education;

import java.util.Random;
import java.util.Scanner;

/*
Есть 3 задания с разной сложностью: легкое, среднее и сложное
Легкое - 1 балл, среднее - 2 балла, сложное - 3 балла
Чтобы получить оценку за задание, его необходимо выполнить (вау)
 */
public class Task {

    private int TasksCount = 6;
    private String Difficulty;
    private Integer TaskScore = 0; //есть метод который решает и сеттером устанавливается значение
    private Boolean IsDone = DecideToDo(); //есть метод который решает

    public int getTasksCount() {
        return TasksCount;
    }

    public String getDifficulty() {
        return Difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.Difficulty = difficulty;
    }

    public Integer getTaskScore() {
        return TaskScore;
    }

    public void setTaskScore(String difficulty) {
        this.TaskScore = CalcTaskScore(difficulty);
    }

    public boolean getIsDone() {
        return IsDone;
    }


    public static boolean DecideToDo(){
        Random i = new Random();
        return i.nextBoolean();
    }

    public static int CalcTaskScore(String name){
        if (name == "easy")
            return 1;
        else if (name == "medium")
            return 2;
        else return 3;
    }

}

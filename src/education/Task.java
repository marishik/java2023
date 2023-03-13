package education;

import java.util.Random;

/*
Есть 3 задания с разной сложностью: легкое, среднее и сложное
Легкое - 1 балл, среднее - 2 балла, сложное - 3 балла
Чтобы получить оценку за задание, его необходимо выполнить (вау)
 */
public class Task {
    private int tasksCount;
    private Integer taskScore;
    private Boolean isDone;

    public int getTasksCount() {
        return tasksCount;
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

    private Task() {
        this.tasksCount = 6;
        this.taskScore = 0;
        this.isDone = decideToDo();
    }

    public static class Builder {
        private int tasksCount;
        private Integer taskScore;
        private Boolean isDone;

        private Builder() {
        }

        public Task.Builder tasksCount() {
            this.tasksCount = tasksCount;

            return this;
        }

        public Task.Builder taskScore() {
            this.taskScore = taskScore;

            return this;
        }

        public Task.Builder isDone() {
            this.isDone = isDone;
            return this;

        }

        public Task build() {
            return new Task();
        }
    }

    public static Task.Builder builder() {
        return new Task.Builder();
    }

    /***
     * Метод рандомно выбирает, будет ли решено задание. Возвращает true/false
     */
    public static boolean decideToDo() {
        Random i = new Random();
        return i.nextBoolean();
    }

    /***
     * На вход подается параметр - уровень сложности задания. В зависимости от имени (easy, medium, hard) происходит начисление баллов: 1, 2 или 3 балла соответственно
     */
    public static int calcTaskScore(String name) {
        if (name.equals("easy"))
            return 1;
        else if (name.equals("medium"))
            return 2;
        else return 3;
    }
}
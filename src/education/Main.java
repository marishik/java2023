package education;

public class Main {
    public static void main(String[] args) {
        //Program.sayHello();
        //Program.sinusTable();

        Student me = Student.builder()
                .firstName("Марина")
                .lastName("Алексеева")
                .mark(new Mark())
                .build();
        Mark marinaMark = new Mark();

        me.setMark(marinaMark);

        Task easy = Task.builder()
                .tasksCount()
                .taskScore()
                .isDone()
                .build();
        Task medium = Task.builder()
                .tasksCount()
                .taskScore()
                .isDone()
                .build();
        Task hard = Task.builder()
                .tasksCount()
                .taskScore()
                .isDone()
                .build();

        Task[] tasks = {easy, medium, hard};

        for (int i = 0; i < tasks.length; i++) {
            boolean decision = tasks[i].getIsDone();

            if (decision && i == 0)
                easy.setTaskScore("easy");
            else if (decision && i == 1)
                medium.setTaskScore("medium");
            else hard.setTaskScore("hard");
        }
        marinaMark.setResult(tasks);
        marinaMark.setForwardEstimate(easy);
        me.setMark(marinaMark);

        me.showTheResult();
    }
}
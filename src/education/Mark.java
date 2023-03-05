package education;

/*
 Result это сумма баллов за 3 задания (из 6 баллов)
 Чтобы иметь возможность сдать экзамен (получить допуск) нужно набрать минимум 3 балла
 (т.е если будет сделано только easy, а medium и hard - нет, то в сумме будет 1 балл и допуска не будет
 Предварительная оценка за дисциплину рассчитывается по проценту выполненной работы, где 6 в моем случае - максимум
*/
public class Mark {
    private int Result;
    private Boolean OpportunityToPassExam = false;
    private int ForwardEstimate;

    public Integer getResult() {
        return Result;
    }

    public void setResult(Task[] tasks) {
        this.Result = CalcResult(tasks);
    }

    public boolean getOpportunityToPassExam() {
        this.OpportunityToPassExam = HaveOppToPassExam(Result);
        return OpportunityToPassExam;
    }


    public int getForwardEstimate() {
        return ForwardEstimate;
    }

    public void setForwardEstimate(Task task) {
        int tasksCount = task.getTasksCount();
        ForwardEstimate = CalcForwardEstimate(Result, tasksCount);
    }

    public static int CalcResult(Task[] tasks){
        int valueCounter = 0;
        for(int i = 0; i<tasks.length; i++)
            valueCounter += tasks[i].getTaskScore();

        return valueCounter;
    }

    public static boolean HaveOppToPassExam(int result){
        if (result >= 3)
            return true;
        else return false;
    }

    public static int CalcForwardEstimate(int result, int tasksCount){
        int percent = (int)((result * 100) / tasksCount);

        if(percent >=40 && percent <60)
            return 3;
        else if (percent >=60 && percent <80)
            return 4;
        else if (percent >=80)
            return 5;
        else return 2;
    }
}

package education;

/*
 Result это сумма баллов за 3 задания (из 6 баллов)
 Чтобы иметь возможность сдать экзамен (получить допуск) нужно набрать минимум 3 балла
 (т.е если будет сделано только easy, а medium и hard - нет, то в сумме будет 1 балл и допуска не будет
 Предварительная оценка за дисциплину рассчитывается по проценту выполненной работы, где 6 в моем случае - максимум
*/
public class Mark {
    private int result;
    private Boolean opportunityToPassExam;
    private int forwardEstimate;

    public Mark() {
        this.result = result;
        this.opportunityToPassExam = false;
        this.forwardEstimate = forwardEstimate;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Task[] tasks) {
        this.result = calcResult(tasks);
    }

    public boolean getOpportunityToPassExam() {
        this.opportunityToPassExam = haveOppToPassExam(result);
        return opportunityToPassExam;
    }

    public int getForwardEstimate() {
        return forwardEstimate;
    }

    public void setForwardEstimate(Task task) {
        int tasksCount = task.getTasksCount();
        forwardEstimate = calcForwardEstimate(result, tasksCount);
    }

    /***
     * На вход принимается массив заданий (экземпляров класса Task). Считается и возвращается итоговое количество баллов за все задания
     */
    public static int calcResult(Task[] tasks) {
        int valueCounter = 0;
        for (int i = 0; i < tasks.length; i++)
            valueCounter += tasks[i].getTaskScore();

        return valueCounter;
    }

    /***
     * Параметр на вход - итоговое количество баллов. Возвращает true/false как допуск или недопуск к экзамену
     */
    public static boolean haveOppToPassExam(int result) {
        return result >= 3;
    }

    /***
     * Параметры на вход: итоговое количество баллов студента, максимальное кол-во баллов за все задания. Возвращается оценка по пятибалльной шкале
     */
    public static int calcForwardEstimate(int result, int tasksCount) {
        int percent = (result * 100) / tasksCount;

        if (percent >= 40 && percent < 60)
            return 3;
        else if (percent >= 60 && percent < 80)
            return 4;
        else if (percent >= 80)
            return 5;
        else return 2;
    }
}

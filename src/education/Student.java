package education;

import java.util.List;

/*
задание выполняется студентом (решает, будет оно выполнено или нет, метод DecideToDo в классе Task.
у студента есть имя и фамилия, а также результаты по выполненной им работе.
он может получить информацию о том, сколько из 6 баллов он набрал, есть ли у него допуск к экзамену и
какая у него предварительная оценка
 */
public class Student {
    String FirstName;
    String LastName;
    Mark mark;

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public Student(){

    }
    public String getFirstName(){
        return FirstName;
    }

    public String getLastName(){
        return LastName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void ShowTheResult(){
        int result = mark.getResult();
        boolean opportunityToPassExam = mark.getOpportunityToPassExam();
        int forwardEstimate = mark.getForwardEstimate();

        System.out.println(FirstName + " " + LastName);
        System.out.println(HowManyPointsScored(result));
        System.out.println(HaveOppToPassExam(opportunityToPassExam));
        System.out.println(WhichForwardEstimate(forwardEstimate));
    }

    public static String HowManyPointsScored(int result){
        String resultOfTasks = "Баллов из 6 : " + Integer.toString(result);
        return resultOfTasks;
    }

    public static String HaveOppToPassExam(boolean opportunityToPassExam){
        String exam = "";
        if(opportunityToPassExam)
            exam = "Да";
        else exam = "Нет";

        String resultOfOpportunityToPass = "Допуск к экзамену: " + exam;
        return resultOfOpportunityToPass;
    }

    public static String WhichForwardEstimate (int forwardEstimate){
        String estimate = "Предварительная оценка (пятибалльная шкала) : " + Integer.toString(forwardEstimate);
        return estimate;
    }

}

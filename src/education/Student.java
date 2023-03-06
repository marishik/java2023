package education;

/*
задание выполняется студентом (решает, будет оно выполнено или нет, метод DecideToDo в классе Task.
у студента есть имя и фамилия, а также результаты по выполненной им работе.
он может получить информацию о том, сколько из 6 баллов он набрал, есть ли у него допуск к экзамену и
какая у него предварительная оценка
 */
public class Student {
    String firstName;
    String lastName;
    Mark mark;

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void showTheResult(){
        int result = mark.getResult();
        boolean opportunityToPassExam = mark.getOpportunityToPassExam();
        int forwardEstimate = mark.getForwardEstimate();

        System.out.println(firstName + " " + lastName);
        System.out.println(howManyPointsScored(result));
        System.out.println(haveOppToPassExam(opportunityToPassExam));
        System.out.println(whichForwardEstimate(forwardEstimate));
    }

    public static String howManyPointsScored(int result){
        return "Баллов из 6 : " + Integer.toString(result);
    }

    public static String haveOppToPassExam(boolean opportunityToPassExam){
        String exam = "";
        if(opportunityToPassExam)
            exam = "Да";
        else exam = "Нет";

        return "Допуск к экзамену: " + exam;
    }

    public static String whichForwardEstimate(int forwardEstimate){
        return "Предварительная оценка (пятибалльная шкала) : " + Integer.toString(forwardEstimate);
    }

}

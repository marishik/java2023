package education;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/*
задание выполняется студентом (решает, будет оно выполнено или нет, метод DecideToDo в классе Task)
у студента есть имя и фамилия, а также результаты по выполненной им работе.
он может получить информацию о том, сколько из 6 баллов он набрал, есть ли у него допуск к экзамену и
какая у него предварительная оценка
 */
public class Student {
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private Mark mark;

    @Builder
    private Student(String firstName, String lastName, Mark mark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mark = mark;
    }

    public void showTheResult() {
        int result = mark.getResult();
        boolean opportunityToPassExam = mark.getOpportunityToPassExam();
        int forwardEstimate = mark.getForwardEstimate();

        System.out.println(firstName + " " + lastName);
        System.out.println(howManyPointsScored(result));
        System.out.println(haveOppToPassExam(opportunityToPassExam));
        System.out.println(whichForwardEstimate(forwardEstimate));
    }

    public static String howManyPointsScored(int result) {
        return "Баллов из 6 : " + Integer.toString(result);
    }

    public static String haveOppToPassExam(boolean opportunityToPassExam) {
        String exam = "";
        if (opportunityToPassExam)
            exam = "Да";
        else exam = "Нет";

        return "Допуск к экзамену: " + exam;
    }

    public static String whichForwardEstimate(int forwardEstimate) {
        return "Предварительная оценка (пятибалльная шкала) : " + Integer.toString(forwardEstimate);
    }

}

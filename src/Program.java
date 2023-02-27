import java.util.Scanner;

public class Program {
    public static void sayHello()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = in.nextLine();
        System.out.println("Привет, " + name);
    }

    public static void sinusTable() {
        System.out.println("Таблица синусов от 0 до 45 градусов:\n");
        System.out.println("+------------------------+");
        System.out.printf("|%-10s | %-10s |\n", "degree", "sinus");
        System.out.println("+------------------------+");

            for (int k = 0; k < 50; k = k + 5){
                double angle = Math.toRadians(k);
                System.out.printf("|%-10s | %-10f |\n", k, Math.sin(angle));
                System.out.println("+------------------------+");
            }
    }
}

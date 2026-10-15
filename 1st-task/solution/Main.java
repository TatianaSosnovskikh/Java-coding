import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Выберите операцию для комплексных матриц:");
                System.out.println("1 - Сложить 2 матрицы");
                System.out.println("2 - Вычесть из одной матрицы другую");
                System.out.println("3 - Перемножить 2 матрицы");
                System.out.println("4 - Разделить одну матрицу на другую");
                System.out.println("5 - Транспонировать матрицу");
                System.out.println("6 - Найти определитель матрицы");
                System.out.println("0 - Выйти из программы");

                int cm = scanner.nextInt();

                if (cm == 0) {
                    System.out.println("Работа программы завершена\n");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Ошибка в вводе данных! Повторите попытку!");
                scanner.nextLine();
            }
        }
    }
}

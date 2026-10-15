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
                switch (cm) {
                    case 1:
                        addScan();
                        break;
                    case 2:
                        subtractScan();
                        break;
                    case 3:
                        multiplyScan();
                        break;
                    case 4:
                        divideScan();
                        break;
                    case 5:
                        transposeScan();
                        break;
                    case 6:
                        determinantScan();
                        break;
                    default:
                        System.out.println("Ошибка! Выберите из существующих операций!");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage() + "\n");
            } catch (ArithmeticException e) {
                System.out.println("Ошибка: " + e.getMessage() + "\n");
            } catch (Exception e) {
                System.out.println("Ошибка в вводе данных! Повторите попытку!");
                scanner.nextLine();
            }
        }
    }

    private static Matrix scanMatrix(String name) {
        System.out.println("Введите количество строк " + name + ": ");
        int r = scanner.nextInt();
        System.out.println("Введите количество столбцов " + name + ": ");
        int c = scanner.nextInt();

        Matrix matrix = new Matrix(r, c);
        System.out.println("Заполните матрицу " + name + ": ");

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.println("Ячейка [" + i + "][" + j + "], действительная часть: ");
                double real = scanner.nextDouble();
                System.out.println("Ячейка [" + i + "][" + j + "], мнимая часть: ");
                double imaginary = scanner.nextDouble();

                matrix.setElement(i, j, new Complex_number(real, imaginary));
            }
        }
        return matrix;
    }

    private static void addScan() {
        Matrix a = scanMatrix("A");
        Matrix b = scanMatrix("B");
        System.out.println("\nМатрица A: ");
        a.print();
        System.out.println("\nМатрица B: ");
        b.print();
        System.out.println("\nСумма A + B: ");

        a.add(b).print();
    }

    private static void subtractScan() {
        Matrix a = scanMatrix("A");
        Matrix b = scanMatrix("B");
        System.out.println("\nМатрица A: ");
        a.print();
        System.out.println("\nМатрица B: ");
        b.print();
        System.out.println("\nРазность A - B: ");

        a.subtract(b).print();
    }

    private static void multiplyScan() {
        Matrix a = scanMatrix("A");
        Matrix b = scanMatrix("B");
        System.out.println("\nМатрица A: ");
        a.print();
        System.out.println("\nМатрица B: ");
        b.print();
        System.out.println("\nПроизведение A * B: ");

        a.multiply(b).print();
    }

    private static void divideScan() {
        Matrix a = scanMatrix("A");
        Matrix b = scanMatrix("B");
        System.out.println("\nМатрица A: ");
        a.print();
        System.out.println("\nМатрица B: ");
        b.print();
        System.out.println("\nПроизведение A / B: ");

        a.divide(b).print();
    }

    private static void transposeScan() {
        Matrix a = scanMatrix("A");
        System.out.println("\nМатрица A: ");
        a.print();
        System.out.println("\nТранспонированная матрица A^T: ");

        a.transpose().print();
    }

    private static void determinantScan() {
        Matrix a = scanMatrix("A");
        System.out.println("\nМатрица A: ");
        a.print();
        System.out.println("\nОпределитель det(A): " + a.determinant().toString());
    }
}

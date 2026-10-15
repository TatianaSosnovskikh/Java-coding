public class Main {

    public static void main(String[] args) {
        Matrix mat1 = new Matrix(3, 3);
        Complex_number num1 = new Complex_number(3.0, 5.0);
        Complex_number num2 = new Complex_number(7.0, 5.0);
        Complex_number num3 = new Complex_number(0.0, 0.0);
        mat1.setElement(0, 0, num1);
        mat1.setElement(0, 1, num1);
        mat1.setElement(0, 2, num1);
        mat1.setElement(1, 0, num2);
        mat1.setElement(1, 1, num2);
        mat1.setElement(1, 2, num3);
        mat1.setElement(2, 0, num3);
        mat1.setElement(2, 1, num2);
        mat1.setElement(2, 2, num3);
        Matrix mat2 = mat1.divide(mat1);

        mat2.print();
    }
}

public class Main {

    public static void main(String[] args) {
        Matrix mat1 = new Matrix(3, 3);
        Complex_number num1 = new Complex_number(3.0, 5.0);
        mat1.setElement(1, 2, num1);
        Matrix mat2 = mat1.add(mat1);
        Matrix mat3 = mat1.subtract(mat2);

        mat2.print();
        mat3.print();
    }
}

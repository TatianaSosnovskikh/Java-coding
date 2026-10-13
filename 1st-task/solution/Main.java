public class Main {

    public static void main(String[] args) {
        Matrix mat1 = new Matrix(3, 3);
        Complex_number num1 = new Complex_number(3.0, 5.0);
        mat1.setElement(1, 2, num1);

        System.out.println(mat1.getElement(1, 2).toString());
    }
}

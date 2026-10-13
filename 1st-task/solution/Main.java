public class Main {

    public static void main(String[] args) {
        Complex_number num1 = new Complex_number(3.0, 2.0);
        Complex_number num2 = new Complex_number(1.0, -5.0);
        Complex_number num3 = num1.add(num2);

        System.out.println(num3.toString());
    }
}

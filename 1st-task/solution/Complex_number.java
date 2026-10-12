public class Complex_number {
    private final double real;
    private final double imaginary;

    public Complex_number() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }

    public Complex_number(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

}
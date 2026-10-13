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

    public Complex_number add(Complex_number another) {
        double newReal = this.real + another.getReal();
        double newImaginary = this.imaginary + another.getImaginary();
        return new Complex_number(newReal, newImaginary);
    }

    public Complex_number subtract(Complex_number another) {
        double newReal = this.real - another.getReal();
        double newImaginary = this.imaginary - another.getImaginary();
        return new Complex_number(newReal, newImaginary);
    }

    public Complex_number multiply(Complex_number another) {
        double newReal = (this.real * another.getReal()) - (this.imaginary * another.getImaginary());
        double newImaginary = (this.real * another.getImaginary()) - (this.imaginary * another.getReal());
        return new Complex_number(newReal, newImaginary);
    }

    public Complex_number divide(Complex_number another) {
        double lower = (another.getReal() * another.getReal()) + (another.getImaginary() * another.getImaginary());
        if (lower == 0) {
            throw new ArithmeticException("Деление на ноль!");
        }
        double newReal = ((this.real * another.getReal()) + (this.imaginary * another.getImaginary())) / lower;
        double newImaginary = ((this.imaginary * another.getReal()) - (this.real * another.getImaginary())) / lower;
        return new Complex_number(newReal, newImaginary);
    }

}
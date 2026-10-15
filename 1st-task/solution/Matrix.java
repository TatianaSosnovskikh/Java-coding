public class Matrix {
    private int rows;
    private int cols;
    private Complex_number[][] nums;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.nums = new Complex_number[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nums[i][j] = new Complex_number();
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setElement(int row, int col, Complex_number data) {
        this.nums[row][col] = data;
    }

    public Complex_number getElement(int row, int col) {
        return this.nums[row][col];
    }

    public Matrix transpose() {
        Matrix result = new Matrix(this.cols, this.rows);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.setElement(j, i, this.nums[i][j]);
            }
        }
        return result;
    }

    public Matrix add(Matrix another) {
        if (this.rows != another.getRows() || this.cols != another.getCols()) {
            throw new IllegalArgumentException("Не совпадают размеры матриц!");
        }
        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.setElement(i, j, this.nums[i][j].add(another.getElement(i, j)));
            }
        }
        return result;
    }

    public Matrix subtract(Matrix another) {
        if (this.rows != another.getRows() || this.cols != another.getCols()) {
            throw new IllegalArgumentException("Не совпадают размеры матриц!");
        }
        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.setElement(i, j, this.nums[i][j].subtract(another.getElement(i, j)));
            }
        }
        return result;
    }

    public Matrix multiply(Matrix another) {
        if (this.cols != another.getRows()) {
            throw new IllegalArgumentException("Не совпадает количество столбцов с количеством строк!");
        }
        Matrix result = new Matrix(this.rows, another.getCols());
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < another.getCols(); j++) {
                Complex_number sum = new Complex_number();
                for (int k = 0; k < this.cols; k++) {
                    sum = sum.add(this.nums[i][k].multiply(another.getElement(k, j)));
                }
                result.setElement(i, j, sum);
            }
        }
        return result;
    }

    public Complex_number determinant() {
        if (this.rows != this.cols) {
            throw new IllegalArgumentException("Задана не квадратная матрица!");
        }
        return calcDeterminant(this.nums);
    }

    private Complex_number calcDeterminant(Complex_number[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            return matrix[0][0].multiply(matrix[1][1]).subtract(matrix[0][1].multiply(matrix[1][0]));
        }
        Complex_number det = new Complex_number();
        for (int i = 0; i < n; i++) {
            Complex_number[][] minor = new Complex_number[n - 1][n - 1];
            for (int j = 1; j < n; j++) {
                int subCol = 0;
                for (int k = 0; k < n; k++) {
                    if (k != i) {
                        minor[j - 1][subCol++] = matrix[j][k];
                    }
                }
            }
            Complex_number sign = (i % 2 == 0) ? new Complex_number(1, 0) : new Complex_number(-1, 0);
            Complex_number tail = matrix[0][i].multiply(sign).multiply(calcDeterminant(minor));
            det = det.add(tail);
        }
        return det;
    }

    public Matrix inverse() {
        Complex_number det = this.determinant();
        if (det.getReal() == 0 && det.getImaginary() == 0) {
            throw new ArithmeticException("Не существует обратной матрицы!");
        }
        Matrix extra = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                Complex_number[][] minor = new Complex_number[this.rows - 1][this.cols - 1];
                int minorR = 0;
                for (int r = 0; r < this.rows; r++) {
                    if (r != i) {
                        int minorC = 0;
                        for (int c = 0; c < this.cols; c++) {
                            if (c != j) {
                                minor[minorR][minorC++] = this.nums[r][c];
                            }
                        }
                        minorR++;
                    }
                }
                Complex_number sign = ((i + j) % 2 == 0) ? new Complex_number(1, 0) : new Complex_number(-1, 0);
                extra.setElement(i, j, sign.multiply(calcDeterminant(minor)));
            }
        }
        Matrix transposedExtra = extra.transpose();
        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.setElement(i, j, transposedExtra.getElement(i, j).divide(det));
            }
        }
        return result;
    }

    public Matrix divide(Matrix another) {
        return this.multiply(another.inverse());
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("[" + nums[i][j] + "]\t");
            }
            System.out.println();
        }
    }
}

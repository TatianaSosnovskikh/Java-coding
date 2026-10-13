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

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("[" + nums[i][j] + "]\t");
            }
            System.out.println();
        }
    }
}

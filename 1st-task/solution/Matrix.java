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
}

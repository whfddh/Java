public class Matrix <T extends Comparable<T>> {
    private T[][] array;
    private int numRows;
    private int numColumns;

    public Matrix(T[][] array) {
        this.array = array;
        this.numRows = array.length;
        this.numColumns = array[0].length;
    }

    public Matrix(int numRows, int numColumns) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        array = (T[][]) new Object[numRows][numColumns];
    }

    public T get(int row, int col){
        return array[row][col];
    }
    public void set(int row, int col, T value) {
        array[row][col] = value;
    }
    public Matrix<T> add(Matrix<T> other) {
        if (numRows != other.numRows || numColumns != other.numColumns) {
            throw new IllegalArgumentException("Matrix dimensions must be the same for addition.");
        }

        Matrix<T> result = new Matrix<>(numRows, numColumns);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                result.set(i, j, addValues(get(i, j), other.get(i, j)));
            }
        }
        return result;
    }

    public Matrix<T> subtract(Matrix<T> other) {
        if (numRows != other.numRows || numColumns != other.numColumns) {
            throw new IllegalArgumentException("Matrix dimensions must be the same for subtraction.");
        }

        Matrix<T> result = new Matrix<>(numRows, numColumns);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                result.set(i, j, subtractValues(get(i, j), other.get(i, j)));
            }
        }
        return result;
    }

    public Matrix<T> multiply(Matrix<T> other) {
        if (numColumns != other.numRows) {
            throw new IllegalArgumentException("The number of columns in the first matrix must be equal to the number of rows in the second matrix for multiplication.");
        }

        Matrix<T> result = new Matrix<>(numRows, other.numColumns);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < other.numColumns; j++) {
                T sum = null;
                for (int k = 0; k < numColumns; k++) {
                    T product = multiplyValues(get(i, k), other.get(k, j));
                    sum = (sum == null) ? product : addValues(sum, product);
                }
                result.set(i, j, sum);
            }
        }
        return result;
    }

    private T addValues(T a, T b) {
        return a;
    }

    private T subtractValues(T a, T b) {
        return a;
    }

    private T multiplyValues(T a, T b) {
        return a;
    }
}

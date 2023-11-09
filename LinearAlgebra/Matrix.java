package LinearAlgebra;

public class Matrix {
    private Vector rows[];

    public Matrix(int m, int n) {
        rows = new Vector[m];
        for (int i = 0; i < m; i++)
            rows[i] = new Vector(n);
    }

    public Matrix(Vector rows[]) {
        this.rows = rows;
    }

    public int rows() {
        return rows.length;
    }

    public int cols() {
        return rows[0].size();
    }

    public Vector getRow(int i) {
        return rows[i];
    }

    public Vector getCol(int j) {
        Vector col = new Vector(rows());
        for (int i = 0; i < rows(); i++)
            col.set(i, rows[i].get(j));
        return col;
    }

    public void setRow(int i, Vector row) {
        rows[i] = row;
    }

    public void setCol(int j, Vector col) {
        for (int i = 0; i < rows(); i++)
            rows[i].set(j, col.get(i));
    }

    public Matrix add(Matrix other) {
        if (rows() != other.rows() || cols() != other.cols())
            throw new IllegalArgumentException("Matrix sizes don't match");
        Matrix result = new Matrix(rows(), cols());
        for (int i = 0; i < rows(); i++)
            result.setRow(i, getRow(i).add(other.getRow(i)));
        return result;
    }

    public Matrix subtract(Matrix other) {
        if (rows() != other.rows() || cols() != other.cols())
            throw new IllegalArgumentException("Matrix sizes don't match");
        Matrix result = new Matrix(rows(), cols());
        for (int i = 0; i < rows(); i++)
            result.setRow(i, getRow(i).subtract(other.getRow(i)));
        return result;
    }

    public Matrix multiply(double scalar) {
        Matrix result = new Matrix(rows(), cols());
        for (int i = 0; i < rows(); i++)
            result.setRow(i, getRow(i).multiply(scalar));
        return result;
    }

    public Matrix multiply(Matrix other) {
        if (cols() != other.rows())
            throw new IllegalArgumentException("Matrix sizes don't match");
        Matrix result = new Matrix(rows(), other.cols());
        for (int i = 0; i < rows(); i++)
            for (int j = 0; j < other.cols(); j++)
                result.set(i, j, getRow(i).dot(other.getCol(j)));
        return result;
    }

    public double get(int i, int j) {
        return rows[i].get(j);
    }

    public void set(int i, int j, double value) {
        rows[i].set(j, value);
    }

    public void print() {
        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < cols(); j++)
                System.out.printf("%f ", get(i, j));
            System.out.println();
        }
        System.out.println();
    }

    
    
    
}

package LinearAlgebra;

public class index {

    public static void main(String[] args) {
        Matrix A = new Matrix(3,3);
        Matrix B = new Matrix(3,3);
        A.print();
        B.print();

        Matrix C = A.add(B);
        C.print();
        Matrix D = A.multiply(B);
        D.print();
    }
    
}

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class MatrixTest {
    public static void main(String[] args) {
        double[][] A = {
                {0.1950, 0.0311},
                {0.3588, 0.2203},
                {0.1716, 0.5931},
                {0.2105, 0.3242}};

        double[][] B = {
                {0.0502, 0.9823, 0.9472},
                {0.5732, 0.2694, 0.916}};

        RealMatrix aRealMatrix = new Array2DRowRealMatrix(A);
        RealMatrix bRealMatrix = new Array2DRowRealMatrix(B);

        RealMatrix cRealMatrix = aRealMatrix.multiply(bRealMatrix);
        System.out.println();
        for (int i = 0; i < cRealMatrix.getRowDimension(); i++) {
            System.out.println(cRealMatrix.getRowVector(i));
        }
    }

}

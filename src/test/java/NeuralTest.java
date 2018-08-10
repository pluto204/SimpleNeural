import java.util.ArrayList;
import java.util.List;

public class NeuralTest {
    public static void main(String[] args) {
        List<Double[]> matA = new ArrayList<>();
        List<Double[][]> matB = new ArrayList<>();

        matA.add(new Double[]{1.,2.});
        matA.add(new Double[]{3.,4.});
        matA.add(new Double[]{5.,6.});

        matB.add(new Double[][]{{},{}});
        matB.add(new Double[][]{{},{}});
        matB.add(new Double[][]{{},{}});
    }
}

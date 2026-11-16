public class GradientDescent {

    public static void main(String[] args) {

        double x = 2;          
        double learningRate = 0.1;
        int iterations = 100;

        for (int i = 1; i <= iterations; i++) {

            double gradient = 2 * (x + 3);

            x = x - learningRate * gradient;

            System.out.println("Iteration " + i + ": x = " + x);
        }

        double y = Math.pow(x + 3, 2);

        System.out.println("\nLocal Minimum:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
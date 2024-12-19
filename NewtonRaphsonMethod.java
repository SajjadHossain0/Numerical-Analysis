import java.util.Scanner;

public class NewtonRaphsonMethod {

    public static double function(double x) {
        return x * x * x - x - 1;
    }

    public static double derivative(double x) {
        return 3 * x * x - 1;
    }

    public static void newtonRaphson(double a, double b, double accuracy) {

        double x0 = (a + b) / 2, x1;
        int iteration = 0;

        do {
            iteration++;
            x1 = x0 - function(x0) / derivative(x0);

            System.out.println("Iteration " + iteration + ": x = " + x1 + ", f(x) = " + function(x1));

            x0 = x1;
        } while (!(function(x1) <= accuracy && function(x1) >= -accuracy));

        System.out.println("The root is approximately: x = " + x1);
        System.out.println("Found after " + iteration + " iterations.");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the initial a : ");
        double a = input.nextDouble();

        System.out.print("Enter the initial b : ");
        double b = input.nextDouble();

        System.out.print("Enter the accuracy (e.g., 0.0001): ");
        double accuracy = input.nextDouble();

        newtonRaphson(a, b, accuracy);

        input.close();
    }
}

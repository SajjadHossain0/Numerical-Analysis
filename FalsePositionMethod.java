import java.util.Scanner;

public class FalsePositionMethod {

    public static double function(double x) {
        return x * x * x - x - 1;
    }

    public static void falsePosition(double a, double b, double accuracy) {

        if (function(a) * function(b) >= 0) {
            System.out.println("Invalid initial guesses, no sign change in the interval [a, b].");
            return;
        }

        double c = a;
        while (!(function(c) <= accuracy && function(c) >= -accuracy)) {

            c = a - function(a) * (b - a) / (function(b) - function(a));

            System.out.println("Current approximation of root: x = " + c + ", f(x) = " + function(c));

            if (function(c) * function(a) < 0) {
                b = c;
            } else {
                a = c;
            }
        }

        System.out.println("The root is approximately: x = " + c);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the initial guess for a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter the initial guess for b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter the desired accuracy (e.g., 0.0001): ");
        double accuracy = scanner.nextDouble();

        falsePosition(a, b, accuracy);

        scanner.close();
    }
}

import java.util.Scanner;

public class BisectionMethod {

    // Define the function for which you want to find the root
    public static double function(double x) {
        return 2 * x * x * x - 3 * x * x - 2;  // Example: f(x) = x^3 - x^2 + 2
    }

    // Bisection Method to find the root
    public static void bisection(double a, double b, double accuracy) {
        if (function(a) * function(b) >= 0) {
            System.out.println("Invalid initial guesses, no sign change in the interval [a, b].");
            return;
        }

        double c = a;  // Initialize result
        while ((b - a) >= accuracy) {  // Continue until the interval is very small

            // Find the midpoint
            c = (a + b) / 2;

            // Check if midpoint is the root
            if (function(c) == 0.0) {
                break;
            }

            // Decide the side to repeat the process
            if (function(c) * function(a) < 0) {
                b = c;
            } else {
                a = c;
            }

            System.out.println("Current approximation of root of the function : x = " + c + ", f(x) = " + function(c));
        }

        System.out.println("The root is approximately: x = " + c);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input interval [a, b]
        System.out.print("Enter the initial guess for a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter the initial guess for b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter the initial guess for accuracy: ");
        double accuracy = scanner.nextDouble();

        // Call the Bisection Method
        bisection(a, b, accuracy);

        scanner.close();
    }
}

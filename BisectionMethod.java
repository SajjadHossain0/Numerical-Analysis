import java.util.Scanner;

public class BisectionMethod {

    public static double function(double x) {
        return 2 * x * x * x - 3 * x * x - 2; 
    }

    public static void bisection(double a, double b, double accuracy) {
        if (function(a) * function(b) >= 0) {
            System.out.println("Invalid initial guesses, no sign change in the interval [a, b].");
            return;
        }

        double c = a;
        while ((b - a) >= accuracy) {  

            c = (a + b) / 2;

            if (function(c) == 0.0) {
                break;
            }

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

        System.out.print("Enter the initial guess for a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter the initial guess for b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter the initial guess for accuracy: ");
        double accuracy = scanner.nextDouble();

        bisection(a, b, accuracy);

        scanner.close();
    }
}

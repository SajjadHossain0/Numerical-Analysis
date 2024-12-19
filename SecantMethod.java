import java.util.Scanner;

public class SecantMethod {

    static double f(double x) {
        return x * x * x - x - 1;
    }

    static void secant(double a, double b, double accuracy) {
        double c;

        System.out.println("Iteration\t a\t\t b\t\t c\t\t f(c)");

        int iteration = 1;

        while (true) {

            c = a - f(a) * (b - a) / (f(b) - f(a));

            System.out.printf("%d\t\t %.6f\t %.6f\t %.6f\t %.6f\n", iteration, a, b, c, f(c));

            if (Math.abs(f(c)) <= accuracy) {
                System.out.printf("Approximate root found at c =  %.6f\n", c);
                break;
            }

            a = b;
            b = c;

            iteration++;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the initial guess of a = ");
        double a = input.nextDouble();
        System.out.print("Enter the initial guess of b = ");
        double b = input.nextDouble();
        System.out.print("Enter the accuracy = ");
        double accuracy = input.nextDouble();

        secant(a, b, accuracy);

        input.close();
    }
}

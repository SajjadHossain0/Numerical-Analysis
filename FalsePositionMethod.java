import java.util.Scanner;

public class FalsePositionMethod {

    public static double f(double x) {
        return x * x * x - x - 1;
    }

    public static void falsePosition(double a, double b, double accuracy) {

        if(f(a) * f(b) >= 0){
            System.out.println("Wrong value of a and b, please try again");
            return;
        }

        double c = a;
        int iteration = 0;
        while (!(f(c) <= accuracy && f(c) >= -accuracy)) {

            c = a - f(a) * (b - a) / (f(b) - f(a));

            System.out.println("Current approximation of root: x = " + c + ", f(x) = " + f(c));

            if (f(a) * f(c) < 0) {
                b = c;
            } else {
                a = c;
            }
            iteration++;
        }

        System.out.println("The root is approximately: x = " + c);
        System.out.println("In the "+iteration+" iterations.");

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

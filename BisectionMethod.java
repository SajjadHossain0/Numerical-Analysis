import java.util.Scanner;

class BisectionMethod {

    public static double f(double x) {
        return x*x*x - x - 1;
    }

    public static void bisection(double a, double b, double accuraccy){
        if(f(a) * f(b) >= 0){
            System.out.println("Wrong value of a and b, please try again");
            return;
        }

        double c = a;
        int iteration = 0;

        while(!(f(c) <= accuraccy && f(c) >= -accuraccy)){
            c = (a + b) / 2;

            System.out.println("Current Approximate root c = "+c+", f(c) = "+f(c));

            if (f(c) == 0.0){
                break;
            }
            else if (f(a) * f(c) < 0){
                b = c;
            }
            else{
                a = c;
            }

            iteration++;
        }

        System.out.println("Approximate root found at c = "+c);
        System.out.println("In the "+iteration+" iterations.");

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the value of a = ");
        double a = input.nextDouble();
        System.out.print("Enter the value of b = ");
        double b = input.nextDouble();
        System.out.print("Enter the value of accuracy = ");
        double accuracy = input.nextDouble();

        bisection(a, b, accuracy);

        input.close();
    }
}

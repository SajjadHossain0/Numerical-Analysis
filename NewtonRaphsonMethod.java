import java.util.Scanner;

class NewtonRaphsonMethod{

    public static double f(double x){
        return x*x*x - x - 1;
    }
    public static double derivative(double x){
        return 3*x*x - 1;
    }

    public static void newtonRaphson(double a, double b, double accuracy){
        if(f(a) * f(b) >= 0){
            System.out.println("The value of a and b is invalid, please try again");
            return;
        }

        double x0 = (a + b) / 2,x1;
        int iteration = 0;

        do{
            iteration++;

            x1 = x0 - (f(x0) / derivative(x0));

            System.out.println("Current root value is "+x1+", f(x0) = "+f(x0));

            x0 = x1;
        }
        while(!(f(x1) <= accuracy && f(x1) >= -accuracy));

        System.out.println("The root is approximately: x = " + x1);
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

        newtonRaphson(a, b, accuracy);

        input.close();
    }
}

package lab1;

import java.text.NumberFormat;
import java.util.Locale;

public class FibonacciMethod {
    public static float fibonacci(int n){
        float x = 1;
        float y = 1;
        for (int i = 2; i < n; i++) {
            y = x + y;
            x = y - x;
        }
        return y;
    }

    public static void fibonacciMethod(Function f, float a, float b, float eps) {
        NumberFormat nf2 = NumberFormat.getInstance(new Locale("sk", "SK"));
        nf2.setMaximumFractionDigits(4);
        int n = 2;
        long x = 1;
        long y = 1;
        while ((b - a)/eps > y) {
            n++;
            y = x + y;
            x = y - x;
        }
        n-=2;
        System.out.println("Iterations number: " + n);
        //System.out.println("Fibonacci number is: " + y);
        float x1 = a + fibonacci(n) / fibonacci(n + 2) * (b - a), x2 = a + fibonacci(n + 1) / fibonacci(n + 2) * (b - a);
        double f2 = f.execute(x2), f1 = f.execute(x1);
        System.out.println("1th interval: " + nf2.format(a) + " , " + nf2.format(b));
        System.out.println("Calculated points are: " + nf2.format(x1) + " , " + nf2.format(x2));
        System.out.println("Calculated function values are: " + nf2.format(f1) + " , " + nf2.format(f2));
        for(int i = 2; i < n + 1; i++) {
            if(f1 < f2) b = x2;
            else a = x1;
            System.out.println(i + "th interval: " + nf2.format(a) + " , " + nf2.format(b));
            x1 = a + fibonacci(n - i + 1) / fibonacci(n - i + 3) * (b - a);
            x2 = a + fibonacci(n - i + 2) / fibonacci(n - i + 3) * (b - a);
            f1 = f.execute(x1);
            f2 = f.execute(x2);
            System.out.println("Calculated points are: " + nf2.format(x1) + " , " + nf2.format(x2));
            System.out.println("Calculated function values are: " + nf2.format(f1) + " , " + nf2.format(f2));
        }
        System.out.println("interval with minimum: [" + a + " ; " + b + "]");
        System.out.println("x = " + x1+ " f(x) = " + f.execute(x1));
        System.out.println("Iterations made: " + n);
    }

    public static void fibonacciMethodPart2(Function f, float a, float b, float eps) {
        NumberFormat nf2 = NumberFormat.getInstance(new Locale("sk", "SK"));
        nf2.setMaximumFractionDigits(10);
        int n = 2;
        long x = 1;
        long y = 1;
        while ((b - a)/eps > y) {
            n++;
            y = x + y;
            x = y - x;
        }
        n-=2;
        float x1 = a + fibonacci(n) / fibonacci(n + 2) * (b - a), x2 = a + fibonacci(n + 1) / fibonacci(n + 2) * (b - a);
        double f2 = f.execute(x2), f1 = f.execute(x1);
        for(int i = 2; i < n + 1; i++) {
            if(f1 < f2) b = x2;
            else a = x1;
            x1 = a + fibonacci(n - i + 1) / fibonacci(n - i + 3) * (b - a);
            x2 = a + fibonacci(n - i + 2) / fibonacci(n - i + 3) * (b - a);
            f1 = f.execute(x1);
            f2 = f.execute(x2);
        }
        System.out.println("Function called: " + n + " Accuracy: " + nf2.format(eps));
    }

    public static void main(String[] args) {
        Function func1 = Functions.action(1);
        Function func2 = Functions.action(2);
        Function func3 = Functions.action(3);
        Function func4 = Functions.action(4);
        Function func5 = Functions.action(5);

        fibonacciMethodPart2(func1, -0.5f, 0.5f, 0.1f);
        fibonacciMethodPart2(func1, -0.5f, 0.5f, 0.05f);
        fibonacciMethodPart2(func1, -0.5f, 0.5f, 0.03f);
        fibonacciMethodPart2(func1, -0.5f, 0.5f, 0.01f);
        fibonacciMethodPart2(func1, -0.5f, 0.5f, 0.001f);
        fibonacciMethodPart2(func1, -0.5f, 0.5f, 0.0005f);
        fibonacciMethodPart2(func1, -0.5f, 0.5f, 0.00005f);
        fibonacciMethodPart2(func1, -0.5f, 0.5f, 0.000001f);
        fibonacciMethodPart2(func1, -0.5f, 0.5f, 0.0000001f);
//        System.out.println("First function results:");
//        fibonacciMethod(func1, -0.5f, 0.5f, 0.1f);
//        System.out.println();
//        System.out.println("Second function results:");
//        fibonacciMethod(func2, 6f, 9.9f, 0.1f);
//        System.out.println();
//        System.out.println("Third function results:");
//        fibonacciMethod(func3, 0f, (float) (2 * Math.PI), 0.1f);
//        System.out.println();
//        System.out.println("Fourth function results:");
//        fibonacciMethod(func4, 0f, 1f, 0.1f);
//        System.out.println();
//        System.out.println("Fifth function results:");
//        fibonacciMethod(func5, 0.5f, 2.5f, 0.1f);

    }
}

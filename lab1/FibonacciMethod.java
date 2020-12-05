package lab1;

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
        int n = 2;
        long x = 1;
        long y = 1;
        while ((b - a)/eps > y) {
            n++;
            y = x + y;
            x = y - x;
        }
        n-=2;
        System.out.println("Iterations number: " + (n + 1));
        System.out.println("Fibonacci number is: " + y);
        float x1 = a + fibonacci(n) / fibonacci(n + 2) * (b - a), x2 = a + fibonacci(n + 1) / fibonacci(n + 2) * (b - a);
        System.out.println("Calculated points are: " + x1 + " , " + x2);
        System.out.println("Calculated function values are: " + f.execute(x1) + " , " + f.execute(x2));
        for(int i = 0; i < n + 1; i++) {
            System.out.println(i+1 + "th interval: " + a + " , " + b);
            if(f.execute(x1) < f.execute(x2)) b = x2;
            else a = x1;
            x1 = a + fibonacci(n - i + 1) / fibonacci(n - i + 3) * (b - a);
            x2 = a + fibonacci(n - i + 2) / fibonacci(n - i + 3) * (b - a);
            System.out.println("Calculated points are: " + x1 + " , " + x2);
            System.out.println("Calculated function values are: " + f.execute(x1) + " , " + f.execute(x2));
        }
        System.out.println("x = " + x1+ " f(x) = " + f.execute(x1));
        System.out.println("Iterations made: " + (n + 1));
    }

    public static void main(String[] args) {
        Function func1 = Functions.action(1);
        Function func2 = Functions.action(2);
        Function func3 = Functions.action(3);
        Function func4 = Functions.action(4);
        Function func5 = Functions.action(5);

        System.out.println("First function results:");
        fibonacciMethod(func1, -0.5f, 0.5f, 0.1f);
        System.out.println();
        System.out.println("Second function results:");
        fibonacciMethod(func2, 6f, 9.9f, 0.1f);
        System.out.println();
        System.out.println("Third function results:");
        fibonacciMethod(func3, 0f, (float) (2 * Math.PI), 0.1f);
        System.out.println();
        System.out.println("Fourth function results:");
        fibonacciMethod(func4, 0f, 1f, 0.1f);
        System.out.println();
        System.out.println("Fifth function results:");
        fibonacciMethod(func5, 0.5f, 2.5f, 0.1f);

    }
}

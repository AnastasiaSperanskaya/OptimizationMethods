package lab1;
import static java.lang.Math.abs;

public class DichotomyMethod {
    public static void dichotomyMethod(Function f, float a, float b, float eps) {
        float delta = eps / 3;
        float x1, x2, middle, x = 0;
        int iter = 0;
        while (abs(a-b) > eps) {
            iter++;
            System.out.println(iter + "th interval: " + a + " , " + b);
            middle = (a+b)/2;
            x = middle;
            x1 = middle - delta;
            x2 = middle + delta;
            System.out.println("Calculated points are: " + x1 + " , " + x2);
            System.out.println("Calculated function values are: " + f.execute(x1) + " , " + f.execute(x2));
            if (f.execute(x1) < f.execute(x2)) b = x2;
            else a = x1;
        }
        System.out.println("x = " + x + " f(x) = " + f.execute(x));
        System.out.println("Iterations made: " + iter);
    }

    public static void main(String[] args) {
        Function func1 = Functions.action(1);
        Function func2 = Functions.action(2);
        Function func3 = Functions.action(3);
        Function func4 = Functions.action(4);
        Function func5 = Functions.action(5);

        System.out.println("First function results:");
        dichotomyMethod(func1, -0.5f, 0.5f, 0.1f);
        System.out.println();
        System.out.println("Second function results:");
        dichotomyMethod(func2, 6f, 9.9f, 0.1f);
        System.out.println();
        System.out.println("Third function results:");
        dichotomyMethod(func3, 0f, (float) (2 * Math.PI), 0.1f);
        System.out.println();
        System.out.println("Fourth function results:");
        dichotomyMethod(func4, 0f, 1f, 0.1f);
        System.out.println();
        System.out.println("Fifth function results:");
        dichotomyMethod(func5, 0.5f, 2.5f, 0.1f);
    }
}

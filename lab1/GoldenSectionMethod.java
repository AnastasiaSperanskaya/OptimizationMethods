package lab1;
import java.lang.Math;

public class GoldenSectionMethod {

    public static void goldenSectionMethod(Function f, float a, float b, float eps) {

        float PHI = (float) ((3 - Math.sqrt(5)) / 2);
        float x1, x2, x;
        int iter = 0;
        while (true){
            iter++;
            System.out.println(iter + "th interval: " + a + " , " + b);
            x2 = b - (b - a) * PHI;
            x1 = a + (b - a) * PHI;
            System.out.println("Calculated points are: " + x1 + " , " + x2);
            System.out.println("Calculated function values are: " + f.execute(x1) + " , " + f.execute(x2));
            if (f.execute(x1) >= f.execute(x2))
                a = x1;
            else
                b = x2;
            if (Math.abs(b - a) < eps)
                break;
        }
        x = (b + a) / 2;
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
        goldenSectionMethod(func1, -0.5f, 0.5f, 0.1f);
        System.out.println();
        System.out.println("Second function results:");
        goldenSectionMethod(func2, 6f, 9.9f, 0.1f);
        System.out.println();
        System.out.println("Third function results:");
        goldenSectionMethod(func3, 0f, (float) (2 * Math.PI), 0.1f);
        System.out.println();
        System.out.println("Fourth function results:");
        goldenSectionMethod(func4, 0f, 1f, 0.1f);
        System.out.println();
        System.out.println("Fifth function results:");
        goldenSectionMethod(func5, 0.5f, 2.5f, 0.1f);
    }

}

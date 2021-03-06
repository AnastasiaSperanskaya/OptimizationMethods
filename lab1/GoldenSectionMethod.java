package lab1;
import java.lang.Math;
import java.text.NumberFormat;
import java.util.Locale;

public class GoldenSectionMethod {
    public static void goldenSectionMethod(Function f, float a, float b, float eps) {

        NumberFormat nf2 = NumberFormat.getInstance(new Locale("sk", "SK"));
        nf2.setMaximumFractionDigits(4);

        float PHI = (float) ((Math.sqrt(5) + 1) / 2);
        float x1, x2, x;
        int iter = 0;
        while (true){
            iter++;
            System.out.println(iter + "th interval: " + nf2.format(a) + " , " + nf2.format(b));
            x1 = b - (b - a) / PHI;
            x2 = a + (b - a) / PHI;
            double f1 = f.execute(x1);
            double f2 = f.execute(x2);
            System.out.println("Calculated points are: " + nf2.format(x1) + " , " + nf2.format(x2));
            System.out.println("Calculated function values are: " + nf2.format(f1) + " , " + nf2.format(f2));
            if (f1 >= f2)
                a = x1;
            else
                b = x2;
            if (Math.abs(b - a) < eps)
                break;
        }
        x = (b + a) / 2;
        System.out.println("next interval could be: [" + a + " ; " + b + "]");
        System.out.println("x = " + x + " f(x) = " + f.execute(x));
        System.out.println("Iterations made: " + iter);
    }

    public static void goldenSectionMethodPart2(Function f, float a, float b, float eps) {

        NumberFormat nf2 = NumberFormat.getInstance(new Locale("sk", "SK"));
        nf2.setMaximumFractionDigits(10);

        float PHI = (float) ((Math.sqrt(5) + 1) / 2);
        float x1, x2, x;
        int iter = 0;
        while (true){
            iter++;
            x1 = b - (b - a) / PHI;
            x2 = a + (b - a) / PHI;
            double f1 = f.execute(x1);
            double f2 = f.execute(x2);
            if (f1 >= f2)
                a = x1;
            else
                b = x2;
            if (Math.abs(b - a) < eps)
                break;
        }
        x = (b + a) / 2;
        System.out.println("Function called: " + (iter+1) + " Accuracy: " + nf2.format(eps));
    }

    public static void main(String[] args) {
        Function func1 = Functions.action(1);
        Function func2 = Functions.action(2);
        Function func3 = Functions.action(3);
        Function func4 = Functions.action(4);
        Function func5 = Functions.action(5);
        Function f_cos = Functions.action(6);
        Function f_pol5 = Functions.action(7);

        //unimodal function (cosine) investigation on three intervals
        System.out.println("Cosine function results on interval [-10;10]:");
        goldenSectionMethod(f_cos, -10, 10, 0.1f);
        System.out.println();
        System.out.println("Cosine function results on interval [-7;4]:");
        goldenSectionMethod(f_cos, -7, 4, 0.1f);
        System.out.println();
        System.out.println("Cosine function resultson interval [-5;3]:");
        goldenSectionMethod(f_cos, -5, 3, 0.1f);
        System.out.println();

        //unimodal function (polinom 5th power) investigation on three intervals
//        System.out.println("Polinom function results on interval [-1;3]:");
//        goldenSectionMethod(f_pol5, -1, 3, 0.1f);
//        System.out.println();
//        System.out.println("Polinom function results on interval [-0.8;1]:");
//        goldenSectionMethod(f_pol5, -0.8f, 1, 0.1f);
//        System.out.println();
//        System.out.println("Polinom function resultson interval [-2;4]:");
//        goldenSectionMethod(f_pol5, -2, 4, 0.1f);
//        System.out.println();
//        System.out.println("Polinom function resultson interval [-10;10]:");
//        goldenSectionMethod(f_pol5, -10, 10, 0.1f);
//        System.out.println();

//        goldenSectionMethodPart2(func1, -0.5f, 0.5f, 0.1f);
//        goldenSectionMethodPart2(func1, -0.5f, 0.5f, 0.05f);
//        goldenSectionMethodPart2(func1, -0.5f, 0.5f, 0.03f);
//        goldenSectionMethodPart2(func1, -0.5f, 0.5f, 0.01f);
//        goldenSectionMethodPart2(func1, -0.5f, 0.5f, 0.001f);
//        goldenSectionMethodPart2(func1, -0.5f, 0.5f, 0.0005f);
//        goldenSectionMethodPart2(func1, -0.5f, 0.5f, 0.00005f);
//        goldenSectionMethodPart2(func1, -0.5f, 0.5f, 0.000001f);
//        goldenSectionMethodPart2(func1, -0.5f, 0.5f, 0.0000001f);
//        goldenSectionMethodPart2(func1, -0.5f, 0.5f, 0.00000001f);
//        goldenSectionMethodPart2(func1, -0.5f, 0.5f, 0.000000001f);
//        goldenSectionMethodPart2(func1, -0.5f, 0.5f, 0.0000000001f);

//        System.out.println("First function results:");
//        goldenSectionMethod(func1, -0.5f, 0.5f, 0.1f);
//        System.out.println();
//        System.out.println("Second function results:");
//        goldenSectionMethod(func2, 6f, 9.9f, 0.1f);
//        System.out.println();
//        System.out.println("Third function results:");
//        goldenSectionMethod(func3, 0f, (float) (2 * Math.PI), 0.1f);
//        System.out.println();
//        System.out.println("Fourth function results:");
//        goldenSectionMethod(func4, 0f, 1f, 0.1f);
//        System.out.println();
//        System.out.println("Fifth function results:");
//        goldenSectionMethod(func5, 0.5f, 2.5f, 0.1f);
    }

}

package lab1;

import java.text.NumberFormat;
import java.util.Locale;

import static java.lang.Math.abs;

public class ParabolaMethod {

    public static void parabolaMethod(Function f, double a, double b, double eps)
    {
        NumberFormat nf2 = NumberFormat.getInstance(new Locale("sk", "SK"));
        nf2.setMaximumFractionDigits(4);
        int iter = 0;
        double f1 = f.execute(a);
        double f3 = f.execute(b);
        double x2 = (a + b) / 5;
        double f2 = f.execute(x2);
        //double x2 = (a + b) / 2;

        while (b - a > eps)
        {
            iter++;
            System.out.println(iter + "th interval: " + nf2.format(a) + " , " + nf2.format(b));
//            double x2 = (a + b) / 5;
//            double f2 = f.execute(x2);
            double u = x2 - ((f2 - f3) * Math.pow(x2 - a, 2) - (f2 - f1) * Math.pow(x2 - b, 2)) /
                    (2 * ((x2 - a) * (f2 - f3) - (x2 - b) * (f2 - f1)));
            double fu = f.execute(u);

            System.out.println("x2: " + nf2.format(x2));
            System.out.println("u: " + nf2.format(u));

            if(fu < f2) {
                if(u < x2) {
                    double tmp = x2;
                    double ftmp = f2;
                    x2 = u;
                    f2 = fu;
                    b = tmp;
                    f3 = ftmp;
                } else {
                    double tmp = x2;
                    double ftmp = f2;
                    x2 = u;
                    f2 = fu;
                    a = tmp;
                    f1 = ftmp;
                }
            } else {
                if(u < x2) {
                    x2 = u;
                    f2 = fu;
                    a = u;
                    f1 = fu;
                } else {
                    x2 = u;
                    f2 = fu;
                    b = u;
                    f3 = fu;
                }
            }
        }

        System.out.println("interval with minimum: [" + a + " ; " + b + "]");
        System.out.println("x = " + (b + a) / 2 + " f(x) = " + f.execute((b + a) / 2));
        System.out.println("Iterations made: " + iter);
    }

    public static void main(String[] args) {
        Function func1 = Functions.action(1);
        Function func2 = Functions.action(2);
        Function func3 = Functions.action(3);
        Function func4 = Functions.action(4);
        Function func5 = Functions.action(5);

        System.out.println("First function results:");
        parabolaMethod(func1, -0.5, 0.5,  0.1);
        System.out.println();
        System.out.println("Second function results:");
        parabolaMethod(func2, 6,9.9, 0.1);
        System.out.println();
        System.out.println("Third function results:");
        parabolaMethod(func3, 0, 2 * Math.PI, 0.1);
        System.out.println();
        System.out.println("Fourth function results:");
        parabolaMethod(func4, 0, 1, 0.1);
        System.out.println();
        System.out.println("Fifth function results:");
        parabolaMethod(func5, 0.5, 2.5, 0.1);
    }
}

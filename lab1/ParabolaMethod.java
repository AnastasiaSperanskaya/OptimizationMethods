package lab1;

import static java.lang.Math.abs;

public class ParabolaMethod {

    public static void parabolaMethod(Function f, double x1, double x2, double x3, float eps) {
        if (f.execute(x2) < f.execute(x1) && f.execute(x2) < f.execute(x3)){

            int iter = 0;
            double u = 0;
            while (x3 - x1 > eps) {
                iter++;
                double f1 = f.execute(x1);
                double f2 = f.execute(x2);
                double f3 = f.execute(x3);
                System.out.println(iter + "th interval: [" + x1 + " ; " + x3 + "]");
                System.out.println("Calculated function values are: " + f1 + " , " + f2 + " , " + f3);
                u = (float) (x2 - ((Math.pow(x2 - x1, 2) * (f2 - f3) - Math.pow(x2 - x3, 2) * (f2 - f1)) /
                        (2 * ((x2 - x1) * (f2 - f3) -  (x2 - x3) * (f2 - f1))) ));
                System.out.println("Calculated value is: " + u);
                double fu = f.execute(u);
                System.out.println("Calculated min value: " + fu);
                if (fu <= f2) {
                    x3 = x2;
                    x2 = u;
                } else {
                    x1 = x2;
                    x2 = u;
                }
            }
            System.out.println("next interval could be: [" + x1 + " ; " + x3 + "]");
            System.out.println("x = " + u + " f(x) = " + f.execute(u));
        } else{
            System.out.println("Wrong interval");
        }
    }

    public static void main(String[] args) {
        Function func1 = Functions.action(1);
        Function func2 = Functions.action(2);
        Function func3 = Functions.action(3);
        Function func4 = Functions.action(4);
        Function func5 = Functions.action(5);

        System.out.println("First function results:");
        parabolaMethod(func1, -0.5, -0.1, 0.5, 0.1f);
        System.out.println();
        System.out.println("Second function results:");
        parabolaMethod(func2, 6, 8, 9.9, 0.1f);
        System.out.println();
        System.out.println("Third function results:");
        parabolaMethod(func3, 0, 4, 2 * Math.PI, 0.1f);
        System.out.println();
        System.out.println("Fourth function results:");
        parabolaMethod(func4, 0, 0.2, 1, 0.1f);
        System.out.println();
        System.out.println("Fifth function results:");
        parabolaMethod(func5, 0.5, 1.2, 2.5, 0.1f);
    }
}

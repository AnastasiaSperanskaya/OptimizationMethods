package lab1;
import java.text.NumberFormat;
import java.util.Locale;

public class BrentsMethod {
    public static void brentsMethod(Function f, double a, double b, double eps)
    {
        NumberFormat nf2 = NumberFormat.getInstance(new Locale("sk", "SK"));
        nf2.setMaximumFractionDigits(4);

        double gold = 0.382;
        double rtol = eps;
        double atol = eps;
        double x0 = a + gold * (b - a);
        double f0 = f.execute(x0);

        double x1 = x0;
        double x2 = x1;
        double d = 0;
        double e = 0;
        double u = 0;
        double f1 = f0;
        double f2 = f0;

        int iter = 0;

        int i = -1;
        while (b - a > eps)
        {
            System.out.println(iter+1 + "th interval: " + nf2.format(a) + " , " + nf2.format(b));
            iter++;
            i++;
            double m = 0.5f * (a + b);
            double tol = rtol * Math.abs(x0) + atol;
            double tol2 = 2f * tol;

            if (Math.abs(x0 - m) <= tol2 - 0.5f * (b - a)) {
                System.out.println("breaking..");
                break;
            }

            double r = 0f;
            double q = r;
            double p = q;

            if (tol < Math.abs(e))
            {
                r = (x0 - x1) * (f0 - f2);
                q = (x0 - x2) * (f0 - f1);
                p = (x0 - x2) * q - (x0 - x1) * r;
                q = 2f * (q - r);
                if (0f < q)
                    p = -p;
                q = Math.abs(q);
                r = e;
                e = d;
            }

            if (Math.abs(p) < Math.abs(0.5f * q * r) && q * (a-x0) < p && p <q*(b-x0))
            {
                d = p / q;
                u = x0 + d;
                if (u -a < tol2 || b-u < tol2)
                {
                    if (x0 < m)
                        d = tol;
                    else
                        d = -tol;
                }
            }
            else
            {
                if (x0 < m)
                    e = b - x0;
                else
                    e = a - x0;
                d = gold * e;
            }

            if (tol <= Math.abs(d))
                u = x0 + d;
            else if (0f < d)
                u = x0 + tol;
            else
                u = x0 - tol;

            double fu = f.execute(u);

            System.out.println("Calculated point: " + nf2.format(u));
            System.out.println("Calculated function value: " + nf2.format(fu));

            if (fu <= f0)
            {
                if (u < x0)
                {
                    if (b != x0)
                        b = x0;
                }
                else
                {
                    if (a != x0)
                        a = x0;
                }

                x2 = x1;
                f2 = f1;
                x1 = x0;
                f1 = f0;
                x0 = u;
                f0 = (float) fu;
            }
            else
            {
                if (u < x0)
                {
                    if (a != u)
                        a = u;
                }
                else
                {
                    if (b != u)
                        b = u;
                }

                if (fu <= f1 || x1 == x0)
                {
                    x2 = x1;
                    f2 = f1;
                    x1 = u;
                    f1 = (float) fu;
                }
                else if (fu <= f2 || x2 == x0 || x2 ==x1)
                {
                    x2 = u;
                    f2 = (float) fu;
                }
            }
        }
        System.out.println("interval with minimum: [" + a + " ; " + b + "]");
        System.out.println("x = " + x0 + " f(x) = " + f.execute(x0));
    }

    public static void main(String[] args) {
        Function func1 = Functions.action(1);
        Function func2 = Functions.action(2);
        Function func3 = Functions.action(3);
        Function func4 = Functions.action(4);
        Function func5 = Functions.action(5);

        System.out.println("First function results:");
        brentsMethod(func1, -0.5, 0.5,  0.1);
        System.out.println();
        System.out.println("Second function results:");
        brentsMethod(func2, 6,9.9, 0.1);
        System.out.println();
        System.out.println("Third function results:");
        brentsMethod(func3, 0, 2 * Math.PI, 0.1);
        System.out.println();
        System.out.println("Fourth function results:");
        brentsMethod(func4, 0, 1, 0.1);
        System.out.println();
        System.out.println("Fifth function results:");
        brentsMethod(func5, 0.5, 2.5, 0.1);
    }
}

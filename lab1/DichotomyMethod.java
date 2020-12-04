package lab1;
import static java.lang.Math.abs;

public class DichotomyMethod {
    public static void dichotomyMethod(Function f, float a, float b, float eps) {

        float c, x = 0;
        while (abs(a-b) > eps) {
            c = (a+b)/2;
            if (f.execute(a) * f.execute(c)<= 0) b = c;
            else
            {
                a = c;
                x = (a+b)/2;
            }
        }
        System.out.println("x = " + x + " f(x) = " + f.execute(x));
    }

    public static void main(String[] args) {

        float a,b,eps = 0.01f;
        a = 0;
        b = 1;

        Function func1 = Functions.action(1);
        Function func2 = Functions.action(2);

        dichotomyMethod(func1, a, b, eps);
    }
}

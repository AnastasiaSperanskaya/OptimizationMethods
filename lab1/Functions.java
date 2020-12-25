package lab1;
import java.lang.Math;

interface Function{
    double execute(double x1, double x2, double x3, double x4);
}

public class Functions {
    static Function action(int number) {
        switch(number){
            case 1: return (x1, x2, x3, x4) -> 100 * Math.pow(x2 - Math.pow(x1, 2), 2) + Math.pow(1 - x1, 2);
            case 2: return (x1, x2, x3, x4) -> Math.pow(x2 - Math.pow(x1, 2), 2) + Math.pow(1 - x1, 2);
            case 3: return (x1, x2, x3, x4) -> Math.pow(1.5 - x1 * (1 - x2), 2) +
                    Math.pow(2.25 - x1 * (1 - Math.pow(x2, 2)), 2) + Math.pow(2.625 - x1 * (1 - Math.pow(x2, 3)), 2);
            case 4: return (x1, x2, x3, x4) -> Math.pow(x1 + x2, 2) + 5 * Math.pow(x3 - x4, 2)
                    + Math.pow(x2 - 2 * x3, 4) + 10 * Math.pow(x1 - x4, 4);
            default: return (x1, x2, x3, x4) -> 0;
        }
    }
}

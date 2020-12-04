package lab1;
import java.lang.Math;

interface Function{
    double execute(double x);
}

public class Functions {
    static Function action(int number) {
        switch(number){
            case 1: return (x) -> (-1) * Math.pow(x, 5) + 4 * Math.pow(x, 4) -
                    12 * Math.pow(x, 3) + 11 * Math.pow(x, 2) - 2 * x + 1;
            case 2: return (x) -> Math.pow(Math.log10(x - 2), 2) + Math.pow(Math.log10(10 - x), 2) -
                    Math.pow(x, 0.2);
            case 3: return (x) -> (-3) * x * Math.sin(0.75 * x) + Math.exp(1) - 2 * x;
            case 4: return (x) -> Math.exp(3 * x) + 5 * Math.exp(1) - 2 * x;
            case 5: return (x) -> 0.2 * x * Math.log10(x) + Math.pow(x - 2.3, 2);
            default: return (x) -> Math.cos(x) - Math.sqrt(x);
        }
    }
}

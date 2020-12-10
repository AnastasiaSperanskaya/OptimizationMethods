package lab1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class BrentsMethod {

    public static void brentsMethod() {

    }

    public static void main(String[] args) {
        Function func1 = Functions.action(1);
        Function func2 = Functions.action(2);
        Function func3 = Functions.action(3);
        Function func4 = Functions.action(4);
        Function func5 = Functions.action(5);

        Locale.setDefault(Locale.FRENCH);
        double x = 11.4;

        System.out.println(x);
        System.out.println((float)x);

        double n = 1240.35342;

        NumberFormat nf2 = NumberFormat.getInstance(new Locale("sk", "SK"));
        nf2.setMaximumFractionDigits(4);
        String val2 = nf2.format(n);

        System.out.println(val2);
    }
}

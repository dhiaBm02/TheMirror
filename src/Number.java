import java.util.ArrayList;
import java.util.List;

public class Number {
    List<Digit> digits = new ArrayList<>();

    public Number(int number) {
        String numberStr = String.format("%04d", number); // Format number to be at least 4 digits, adding leading zeros if necessary

        for (char c : numberStr.toCharArray()) {
            int digit = Character.getNumericValue(c);
            digits.add(new Digit(digit));
        }
    }

    public Number() {}

    void addDigit(Digit digit) {
        digits.add(digit);
    }

    private void setDigits(List<Digit> digits) {
        this.digits.clear();
        this.digits.addAll(digits);
    }
}

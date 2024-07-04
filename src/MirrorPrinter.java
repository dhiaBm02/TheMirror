public class MirrorPrinter {
    Mirror mirror;

    public MirrorPrinter(Mirror mirror) {
        this.mirror = mirror;
    }

    public void print() {
        String result = "The Mirror:\n";
        result += getMirror_A(mirror.initNumber, mirror.Y_Number);
        result += "\n";
        result += getMirror_FGB(mirror.initNumber, mirror.Y_Number);
        result += "\n";
        result += getMirror_EDC(mirror.initNumber, mirror.Y_Number);
        result += "\n_________________|________________\n";
        result += getMirror_A(mirror.X_Number, mirror.XY_Number);
        result += "\n";
        result += getMirror_FGB(mirror.X_Number, mirror.XY_Number);
        result += "\n";
        result += getMirror_EDC(mirror.X_Number, mirror.XY_Number);
        result += "\n                 |                 \n";

        System.out.println(result);
    }

    private String getMirror_A(Number number1, Number number2) {
        String result = "";
        result += getNumber_A(number1) + " | " + getNumber_A(number2);
        return result;
    }

    private String getMirror_FGB(Number number1, Number number2) {
        String result = "";
        result += getNumber_FGB(number1) + " | " + getNumber_FGB(number2);
        return result;
    }

    private String getMirror_EDC(Number number1, Number number2) {
        String result = "";
        result += getNumber_EDC(number1) + " | " + getNumber_EDC(number2);
        return result;
    }

    private String getNumber_A(Number number) {
        if (number == null)
            return "                ";
        String result = "";
        for (Digit digit: number.digits) {
            result += getDigit_A(digit) + " ";
        }
        return result;
    }

    private String getNumber_FGB(Number number) {
        if (number == null)
            return "                ";
        String result = "";
        for (Digit digit: number.digits) {
            result += getDigit_FGB(digit) + " ";
        }
        return result;
    }

    private String getNumber_EDC(Number number) {
        if (number == null)
            return "                ";
        String result = "";
        for (Digit digit: number.digits) {
            result += getDigit_EDC(digit) + " ";
        }
        return result;
    }

    private String getDigit_A(Digit digit) {
        return digit.segments.contains(Segment.A) ? " _ " : "   ";
    }

    private String getDigit_FGB(Digit digit) {
        String result = "";
        result += digit.segments.contains(Segment.F) ? "|" : " ";
        result += digit.segments.contains(Segment.G) ? "_" : " ";
        result += digit.segments.contains(Segment.B) ? "|" : " ";
        return result;
    }

    private String getDigit_EDC(Digit digit) {
        String result = "";
        result += digit.segments.contains(Segment.E) ? "|" : " ";
        result += digit.segments.contains(Segment.D) ? "_" : " ";
        result += digit.segments.contains(Segment.C) ? "|" : " ";
        return result;
    }
}

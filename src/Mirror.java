public class Mirror {
    Number initNumber;
    Number X_Number = null;
    Number Y_Number = null;
    Number XY_Number = null;

    public Mirror(Number initNumber) {
        this.initNumber = initNumber;
    }

    void mirrorX() {
        if (X_Number != null && XY_Number != null) {
            System.out.println("The Mirror had already made all the possible reflections." +
                    "\nto continue you should clear the mirror or choose a new number!");
            return;
        }
        if (X_Number == null) {
            X_Number = reflectNumberXAxis(initNumber);
        }
        if (Y_Number != null && XY_Number == null) {
            XY_Number = reflectNumberXAxis(Y_Number);
        }
    }

    void mirrorY() {
        if (Y_Number != null && XY_Number != null) {
            System.out.println("The Mirror had already made all the possible reflections." +
                    "\nto continue you should clear the mirror or choose a new number!");
            return;
        }
        if (Y_Number == null) {
            Y_Number = reflectNumberYAxis(initNumber);
        }
        if (X_Number != null && XY_Number == null) {
            XY_Number = reflectNumberYAxis(X_Number);
        }
    }

    private Number reflectNumberXAxis(Number number) {
        Number reflectedNumber = new Number();
        for (Digit digit : number.digits) {
            reflectedNumber.addDigit(reflectDigitXAxis(digit));
        }
        return reflectedNumber;
    }

    private Digit reflectDigitXAxis(Digit digit) {
        Digit reflectedDigit = new Digit();
        for (Segment segment : digit.segments) {
            switch (segment) {
                case A -> reflectedDigit.addSegment(Segment.D);
                case B -> reflectedDigit.addSegment(Segment.C);
                case C -> reflectedDigit.addSegment(Segment.B);
                case D -> reflectedDigit.addSegment(Segment.A);
                case E -> reflectedDigit.addSegment(Segment.F);
                case F -> reflectedDigit.addSegment(Segment.E);
                case G -> reflectedDigit.addSegment(Segment.G);
            }
        }
        return reflectedDigit;
    }

    private Number reflectNumberYAxis(Number number) {
        Number reflectedNumber = new Number();
        for (int i = number.digits.size() - 1; i >= 0; i--) {
            Digit digit = number.digits.get(i);
            reflectedNumber.addDigit(reflectDigitYAxis(digit));
        }
        return reflectedNumber;
    }

    private Digit reflectDigitYAxis(Digit digit) {
        Digit reflectedDigit = new Digit();
        for (Segment segment : digit.segments) {
            switch (segment) {
                case A -> reflectedDigit.addSegment(Segment.A);
                case B -> reflectedDigit.addSegment(Segment.F);
                case C -> reflectedDigit.addSegment(Segment.E);
                case D -> reflectedDigit.addSegment(Segment.D);
                case E -> reflectedDigit.addSegment(Segment.C);
                case F -> reflectedDigit.addSegment(Segment.B);
                case G -> reflectedDigit.addSegment(Segment.G);
            }
        }
        return reflectedDigit;
    }

    private Number getInitNumber() {
        return initNumber;
    }

    void setInitNumber(Number InitNumber) {
        this.initNumber = InitNumber;
        clear();
    }

    void clear() {
        X_Number = null;
        Y_Number = null;
        XY_Number = null;
    }
}

import java.util.EnumSet;


public class Digit {
    private static final EnumSet<Segment>[] DIGIT_SEGMENTS = new EnumSet[]{
            EnumSet.of(Segment.A, Segment.B, Segment.C, Segment.D, Segment.E, Segment.F),
            EnumSet.of(Segment.B, Segment.C),
            EnumSet.of(Segment.A, Segment.B, Segment.D, Segment.E, Segment.G),
            EnumSet.of(Segment.A, Segment.B, Segment.C, Segment.D, Segment.G),
            EnumSet.of(Segment.B, Segment.C, Segment.F, Segment.G),
            EnumSet.of(Segment.A, Segment.C, Segment.D, Segment.F, Segment.G),
            EnumSet.of(Segment.A, Segment.C, Segment.D, Segment.E, Segment.F, Segment.G),
            EnumSet.of(Segment.A, Segment.B, Segment.C),
            EnumSet.of(Segment.A, Segment.B, Segment.C, Segment.D, Segment.E, Segment.F, Segment.G),
            EnumSet.of(Segment.A, Segment.B, Segment.C, Segment.D, Segment.F, Segment.G)
    };

    EnumSet<Segment> segments;

    public Digit(int digit) {
        if (digit < 0 || digit > 9) {
            throw new IllegalArgumentException("digit must be between 0 and 9");
        }
        segments = DIGIT_SEGMENTS[digit];
    }

    public Digit() {
        segments = EnumSet.noneOf(Segment.class);
    }

    void addSegment(Segment segment) {
        segments.add(segment);
    }

    private void addSegments(EnumSet<Segment> segments) {
        this.segments.addAll(segments);
    }
}

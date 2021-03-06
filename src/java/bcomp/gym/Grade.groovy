package bcomp.gym

class Grade implements Comparable<Grade> {

    double value;

    /** required by Hibernate */
    Grade() {}

    public Grade(double value) {
        assert 0.0 <= value && value < 1.0
        this.value = value
    }

    @Override
    int compareTo(Grade o) {
        return this.value<=>o.value
    }

    final static
    def FONT_GRADES = ['1A', '1B', '1C', '2A', '2B', '2C', '3A', '3B', '3C', '4A', '4B', '4C', '5A', '5B', '5C',
            '6A', '6A+', '6B', '6B+', '6C', '6C+', '7A', '7A+', '7B', '7B+', '7C', '7C+', '8A', '8A+', '8B', '8B+',
            '8C', '8C+']

    public String toFontScale() {
        double segment = 1.0 / FONT_GRADES.size()
        return FONT_GRADES[(int) Math.floor(value / segment)]
    }

    public static Grade fromFontScale(String font) {
        int i = FONT_GRADES.indexOf(font.toUpperCase())
        assert i != -1
        double segment = 1.0 / FONT_GRADES.size()

        return new Grade(i * segment + (segment / 2))
    }

    public static boolean isFrontScaleGrade(String font) {
        return FONT_GRADES.contains(font.toUpperCase())
    }

    public static Grade between(Grade g1, Grade g2) {
        assert g1 <= g2
        return g1 + (g2 - g1) / 2
    }

    /** Can be used for null values. Lower than regular lowest() */
    public static Grade zero() {
        return new Grade(0.0);
    }

    public static Grade lowest() {
        return fromFontScale(FONT_GRADES[0])
    }

    public static Grade highest() {
        return fromFontScale(FONT_GRADES[FONT_GRADES.size() - 1])
    }

    public static double oneFontGradeDifference() {
        return Grade.fromFontScale('7a+').value - Grade.fromFontScale('7a').value;
    }


    public Grade plus(double value) {
        return new Grade(this.value + value)
    }

    public double minus(Grade g) {
        return this.value - g.value
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Grade)) return false

        Grade grade = (Grade) o

        if (Double.compare(grade.value, value) != 0) return false

        return true
    }

    int hashCode() {
        long temp = value != +0.0d ? Double.doubleToLongBits(value) : 0L
        return (int) (temp ^ (temp >>> 32))
    }

    @Override
    public String toString() {
        return "${String.format('%.3f', value)} (${toFontScale()})"
    }
}

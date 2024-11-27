package equalsgeneralcontract;

// Class with typical equals method

// Recipe for a high-quality equals method:
// 1. Use the == operator to check if the argument is a reference to this object.
// 2. Use the instanceof operator to check if the argument has the correct type.
// 3. Cast the argument to the correct type.
// 4. For each "significant" field in the class, check if that field of the argument matches the corresponding field of this object.
// Lastly, rewriting equals methods and running tests can be mundane. It is okay to use programs to generate this code sometimes.
// Google's AutoValue framework, IDE's, and ChatGPT, can all do this.
public class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }

    // Always override hashCode when you override equals!
    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode); // Hash the areaCode
        result = 31 * result + Short.hashCode(prefix); // Incorporate prefix
        result = 31 * result + Short.hashCode(lineNum); // Incorporate lineNum
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) { // #1
            return true;
        }
        if (!(o instanceof PhoneNumber)) { // #2
            return false;
        }
        PhoneNumber pn = (PhoneNumber) o; // #3
        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode; // #4
        // Primitives can use ==, float use Float.compare, double use Double.compare, array check each element, null use Objects.equals
    }

    /**
     * Returns the string representation of this phone number. The string consists of twelve characters whose format is
     * "XXX-YYY-ZZZ", where XXX is the area code, YYY is the prefix, and ZZZZ is the line number. Each of the capital
     * letters represents a single decimal digit.
     *
     * If any of the three parts of this phone number is too small to fill up its field, the field is padded with leading
     * zeros. For example, if the value of the line number is 123, the last four characters of the string representation
     * will be "0123".
     */
    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }
}

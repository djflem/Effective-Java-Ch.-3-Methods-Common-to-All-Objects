package org.example.overridehashcodeandequals;

import java.util.Objects;

// You must override hashCode in every class that overrides equals!
// The key provision that is violated when you fail to override hashCode is that equal objects must have equal hash codes.
// Do not be tempted to exclude significant fields from the hash code computation to improve performance.
// Don't provide a detailed specification for the value returned by hashCode, so clients can't reasonably depend
// on it; this gives you the flexibility to change it.
public class OverrideHashCode {
    /*
    // The worst possible legal hashCode implementation - never use!
    @Override
    public int hashCode() {
        return 42;
    }

    // Typical hashCode method
    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode); // Hash the areaCode
        result = 31 * result + Short.hashCode(prefix); // Incorporate prefix
        result = 31 * result + Short.hashCode(lineNum); // Incorporate lineNum
        return result;
    }

    // One-line hashCode method - mediocre performance
    // Can be used in performance non-critical applications
    @Override
    public int hashCode() {
        return Objects.hash(lineNum, prefix, areaCode);
    }

    // hashCode method with lazily initialized cached hash code
    private int hashCode; // Automatically initialized to 0
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNum);
            hashCode = result;
        }
        return result;
    }
    */
}

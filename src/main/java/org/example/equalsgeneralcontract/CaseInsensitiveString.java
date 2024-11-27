package org.example.equalsgeneralcontract;

import java.util.Objects;

// Overriding the equals method can easily cause problems, so it's best to not do it in the first place.
// This is the right thing to do if any of these condition apply:
// -Each instance of the class is inherently unique.
// -There is no need for the class to provide a "logical equality" test.
// -A superclass has already overridden equals, and the superclass behavior is appropriate for this class.
// -The class is private or package-private, and you are certain that its equals method will never be invoked.
// Overriding is appropriate when a class has a notion of logical equality that differs from the mere object
// identity and a superclass has not already overridden equals. Generally the case for value classes.
// Value class: A class that represents a value, such as Integer or String.
// The equals' equivalence relation properties: reflexive, symmetric, transitive, consistent, non-null must return false
public class CaseInsensitiveString {
    /*
    // If you are extremely risk-averse, you can override the equals method to ensure that it isn't invoked accidentally.
    @Override
    public boolean equals(Object o) {
        throw new AssertionError(); // Method is never called
    }
    */

    // Broken - violates symmetry!
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    /*
    // Broken - violates symmetry!
    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString) {
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        }
        if (o instanceof String) { // One-way interoperability!
            return s.equalsIgnoreCase((String) o);
        }
        return false;
    }
    */

    // refactor
    @Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }
}

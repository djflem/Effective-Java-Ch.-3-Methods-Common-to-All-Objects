package org.example.implementingcomparable;

import java.util.Comparator;

// When you implement a value class that has a sensible ordering, you should have the class implement the Comparable interface
// so that its instances can be easily sorted, searched, and used in comparison-based collections. When comparing field values
// in the implementations of the compareTo methods, avoid the use of the <and> operators. Instead, use the static compare
// methods in the boxed primitive classes or the comparator construction methods in the Comparator interface.
public class Comparable {
    /*
    // BROKEN difference-based comparator - violates transitivity!
    static Comparator<Object> hashCodeOrder = new Comparator<>() {
        public int compare(Object o1, Object o2) {
            return o1.hashCode() - o2.hashCode();
        }
    };
    */

    // Comparator based on static compare method
    static Comparator<Object> hashCodeOrderStatic = new Comparator<>() {
        public int compare(Object o1, Object o2) {
            return Integer.compare(o1.hashCode(), o2.hashCode());
        }
    };

    // Comparator based on Comparator construction method
    static Comparator<Object> hashCodeOrderConstructor = Comparator.comparingInt(o -> o.hashCode());
}

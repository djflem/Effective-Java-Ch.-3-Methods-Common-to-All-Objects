package equalsgeneralcontract;

import org.example.equalsgeneralcontract.PhoneNumber;
import org.junit.Test;
import static org.junit.Assert.*;

public class PhoneNumberTest {
    @Test
    public void testEqualsReflexivity() {
        PhoneNumber pn1 = new PhoneNumber(123, 456, 7890);
        assertTrue("Equals should be reflexive", pn1.equals(pn1));
    }

    @Test
    public void testEqualsSymmetry() {
        PhoneNumber pn1 = new PhoneNumber(123, 456, 7890);
        PhoneNumber pn2 = new PhoneNumber(123, 456, 7890);
        assertTrue("Equals should be symmetric", pn1.equals(pn2));
        assertTrue("Equals should be symmetric", pn2.equals(pn1));
    }

    @Test
    public void testEqualsTransitivity() {
        PhoneNumber pn1 = new PhoneNumber(123, 456, 7890);
        PhoneNumber pn2 = new PhoneNumber(123, 456, 7890);
        PhoneNumber pn3 = new PhoneNumber(123, 456, 7890);
        assertTrue("Equals should be transitive", pn1.equals(pn2));
        assertTrue("Equals should be transitive", pn2.equals(pn3));
        assertTrue("Equals should be transitive", pn1.equals(pn3));
    }

    @Test
    public void testEqualsConsistency() {
        PhoneNumber pn1 = new PhoneNumber(123, 456, 7890);
        PhoneNumber pn2 = new PhoneNumber(123, 456, 7890);
        PhoneNumber pnDifferent = new PhoneNumber(321, 654, 9870);

        assertTrue("Equals should be consistent", pn1.equals(pn2));
        assertTrue("Equals should be consistent", pn1.equals(pn2));
        assertFalse("Equals should be consistent", pn1.equals(pnDifferent));
    }

    @Test
    public void testEqualsNullComparison() {
        PhoneNumber pn1 = new PhoneNumber(123, 456, 7890);
        assertFalse("Equals should return false when compared to null", pn1.equals(null));
    }

    @Test
    public void testHashCodeContract() {
        PhoneNumber pn1 = new PhoneNumber(123, 456, 7890);
        PhoneNumber pn2 = new PhoneNumber(123, 456, 7890);
        PhoneNumber pnDifferent = new PhoneNumber(321, 654, 9870);

        // Equal objects must have the same hash code
        assertTrue("Equal objects must have the same hash code", pn1.hashCode() == pn2.hashCode());

        // Unequal objects can have different hash codes
        assertFalse("Unequal objects can have different hash codes", pn1.hashCode() == pnDifferent.hashCode());
    }
}

package org.example;

import org.example.equalsgeneralcontract.CaseInsensitiveString;
import org.example.equalsgeneralcontract.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //EQUALS GENERAL CONTRACT
        System.out.println();
        System.out.println("EQUALS GENERAL CONTRACT");
        System.out.println();
        //

        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println(cis.equals(s)); // true (refactor: false)
        System.out.println(s.equals(cis)); // false, clear violation of symmetry (refactor: false)
        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);
        System.out.println(list.contains(s)); // false, but equals has been defiled and now has unpredictable behavior. (refactor: false)

        //OVERRIDING hashCODE & toSTRING
        System.out.println();
        System.out.println("OVERRIDING hashCODE & toSTRING");
        System.out.println();
        //

        PhoneNumber phoneNumber1 = new PhoneNumber(425, 788, 8845);
        PhoneNumber phoneNumber2 = new PhoneNumber(206, 788, 8845);
        System.out.println("Does phone number 1 equal phone number 2?: " + phoneNumber1.equals(phoneNumber2));
        System.out.println("Phone number 1 hash code: " + phoneNumber1.hashCode());
        System.out.println("Phone number 1 toString: " + phoneNumber1.toString());

        //OVERRIDING CLONE
        System.out.println();
        System.out.println("OVERRIDING CLONE");
        System.out.println();
        //

        PhoneNumber phoneNumber3 = phoneNumber1.clone();
        System.out.println("Is the clone of phone number 1 equal to original phone number 1?: " + phoneNumber3.equals(phoneNumber1));
        System.out.println("Phone number 3 hash code (clone of phone number 1): " + phoneNumber3.hashCode());
        System.out.println("Phone number 3 toString: " + phoneNumber3.toString());

        //IMPLEMENTING COMPARABLE
        System.out.println();
        System.out.println("IMPLEMENTING COMPARABLE");
        System.out.println();
        //

        PhoneNumber numberToCompare1 = new PhoneNumber(212, 225, 8899);
        PhoneNumber numberToCompare2 = new PhoneNumber(212, 225, 8899);
        PhoneNumber numberToCompare3 = new PhoneNumber(212, 225, 9999);
        System.out.println("Number 1 compared to 2 is: " + numberToCompare1.compareTo(numberToCompare2));
        System.out.println("Number 2 compared to 3 is: " + numberToCompare2.compareTo(numberToCompare3));
        System.out.println("Number 1 compared to 3 is: " + numberToCompare1.compareTo(numberToCompare3));
        // A negative value if the first string is lexicographically less than the second.
        // 0 if the two strings are considered equal (ignoring case).
        // A positive value if the first string is lexicographically greater than the second.
        CaseInsensitiveString cis2 = new CaseInsensitiveString("PoLiawdawsh");
        System.out.println("cis compared to cis2 is: " + cis.compareTo(cis2));
    }
}

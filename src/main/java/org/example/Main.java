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
    }
}

package org.example;

import equalsgeneralcontract.CaseInsensitiveString;
import equalsgeneralcontract.ColorPoint;
import equalsgeneralcontract.PhoneNumber;
import equalsgeneralcontract.Point;

import java.awt.*;
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
        System.out.println(phoneNumber1.equals(phoneNumber2));
        System.out.println(phoneNumber1.hashCode());
        System.out.println(phoneNumber1.toString());



    }
}

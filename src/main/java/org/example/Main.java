package org.example;

import equalsgeneralcontract.CaseInsensitiveString;
import equalsgeneralcontract.ColorPoint;
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



    }
}

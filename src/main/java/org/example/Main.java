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

        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.println(p1.equals(p2)); // true
        System.out.println(p2.equals(p3)); // false, clear violation of symmetry (refactor: true, but at the cost of transitivity!)
        System.out.println(p1.equals(p3)); // false, signaling clear violation of transitivity
    }
}

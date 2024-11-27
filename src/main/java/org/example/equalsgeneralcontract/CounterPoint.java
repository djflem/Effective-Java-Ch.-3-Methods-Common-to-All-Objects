package org.example.equalsgeneralcontract;

import java.util.concurrent.atomic.AtomicInteger;

// Liskov substitution principle says that any important property of a type should also hold for all its subtypes so that any
// method written for the type should work equally well on its subtypes.
public class CounterPoint extends Point {
    private static final AtomicInteger counter = new AtomicInteger();

    public CounterPoint(int x, int y) {
        super(x, y);
        counter.incrementAndGet();
    }

    public static int getNumberCreated() {
        return counter.get();
    }
}

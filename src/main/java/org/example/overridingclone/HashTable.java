package org.example.overridingclone;

public class HashTable implements Cloneable {
    private Entry[] buckets;

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // Recursively copy the linked list headed by this Entry
        // Prone to long lists, first can check if null then copy after
        Entry deepCopy() {
            Entry result = new Entry(key, value, next);
            for (Entry p = result; p.next != null; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            }
            return result;
        }
    }

    /*
    // Broken clone method - results in shared mutable state!
    @Override
    public HashTable clone() {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = buckets.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    */

    // clone() refactor
    @Override
    public HashTable clone() {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = new Entry[buckets.length];
            for (int i = 0; i < buckets.length; i++) {
                result.buckets[i] = buckets[i].deepCopy();
            }
            return result;
        } catch (CloneNotSupportedException e) {
            // The clone method does not declare throws CloneNotSupportedException because this exception is handled internally.
            // If the exception were ever thrown, it would be wrapped in an AssertionError, as this situation should not happen if the Cloneable contract is fulfilled.
            throw new AssertionError();
        }
    }

    // If your class isn't implementing Cloneable, you're better off copying objects with a...
    // 1. Copy constructor
    public HashTable(HashTable original) {
        this.buckets = new Entry[original.buckets.length];
        for (int i = 0; i < original.buckets.length; i++) {
            if (original.buckets[i] != null) {
                this.buckets[i] = original.buckets[i].deepCopy();
            }
        }
    }

    // If your class isn't implementing Cloneable, you're better off copying objects with a...
    // 2. Copy static factory method
    public static HashTable copyOf(HashTable original) {
        return new HashTable(original);
    }
}

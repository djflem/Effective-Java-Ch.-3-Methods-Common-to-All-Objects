package org.example.overridingclone;

// All classes implementing Cloneable should override clone with a public method whose return type is the class itself.
// This method should first call super.clone, then fix any fields that need fixing. Typically, this means copying
// any mutable objects that comprise the internal "deep structure" of the object and replacing the clone's references
// to these objects with references to their copies.
public class Entry {
    final Object key;
    Object value;
    Entry next;

    Entry(Object key, Object value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    // Or if I don't want to implement a working clone method, and to prevent subclasses from implementing one
    // by providing the following degenerate clone implementation:
    //@Override
    //protected final Object clone() throws CloneNotSupportedException {
    //    throw new CloneNotSupportedException();
    //}
}

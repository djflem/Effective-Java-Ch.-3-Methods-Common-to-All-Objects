package overridingclone;

import org.example.overridingclone.Stack;
import org.junit.Test;
import java.util.EmptyStackException;
import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void testCloneMethod() {
        Stack original = createSampleStack();
        Stack cloned = original.clone();

        // Ensure the cloned stack is independent of the original
        cloned.pop();

        // Original stack remains unaffected
        assertEquals(3, getStackSize(original));
        assertEquals(2, getStackSize(cloned));

        // Verify the contents
        assertStackContains(original, "Third", "Second", "First");
        assertStackContains(cloned, "Second", "First");
    }

    @Test
    public void testCopyConstructor() {
        Stack original = createSampleStack();
        Stack copied = new Stack(original);

        // Ensure the copied stack is independent of the original
        copied.pop();

        // Original stack remains unaffected
        assertEquals(3, getStackSize(original));
        assertEquals(2, getStackSize(copied));

        // Verify the contents
        assertStackContains(original, "Third", "Second", "First");
        assertStackContains(copied, "Second", "First");
    }

    @Test
    public void testCopyFactoryMethod() {
        Stack original = createSampleStack();
        Stack copied = Stack.copyOf(original);

        // Ensure the copied stack is independent of the original
        copied.pop();

        // Original stack remains unaffected
        assertEquals(3, getStackSize(original));
        assertEquals(2, getStackSize(copied));

        // Verify the contents
        assertStackContains(original, "Third", "Second", "First");
        assertStackContains(copied, "Second", "First");
    }

    private Stack createSampleStack() {
        Stack stack = new Stack();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        return stack;
    }

    private int getStackSize(Stack stack) {
        Stack temp = new Stack(stack); // Use a copy to avoid mutating the original
        int size = 0;
        while (true) {
            try {
                temp.pop();
                size++;
            } catch (EmptyStackException e) {
                break;
            }
        }
        return size;
    }

    private void assertStackContains(Stack stack, String... elements) {
        Stack temp = new Stack(stack); // Use a copy to avoid mutating the original
        for (String element : elements) {
            assertEquals(element, temp.pop());
        }
        assertThrows(EmptyStackException.class, temp::pop); // Ensure the stack is empty
    }
}

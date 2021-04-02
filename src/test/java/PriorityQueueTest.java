import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PriorityQueueTest{
    public static Stream<Arguments> streamParameters() {
        return Stream.of(
                arguments(new int[]{1, 3, 4, 2}, new int[]{1, 3, 3, 4}),
                arguments(new int[]{7, 9, 2, 5}, new int[]{2, 2, 7, 9}),
                arguments(new int[]{5, 8, 0, 2}, new int[]{0, 1, 5, 8}),
                arguments(new int[]{6, 4, 8, 1}, new int[]{1, 1, 6, 8}),
                arguments(new int[]{0, 5, 7, 9}, new int[]{0, 1, 7, 9})
        );
    }
    @ParameterizedTest
    @MethodSource("streamParameters")
    public void parameterizedTest(int[] random_array, int[] correct_array) {
        PriorityQueue pqTester = new PriorityQueue();
        for (int e : random_array) {
            // offer: Inserts the specified element into this priority queue.
            pqTester.offer(e);
        }
        for (int e : correct_array) {
            // poll: Retrieves and removes the head of this queue, or returns null if this queue is empty.
            assertEquals(e, pqTester.poll());
        }
    }
    @Test
    public void initialCapacityTest() {
        // Throws: IllegalArgumentException - if initialCapacity is less than 1
        assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(0);
        });
    }

    @Test
    public void offerTest() {
        // Throws: NullPointerException - if the specified element is null
        assertThrows(NullPointerException.class, () -> new PriorityQueue().offer(null));
    }

    @Test
    public void addTest() {
        // Throws: NullPointerException - if the specified element is null
        assertThrows(NullPointerException.class, () -> new PriorityQueue().add(null));
    }
}

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import mihajlovic.jelena.TwoNumbers;

public class TwoNumbersTest {

    private TwoNumbers tn = new TwoNumbers();
    private int[] array = { 5, 3, 1, 8, 10, 34, 2, 12 };
    private int target = 12;

    @Test
    void testBruteForce() {
	assertArrayEquals(new int[] { 4, 6 }, tn.bruteForce(array, target));
	assertThrows(IllegalArgumentException.class, () -> {
	    tn.bruteForce(null, target);
	});
	assertNull(tn.bruteForce(array, target * 2));
    }

    @Test
    void testHashMap() {
	assertArrayEquals(new int[] { 4, 6 }, tn.hashMap(array, target));
	assertThrows(IllegalArgumentException.class, () -> {
	    tn.hashMap(null, target);
	});
	assertNull(tn.hashMap(array, target * 2));
    }

    @Test
    void testTwoNumbers() {
	assertArrayEquals(new int[] { 4, 6 }, tn.twoNumbers(array, target));
	assertThrows(IllegalArgumentException.class, () -> {
	    tn.twoNumbers(null, target);
	});
	assertNull(tn.twoNumbers(array, target * 2));
    }
}

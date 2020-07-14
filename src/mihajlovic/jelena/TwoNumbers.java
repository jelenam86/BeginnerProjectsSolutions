package mihajlovic.jelena;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoNumbers {

    /*
     * Given an array of integers, return indices of the two numbers such that they
     * add up to a specific target. You may assume that each input would have
     * exactly one solution, and you may not use the same element twice.
     */

    public static void main(String[] args) {

	TwoNumbers tn = new TwoNumbers();
	int[] array = { 2, 17, 11, 15, 9, 7, 6 };
	int target = 9;

	tn.print(tn.bruteForce(array, target));
	tn.print(tn.hashMap(array, target));
	tn.print(tn.twoNumbers(array, target));

    }

    private void checkInput(int[] array) {
	if (array == null || array.length < 2) {
	    throw new IllegalArgumentException("No such elements");
	}
    }

    public int[] bruteForce(int[] array, int target) {
	checkInput(array);
	for (int i = 0; i < array.length - 1; i++) {
	    for (int j = i + 1; j < array.length; j++) {
		if (array[i] + array[j] == target) {
		    return new int[] { i, j };
		}
	    }
	}
	return null;
    }

    public int[] hashMap(int[] array, int target) {
	checkInput(array);
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	for (int i = 0; i < array.length; i++) {
	    if (map.containsKey(array[i])) {
		return new int[] { map.get(array[i]), i };
	    }
	    map.put(target - array[i], i);
	}
	return null;
    }

    public int[] twoNumbers(int[] array, int target) {
	checkInput(array);
	int[] values = findValues(array, target);
	if (values == null)
	    return null;
	int first = returnIndex(values[0], array);
	int second = returnIndex(values[1], array);
	return new int[] { Math.min(first, second), Math.max(first, second) };
    }

    private int[] findValues(int[] array, int target) {
	int[] copyOfArray = array.clone();
	Arrays.sort(copyOfArray);
	int min = 0;
	int max = copyOfArray.length - 1;
	while (min < max) {
	    if (copyOfArray[min] + copyOfArray[max] > target) {
		max--;
	    } else if (copyOfArray[min] + copyOfArray[max] < target) {
		min++;
	    } else {
		return new int[] { copyOfArray[min], copyOfArray[max] };
	    }
	}
	return null;
    }

    private int returnIndex(int value, int[] array) {
	return IntStream.range(0, array.length).filter(i -> array[i] == value).findFirst().orElse(-1);
    }

    private void print(int[] array) {
	System.out.println(array == null ? "No such elements" : "" + array[0] + " " + array[1]);
    }
}

package mihajlovic.jelena;

public class Palindrome {

    /*
     * Palindrome means anything(here numbers) that reads the same backwards as
     * forwards. Write a program to check if a number is a palindrome or not. For
     * example 12321 is a palindrome since it reads the same forward and backwards.
     */

    public boolean isPalindrome(int number) {
	int[] array = createArray(number);
	int length = array.length;
	int half = length / 2 == 0 ? length / 2 : length / 2 + 1;
	for (int i = 0; i < half; i++) {
	    if (array[i] != array[length - 1 - i])
		return false;
	}
	return true;
    }

    private int[] createArray(int number) {
	if (number == 0)
	    return new int[] { 0 };
	int[] array = new int[(int) (Math.log10(number) + 1)];
	while (number > 0) {
	    array[(int) (Math.log10(number) + 1) - 1] = number % 10;
	    number /= 10;
	}
	return array;
    }

    public boolean isPalindromeUsingStringBuilder(int number) {
	String string = String.valueOf(number);
	StringBuilder builder = new StringBuilder(string);
	return string.equals(builder.reverse().toString());

    }

    public boolean isPalindromeRecursive(int number) {
	int[] array = createArray(number);
	int forward = 0;
	int backward = array.length - 1;
	if (forward == backward)
	    return true;
	if (array[forward] != array[backward])
	    return false;
	if (forward < backward + 1) {
	    return isPalindromeRecursive(removeFirstAndLastDigit(number));
	}
	return true;
    }

    private int removeFirstAndLastDigit(int number) {
	int[] array = createArray(number);
	if (array.length <= 2)
	    return 0;
	StringBuilder sb = new StringBuilder();
	for (int i = 1; i < array.length - 1; i++) {
	    sb.append(array[i]);
	}
	return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {

	Palindrome p = new Palindrome();

	System.out.println(p.isPalindrome(1234321));
	System.out.println(p.isPalindromeUsingStringBuilder(1234321));
	System.out.println(p.isPalindromeRecursive(1234321));

	// see PalindromeTest in test package
    }

}

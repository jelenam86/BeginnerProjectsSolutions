package mihajlovic.jelena;

import java.util.ArrayList;
import java.util.List;

public class ChickensAndRabbits {

    /*
     * Write a program to solve a classic ancient Chinese puzzle: We count 35 heads
     * and 94 legs among the chickens and rabbits in a farm. How many rabbits and
     * how many chickens do we have?
     * 
     * Hint: Use for loop to iterate all possible solutions.
     */

    public static void main(String[] args) {

	int numberOfHeads = 35;
	int numberOfLegs = 94;

	new ChickensAndRabbits().findAllSolutions(numberOfHeads, numberOfLegs).forEach(System.out::println);
    }

    private List<Solution> findAllSolutions(int numberOfHeads, int numberOfLegs) {
	List<Solution> list = new ArrayList<Solution>();
	for (int i = 0; i <= numberOfHeads; i++) {
	    int j = numberOfHeads - i;
	    if (4 * i + 2 * j == numberOfLegs) {
		list.add(this.new Solution(i, j));
	    }
	}
	return list;
    }

    class Solution {

	int rabbits;
	int chickens;

	Solution(int rabbits, int chickens) {
	    this.rabbits = rabbits;
	    this.chickens = chickens;
	}

	public int getRabbits() {
	    return rabbits;
	}

	public void setRabbits(int rabbits) {
	    this.rabbits = rabbits;
	}

	public int getChickens() {
	    return chickens;
	}

	public void setChickens(int chickens) {
	    this.chickens = chickens;
	}

	@Override
	public String toString() {
	    return "Number of rabbits: " + rabbits + ", Number of chickens: " + chickens;
	}

    }
}

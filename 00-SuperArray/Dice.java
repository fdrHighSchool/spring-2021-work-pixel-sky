public class Dice {
    private DynamicArray<Integer> rolls = new DynamicArray<Integer>();
    private int sides;

    // default constructor
    public Dice() {
        this(6);
    }

    public Dice(int sides) {
        if (sides < 1) throw new IllegalArgumentException("Cannot have sides less than 1. Argument passed: " + sides);
        this.sides = sides;
    }

    // roll the dice 
    public int roll() {
        int randomNumber = (int)(Math.random() * this.sides) + 1;
        this.rolls.add(randomNumber);
        return randomNumber;
    }

    // return the sum of all rolls
    public int sumRolls() {
        int sum = 0;
        for (int i = 0; i < this.rolls.size(); i++) sum += this.rolls.get(i);
        return sum;
    }

    // return the average of the rolls
    public double average() {
        return sumRolls() / this.rolls.size();
    }
    
    // return the indexes of the longest run
    public DynamicArray<Integer> indexesOfLongestRun() {
        if (this.rolls.size() < 3) return null;

        DynamicArray<Integer> indexes = new DynamicArray<Integer>(2); // store the indexes of the longest runs
        int longestRun = 0; // store the longest run that has occured
        int countRuns = 0; // count run of the current running number
        int running = 0; // store the index of the current running number

        // illterate throught all the rolls
        for (int i = 0; i < this.rolls.size(); i++) {
            // check if the running number is still the same
            if (this.rolls.get(running) != this.rolls.get(i)) {
                // if the current run is the same length as the longest run, add the index of the current run to the list
                if (countRuns == longestRun) indexes.add(i);
                // if the current run is longer than the longest run
                else if (countRuns > longestRun) {
                    indexes.clear(); // clear the list
                    indexes.add(running); // add the index of the new longest run to the list
                    longestRun = countRuns; // update the longest run
                }
                running = i; // update the running number
                countRuns = 1; // reset run count
            }
            else {
                countRuns++;
            }
        }

        if (longestRun > 1) { // if there is a run of 2 or above
            if (countRuns == longestRun) indexes.add(running); // if the current run number is the same as the longest run, add the current running number to the list
            else if (countRuns > longestRun) { // if the current run is longer than the longest run
                indexes.clear(); // clear the list 
                indexes.add(running); // add the current run to the empty list
            }
            return indexes;
        }
        else return null; // if there are no run of 2 or above, return null
    }

    // return the number with the longest consecutive run 
    public int[] numberOfLongestRun() {
        DynamicArray<Integer> run = this.indexesOfLongestRun(); // store the indexes of the higest runs
        if (run == null) return null; // if there are no run, return null

        int[] numbers = new int[run.size()]; // store the numbers with the lontest run
        for (int i = 0; i < run.size(); i++) numbers[i] = this.rolls.get(run.get(i)); // add the number to the list
        return numbers;
    }

    // return the length of the longest run
    public int lengthOfLongestRun() {
        DynamicArray<Integer> run = this.indexesOfLongestRun(); // store the index of the highest runs
        if (run == null) return -1; // if there are no run, return -1

        int length = 0; // keep track of the length
        int index = run.get(0); // get the first index of the top run
        int number = this.rolls.get(index); // get the number of the first index of the top run
        while (this.rolls.get(index + length) == number) length++; // while it is the same number, increase length
        return length;
    }

    // return the amount of sides on the dice
    public int getSides() {
        return this.sides;
    }

    public void clearRolls() {
        this.rolls.clear();
    }

    // return the rolls user has made
    @Override
    public String toString() {
        return this.rolls.toString();
    }
}

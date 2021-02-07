public class DiceRoll {
    private DynamicArray<Integer> rolls = new DynamicArray<Integer>();
    private int sides;

    // default constructor
    public DiceRoll() {
        this(6);
    }

    public DiceRoll(int sides) {
        if (sides < 1) throw new IllegalArgumentException("Cannot have sides less than 1. Argument passed: " + sides);
        this.sides = sides;
    }

    // roll the dice 
    public int roll() {
        int randomNumber = (int)(Math.random() * this.sides) - 1;
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

    // return the amount of sides on the dice
    public int getSides() {
        return this.sides;
    }

    // return the rolls user has made
    @Override
    public String toString() {
        return this.rolls.toString();
    }
}

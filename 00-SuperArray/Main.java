import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // DynamicArray<Integer> numbersArray = new DynamicArray<Integer>(0);
        // int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // print(numbersArray.isEmpty());      // true
        // print(numbersArray.size());         // 0
        
        // for (int i = 0; i < numbers.length; i++) numbersArray.add(numbers[i]);
        // print(numbersArray.toString());     // [1, 2, 3, 4, 5, 6, 7, 8, 9]
        
        // numbersArray.set(8, 0);            
        // print(numbersArray.toString());     // [1, 2, 3, 4, 5, 6, 7, 8, 0]
        
        // print(numbersArray.removeAt(8));    // 0
        // print(numbersArray.toString());     // [1, 2, 3, 4, 5, 6, 7, 8]
        
        // print(numbersArray.remove(8));      // true
        // print(numbersArray.toString());     // [1, 2, 3, 4, 5, 6, 7]
        
        // print(numbersArray.indexOf(4));     // 3
        
        // print(numbersArray.get(4));         // 5
        
        // print(numbersArray.size());         // 7
        
        // print(numbersArray.contains(4));    // true

        // numbersArray.grow(10);              // increase capacity by 10

        // numbersArray.add(2, 11);
        // print(numbersArray.toString());     // [1, 2, 11, 3, 4, 5, 6, 7]

        // print(numbersArray.removeAt(2));    // 11
        // print(numbersArray.toString());     // [1, 2, 3, 4, 5, 6, 7]

        // print(numbersArray.size());         // 7
        
        // print(numbersArray.isEmpty());      // false

        // numbersArray.clear();               
        // print(numbersArray.toString());     // []

        // print(numbersArray.isEmpty());      // true
        // print(numbersArray.size());         // 0

        // -------------------------------------------------------- //
        Dice dice = new Dice();

        print(dice.toString());

        print(dice.getSides());

        print(dice.indexesOfLongestRun());

        for (int i = 0; i < 5; i++) dice.roll();
        print(dice.toString());

        print(dice.indexesOfLongestRun());
        print(Arrays.toString(dice.numberOfLongestRun()));
        print(dice.lengthOfLongestRun());

        dice.clearRolls();
        print(dice.toString());
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }
}

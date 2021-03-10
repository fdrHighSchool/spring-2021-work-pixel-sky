public class ArrayTester {
    public static boolean hasAllValues(int[] arr1, int[] arr2) {}
    public static boolean containsDuplicates(int[] arr) {}
    
    public static int[] getColumn(int[][] arr2D, int c) {
        int[] newArray = new int[arr2D.length];

        for (int r = 0; r < arr2D.length; r++) {
            newArray[r] = arr2D[r][c];
        }

        return newArray;
    }

    public static boolean isLatin(int[][] square) {
        if (containsDuplicates(square[0])) return false;

        for (int r = 1; r < square.length; r++) {
            if (!hasAllValues(square[0], square[r])) {
                return false;
            }
        }

        for (int r = 0; r < square.length; r++) {
            if (!hasAllValues(square[0], getColumn(square, r))) {
                return false;
            }
        }

        return true;
    }
}

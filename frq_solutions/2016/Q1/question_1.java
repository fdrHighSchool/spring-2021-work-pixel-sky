import java.util.ArrayList;

class RandomStringChooser {
    private ArrayList<String> string_list = new ArrayList<String>();

    // construct from string array
    public RandomStringChooser(String[] s_array) {
        for (String string : s_array) 
            string_list.add(string);
    }

    // return a random string and pop it
    // if list empty return NONE
    public String getNext() {
        return !this.string_list.isEmpty() ? this.string_list.remove((int) (Math.random() * this.string_list.size())) : "NONE";
    }
}

class RandomLetterChooser extends RandomStringChooser {
    public RandomLetterChooser(String str) {
        super(getSingleLetters(str));
    }

    public static String[] getSingleLetters(String str) {
    }
}
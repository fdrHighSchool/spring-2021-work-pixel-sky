import java.util.List;

class StringFormatter {
    public static int totalLetters(List<String> wordList) {
        int totalLetters = 0;
        for (String word : wordList) {
            totalLetters += word.length();
        }
        return totalLetters;
    }

    public static int basicGapWidth(List<String> wordList, int formattedLen) {
        return (formattedLen - totalLetters(wordList)) / (wordList.size() - 1);
    }

    public static int leftoverSaces(List<String> wordList, int formattedLen) { 
        return (formattedLen - totalLetters(wordList)) % (wordList.size() - 1);
    }

    public static String format(List<String> wordList, int formattedLen) {
        int basicGapWidth = basicGapWidth(wordList, formattedLen);
        int leftoverSaces = leftoverSaces(wordList, formattedLen);
        
        StringBuilder sb = new StringBuilder().append(wordList.get(0));
        for (int i = 1; i < wordList.size(); i++) {
            for (int c = leftoverSaces-- > 0 ? -1 : 0; c < basicGapWidth; c++)
                sb.append(" ");
            sb.append(wordList.get(i));
        }
        return sb.toString();
    }
}

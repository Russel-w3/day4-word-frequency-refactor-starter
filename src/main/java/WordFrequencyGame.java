import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    public static final String ANY_SPACE_SEPARATOR = "\\s+";

    public String getResult(String inputStr) {
        String[] words = inputStr.split(ANY_SPACE_SEPARATOR);
        if (words.length == 1) {
            return inputStr + " 1";
        } else {
            try {
                List<Input> frequencies = countFrequencies(words);
                frequencies.sort((word1, word2) -> word2.getWordCount() - word1.getWordCount());
                return comPoseOutput(frequencies);
            } catch (Exception e) {
                return "Calculate Error";
            }
        }
    }

    private static String comPoseOutput(List<Input> frequencies) {
        return frequencies.stream()
                .map(word -> word.getValue() + " " + word.getWordCount())
                .collect(Collectors.joining("\n"));
    }

    private List<Input> countFrequencies(String[] words) {
        Map<String, Integer> wordCountMap = groupSameWords(words);
        List<Input> frequencies = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            frequencies.add(new Input(entry.getKey(), entry.getValue()));
        }
        return frequencies;
    }

    private static Map<String, Integer> groupSameWords(String[] words) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        return wordCountMap;
    }


}

package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import model.Word;
import model.WordInfo;

public class InputHandler {

    public List<WordInfo> getWordInfo(File file) throws IOException {
        var inputText = Files.readString(file.toPath());

        return getWords(inputText)
                .stream()
                .map(w -> {
                    List<Character> vowels = getVowels(w);
                    var word = new Word(new HashSet<>(vowels), w.length());
                    return new WordInfo(word, (double) vowels.size());
                })
                .toList();

    }

    private List<String> getWords(String input) {
        return Arrays.stream(input
                        .replaceAll("[^a-zA-Z ]", "")
                        .toLowerCase()
                        .split("\\s+"))
                .toList();
    }

    private List<Character> getVowels(String w) {
        return w.chars()
                .filter(ch -> List.of('u', 'i', 'e', 'o', 'a').contains((char) ch))
                .mapToObj(ch -> (char) ch)
                .toList();
    }

}

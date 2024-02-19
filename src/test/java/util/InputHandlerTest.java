package util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import model.Word;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    @Test
    void getWordInfo() throws IOException {
        var inputFile = new File("src/test/resources/input.txt");

        var inputHandler = new InputHandler();
        var wordInfo = inputHandler.getWordInfo(inputFile);

        assertEquals(17, wordInfo.size());
        assertEquals(new Word(Set.of('a', 'o'), 6), wordInfo.get(0).getWord());
        assertEquals(2, wordInfo.get(0).getVowelCount());
        assertEquals(6, wordInfo.get(0).getWord().getLength());
    }
}
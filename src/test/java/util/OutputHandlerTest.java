package util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Set;
import model.AverageOutput;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class OutputHandlerTest {
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    void writeAverages() throws IOException {
        var outputHandler = new OutputHandler();
        var averages = new ArrayList<AverageOutput>();

        averages.add(new AverageOutput(Set.of('a', 'u', 'z'), 5, (double) 3));

        outputHandler.writeAverages(averages, new File("output-test.txt"));
        var outputText = Files.readString(Path.of("output-test.txt"));
        assertEquals(outputText, averages.get(0).toString());

    }

    @Test
    void writeAveragesFail() {
        var outputHandler = new OutputHandler();
        var averages = new ArrayList<AverageOutput>();

        averages.add(new AverageOutput(Set.of('a', 'u', 'z'), 5, (double) 3));

        outputHandler.writeAverages(averages, new File("output-test.txt"));
        exceptionRule.expect(IOException.class);
    }
}
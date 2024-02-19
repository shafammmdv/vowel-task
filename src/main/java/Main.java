import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;
import model.AverageOutput;
import model.WordInfo;
import util.InputHandler;
import util.OutputHandler;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {

        var inputHandler = new InputHandler();
        var outputHandler = new OutputHandler();
        var outputs = new ArrayList<AverageOutput>();

        var inputFile = new File(Objects.requireNonNull(Main.class.getResource("input.txt")).toURI());
        var outputFile = new File("output.txt");
        var wordInfo = inputHandler.getWordInfo(inputFile);


        var averages = wordInfo
                .stream()
                .collect(Collectors.groupingBy(a -> a.getWord().getLength(),
                        Collectors.groupingBy(a -> a.getWord().getVowels(),
                                Collectors.averagingDouble(WordInfo::getVowelCount))));


        averages.forEach((length, vowelData) -> vowelData.forEach((vowels, average) ->
                outputs.add(new AverageOutput(vowels, length, average))));

        outputHandler.writeAverages(outputs, outputFile);
    }

}

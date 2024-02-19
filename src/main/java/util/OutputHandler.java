package util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import model.AverageOutput;
import org.apache.commons.io.FileUtils;

public class OutputHandler {

    public void writeAverages(List<AverageOutput> averages, File outputFile) {
        averages.forEach(av -> {
            try {
                FileUtils.writeStringToFile(outputFile, av.toString(), StandardCharsets.UTF_8, averages.indexOf(av) != 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

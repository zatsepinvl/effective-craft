package contest.taskG;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.String.format;

public class Generator {

    private final static String INPUT = "_input.txt";

    public static void main(String[] args) throws IOException {
        Files.deleteIfExists(Path.of(INPUT));
        Files.createFile(Path.of(INPUT));
        BufferedWriter writer = new BufferedWriter(new FileWriter(INPUT));
        int n = 1000;
        writer.write("" + n);
        writer.newLine();
        int xOffset = 1_000_000_000;
        int yOffset = -1_000_000_000;
        for (int i = 0; i < n; i++) {
            writer.write(format("%d %d", xOffset + i, xOffset + i));
            writer.newLine();
        }
      /*  for (int i = n; i > 0; i--) {
            writer.write(format("%d %d", i, i));
            writer.newLine();
        }*/
        int capacity = 2_000_000_000;
        writer.write("" + capacity);
        writer.newLine();
        writer.write(format("%d %d", 1, n));
        writer.newLine();
        writer.close();
    }
}

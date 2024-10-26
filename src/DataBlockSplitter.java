package src;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DataBlockSplitter {

    public static List<byte[]> getFileBlocks(String filePath, int blockSize) throws IOException {
        List<byte[]> blocks = new ArrayList<>();

        // Read the file and split it into blocks
        try (InputStream inputStream = Files.newInputStream(Paths.get(filePath))) {
            byte[] buffer = new byte[blockSize];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                // If the last block is smaller than the block size, trim the buffer
                if (bytesRead < blockSize) {
                    buffer = Arrays.copyOf(buffer, bytesRead);
                }
                blocks.add(buffer.clone()); // Clone the buffer to avoid overwriting
            }
        }

        return blocks;
    }
}
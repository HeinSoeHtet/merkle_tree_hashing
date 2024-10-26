package src;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.nio.file.*;

public class MultiThreadedMerkleTreeHash {

    public static TableData computeRootHash(List<String> filePaths, int numThreads)
            throws Exception {

        long startTime = System.currentTimeMillis();

        // Create a thread pool with runtime available processors
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<String>> rootHashFutures = new ArrayList<>();

        // Submit tasks for each file path
        for (String filePath : filePaths) {
            rootHashFutures.add(executor.submit(() -> computeSingleRootHash(filePath, numThreads)));
        }

        // Collect results from all futures
        for (Future<String> future : rootHashFutures) {
            String rootHashString = future.get();
            System.out.println("Merkle Root Hash: " + rootHashString);
        }

        // Shutdown executor service
        executor.shutdown();

        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        return new TableData("Multi thread", Integer.toString(numThreads), Integer.toString(filePaths.size()),
                Long.toString(timeTaken) + " ms");
    }

    private static String computeSingleRootHash(String filePath, int numThreads) throws Exception {
        long fileSize = Files.size(Paths.get(filePath));
        int leafNodeCount = 10000;

        List<byte[]> dataBlocks = DataBlockSplitter.getFileBlocks(
                filePath,
                (int) Math.ceil((double) fileSize / leafNodeCount));

        // Create a thread pool with runtime available processors
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Hash all leaf nodes in parallel
        List<Future<byte[]>> leafHashes = new ArrayList<>();
        for (byte[] block : dataBlocks) {
            leafHashes.add(executor.submit(() -> MerkleTreeHashUtil.hash(block)));
        }

        // Wait for all leaf hashes to complete
        List<byte[]> currentLevel = new ArrayList<>();
        for (Future<byte[]> future : leafHashes) {
            currentLevel.add(future.get());
        }

        // Build the Merkle tree levels in parallel
        while (currentLevel.size() > 1) {
            List<byte[]> nextLevel = new ArrayList<>();
            List<Future<byte[]>> parentHashes = new ArrayList<>();

            for (int i = 0; i < currentLevel.size(); i += 2) {
                int left = i;
                int right = Math.min(i + 1, currentLevel.size() - 1);
                byte[] leftNode = currentLevel.get(left);
                byte[] rightNode = currentLevel.get(right);

                // Hash pairs in parallel
                parentHashes.add(executor
                        .submit(() -> MerkleTreeHashUtil.hash(MerkleTreeHashUtil.concatByteArr(leftNode, rightNode))));
            }

            // Wait for all parent node hashes to complete
            for (Future<byte[]> future : parentHashes) {
                nextLevel.add(future.get());
            }

            // Move up to the next level
            currentLevel = nextLevel;
        }

        byte[] rootHash = currentLevel.get(0);
        executor.shutdown(); // Shutdown executor for the current file

        return MerkleTreeHashUtil.bytesToHex(rootHash);
    }
}
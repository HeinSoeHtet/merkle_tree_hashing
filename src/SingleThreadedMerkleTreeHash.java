package src;

import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.nio.file.*;

public class SingleThreadedMerkleTreeHash {
    public static TableData computeRootHash(List<String> filePaths) throws Exception {

        long startTime = System.currentTimeMillis();

        for (String filePath : filePaths) {

            long fileSize = Files.size(Paths.get(filePath));
            int leafNodeCount = 10000;

            List<byte[]> dataBlocks = DataBlockSplitter.getFileBlocks(
                    filePath,
                    (int) Math.ceil((double) fileSize / leafNodeCount));

            // Hash all leaf nodes
            List<byte[]> leafHashes = new ArrayList<>();
            for (byte[] block : dataBlocks) {
                leafHashes.add(MerkleTreeHashUtil.hash(block));
            }

            byte[] rootHash = buildMerkleTree(leafHashes);

            String rootHashString = MerkleTreeHashUtil.bytesToHex(rootHash);
            System.out.println("Merkle Root Hash: " + rootHashString);

        }

        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        return new TableData("Single thread", "1", Integer.toString(filePaths.size()),
                Long.toString(timeTaken) + " ms");
    }

    private static byte[] buildMerkleTree(List<byte[]> leafHashes) throws NoSuchAlgorithmException {
        List<byte[]> currentLevel = leafHashes;

        // Continue building the tree until we have a single root hash
        while (currentLevel.size() > 1) {
            List<byte[]> nextLevel = new ArrayList<>();

            for (int i = 0; i < currentLevel.size(); i += 2) {
                // Get two adjacent hashes (or duplicate the last one if odd number)
                byte[] left = currentLevel.get(i);
                byte[] right = (i + 1 < currentLevel.size()) ? currentLevel.get(i + 1) : left;

                // Concatenate the two hashes and hash them together to form the parent node
                byte[] concatenated = MerkleTreeHashUtil.concatByteArr(left, right);
                byte[] parentHash = MerkleTreeHashUtil.hash(concatenated);
                nextLevel.add(parentHash);
            }

            // Move up to the next level in the tree
            currentLevel = nextLevel;
        }

        return currentLevel.get(0);
    }

}

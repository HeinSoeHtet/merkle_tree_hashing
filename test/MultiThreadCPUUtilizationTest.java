package test;

import src.MultiThreadedMerkleTreeHash;

import java.util.List;
import java.util.Collections;

public class MultiThreadCPUUtilizationTest {
    public static void main(String[] args) throws Exception {
        // just to warm-up JVM
        MultiThreadedMerkleTreeHash
                .computeRootHash(List.of("resources/6KB.csv"), 20);

        MultiThreadedMerkleTreeHash
                .computeRootHash(Collections.nCopies(100, "resources/150MB.csv"), 20);

    }
}

package test;

import src.SingleThreadedMerkleTreeHash;

import java.util.Collections;
import java.util.List;

public class SingleThreadCPUUtilizationTest {

    public static void main(String[] args) throws Exception {
        // just to warm-up JVM
        SingleThreadedMerkleTreeHash
                .computeRootHash(List.of("resources/6KB.csv"));

        SingleThreadedMerkleTreeHash
                .computeRootHash(Collections.nCopies(100, "resources/150MB.csv"));
    }

}

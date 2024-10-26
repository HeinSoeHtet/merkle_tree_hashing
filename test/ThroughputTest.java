package test;

import src.MultiThreadedMerkleTreeHash;
import src.SingleThreadedMerkleTreeHash;
import src.Table;

import java.util.Collections;
import java.util.List;

public class ThroughputTest {
        public static void main(String[] args) throws Exception {
                // just to warm-up JVM
                SingleThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv"));
                MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv"), 4);

                Table table1 = new Table();

                table1.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/6KB.csv")));

                table1.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/6KB.csv"), 5));
                table1.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/6KB.csv"), 10));
                table1.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/6KB.csv"), 20));
                table1.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/6KB.csv"), 50));
                table1.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/6KB.csv"), 100));

                Table table2 = new Table();

                table2.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/30MB.csv")));

                table2.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/30MB.csv"), 5));
                table2.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/30MB.csv"), 10));
                table2.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/30MB.csv"), 20));
                table2.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/30MB.csv"), 50));
                table2.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/30MB.csv"), 100));
                Table table3 = new Table();
                table3.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/150MB.csv")));

                table3.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/150MB.csv"), 5));
                table3.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/150MB.csv"), 10));
                table3.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/150MB.csv"), 20));
                table3.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/150MB.csv"), 50));
                table3.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/150MB.csv"), 100));

                System.out.println("\n50x6KB");
                table1.print();
                System.out.println("\n50x30MB");
                table2.print();
                System.out.println("\n50x150MB");
                table3.print();

        }
}

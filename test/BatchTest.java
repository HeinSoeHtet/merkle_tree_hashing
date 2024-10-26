package test;

import src.SingleThreadedMerkleTreeHash;
import src.MultiThreadedMerkleTreeHash;

import java.util.List;
import java.util.Collections;

import src.Table;

public class BatchTest {
        public static void main(String[] args) throws Exception {
                // just to warm-up JVM
                SingleThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv"));
                MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv"), 4);

                Table table1 = new Table();

                table1.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(10, "resources/6KB.csv")));
                table1.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(10, "resources/6KB.csv"), 20));

                table1.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/6KB.csv")));
                table1.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/6KB.csv"), 20));

                table1.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(100, "resources/6KB.csv")));
                table1.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(100, "resources/6KB.csv"), 20));

                Table table3 = new Table();
                table3.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(10, "resources/8MB.csv")));
                table3.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(10, "resources/8MB.csv"), 20));

                table3.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/8MB.csv")));
                table3.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/8MB.csv"), 20));

                table3.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(100, "resources/8MB.csv")));
                table3.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(100, "resources/8MB.csv"), 20));

                Table table4 = new Table();
                table4.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(10, "resources/30MB.csv")));
                table4.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(10, "resources/30MB.csv"), 20));

                table4.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/30MB.csv")));
                table4.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/30MB.csv"), 20));

                table4.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(100, "resources/30MB.csv")));
                table4.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(100, "resources/30MB.csv"), 20));

                Table table5 = new Table();
                table5.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(10, "resources/150MB.csv")));
                table5.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(10, "resources/150MB.csv"), 20));

                table5.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/150MB.csv")));
                table5.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(50, "resources/150MB.csv"), 20));

                table5.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(100, "resources/150MB.csv")));
                table5.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(Collections.nCopies(100, "resources/150MB.csv"), 20));

                System.out.println("\n6KB");
                table1.print();
                System.out.println("\n8MB");
                table3.print();
                System.out.println("\n30MB");
                table4.print();
                System.out.println("\n150MB");
                table5.print();
        }
}

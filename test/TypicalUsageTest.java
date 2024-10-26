package test;

import src.MultiThreadedMerkleTreeHash;
import src.SingleThreadedMerkleTreeHash;
import src.Table;

import java.util.List;

public class TypicalUsageTest {
        public static void main(String[] args) throws Exception {
                // just to warm-up JVM
                SingleThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv"));
                MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv"), 4);

                Table table1 = new Table();

                table1.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv", "resources/6KB.csv", "resources/8MB.csv",
                                                "resources/30MB.csv")));
                table1.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv", "resources/6KB.csv", "resources/8MB.csv",
                                                "resources/30MB.csv"), 5));
                table1.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv", "resources/6KB.csv", "resources/8MB.csv",
                                                "resources/30MB.csv"), 10));
                table1.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv", "resources/6KB.csv", "resources/8MB.csv",
                                                "resources/30MB.csv"), 20));
                table1.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv", "resources/6KB.csv", "resources/8MB.csv",
                                                "resources/30MB.csv"), 50));

                Table table2 = new Table();

                table2.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(
                                                List.of("resources/30MB.csv", "resources/30MB.csv",
                                                                "resources/150MB.csv",
                                                                "resources/150MB.csv", "resources/150MB.csv")));
                table2.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/30MB.csv", "resources/30MB.csv",
                                                "resources/150MB.csv",
                                                "resources/150MB.csv", "resources/150MB.csv"), 5));
                table2.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/30MB.csv", "resources/30MB.csv",
                                                "resources/150MB.csv",
                                                "resources/150MB.csv", "resources/150MB.csv"), 10));
                table2.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/30MB.csv", "resources/30MB.csv",
                                                "resources/150MB.csv",
                                                "resources/150MB.csv", "resources/150MB.csv"), 20));
                table2.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/30MB.csv", "resources/30MB.csv",
                                                "resources/150MB.csv",
                                                "resources/150MB.csv", "resources/150MB.csv"), 50));

                Table table3 = new Table();

                table3.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/8MB.csv", "resources/30MB.csv",
                                                "resources/150MB.csv",
                                                "resources/600MB.csv")));
                table3.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/8MB.csv", "resources/30MB.csv",
                                                "resources/150MB.csv",
                                                "resources/600MB.csv"), 5));
                table3.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/8MB.csv", "resources/30MB.csv",
                                                "resources/150MB.csv",
                                                "resources/600MB.csv"), 10));
                table3.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/8MB.csv", "resources/30MB.csv",
                                                "resources/150MB.csv",
                                                "resources/600MB.csv"), 20));
                table3.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/8MB.csv", "resources/30MB.csv",
                                                "resources/150MB.csv",
                                                "resources/600MB.csv"), 50));

                System.out.println("\n2x6KB, 1x8MB, 1x30MB");
                table1.print();
                System.out.println("\n2x30MB, 3x150MB");
                table2.print();
                System.out.println("\n1x8MB, 1x30MB, 1x150MB, 1x600MB");
                table3.print();
        }
}

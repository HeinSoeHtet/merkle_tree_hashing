package test;

import src.MultiThreadedMerkleTreeHash;

import java.util.List;

import src.Table;
import src.SingleThreadedMerkleTreeHash;

public class BaselineTest {

        public static void main(String[] args) throws Exception {
                // just to warm-up JVM
                SingleThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv"));
                MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv"), 4);

                Table table1 = new Table();

                table1.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv")));
                table1.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv"), 4));

                table1.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv"), 8));
                table1.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv"), 16));
                table1.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/6KB.csv"), 32));

                Table table2 = new Table();
                table2.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/1MB.csv")));
                table2.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/1MB.csv"), 4));
                table2.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/1MB.csv"), 8));
                table2.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/1MB.csv"), 16));
                table2.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/1MB.csv"), 32));

                Table table3 = new Table();
                table3.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/8MB.csv")));
                table3.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/8MB.csv"), 4));
                table3.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/8MB.csv"), 8));
                table3.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/8MB.csv"), 16));
                table3.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/8MB.csv"), 32));

                Table table4 = new Table();
                table4.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/30MB.csv")));
                table4.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/30MB.csv"), 4));
                table4.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/30MB.csv"), 8));
                table4.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/30MB.csv"), 16));
                table4.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/30MB.csv"), 32));

                Table table5 = new Table();
                table5.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/150MB.csv")));
                table5.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/150MB.csv"), 4));
                table5.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/150MB.csv"), 8));
                table5.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/150MB.csv"), 16));
                table5.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/150MB.csv"), 32));

                Table table6 = new Table();
                table6.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/600MB.csv")));
                table6.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/600MB.csv"), 4));
                table6.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/600MB.csv"), 8));
                table6.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/600MB.csv"), 16));
                table6.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/600MB.csv"), 32));

                Table table7 = new Table();
                table7.addData(SingleThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/1.6GB.csv")));
                table7.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/1.6GB.csv"), 4));
                table7.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/1.6GB.csv"), 8));
                table7.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/1.6GB.csv"), 16));
                table7.addData(MultiThreadedMerkleTreeHash
                                .computeRootHash(List.of("resources/1.6GB.csv"), 32));

                System.out.println("\n1x6KB");
                table1.print();
                System.out.println("\n1x1MB");
                table2.print();
                System.out.println("\n1x8MB");
                table3.print();
                System.out.println("\n1x30MB");
                table4.print();
                System.out.println("\n1x150MB");
                table5.print();
                System.out.println("\n1x600MB");
                table6.print();
                System.out.println("\n1x1.6GB");
                table7.print();

        }
}

package src;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private List<TableData> data;

    public Table() {
        this.data = new ArrayList<>();
    }

    public void print() {
        System.out.printf("| %-3s | %-15s | %-12s | %10s | %15s |%n", "No.",
                "Version", "Thread Count", "File Count", "Time Taken", "Description",
                "Unit");

        for (int i = 0; i < this.data.size(); i++) {
            System.out.printf("| %-3s | %-15s | %-12s | %10s | %15s |%n", Integer.toString(i + 1),
                    this.data.get(i).getVersion(), this.data.get(i).getThreadCount(),
                    this.data.get(i).getFileCount(),
                    this.data.get(i).getTimeTaken());
        }
    }

    public void addData(TableData data) {
        this.data.add(data);
    }

}

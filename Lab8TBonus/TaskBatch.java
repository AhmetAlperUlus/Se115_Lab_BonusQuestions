public class TaskBatch {
    private Task[] tasks;
    private int taskCount;

    public TaskBatch() {
        tasks = new Task[5];
        taskCount = 0;
    }

    public void addTask(Task t) {
        if (taskCount < 5) {
            tasks[taskCount] = t;
            taskCount++;
        }

        else {
            System.out.println("Error: Batch is full. Cannot add more tasks.");
        }
    }

    public int getTotalEnergyCost() {
        if (taskCount == 0) {
            System.out.println("Batch is empty.");
            return 0;
        }

        int total = 0;

        for (int i = 0; i < taskCount; i++) {
            total += tasks[i].getEnergyCost();
        }

        return total;
    }

    public Task[] getTasks() {
        if (taskCount == 0) {
            System.out.println("Batch is empty.");
        }

        return tasks;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void printBatchInfo() {
        if (taskCount == 0) {
            System.out.println("Batch is empty, nothing to print."); // [cite: 1912]
        }

        else {
            System.out.println("--- Batch Info ---");

            for (int i = 0; i < taskCount; i++) {
                tasks[i].describeTask();
            }
        }
    }
}

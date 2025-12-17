public class Robot {
    private String modelName;
    private int batteryLevel;
    private String status;

    public Robot(String modelName, int batteryLevel, String status) {
        this.modelName = modelName;
        this.batteryLevel = batteryLevel;
        this.status = status;
    }

    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }

    public int getBatteryLevel() { return batteryLevel; }
    public void setBatteryLevel(int batteryLevel) { this.batteryLevel = batteryLevel; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void displayRobotInfo() {
        System.out.println("Robot Model: " + modelName + ", Battery: " + batteryLevel + ", Status: " + status);
    }

    public boolean isBatteryEnough(int requiredAmount) {
        return batteryLevel >= requiredAmount;
    }

    public void consumeBattery(int amount) {
        batteryLevel -= amount;

        if (batteryLevel < 0) batteryLevel = 0;
    }

    public void chargeBattery(int amount) {
        batteryLevel += amount;

        if (batteryLevel >= 100) {
            status = "Active";
        }

        else {
            status = "Charging";
        }
    }

    public void performTask(Task t) {
        System.out.println(modelName + " is attempting task: " + t.getTaskName());

        if (status.equalsIgnoreCase("Charging")) {
            System.out.println("Failure: Robot is charging and cannot perform tasks.");
            return;
        }

        if (isBatteryEnough(t.getEnergyCost())) {
            consumeBattery(t.getEnergyCost()); // [cite: 1884]
            System.out.println("Success: " + modelName + " completed " + t.getTaskName() + ".");
        }

        else {
            System.out.println("Failure: Not enough battery for " + t.getTaskName());
        }
    }

    public void performTaskBatch(TaskBatch batch) {
        if (batch.getTaskCount() == 0) {
            System.out.println("Error: Batch is empty.");
            return;
        }

        int totalCost = batch.getTotalEnergyCost();

        if (!isBatteryEnough(totalCost)) {
            System.out.println("Error: Not enough battery to process the entire batch.");
            return;
        }

        System.out.println("Processing Batch...");
        Task[] tasks = batch.getTasks();

        for (int i = 0; i < batch.getTaskCount(); i++) {
            performTask(tasks[i]);
            displayRobotInfo();
        }
    }
}

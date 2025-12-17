import java.util.Scanner;

public class Lab8T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Robot Creation ---");
        Robot r1 = new Robot("Atlas", 120, "Active");
        Robot r2 = new Robot("Spot", 45, "Charging");

        r1.displayRobotInfo();
        r2.displayRobotInfo();
        System.out.println();

        System.out.println("--- Battery Operations ---");
        System.out.print("Enter battery amount to consume for " + r1.getModelName() + ": ");
        int consumeAmt = sc.nextInt();

        if (r1.isBatteryEnough(consumeAmt)) {
            r1.consumeBattery(consumeAmt);
            System.out.println("Consumed " + consumeAmt + " battery.");
        }

        else System.out.println("Not enough battery!");

        r1.displayRobotInfo();

        System.out.println("Charging " + r2.getModelName() + " by 60...");
        r2.chargeBattery(60);
        r2.displayRobotInfo();
        System.out.println();

        System.out.println("--- Single Task ---");
        Task t1 = new Task("Welding", 30);
        Task t2 = new Task("Painting", 20);

        t1.describeTask();

        System.out.println("Before Task:");
        r1.displayRobotInfo();

        r1.performTask(t1);

        System.out.println("After Task:");
        r1.displayRobotInfo();
        System.out.println();

        System.out.println("--- Task Batch ---");
        TaskBatch batch = new TaskBatch();

        batch.addTask(new Task("Assembly", 25));
        batch.addTask(new Task("Inspection", 10));
        batch.addTask(new Task("Packing", 15));

        batch.printBatchInfo();
        System.out.println("Total Batch Cost: " + batch.getTotalEnergyCost());
        System.out.println();

        System.out.println("--- Process Batch ---");
        System.out.println("Robot status before batch:");
        r1.displayRobotInfo();

        r1.setBatteryLevel(100);
        r1.setStatus("Active");
        System.out.println("(Robot recharged for demo)");

        r1.performTaskBatch(batch);

        System.out.println("Robot status after batch:");
        r1.displayRobotInfo();
    }
}
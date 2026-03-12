import java.util.*;
public class workloadGenerator {

    public static ArrayList<process> generateProcesses(int count) {

        Random rand = new Random(42);

        ArrayList<process> processes = new ArrayList<>();

        for (int i=1; i<=count; i++) {

            // arrival time between 0-19
            int arrivalTime = rand.nextInt(20);
            // burst time between 1-9
            int burstTime = rand.nextInt(9) + 1;
            // priority range 1-5
            int priority = rand.nextInt(5) + 1;

            process p = new process(i, arrivalTime, burstTime, priority);
            processes.add(p);

        }
        
        return processes;
    }
}

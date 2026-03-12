import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
public class metrics {
    
    public static void printMetrics(String schedulerName, ArrayList<process> processes, int totalTime) {
        double totalWT = 0, totalTAT = 0;
        
        for ( process p: processes) {
            totalWT += p.getWaitingTime();
            totalTAT += p.getTurnaroundTime();
        }

        double avgWT = totalWT/processes.size();
        double avgTAT = totalTAT/processes.size();
        double throughput = (double) processes.size()/totalTime;

        System.out.println("\n---- Metrics ----");
        System.out.println("Average Waiting Time: " + avgWT);
        System.out.println("Average Turnaround Time: " + avgTAT);
        System.out.printf("Throughput: %.2f\n\n",throughput);


        writeToCSV(schedulerName, avgWT, avgTAT, throughput);

    }

    public static void writeToCSV(String schedulerName, double avgWT, double avgTAT, double throughput) {
        try {
            FileWriter writer = new FileWriter("results.csv", true);
            writer.append(schedulerName + "," + avgWT + "," + avgTAT + "," + throughput + "\n");
            writer.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

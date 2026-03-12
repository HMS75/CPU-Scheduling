import java.util.*;

public class finalSimulator {
    public static ArrayList<process> cloneProcesses(ArrayList<process> original) {
        ArrayList<process> copy = new ArrayList<>();

        for (process p : original) {
        copy.add(new process(p.processId, p.arrivalTime, p.burstTime, p.priority));
        }

        return copy;
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

        ArrayList<process> original = workloadGenerator.generateProcesses(50);

        ArrayList<process> fcfsList = cloneProcesses(original);
        scheduler fcfs = new fcfs();
        scheduleResult t1 = fcfs.schedule(fcfsList);
        metrics.printMetrics(t1.schedulerName, fcfsList, t1.totalTime);

        ArrayList<process> adaptiveList = cloneProcesses(original);
        scheduler adaptive = new adaptiveScheduler();
        scheduleResult t2 = adaptive.schedule(adaptiveList);
        metrics.printMetrics(t2.schedulerName, adaptiveList, t2.totalTime);

        System.out.println("-----------");
        
        }
    }
}

import java.util.*;
public class adaptiveScheduler implements scheduler {
    @Override
    public scheduleResult schedule(ArrayList<process> processes) {

        double totalBurst = 0;

        for (process p: processes) {
            totalBurst += p.burstTime;
        }

        double avgBurst = totalBurst/processes.size();
        int processCount = processes.size();

        scheduler choosenScheduler;

        if (avgBurst <= 4) {
            System.out.println("Adaptive chose SJF");
            choosenScheduler = new sjf();
        }

        else if (processCount > 30) {
            System.out.println("Adaptive chose RR");
            choosenScheduler = new roundRobin();
        }
        
        else {
            System.out.println("Adaptive chose FCFS");
            choosenScheduler = new fcfs();
        }
        
        return choosenScheduler.schedule(processes);
    }
}

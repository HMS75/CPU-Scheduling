import java.util.*;

public class roundRobin implements scheduler{
    public scheduleResult schedule(ArrayList<process> processes) {
        Collections.sort(processes, Comparator.comparingInt(p->p.arrivalTime));
        
        Queue<process> readyQueue = new LinkedList<>();

        int time = 0, index = 0, timeQuantum = 2;

        while ( !readyQueue.isEmpty() || index < processes.size() ) {
            while ( index < processes.size() && processes.get(index).arrivalTime < time ) {
                readyQueue.add(processes.get(index));
                index++;
            }
            if ( readyQueue.isEmpty() ) {
                time++;
                continue;
            }

            process current = readyQueue.poll();

            System.out.println("Running P" + current.processId + " at time " + time);

            int runTime = Math.min(timeQuantum, current.remainingTime);

            current.remainingTime -= runTime;
            time += runTime;

            // add newly arrived processes during this time
            while (index < processes.size() && processes.get(index).arrivalTime <= time) {
                readyQueue.add(processes.get(index));
                index++;
            }

            if (current.remainingTime == 0) {
                current.completionTime = time;
                System.out.println("P" + current.processId + " completed at time " + time);
            } else {
                readyQueue.add(current); // rotate back
            }
        }
        return new scheduleResult(time, "SJF");
    }
}

import java.util.*;
public class sjf implements scheduler{
    public scheduleResult schedule(ArrayList<process> processes) {
        /*  how does SJF work?
            shortest burst time! 
            1) so instead of sorting by arrival time, sort by burst time.
            2) but you also have to check if the process arrived at that time or not */

        // sort processes by their burst time
        Collections.sort(processes,Comparator.comparingInt(p->p.arrivalTime));
        
        // create a 
        PriorityQueue<process> readyQueue = new PriorityQueue<>(Comparator.comparingInt(p->p.burstTime));

        int time = 0, index = 0;

        while ( !readyQueue.isEmpty() || index < processes.size() ) {
            while ( index < processes.size() && processes.get(index).arrivalTime <= time) {
                readyQueue.add(processes.get(index));
                index++;
            }
            if ( readyQueue.isEmpty() ) {
                time++;
                continue;
            }

            process current = readyQueue.poll();

            System.out.println("Running P" + current.processId + " at time " + time);

            time += current.burstTime;

            current.completionTime = time;

            System.out.println("P" + current.processId + " completed at " + time);
        }
        return new scheduleResult(time, "SJF");
    }
}

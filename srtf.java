import java.util.*;

public class srtf implements scheduler {
    public scheduleResult schedule(ArrayList<process> processes) {

        Collections.sort(processes, Comparator.comparingInt(p->p.arrivalTime));

        PriorityQueue<process> readyQueue = new PriorityQueue<>(Comparator.comparingInt(p->p.remainingTime));

        int time = 0, index = 0;

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

            time++;
            current.remainingTime--;

            if ( current.remainingTime == 0 ) {
                current.completionTime = time;
                System.out.println("P" + current.processId + " completed at time " + time);
            } 
            else {
                readyQueue.add(current);
            }
        }
        return new scheduleResult(time, "SRTF");
    }
}

import java.util.*;

public class fcfs implements scheduler {

    @Override
    public scheduleResult schedule(ArrayList<process> processes) {

        // sort processes by arrival time
        Collections.sort(processes, Comparator.comparingInt(p -> p.arrivalTime));

        Queue<process> readyQueue = new LinkedList<>();

        int time = 0;
        int index = 0; // to track processes added to queue

        while (!readyQueue.isEmpty() || index < processes.size()) {

            // add processes to queue whose arrival time <= current time
            while (index < processes.size() && processes.get(index).arrivalTime <= time) {
                readyQueue.add(processes.get(index));
                index++;
            }

            if (readyQueue.isEmpty()) {
                time++; // CPU idle
                continue;
            }

            process current = readyQueue.poll();

            System.out.println("Running P" + current.processId + " at time " + time);

            // Run process till completion
            time += current.burstTime;

            current.completionTime = time;

            System.out.println("P" + current.processId + " completed at time " + time);
        }
        return new scheduleResult(time, "FCFS");
    }
}
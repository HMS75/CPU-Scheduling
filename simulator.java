import java.util.ArrayList;

public class simulator {

    public static ArrayList<process> cloneProcesses(ArrayList<process> original) {
        ArrayList<process> copy = new ArrayList<>();

        for (process p : original) {
        copy.add(new process(p.processId, p.arrivalTime, p.burstTime, p.priority));
        }

        return copy;
    }

    public static void main(String[] args) {
        /* 
        // create an ArrayList of Process
        ArrayList<process> processes = new ArrayList<>();

        //manually add 5 processes
        processes.add(new process(1, 0, 5, 2));
        processes.add(new process(2, 1, 3, 1));
        processes.add(new process(3, 2, 8, 3));
        processes.add(new process(4, 3, 6, 2));
        processes.add(new process(5, 4, 2, 1)); */

        // randomly generated processes
        ArrayList<process> original = workloadGenerator.generateProcesses(20);
        
        // print all processes
        for (process p : original) 
        {    p.printProcess(); }

        System.out.println();
         
        /* 
        
        scheduler schedules;

        schedules = new fcfs();
        ArrayList<process> fcfsList = cloneProcesses(original);
        int time1 = schedules.schedule(fcfsList);
        metrics.printMetrics(fcfsList, time1);

        schedules = new sjf();
        ArrayList<process> sjfList = cloneProcesses(original);
        int time2 = schedules.schedule(sjfList);
        metrics.printMetrics(sjfList,time2);

        schedules = new srtf();
        ArrayList<process> srtfList = cloneProcesses(original);
        int time3 = schedules.schedule(srtfList);
        metrics.printMetrics(srtfList, time3);

        schedules = new roundRobin();
        ArrayList<process> rrList = cloneProcesses(original);
        int time4 = schedules.schedule(rrList);
        metrics.printMetrics(rrList, time4);

        */
       ArrayList<process> adaptiveList = cloneProcesses(original);
       
       scheduler adaptive = new adaptiveScheduler();
       scheduleResult adaptives = adaptive.schedule(adaptiveList);

       metrics.printMetrics(adaptives.schedulerName, adaptiveList, adaptives.totalTime);

        /* 
        // modified
        fcfs fcfsObj = new fcfs();
        int totalTime = fcfsObj.schedule(processes);
        System.out.println();
        metrics.printMetrics(processes, totalTime);
        System.out.println();

        // modified 2
        sjf sjfObj = new sjf();
        int totalTime1 = sjfObj.schedule(processes);
        System.out.println();
        metrics.printMetrics(processes, totalTime1);
        System.out.println();

        // modified 3
        srtf srtfObj = new srtf();
        int totalTime2 = srtfObj.schedule(processes);
        System.out.println();
        metrics.printMetrics(processes, totalTime2);
        System.out.println();
        */
    }
}

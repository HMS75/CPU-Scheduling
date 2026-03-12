public class process {
    int processId;
    int arrivalTime;
    int burstTime;
    int remainingTime;
    int priority;
    int completionTime;

    // constructor  
    public process(int processId, int arrivalTime, int burstTime, int priority) {
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime; // initially same
        this.priority = priority;
    }

    public void printProcess() 
    {   System.out.printf("%-4s | Arrival: %-2d | Burst: %-2d | Priority: %-2d%n","P" + processId, arrivalTime, burstTime, priority);
        // % → starts the format specifier, -4s → left-align string in 4-character width, %-2d → left-align integer in 2-character width,
        // | → literal separator, %n → newline (platform-independent)
    }

    public int getTurnaroundTime() 
    {   return completionTime - arrivalTime;    }

    public int getWaitingTime() 
    {   return getTurnaroundTime() - burstTime; }

}

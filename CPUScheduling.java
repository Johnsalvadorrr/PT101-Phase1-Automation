public class CPUSchedulingSimulator {

    public static void main(String[] args) {

    	 System.out.println("CPU SCHEDULING SIMULATOR");
    	    System.out.println();

    	    String[] processes = {"P1", "P2", "P3", "P4"};
    	    int[] arrivalTime = {0, 0, 0, 0};
    	    int[] burstTime = {6, 2, 8, 3};

    	    // Store the completion time of each process
    	    int[] completionTime = new int[4];
    	    int[] turnaroundTime = new int[4];
    	    int[] waitingTime = new int[4];
    	    
    	    double totalTAT = 0;
    	    double totalWT = 0;

    	    // FCFS: execute processes in their original order
    	    int currentTime = 0;

    	    for (int i = 0; i < processes.length; i++) {

    	        // If the CPU must wait for a process to arrive
    	        if (currentTime < arrivalTime[i]) {
    	            currentTime = arrivalTime[i];
    	        }

    	        // Add the burst time to get the completion time
    	        currentTime = currentTime + burstTime[i];
    	        completionTime[i] = currentTime;
    	        
    	        turnaroundTime[i] = completionTime[i] - arrivalTime[i];
    	        waitingTime[i] = turnaroundTime[i] - burstTime[i];
    	        
    	        totalTAT = totalTAT + turnaroundTime[i];
    	        totalWT = totalWT + waitingTime[i];
    	    }

    	    // Display the FCFS results
    	    System.out.println("FCFS RESULTS");
    	    System.out.println("Process\tAT\tBT\tCT\tTAT\tWT");

    	    for (int i = 0; i < processes.length; i++) {
    	    	System.out.println(
    	    		    processes[i] + "\t" +
    	    		    arrivalTime[i] + "\t" +
    	    		    burstTime[i] + "\t" +
    	    		    completionTime[i] + "\t" +
    	    		    turnaroundTime[i] + "\t" +
    	    		    waitingTime[i]
    	    		);
    	    }
    	    System.out.println();
	    	System.out.println("Average Turnaround Time: " + (totalTAT / 4));
	    	System.out.println("Average Waiting Time: " + (totalWT / 4));
	    	
	    	System.out.println();
	    	System.out.println("FCFS GANTT CHART");
	    	System.out.println("|  P1  |  P2  |   P3   |  P4  |");
	    	System.out.println("0      6      8       16      19");
	    	
	    	System.out.println();
	    	System.out.println("SJF RESULTS");
	    	
	    	String[] sjfProcesses = {"P2", "P4", "P1", "P3"};
	    	int[] sjfBurstTime = {2, 3, 6, 8};
	    	int[] sjfCompletionTime = new int[4];
	    	int[] sjfTurnaroundTime = new int[4];
	    	int[] sjfWaitingTime = new int[4];
	    	
	    	double sjfTotalTAT = 0;
	    	double sjfTotalWT = 0;
	    	
	    	int sjfCurrentTime = 0;

	    	for (int i = 0; i < sjfProcesses.length; i++) {

	    	    sjfCurrentTime = sjfCurrentTime + sjfBurstTime[i];

	    	    sjfCompletionTime[i] = sjfCurrentTime;
	    	    
	    	    sjfTurnaroundTime[i] = sjfCompletionTime[i];
	    	    sjfWaitingTime[i] = sjfTurnaroundTime[i] - sjfBurstTime[i];
	    	    
	    	    sjfTotalTAT = sjfTotalTAT + sjfTurnaroundTime[i];
	    	    sjfTotalWT = sjfTotalWT + sjfWaitingTime[i];
	    	}
	    	
	    	System.out.println("Process\tBT\tCT\tTAT\tWT");

	    	for (int i = 0; i < sjfProcesses.length; i++) {
	    	    System.out.println(
	    	        sjfProcesses[i] + "\t" +
	    	        sjfBurstTime[i] + "\t" +
	    	        sjfCompletionTime[i] + "\t" +
	    	        sjfTurnaroundTime[i] + "\t" +
	    	        sjfWaitingTime[i]
	    	    );
	    	}
	    	
	    	System.out.println();
	    	System.out.println("SJF Average Turnaround Time: " + (sjfTotalTAT / 4));
	    	System.out.println("SJF Average Waiting Time: " + (sjfTotalWT / 4));
	    	
	    	System.out.println();
	    	System.out.println("SJF GANTT CHART");
	    	System.out.println("| P2 | P4 |   P1   |    P3    |");
	    	System.out.println("0    2    5        11         19");
	    	
	    	System.out.println();
	    	System.out.println("SCHEDULING COMPARISON");
	    	System.out.println("Algorithm\tAverage TAT\tAverage WT");
	    	System.out.println("FCFS\t\t" + (totalTAT / 4) + "\t\t" + (totalWT / 4));
	    	System.out.println("SJF\t\t" + (sjfTotalTAT / 4) + "\t\t" + (sjfTotalWT / 4));

    }
}

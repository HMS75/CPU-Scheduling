# Adaptive CPU Scheduling Simulator

## Overview

This project is a *Java-based CPU Scheduling Simulator* that implements multiple classical scheduling algorithms and evaluates their performance across different workload patterns.

The simulator compares the behaviour of different algorithms using common performance metrics such as:

* Average Waiting Time
* Average Turnaround Time
* Throughput

Additionally, the project introduces an **Adaptive Scheduler** that dynamically selects the most suitable scheduling algorithm based on characteristics of the workload.

The goal of this project is to analyze how scheduling strategies perform under different types of job distributions.

---

# Implemented Scheduling Algorithms

The simulator implements the following CPU scheduling algorithms:

### 1. First Come First Serve (FCFS)

Processes are executed in the order they arrive.

**Characteristics**

* Simple to implement
* Non-preemptive
* May cause long waiting times for short processes (convoy effect)

---

### 2. Shortest Job First (SJF)

Processes with the smallest CPU burst time are executed first.

**Characteristics**

* Non-preemptive
* Minimizes average waiting time in many cases
* Requires knowledge or estimation of burst times

---

### 3. Shortest Remaining Time First (SRTF)

Preemptive version of SJF.

**Characteristics**

* Always runs the process with the smallest remaining burst time
* Preempts currently running processes if a shorter job arrives
* Provides optimal waiting time when burst times are known

---

### 4. Round Robin (RR)

Processes are executed in a cyclic order with a fixed time quantum.

**Characteristics**

* Preemptive
* Fair CPU sharing among processes
* Commonly used in time-sharing systems

---

### 5. Adaptive Scheduler

The adaptive scheduler selects a scheduling strategy dynamically based on workload characteristics.

Current heuristic:

```
if burst variance is high
    use SRTF
else if average burst time is small
    use SJF
else
    use Round Robin
```

This allows the system to adapt to workloads containing:

* many short jobs
* mixed jobs
* high burst variability

---

# Workload Generator

The simulator includes a **WorkloadGenerator** module that produces different types of process workloads for benchmarking algorithms.

### 1. Short Job Workload

Processes have small burst times.

Used to evaluate algorithms optimized for short tasks.

---

### 2. Long Job Workload

Processes have larger burst times.

Useful for testing scheduling stability.

---

### 3. Mixed Workload

Contains both short and long jobs.

Represents a realistic CPU workload.

---

### 4. Heavy Load Workload

Simulates a system with a large number of processes.

Used to evaluate scalability and algorithm efficiency.

---

# Performance Metrics

The simulator calculates the following metrics for each scheduling algorithm.

### Average Waiting Time

Average time a process spends waiting in the ready queue.

```
Waiting Time = Turnaround Time - Burst Time
```

---

### Average Turnaround Time

Average time from process arrival to completion.

```
Turnaround Time = Completion Time - Arrival Time
```

---

### Throughput

Number of processes completed per unit time.

```
Throughput = Total Processes / Total Execution Time
```

---

# Project Structure

```
CPU-Scheduler
│
├── Main.java
├── Process.java
│
├── FCFS.java
├── SJF.java
├── SRTF.java
├── RR.java
├── AdaptiveScheduler.java
│
├── WorkloadGenerator.java
├── Metrics.java
├── ResultsExporter.java
│
└── results.json
```

---

# How to Run

### 1. Compile the project

```
javac *.java
```

### 2. Run the simulator

```
java Main
```

The simulator will:

1. Generate workloads
2. Run all scheduling algorithms
3. Calculate performance metrics
4. Export results to `results.json`

---

# Design Goals

The simulator was designed with the following goals:

* Provide a modular implementation of scheduling algorithms
* Allow easy addition of new algorithms
* Support multiple workload patterns
* Enable objective performance comparisons

---

# Technologies Used

* **Java**
* Standard Java libraries
* Object-oriented design principles

---

# Conclusion

This project demonstrates the behaviour of classical CPU scheduling algorithms under different workload conditions.

The adaptive scheduler highlights how **dynamic algorithm selection** can improve system performance when workloads vary.

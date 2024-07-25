package org.example;

public class CallCounter {
    private int systemStateId;
    private int processed;
    private int completed;
    private int block;
    private int busy;

    public CallCounter() {
    }

    public CallCounter(int systemStateId, int processed, int completed, int block, int busy) {
        this.systemStateId = systemStateId;
        this.processed = processed;
        this.completed = completed;
        this.block = block;
        this.busy = busy;
    }

    public int getStateId() {
        return systemStateId;
    }

    public void incStateId() {
        this.systemStateId++;
    }

    public int getProcessed() {
        return processed;
    }

    public void incProcessedCall() {
        this.processed++;
    }

    public int getCompleted() {
        return completed;
    }

    public void incCompletedCall() {
        this.completed++;
        this.processed++;
        this.systemStateId++;
    }

    public int getBlock() {
        return block;
    }

    public void incBlockedCall() {
        this.block++;
        this.processed++;
        this.systemStateId++;
    }

    public int getBusy() {
        return busy;
    }

    public void incBusyCall() {
        this.busy++;
        this.processed++;
        this.systemStateId++;
    }

    @Override
    public String toString() {
        return "System State - "+ systemStateId + " {" +
                "Processed=" + processed +
                ", Completed=" + completed +
                ", Block=" + block +
                ", Busy=" + busy +
                '}';
    }
}

package org.example;

public class NewCall {
    private int fromLine;
    private int toLine;
    private int length_of_call;
    private int arrivalTime;

    public NewCall(int fromLine, int toLine, int length_of_call, int arrivalTime) {
        this.fromLine = fromLine;
        this.toLine = toLine;
        this.length_of_call = length_of_call;
        this.arrivalTime = arrivalTime;
    }

    public int getFromLine() {
        return fromLine;
    }

    public void setFromLine(int fromLine) {
        this.fromLine = fromLine;
    }

    public int getToLine() {
        return toLine;
    }

    public void setToLine(int toLine) {
        this.toLine = toLine;
    }

    public int getLength_of_call() {
        return length_of_call;
    }

    public void setLength_of_call(int length_of_call) {
        this.length_of_call = length_of_call;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "NewCall {" +
                "From Line=" + fromLine +
                ", To Line=" + toLine +
                ", Length of call=" + length_of_call +
                "}\nArrival Time=" + arrivalTime
                ;
    }
}

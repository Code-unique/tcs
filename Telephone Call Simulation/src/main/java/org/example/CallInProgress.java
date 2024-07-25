package org.example;

public class CallInProgress {
    private int fromLine;
    private int toLine;
    private int end;

    public CallInProgress() {
    }

    public CallInProgress(int fromLine, int toLine, int end) {
        this.fromLine = fromLine;
        this.toLine = toLine;
        this.end = end;
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

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "CallInProgress {" +
                "From=" + fromLine +
                ", To=" + toLine +
                ", End=" + end +
                '}';
    }
}

package org.example;

public class Line {
    private int id;
    private Boolean isBusy;

    public Line(int id, Boolean isBusy) {
        this.id = id;
        this.isBusy = isBusy;
    }

    public Boolean getLineStatus() {
        return isBusy;
    }

    public void setLineStatus(Boolean isBusy) {
        this.isBusy = isBusy;
    }

    @Override
    public String toString() {
        return id+": " + (isBusy ? "busy" : 0);
    }
}

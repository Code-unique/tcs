package org.example;

import java.util.*;

public class TelephoneCallSystem {
    private static final int NO_OF_LINKS = 3;
    private static final int NO_OF_LINES = NO_OF_LINKS*2+2;
    private int linkInUse;
    private int clock;

    private Line [] line = new Line[NO_OF_LINES];
    private ArrayList<CallInProgress> callInProgresses = new ArrayList<CallInProgress>(NO_OF_LINKS);
    private NewCall newCall;
    private CallCounter callCounter;

    public TelephoneCallSystem() {
        this.linkInUse = 2;
        this.clock = 10;
        line[0] = new Line(1, false);
        line[1] = new Line(2, true);
        line[2] = new Line(3, true);
        line[3] = new Line(4, false);
        line[4] = new Line(5, false);
        line[5] = new Line(6, true);
        line[6] = new Line(7, true);
        line[7] = new Line(8, false);
        this.callInProgresses.add(new CallInProgress(2, 6, 20));
        this.callInProgresses.add(new CallInProgress(3, 7, 25));
        this.newCall = new NewCall(1, 6, 15, 13);
        this.callCounter = new CallCounter(1, 2, 0, 0, 0);

        display();
    }

    void display() {
        System.out.println("**************************************************");
        System.out.println();

        System.out.println("Line: " + Arrays.toString(line));
        System.out.println();
        System.out.println(callInProgresses);
        System.out.println();

        System.out.println("Max link: " + NO_OF_LINKS);
        System.out.println("Link in use: " + linkInUse);

        System.out.println();
        System.out.println("Current Time: " + this.clock);
        System.out.println();

        System.out.println(newCall);
        System.out.println();

        System.out.println(callCounter);

        System.out.println();
        System.out.println("**************************************************");

    }

    public void start() throws InterruptedException {
//        int temp=0;

        while(clock != -1) {


            Map<String, Integer> map = getNextClockValue();
            this.clock = map.values().iterator().next();
//            System.out.println();
//            System.out.println(clock);
            if (map.keySet().iterator().next().equals("NewCall")) {
                boolean isBusy = isCallBusy();
                if (isBusy) {
                    System.out.println("Sorry, Line is busy");
                } else {
                    System.out.println("Line not busy");
                    boolean isBlocked = isCallBlocked();
                    if (isBlocked) {
                        System.out.println("Call blocked");
//                        continue;
                    } else {
                        CallInProgress call = new CallInProgress(newCall.getFromLine(), newCall.getToLine(), clock+ newCall.getLength_of_call() );
                        callInProgresses.add(call);

                        // Initialize line as busy
                        line[call.getFromLine()-1].setLineStatus(true);
                        line[call.getToLine()-1].setLineStatus(true);

                        linkInUse = callInProgresses.size();
                        callCounter.incProcessedCall();
                        callCounter.incStateId();
                        System.out.println("Call not blocked");
                    }
                }
            } else if (map.keySet().iterator().next().equals("CallInProgress")) {
                line[callInProgresses.get(0).getFromLine()-1].setLineStatus(false);
                line[callInProgresses.get(0).getToLine()-1].setLineStatus(false);
                callInProgresses.remove(0);
                linkInUse = callInProgresses.size();
                callCounter.incCompletedCall();
                System.out.println("Call completed");

            }

            Thread.sleep(5000);
            display();


            int from;
            int to;
            int length;
            int arrivalTime;
            do {
                from = getRandomNumber(1, 8);
                to = getRandomNumber(1, 8);
                length = getRandomNumber(30, 50);
                arrivalTime = getRandomNumber(this.clock + 10, this.clock + 20);
            } while (from == to);

            this.newCall = new NewCall(from, to, length, arrivalTime);

        }
    }

    public Map<String, Integer> getNextClockValue() {
        Map<String, Integer> map = new HashMap<>();
        if (callInProgresses.isEmpty()) {
            map.put("NewCall", newCall.getArrivalTime());
            return map;
        }
        if (newCall.getArrivalTime() < callInProgresses.get(0).getEnd()) {
            map.put("NewCall", newCall.getArrivalTime());
            return map;
        } else {
            map.put("CallInProgress", callInProgresses.get(0).getEnd());
        }
        return map;
    }

    public Boolean isCallBusy() {
        int from = newCall.getFromLine();
        int to = newCall.getToLine();

        if (line[from-1].getLineStatus() || line[to-1].getLineStatus()) {
            callCounter.incBusyCall();
//            this.clock=-1;
            return true;
        }
        return false;
    }

    public Boolean isCallBlocked() {
        if (NO_OF_LINKS == linkInUse) {
            callCounter.incBlockedCall();
            return true;
        }
        return false;
    }

    public int getRandomNumber(int from, int to) {
        return (int) (Math.random() * (from-to) + to);
    }

}

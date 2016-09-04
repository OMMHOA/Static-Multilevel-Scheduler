package scheduler;

class Task {
    private char order;
    private int priority;
    private int startTime;
    private int burstTime;

    public Task(char o, int p, int st, int bt){
        order = o;
        priority = p;
        startTime = st;
        burstTime = bt;
    }

    public char getOrder() {
        return order;
    }

    public int getPriority() {
        return priority;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getBurstTime() {
        return burstTime;
    }
}

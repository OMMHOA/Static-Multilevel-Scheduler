package scheduler;

class TaskInAlgorithm {
    private Task task;
    private int burstTimeLeft;
    private int timeWaited;

    public TaskInAlgorithm(Task task) {
        this.task = task;
        burstTimeLeft = task.getBurstTime();
        timeWaited = 0;
    }

    public void process(){
        burstTimeLeft--;
    }

    public void delayTask(){
        timeWaited++;
    }

    public Task getTask() {
        return task;
    }

    public int getBurstTimeLeft() {
        return burstTimeLeft;
    }

    public int getTimeWaited() {
        return timeWaited;
    }
}

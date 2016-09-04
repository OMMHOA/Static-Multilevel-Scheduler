package scheduler;

import java.util.ArrayList;
import java.util.List;

class SJF {
    private List<TaskInAlgorithm> tasks;
    private boolean processingTask;
    private int actualTaskIndex;

    SJF() {
        tasks = new ArrayList<>();
        processingTask = false;
    }

    void addTask(Task task){
        tasks.add(new TaskInAlgorithm(task));
    }

    boolean isDone() {
        return tasks.size() == 0;
    }

    // use only when isDone is false!
    void process(){
        // find the shortest job task
        if(!processingTask){
            actualTaskIndex = 0;
            int minBurstTime = tasks.get(0).getBurstTimeLeft();
            for (int i = 0; i < tasks.size(); i++) {
                if(tasks.get(i).getBurstTimeLeft() < minBurstTime){
                    minBurstTime = tasks.get(i).getBurstTimeLeft();
                    actualTaskIndex = i;
                }
            }
        }
        tasks.get(actualTaskIndex).process();
        delayTasks();
        if(tasks.get(actualTaskIndex).getBurstTimeLeft() == 0){
            Globals.result.add(tasks.remove(actualTaskIndex));
            processingTask = false;
        } else {
            processingTask = true;
        }
    }

    private void delayTasks(){
        for (int i = 0; i < tasks.size(); i++) {
            if(i != actualTaskIndex) {
                tasks.get(i).delayTask();
            }
        }
    }

}

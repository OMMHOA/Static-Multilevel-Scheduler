package scheduler;

import java.util.ArrayList;
import java.util.List;

class RR {
    private List<TaskInAlgorithm> tasks;
    private int milisecsGiven;

    RR() {
        tasks = new ArrayList<>();
        milisecsGiven = 0;
    }

    void addTask(Task task){
        tasks.add(new TaskInAlgorithm(task));
    }

    void process(){
        if(milisecsGiven < 2){
            tasks.get(0).process();
            delayTasks();
            if(notLastInLine()) {
                Globals.result.add(tasks.get(0));
            }
            milisecsGiven++;
            if(tasks.get(0).getBurstTimeLeft() == 0){
                tasks.remove(0);
                milisecsGiven = 0;
            }
        } else {
            milisecsGiven = 0;
            tasks.add(tasks.remove(0));
            process();
        }
    }

    void jumpIfDidnt(){
        if (milisecsGiven == 2){
            milisecsGiven = 0;
            tasks.add(tasks.remove(0));
        }
    }

    private boolean notLastInLine() {
        return Globals.result.size() <= 0 || tasks.get(0) != Globals.result.get(Globals.result.size() - 1);
    }

    private void delayTasks(){
        for (int i = 1; i < tasks.size(); i++) {
            tasks.get(i).delayTask();
        }
    }

    void delayAllTasks(){
        tasks.forEach(TaskInAlgorithm::delayTask);
    }

    boolean isDone() {
        return tasks.size() == 0;
    }

    boolean processing(){
        return milisecsGiven == 1;
    }

    void interruptProcess(){
        milisecsGiven = 0;
        tasks.add(tasks.remove(0));
    }
}

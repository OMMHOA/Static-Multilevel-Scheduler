package scheduler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Adder {
    private List<Task> tasks;
    private SJF sjf;
    private RR rr;

    public Adder(SJF s, RR r) {
        sjf = s;
        rr = r;
        // read the lines into an list
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tasks = new ArrayList<>();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length == 4) {
                    tasks.add(new Task(parts[0].charAt(0), Integer.valueOf(parts[1]),
                            Integer.valueOf(parts[2]), Integer.valueOf(parts[3])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        addActualTasks();
    }

    public void addActualTasks(){
        int i = 0;
        while (i < tasks.size()) {
            Task actualTask = tasks.get(i);
            if(actualTask.getStartTime() == Globals.getTime()){
                if (actualTask.getPriority() <= 4){
                    sjf.addTask(tasks.remove(i));
                } else {
                    rr.addTask(tasks.remove(i));
                }
                i--;
            }
            i++;
        }
    }

    public boolean isDone() {
        if (tasks.size() == 0)
            return true;
        else return false;
    }
}

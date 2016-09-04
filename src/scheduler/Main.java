package scheduler;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SJF sjf = new SJF();
        RR rr = new RR();
        Adder adder = new Adder(sjf, rr);
        while(!adder.isDone() || !sjf.isDone() || !rr.isDone()){
            if(!sjf.isDone()){
                sjf.process();
                rr.delayAllTasks();
            } else if (!rr.isDone()) {
                rr.process();
            }
            Globals.incTime();
            boolean before = sjf.isDone();
            adder.addActualTasks();
            rr.jumpIfDidnt();
            boolean after = sjf.isDone();
            if ((before) && (!after) && !rr.isDone()){
                if (rr.processing())
                    rr.interruptProcess();
            }
        }

        List<TaskInAlgorithm> inOrder = new ArrayList<>();
        for (int i = 0; i < Globals.result.size(); i++) {
            if(!inOrder.contains(Globals.result.get(i))){
                inOrder.add(Globals.result.get(i));
            } else {
                inOrder.add(inOrder.remove(inOrder.indexOf(Globals.result.get(i))));
            }
        }
        // write the results
        for (int i = 0; i < Globals.result.size(); i++) {
            System.out.print(Globals.result.get(i).getTask().getOrder());
        }
        System.out.println();
        for (int i = 0; i < inOrder.size(); i++) {
            if (i != 0) System.out.print(",");
            System.out.print(inOrder.get(i).getTask().getOrder()
                    + ":" + inOrder.get(i).getTimeWaited());
        }
    }
}

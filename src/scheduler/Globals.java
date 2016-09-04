package scheduler;

import java.util.ArrayList;
import java.util.List;

abstract class Globals {
    private static int time = 0;
    public static List<TaskInAlgorithm> result = new ArrayList<>();

    static void incTime(){ time++; }

    static int getTime() {
        return time;
    }
}

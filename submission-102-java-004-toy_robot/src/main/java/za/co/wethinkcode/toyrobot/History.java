package za.co.wethinkcode.toyrobot;

import java.util.*;

public class History {

    private ArrayList<String> History = new ArrayList<>();

    public History(ArrayList<String> list) {
        this.History = list;
    }

    public ArrayList<String> getHistory() {
        return this.History;
    }

    public void addHistory(String instruction) {
        History.add(instruction);
    }
}

// make sure to look at history.java for further implementation.
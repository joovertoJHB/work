package za.co.wethinkcode.toyrobot.maze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import za.co.wethinkcode.toyrobot.*;

import za.co.wethinkcode.toyrobot.Robot;
import za.co.wethinkcode.toyrobot.world.IWorld;
import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.world.SquareObstacle;
import za.co.wethinkcode.toyrobot.world.TextWorld;


public class SimpleMazeRunner implements MazeRunner {

    public final ArrayList<int[]> graphPositions = new ArrayList<int[]>();
    public final ArrayList<int[]> openPositionsList = new ArrayList<int[]>();
    public final ArrayList<int[]> pathList = new ArrayList<int[]>();
    public final ArrayList<int[]> nextToVisit = new ArrayList<int[]>();
    public final ArrayList<int[]> visited = new ArrayList<int[]>();

    public TextWorld textWorld;
    public SquareObstacle obstacles;

    public SimpleMazeRunner(Robot target, IWorld.Direction up) {
    }

    @Override
    public boolean mazeRun(Robot target, IWorld.Direction edgeDirection) {
        GraphMake();
        OpenPositions();
        solve();
        return true;
    }

    @Override
    public int getMazeRunCost() {
        return 0;
    }

    public void GraphMake() {

        for (int x = -100; x <= 100; x+=5) {
            for (int y = -100; y <= 200; y+=5) {

                this.graphPositions.add(new int[]{x,y});
            }
        }
    }

    public void OpenPositions() {
        for (int i = 0; i <= graphPositions.size();i++) {
            Position jump = new Position(graphPositions.get(i)[0], graphPositions.get(i)[1]);
            if(!obstacles.blocksPosition(jump)){
                this.openPositionsList.add(graphPositions.get(i));
            }
            this.openPositionsList.add(graphPositions.get(i));
        }
    }

    public boolean solve(){
        int[] start = new int[] {0,0};
        int[] end = new int[] {100,20};

        nextToVisit.add(start);

        while(nextToVisit.isEmpty()) {

            int[] node = nextToVisit.get(0);
            nextToVisit.remove(0);

            ArrayList<int[]> adjacent = new ArrayList<int[]>();
            adjacent.add(new int[]{node[0]+5, node[1]});
            adjacent.add(new int[]{node[0]-5, node[1]});
            adjacent.add(new int[]{node[0], node[1]+5});
            adjacent.add(new int[]{node[0], node[1]-5});

            if(node == end) {
                visited.add(node);
                System.out.println(visited);
                return true;
            }

            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);

            for (int[] child : adjacent) {
                if (openPositionsList.contains(child)) {
                    nextToVisit.add(child);
                }
            }

        }
        // HashMap<int[], int[]> parentList = new HashMap<>();

        return false;
    }
}

// top = -70, 200
// bottom = -30, - 200
// right = 100, 20
// left = -100, -10


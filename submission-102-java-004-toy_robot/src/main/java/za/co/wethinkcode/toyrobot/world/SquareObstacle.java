package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Position;
import java.math.*;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class SquareObstacle implements Obstacle{

    private final int x;
    private final int y;
    private final int size;

    public SquareObstacle(int x, int y) {
        this.x = x;
        this.y = y;
        this.size = 5;
    }
    
    @Override
    public int getBottomLeftX() {
        return this.x;
    }

    @Override
    public int getBottomLeftY() {
        return this.y;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean blocksPosition(Position position) {
        // if(position.getX() == this.x && position.getY() == this.y) {
        //     return true;
        // } else if ((position.getX() <= (this.x + 4) && position.getX() >= this.x) && (position.getY() <= (this.y +4) && position.getY() >= this.y)) {
        //     return true;
        // } else if (position.getX() == (this.x + 4) && position.getY() == (this.y + 4)){
        //     return true;
        // }
        // return false;

        Boolean checkY = this.y == position.getY() || position.getY() >= this.y && position.getY() <= this.y+4;
        Boolean checkX = this.x == position.getX() || position.getX() >= this.x && position.getX() <= this.x+4;

        if (checkX && checkY){
            return true;
        }
        return false;
    }

    @Override
    public boolean blocksPath(Position a, Position b) {
        int ax = a.getX(); int ay = a.getY();
        int bx = b.getX(); int by = b.getY();
        if (ax == bx) {
            if ((this.x <= ax && this.x + 5 >= ax)
                    && (this.y <= max(ay, by) && this.y >= min(ay, by))) {
                return true;
            }
        } else if (ay == by) {
            if ((this.y <= ay && this.y + 5 >= ay)
                    && (this.x <= max(ax, bx) && this.x >= min(ax, bx))) {
                return true;
            }
        }
        return false;
    }
}

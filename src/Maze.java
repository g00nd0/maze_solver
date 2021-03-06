import java.util.LinkedList;

//maze object created, so that multiple mazes (objects) can be created and solved with the maze solver
public class Maze {
    public int[][] maze;
    public LinkedList<Position> path = new LinkedList<Position>(); //new linkedlist defined in Maze class to save position
    public Position start;
}
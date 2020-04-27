//import java.util.*;
import java.util.LinkedList;

//Day 13 - Intro to OOP, with Maze Solver app, 30 days of java Caleb Curry

public class maze_solver {

    static Maze m = new Maze();
    

    //0 = wall
    //1 = path
    //2 = destination

    //static LinkedList<Position> path = new LinkedList<Position>(); //stack keeps track of position of valid paths in maze
    //line above not needed, as maze class has been created to handle object creation

    public static void main(String[] args) {

        int[][] maze = {
            {0,1,1,1,0,1,0,0,0,1,1,0,1,1},
            {1,1,2,0,0,1,0,1,1,1,1,0,1,1},
            {1,0,0,1,1,1,0,1,0,1,1,0,0,1},
            {1,1,1,1,0,1,0,1,0,1,1,1,1,1},
            {1,0,1,1,0,1,1,1,0,1,1,0,1,1},
            {1,0,0,1,0,0,0,0,1,1,1,0,1,1}
        };

        m.maze = maze;
        m.start = new Position(4,8);
        m.path = new LinkedList<Position>();

        if(solve_maze(new Position(4,8))) {   // refactored, 
            System.out.println("You won!");
        } else{
            System.out.println("no path");  // therefore no path to finish maze :(
        };


        //Position p = new Position(1,12); //intitalize start postion, element at row,col
        
        //System.out.println(path.peek(x));
        
    }

    private static boolean solve_maze(Position p){ // create private method for solving maze, is there a way to invoke methods from VS Code?
        m.path.push(p);
               
        while(true){

            int y = m.path.peek().y; //make references to path.peek().x or .y coords, theis gets the current postion in 2d array
            int x = m.path.peek().x;

            m.maze[y][x] = 0; //array value is subst to value 0, means that it has visited this position

            //down
            if(isValid(y+1, x)){
                
                if(m.maze[y+1][x] == 2){ //y+1 means moving down, if lands on 2, desitination reached
                System.out.println("Moved down");
                return true;
                }else if(m.maze[y+1][x] == 1){ //if lands on 1, move in direction in this if else
                System.out.println("Moved Down");
                m.path.push(new Position(y+1,x));
                continue;
                }
            }

            //left
            if(isValid(y, x-1)){
                
                if(m.maze[y][x-1] == 2){ //x-1 means moving left
                System.out.println("Moved left");
                return true;
                }else if(m.maze[y][x-1] == 1){ 
                System.out.println("Moved left");
                m.path.push(new Position(y,x-1));
                continue;
                }
            }

             //up
            if(isValid(y-1, x)){
                
                if(m.maze[y-1][x] == 2){ //y-1 means moving up
                System.out.println("Moved up");
                return true;
                }else if(m.maze[y-1][x] == 1){
                System.out.println("Moved up");
                m.path.push(new Position(y-1,x));
                continue;
                }
            }
            
             //right
            if(isValid(y, x+1)){ 
                if(m.maze[y][x+1] == 2){ //x+1 means moving right
                System.out.println("Moved right");
                return true;
                }else if(m.maze[y][x+1] == 1){
                System.out.println("Moved right");
                m.path.push(new Position(y,x+1));
                continue;
                }
            }           
            
            m.path.pop(); //remove latest value off stack, to move to prev position
            System.out.println("moved back");
            if(m.path.size() <= 0) {  //if size of linkedlist is 0 or less, means stack is empty, therefore it has backtracked and exhausted all paths
                return false;   // return false, then handle the outcome from main method
            }
        }
    }

    public static boolean isValid(int y, int x){
        if(y<0 || y >= m.maze.length || x < 0 || x >= m.maze[y].length){
            return false;
        }
        return true;
    }
}
//import java.util.*;
import java.util.LinkedList;

//Day 9 - start of Maze Solver, 30 days of java Caleb Curry

public class maze_solver {

    static int[][] maze = {
        {0,1,1,1,0,1,0,0,0,1,1,0,1,1},
        {1,1,2,0,0,1,0,1,1,1,1,0,1,1},
        {1,0,0,1,1,1,0,1,0,1,1,0,0,1},
        {1,1,1,1,0,1,0,1,0,1,1,1,1,1},
        {1,0,1,1,0,1,1,1,0,1,1,0,1,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1,1}
    };

    //0 = wall
    //1 = path
    //2 = destination

    static LinkedList<Position> path = new LinkedList<Position>(); //stack keeps track of posiotion of valid paths in maze

    public static void main(String[] args) {

        Position p = new Position(1,12); //intitalize start postion, element at row,col
        path.push(p);
               
        while(true){

            int y = path.peek().y; //make references to path.peek().x or .y coords, theis gets the current postion in 2d array
            int x = path.peek().x;

            maze[y][x] = 0; //array value is subst to value 0, means that it has visited this position

            //down
            if(isValid(y+1, x)){
                
                if(maze[y+1][x] == 2){ //y+1 means moving down, if lands on 2, desitination reached
                System.out.println("Moved down, You Won!");
                return;
                }else if(maze[y+1][x] == 1){ //if lands on 1, move in direction in this if else
                System.out.println("Moved Down");
                path.push(new Position(y+1,x));
                continue;
                }
            }

            //left
            if(isValid(y, x-1)){
                
                if(maze[y][x-1] == 2){ //x-1 means moving left
                System.out.println("Moved left, You Won!");
                return;
                }else if(maze[y][x-1] == 1){ 
                System.out.println("Moved left");
                path.push(new Position(y,x-1));
                continue;
                }
            }

             //up
            if(isValid(y-1, x)){
                
                if(maze[y-1][x] == 2){ //y-1 means moving up
                System.out.println("Moved up, You Won!");
                return;
                }else if(maze[y-1][x] == 1){
                System.out.println("Moved up");
                path.push(new Position(y-1,x));
                continue;
                }
            }
            
             //right
            if(isValid(y, x+1)){ 
                if(maze[y][x+1] == 2){ //x+1 means moving right
                System.out.println("Moved right, You Won!");
                return;
                }else if(maze[y][x+1] == 1){
                System.out.println("Moved right");
                path.push(new Position(y,x+1));
                continue;
                }
            }           
            
            path.pop(); //remove latest value off stack, to move to prev position
            System.out.println("moved back");
            if(path.size() <= 0) {  //if size of linkedlist is 0 or less, means stack is empty, therefore it has backtracked and exhausted all paths
                System.out.println("no path");  // therefore no path to finish maze :(
                return;
            }
        }
        //System.out.println(path.peek(x));
        
    }

    public static boolean isValid(int y, int x){
        if(y<0 || y >= maze.length || x < 0 || x >= maze[y].length){
            return false;
        }
        return true;
    }
}
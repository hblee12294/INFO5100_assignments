import java.util.ArrayList;

class Cell {
	int x, y;
	
	Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "[" + this.x + ", " + this.y + "]";
	}
}

public class Extra {

	ArrayList<Cell> result = new ArrayList<Cell>();
	
	public ArrayList<Cell> findPath(int[][] maze) {
		find(maze, 0, 0, maze.length - 1, maze[0].length - 1);
		return result;
	}
	// No need to pass endX and endY since you can get the info from maze
	public boolean find(int maze[][], int x, int y, int endX, int endY) {
		if (x == endX && y == endY) {
			result.add(new Cell(x, y));
			return true;
		}
		
		if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length &&  maze[x][y] == 1) {
			result.add(new Cell(x, y));
			
			if (find(maze, x+1, y, endX, endY))
				return true;
			
			if (find(maze, x, y+1, endX, endY))
				return true;
			
			result.remove(result.size() - 1);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Extra ex = new Extra();
		int[][] maze = {{1, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
		
		for (Cell c : ex.findPath(maze)) {
			System.out.print(c.toString() + " ");
		}
	
	}

}

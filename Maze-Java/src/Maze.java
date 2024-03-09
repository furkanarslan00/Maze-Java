
public class Maze {

	public static int N;

	
	public void printSolution(int sol[][])
	{
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(sol[i][j]==0) {
					System.out.print(" . ");
				}
			     
				else {
					System.out.print(" # ");
				}
				
			}
				
			System.out.println();	
				
		}
		
	}


	public boolean isSafe(
		int maze[][], int x, int y)
	{

		return (x >= 0 && x < N && y >= 0&& y < N && maze[x][y] == 1);
	}


	public boolean solveMaze(int maze[][]){
		
		int sol[][] = new int[N][N];

		if (solveMazeUtil(maze, 0, 0, sol) == false) {
			System.out.print("Solution doesn't exist");
			return false;
		}

		printSolution(sol);
		return true;
	}

	public boolean solveMazeUtil(int maze[][], int x, int y,int sol[][]){
	
		if (x == N - 1 && y == N - 1&& maze[x][y] == 1) {
			sol[x][y] = 1;
			return true;
		}

		if (isSafe(maze, x, y) == true) {
			if (sol[x][y] == 1)
				return false;
		
			sol[x][y] = 1;

			if (solveMazeUtil(maze, x + 1, y, sol))
				return true;

			if (solveMazeUtil(maze, x, y + 1, sol))
				return true;

			sol[x][y] = 0;
			return false;
		}

		return false;
	}

	public static void main(String args[]){
		
		Maze maz = new Maze();
		int maze[][] = { { 1, 0, 0, 0 },
						 { 1, 1, 0, 1 },
						 { 0, 1, 0, 0 },
						 { 1, 1, 1, 1 }};

		N = maze.length;
		maz.solveMaze(maze);
	}
}


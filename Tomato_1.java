import java.util.*;

public class Tomato_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] map = new int[m][n];
		Queue<Coordinate> q = new LinkedList();
		for (int i = 0 ; i < m ; i++) {
			for (int j = 0 ; j < n ; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					Coordinate coordinate = new Coordinate();
					coordinate.setX(i);
					coordinate.setY(j);
					coordinate.setTime(0);
					q.add(coordinate);
				}
			}
		}
		int maxTime = -1;
		while(q.peek() != null) {
			Coordinate coordinate = q.remove();
			int x = coordinate.getX();
			int y = coordinate.getY();
			int time = coordinate.getTime();
			System.out.println(Integer.valueOf(x) + "." + Integer.valueOf(y) + " " + Integer.valueOf(time));
			if( x - 1 >= 0 && map[x - 1][y] == 0) {
				Coordinate tempCoordinate = new Coordinate();
				tempCoordinate.setX(x - 1);
				tempCoordinate.setY(y);
				tempCoordinate.setTime(time + 1);
				q.add(tempCoordinate);
				map[x - 1][y] = 1;
				maxTime = maxTime > (time+1) ? maxTime : (time+1);
			}
			if( y - 1 >= 0 && map[x][y - 1] == 0) {
				Coordinate tempCoordinate = new Coordinate();
				tempCoordinate.setX(x);
				tempCoordinate.setY(y - 1);
				tempCoordinate.setTime(time + 1);
				q.add(tempCoordinate);
				map[x][y - 1] = 1;
				maxTime = maxTime > (time+1) ? maxTime : (time+1);
			}
			if( x + 1 < m && map[x + 1][y] == 0) {
				Coordinate tempCoordinate = new Coordinate();
				tempCoordinate.setX(x + 1);
				tempCoordinate.setY(y);
				tempCoordinate.setTime(time + 1);
				q.add(tempCoordinate);
				map[x + 1][y] = 1;
				maxTime = maxTime > (time+1) ? maxTime : (time+1);
			}
			if( y + 1 < n && map[x][y + 1] == 0) {
				Coordinate tempCoordinate = new Coordinate();
				tempCoordinate.setX(x);
				tempCoordinate.setY(y + 1);
				tempCoordinate.setTime(time + 1);
				q.add(tempCoordinate);
				map[x][y + 1] = 1;
				maxTime = maxTime > (time+1) ? maxTime : (time+1);
			}
		}
		System.out.println(Integer.valueOf(maxTime));
	}
}

class Coordinate {
	private int x;
	private int y;
	private int time;

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}

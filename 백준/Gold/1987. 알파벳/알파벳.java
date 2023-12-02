import java.util.Scanner;

public class Main {
	static boolean isVisited[];
	static int[] dx, dy;
	static char[][] map;
	static int R, C, answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dx = new int[] {-1, 0, 1, 0};
		dy = new int[] {0, 1, 0, -1};
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		map = new char[R][C];
		isVisited = new boolean[26];
		
		for(int i=0;i<R;i++) {
			map[i] = sc.nextLine().toCharArray();
		}
		
		isVisited[map[0][0]-'A'] = true;
		dfs(0, 0, 1);
		System.out.println(answer);
	}
	
	public static void dfs(int x, int y, int cnt) {
		answer = Math.max(answer, cnt);
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 <= nx && nx < R && 0 <= ny && ny < C && !isVisited[map[nx][ny]-'A']) {
				isVisited[map[nx][ny]-'A'] = true;
				dfs(nx, ny, cnt+1);
				isVisited[map[nx][ny]-'A'] = false;
			}
		}
	}

}

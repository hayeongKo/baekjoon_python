import java.util.*;

public class Main {
	static int N, ans;
	static int[] rows, dia, undia;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		
		rows = new int[N+1];
		dia = new int[N*2+1];
		undia = new int[N*2+1];
		
		dfs(1);
		System.out.println(ans);
		
	}
	
	public static void dfs(int row) {
		if (row == N+1) {
			ans++;
			return;
		}
		
		for(int col = 1; col <= N; col++) {
			if (rows[col] == 1 || dia[col+row] == 1 || undia[N-(row-col)+1] == 1) continue;
			rows[col] = 1;
			dia[col+row] = 1;
			undia[N-(row-col)+1]=1;
			dfs(row+1);
			rows[col] = 0;
			dia[col+row] = 0;
			undia[N-(row-col)+1]=0;
		}
	}

}

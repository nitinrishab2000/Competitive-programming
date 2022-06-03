import java.util.*;
import java.io.*;
public class B1688{
	static FastScanner fs = null;
	public static void main(String[] args) {
		fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = fs.nextInt();
		while (t-->0) {
			int n = fs.nextInt();
			int a[] = new int[n];
			int ce = 0;
			for(int i=0;i<n;i++){
				a[i] = fs.nextInt();
				if(a[i]%2==0){
					ce+=1;
				}
			}
			int co = Integer.MAX_VALUE;
			for(int i=0;i<n;i++){
				int num = a[i];
				int c = 0;
				while (num%2==0) {
					c+=1;
					num/=2;
				}
				co = Math.min(co,c);
			}
			int ans = 0;
			if(co==0){
				ans = ce;
			}
			else{
				ans = co+(ce-1);
			}
			out.println(ans);
		}
		out.close();
	}
	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
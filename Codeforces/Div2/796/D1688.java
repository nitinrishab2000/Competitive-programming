import java.util.*;
import java.io.*;
public class D1688{
	static FastScanner fs = null;
	public static void main(String[] args) {
		fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = fs.nextInt();
		while (t-->0) {
			int n = fs.nextInt();
			long a[] = new long[n];
			int k = fs.nextInt();
			for(int i=0;i<n;i++){
				a[i] = fs.nextLong();
			}
			long ans = (long)0;
			if(n>k){
				long sum = (long)0;
				for(int i=0;i<k;i++){
					sum+=a[i];
				}
				ans = Math.max(ans,sum);
				for(int i=k;i<n;i++){
					sum+=a[i];
					sum-=a[i-k];
					ans = Math.max(ans,sum);
				}
				long x = ((long)k*((long)k-(long)1))/(long)2;
				ans+=x;
			}
			else{
				long sum = (long)0;
				for(int i=0;i<n;i++){
					sum+=a[i];
				}
				ans+=(sum);
				long x = (long)n*(long)k;
				ans+=x;
				long xo = ((long)n*((long)n-(long)1))/(long)2;
				ans-=xo;
				ans-=(long)n;
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
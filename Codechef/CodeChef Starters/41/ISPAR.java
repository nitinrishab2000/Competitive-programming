import java.util.*;
import java.io.*;
class A{
	static FastScanner fs = null;
	public static void main(String[] args) {
		fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = fs.nextInt();
		while (t-->0) {
			long n = fs.nextLong();
			long k = fs.nextLong();
			if(k==(long)1){
				if(n%2==0){
					out.println("EVEN");
				}
				else
					out.println("ODD");
			}
			else{
				k-=(long)1;
				if(k%(long)2==(long)0){
					out.println("EVEN");
				}
				else{
					if(k==(long)1)
						out.println("ODD");
					else
						out.println("EVEN");
				}
			}
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

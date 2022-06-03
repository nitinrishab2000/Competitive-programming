import java.util.*;
import java.io.*;
public class A1688{
	static FastScanner fs = null;
	public static void main(String[] args) {
		fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = fs.nextInt();
		while (t-->0) {
			int n = fs.nextInt();
			int ar[] = new int[64];
			int c = 0;
			int x = n;
			while (x>0) {
				ar[c] = x%2;
				x/=2;
				c+=1;
			}
			int num = -1;
			for(int i=0;i<c;i++){
				if(ar[i]==1){
					num = (int)Math.pow(2,i);
					break;
				}
			}
			// out.println(num)
			if(n==1){
				num = 3;
			}
			else{
				if((num^n) >0){

				}
				else if(((1+num)^(n))>0){
					num+=1;
				}
			}
			out.println(num);
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
